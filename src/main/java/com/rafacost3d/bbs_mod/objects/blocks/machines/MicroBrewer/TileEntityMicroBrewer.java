package com.rafacost3d.bbs_mod.objects.blocks.machines.MicroBrewer;

import com.rafacost3d.bbs_mod.init.ItemInit;
import com.rafacost3d.bbs_mod.util.BeerMath;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class TileEntityMicroBrewer extends TileEntityLockable implements ITickable, ISidedInventory {

    private static final int[] SLOTS_TOP = new int[] {0};
    private static final int[] SLOTS_BOTTOM = new int[] {2, 1};
    private static final int[] SLOTS_SIDES = new int[] {3};
    private NonNullList<ItemStack> inventory = NonNullList.<ItemStack>withSize(4, ItemStack.EMPTY);
    private String customName;

    private int burnTime;
    private int currentBurnTime;
    private int cookTime;
    private int totalCookTime;

    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
    {
        return new ContainerFurnace(playerInventory, this);
    }

    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : "tile.bbs_mod.microbrewer.name";
    }

    @Override
    public boolean hasCustomName() {
        return this.customName !=null && !this.customName.isEmpty();
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentString(this.getName());
    }

    @Override
    public int getSizeInventory() {
        return this.inventory.size();
    }

    @Override
    public boolean isEmpty() {
        for(ItemStack stack : this.inventory){
            if(!stack.isEmpty()) return false;
        }
        return true;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return (ItemStack)this.inventory.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.inventory, index, count);
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.inventory, index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        ItemStack itemStack = (ItemStack)this.inventory.get(index);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemStack) && ItemStack.areItemStackShareTagsEqual(stack, itemStack);
        this.inventory.set(index, stack);

        if(stack.getCount() > this.getInventoryStackLimit())
            stack.setCount(this.getInventoryStackLimit());
        if(index == 0 && index + 1 == 1 && !flag) {
            ItemStack stack1 = (ItemStack)this.inventory.get(index + 1);
            this.totalCookTime = this.getCookTime(stack);
            this.cookTime = 0;
            this.markDirty();
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.inventory = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.inventory);
        this.burnTime = compound.getInteger("BurnTime");
        this.cookTime = compound.getInteger("CookTime");
        this.totalCookTime = compound.getInteger("CookTimeTotal");
        this.currentBurnTime = getItemBurnTime((ItemStack)this.inventory.get(2));

        if(compound.hasKey("CustomName", 8)) this.setCustomName(compound.getString("CustomName"));


    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setInteger("BurnTime", (short)this.burnTime);
        compound.setInteger("CookTime", (short)this.cookTime);
        compound.setInteger("CookTimeTotal", (short)this.totalCookTime);
        ItemStackHelper.saveAllItems(compound, this.inventory);

        if(this.hasCustomName()) compound.setString("CustomName", this.customName);
        this.markDirty();
        return compound;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    public boolean isBurning()
    {
        return this.burnTime > 0;
    }

    @SideOnly(Side.CLIENT)
    public static boolean isBurning(IInventory inventory)
    {
        return inventory.getField(0) > 0;
    }

    public void update()
    {
        boolean flag = this.isBurning();
        boolean flag1 = false;
        if(this.isBurning()) --this.burnTime;
        if(!this.world.isRemote)
        {
            ItemStack stack = (ItemStack)this.inventory.get(2);
            if(this.isBurning() || !stack.isEmpty() && !((((ItemStack)this.inventory.get(0)).isEmpty()) || ((ItemStack)this.inventory.get(1)).isEmpty()))
            {
                if(!this.isBurning() && this.canSmelt())
                {
                    this.burnTime = getItemBurnTime(stack);
                    this.currentBurnTime = this.burnTime;
                    if(this.isBurning())
                    {
                        flag1 = true;
                        if(!stack.isEmpty())
                        {
                            Item item = stack.getItem();
                            stack.shrink(1);
                            if(stack.isEmpty())
                            {
                                ItemStack item1 = item.getContainerItem(stack);
                                this.inventory.set(2, item1);
                            }
                        }
                    }
                }
                if(this.isBurning() && this.canSmelt())
                {
                    ++this.cookTime;
                    if(this.cookTime == this.totalCookTime)
                    {
                        this.cookTime = 0;
                        this.totalCookTime = this.getCookTime((ItemStack)this.inventory.get(1));
                        this.smeltItem();
                        flag1 = true;
                    }
                }
                else this.cookTime = 0;
            }
            else if(!this.isBurning() && this.cookTime > 0)
            {
                this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
            }
            if(flag != this.isBurning())
            {
                flag1 = true;
                MicroBrewerBlock.setState(this.isBurning(), this.world, this.pos);
            }
        }
        if(flag1) this.markDirty();
    }

    public int getCookTime(ItemStack input1)
    {
        String ItemName = input1.getItem().getUnlocalizedName();
        switch (ItemName){
            case "item.sugar":
                return 240;
            case "item.bbs_mod.lme_wheat":
                return 720;
            case "item.liberty.hop":
                return 1800;
            case "item.bbs_mod.wortkeg":
                return 1800;
            case "item.bbs_mod.yeast":
                return 16000;
            default:
                return 20;
        }
    }

    private boolean canSmelt()
    {
        if(((ItemStack)this.inventory.get(0)).isEmpty() || ((ItemStack)this.inventory.get(1)).isEmpty()) return false;
        //Check Recipe Item Quantity;
        if((this.inventory.get(0).getItem()==Items.SUGAR && this.inventory.get(0).getCount()<64) && (this.inventory.get(1).getItem()==Items.WHEAT && this.inventory.get(1).getCount()<64)) return false;
        else
        {
            ItemStack result = MicroBrewerRecipes.getInstance().getMicroBrewerResult((ItemStack)this.inventory.get(0), (ItemStack)this.inventory.get(1));
            if(result.isEmpty()) return false;
            else
            {
                ItemStack output = (ItemStack)this.inventory.get(3);
                if(output.isEmpty()) return true;
                if(!output.isItemEqual(result)) return false;
                int res = output.getCount() + result.getCount();
                return res <= getInventoryStackLimit() && res <= output.getMaxStackSize();
            }
        }
    }

    public void smeltItem()
    {
        if(this.canSmelt())
        {
            ItemStack input1 = (ItemStack)this.inventory.get(0);
            ItemStack input2 = (ItemStack)this.inventory.get(1);

            //Shrink Recipe Quantity
            if(input1.getItem()==Items.SUGAR) {
                if(input1.getCount()==64 && input2.getCount() == 64){
                    ItemStack result = MicroBrewerRecipes.getInstance().getMicroBrewerResult(input1, input2);
                    ItemStack output = (ItemStack) this.inventory.get(3);
                    if (output.isEmpty()) this.inventory.set(3, result.copy());
                    else if (output.getItem() == result.getItem()) output.grow(result.getCount());
                    input1.shrink(64);
                    input2.shrink(64);
                }
            }
            else {
                ItemStack result = MicroBrewerRecipes.getInstance().getMicroBrewerResult(input1, input2);
                ItemStack ic = new ItemStack(result.getItem());
                ItemStack output = (ItemStack) this.inventory.get(3);
                Item a = result.getItem();
                Item b = ItemInit.mashKegItem;
                Item c = ItemInit.HOTWORT_KEG;
                Item d = ItemInit.WORT_KEG;
                Item e = ItemInit.BEER_KEG;
                if(a == b){
                    String lme = input1.getItem().getUnlocalizedName();
                    String malt;
                    Integer lb;
                    Double lovi;
                    switch (lme){
                        case "item.bbs_mod.lme_pilsen":
                            malt = "Pilsen";
                            lb = 1;
                            lovi = 2.0;
                            break;
                        case "item.bbs_mod.lme_extralight":
                            malt = "Extralight";
                            lb = 2;
                            lovi = 2.5;
                            break;
                        case "item.bbs_mod.lme_wheat":
                            malt = "Wheat";
                            lb = 3;
                            lovi = 3.0;
                            break;
                        case "item.bbs_mod.lme_light":
                            malt = "Light";
                            lb = 4;
                            lovi = 4.0;
                            break;
                        case "item.bbs_mod.lme_munich":
                            malt = "Munich";
                            lb = 5;
                            lovi = 8.0;
                            break;
                        case "item.bbs_mod.lme_amber":
                            malt = "Amber";
                            lb = 6;
                            lovi = 10.0;
                            break;
                        case "item.bbs_mod.lme_dark":
                            malt = "Dark";
                            lb = 7;
                            lovi = 30.0;
                            break;
                        default:
                            return;
                    }
                    getTagCompoundSafe(ic).setString("malt", "LME " + malt);
                    getTagCompoundSafe(ic).setInteger("lb", lb);
                    getTagCompoundSafe(ic).setDouble("srm", BeerMath.RoundTo2Decimals(BeerMath.SRM(lovi, input1.getCount())));
                    getTagCompoundSafe(ic).setDouble("og", BeerMath.RoundTo3Decimals(BeerMath.OG(input1.getCount()*3.3,5)));
                    if (output.isEmpty()) this.inventory.set(3, ic);
                    input1.shrink(input1.getCount());
                    input2.shrink(1);
                } else if(a==c) {
                    String name[] = input1.getUnlocalizedName().split("[.]");
                    getTagCompoundSafe(ic).setString("malt", getTagCompoundSafe(input2).getString("malt"));
                    getTagCompoundSafe(ic).setInteger("lb", getTagCompoundSafe(input2).getInteger("lb"));
                    getTagCompoundSafe(ic).setDouble("srm", getTagCompoundSafe(input2).getDouble("srm"));
                    getTagCompoundSafe(ic).setDouble("og", getTagCompoundSafe(input2).getDouble("og"));
                    getTagCompoundSafe(ic).setDouble("ibu", BeerMath.RoundTo2Decimals(BeerMath.IBU(input1.getCount(),5.0, 5.0,getTagCompoundSafe(input2).getDouble("og"), name[1])));
                    if (output.isEmpty()) this.inventory.set(3, ic);
                    input1.shrink(input1.getCount());
                    input2.shrink(1);
                } else if(a==d) {
                    Double lb = getTagCompoundSafe(input2).getDouble("srm");
                    getTagCompoundSafe(ic).setString("malt", getTagCompoundSafe(input2).getString("malt"));
                    getTagCompoundSafe(ic).setInteger("lb", lb.intValue());
                    getTagCompoundSafe(ic).setDouble("srm", getTagCompoundSafe(input2).getDouble("srm"));
                    getTagCompoundSafe(ic).setDouble("og", getTagCompoundSafe(input2).getDouble("og"));
                    getTagCompoundSafe(ic).setDouble("ibu", getTagCompoundSafe(input2).getDouble("ibu"));
                    if (output.isEmpty()) this.inventory.set(3, ic);
                    input1.shrink(1);
                    input2.shrink(1);

                } else if(a==e) {
                    Double og = getTagCompoundSafe(input2).getDouble("og");
                    Double fg = BeerMath.RoundTo3Decimals(BeerMath.FG(og));
                    Double abv = BeerMath.RoundTo2Decimals(BeerMath.ABV(og,fg));
                    getTagCompoundSafe(ic).setString("malt", getTagCompoundSafe(input2).getString("malt"));
                    getTagCompoundSafe(ic).setInteger("lb", getTagCompoundSafe(input2).getInteger("lb"));
                    getTagCompoundSafe(ic).setDouble("srm", getTagCompoundSafe(input2).getDouble("srm"));
                    getTagCompoundSafe(ic).setDouble("og", og);
                    getTagCompoundSafe(ic).setDouble("ibu", getTagCompoundSafe(input2).getDouble("ibu"));
                    getTagCompoundSafe(ic).setDouble("fg", fg);
                    getTagCompoundSafe(ic).setDouble("abv", abv);
                    if (output.isEmpty()) this.inventory.set(3, ic);
                    input1.shrink(1);
                    input2.shrink(1);
                } else {
                if (output.isEmpty()) this.inventory.set(3, result.copy());
                else if (output.getItem() == result.getItem()) output.grow(result.getCount());
                input1.shrink(1);
                input2.shrink(1);
        }

            }
        }
    }

    private NBTTagCompound getTagCompoundSafe(ItemStack stack) {
        NBTTagCompound tagCompound = stack.getTagCompound();
        if (tagCompound == null) {
            tagCompound = new NBTTagCompound();
            stack.setTagCompound(tagCompound);
        }
        return tagCompound;
    }

    public static int getItemBurnTime(ItemStack fuel)
    {
        if(fuel.isEmpty()) return 0;
        else
        {
            Item item = fuel.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR)
            {
                Block block = Block.getBlockFromItem(item);
                if (block == Blocks.WOODEN_SLAB) return 150;
                if (block.getDefaultState().getMaterial() == Material.WOOD) return 300;
                if (block == Blocks.COAL_BLOCK) return 16000;
            }
            if (item instanceof ItemTool && "WOOD".equals(((ItemTool)item).getToolMaterialName())) return 200;
            if (item instanceof ItemSword && "WOOD".equals(((ItemSword)item).getToolMaterialName())) return 200;
            if (item instanceof ItemHoe && "WOOD".equals(((ItemHoe)item).getMaterialName())) return 200;
            if (item == Items.STICK) return 100;
            if (item == Items.COAL) return 1600;
            if (item == Items.LAVA_BUCKET) return 20000;
            if (item == Item.getItemFromBlock(Blocks.SAPLING)) return 100;
            if (item == Items.BLAZE_ROD) return 2400;

            return GameRegistry.getFuelValue(fuel);
        }
    }

    public static boolean isItemFuel(ItemStack fuel)
    {
        return getItemBurnTime(fuel) > 0;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player)
    {
        return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory(EntityPlayer player) {}

    @Override
    public void closeInventory(EntityPlayer player) {}

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {

        if(index == 3) return false;
        else if(index != 2) return true;
        else
        {
            return isItemFuel(stack);
        }
    }

    public String getGuiID()
    {
        return "textures/gui/microbrewer_gui.png";
    }

    @Override
    public int getField(int id)
    {
        switch(id)
        {
            case 0:
                return this.burnTime;
            case 1:
                return this.currentBurnTime;
            case 2:
                return this.cookTime;
            case 3:
                return this.totalCookTime;
            default:
                return 0;
        }
    }

    @Override
    public void setField(int id, int value)
    {
        switch(id)
        {
            case 0:
                this.burnTime = value;
                break;
            case 1:
                this.currentBurnTime = value;
                break;
            case 2:
                this.cookTime = value;
                break;
            case 3:
                this.totalCookTime = value;
        }
    }

    @Override
    public int getFieldCount()
    {
        return 4;
    }

    @Override
    public void clear()
    {
        this.inventory.clear();
    }

    public int[] getSlotsForFace(EnumFacing side)
    {
        if (side == EnumFacing.DOWN)
        {
            return SLOTS_BOTTOM;
        }
        else
        {
            return side == EnumFacing.UP ? SLOTS_TOP : SLOTS_SIDES;
        }
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side.
     */
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction)
    {
        return this.isItemValidForSlot(index, itemStackIn);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side.
     */
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction)
    {
        if (direction == EnumFacing.DOWN && index == 1)
        {
            Item item = stack.getItem();

            if (item != Items.WATER_BUCKET && item != Items.BUCKET)
            {
                return false;
            }
        }

        return true;
    }

    net.minecraftforge.items.IItemHandler handlerTop = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.UP);
    net.minecraftforge.items.IItemHandler handlerBottom = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.DOWN);
    net.minecraftforge.items.IItemHandler handlerSide = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.WEST);

    @SuppressWarnings("unchecked")
    @Override
    @javax.annotation.Nullable
    public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @javax.annotation.Nullable net.minecraft.util.EnumFacing facing)
    {
        if (facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            if (facing == EnumFacing.DOWN)
                return (T) handlerBottom;
            else if (facing == EnumFacing.UP)
                return (T) handlerTop;
            else
                return (T) handlerSide;
        return super.getCapability(capability, facing);
    }
}