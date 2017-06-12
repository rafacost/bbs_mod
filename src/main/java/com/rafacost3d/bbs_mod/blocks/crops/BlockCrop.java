package com.rafacost3d.bbs_mod.blocks.crops;

import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.common.FMLLog;

import java.util.List;
import java.util.Random;

public class BlockCrop extends BlockCrops implements IPlantable {

    private static final int MATURE_AGE = 7;

    private static final PropertyInteger AGE = PropertyInteger.create("age", 0, MATURE_AGE);

    private static final AxisAlignedBB[] CROPS_AABB = new AxisAlignedBB[]{new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.625D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.875D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D)};

    private final String registerName;
    public final String name;
    private String BASE_STAGE_ID = null;

    private Item seed;
    private Item food;

    public void setSeed(Item seed) {
        this.seed = seed;
    }

    public void setFood(Item food) {
        this.food = food;
    }

    public BlockCrop(String registerName, String name) {
        super();
        this.registerName = registerName;
        this.name = name;
        this.setDefaultState(blockState.getBaseState().withProperty(getAgeProperty(), 0));
    }

     public String getStageId(int stage) {
        if (BASE_STAGE_ID == null) {
            BASE_STAGE_ID = registerName.replaceFirst("hop", "").replace("Crop", "") + "_stage";
        }
        return BASE_STAGE_ID + stage;
    }


    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        // CROPS_AABB is based on an age range from 0 to 7. Times two should fix that issue.
        return CROPS_AABB[state.getValue(AGE)];
    }

    private boolean isSuitableSoilBlock(Block soilBlock) {
        return soilBlock == Blocks.FARMLAND;
    }

    @Override
    public PropertyInteger getAgeProperty() {
        return AGE;
    }

    public int getMatureAge() {
        return MATURE_AGE;
    }

    public boolean isMature(IBlockState state) {
        return state.getValue(getAgeProperty()) >= MATURE_AGE;
    }

    @Override
    public Item getSeed() {
        if (seed == null) {
            FMLLog.bigWarning("No seed have been set up for %s.", getUnlocalizedName());
            return new Item();
        }
        return seed;
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(getSeed());
    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return !isMature(state);
    }

    @Override
    public Item getCrop() {
        if (food == null) {
            FMLLog.bigWarning("No food has been set up for %s.", getUnlocalizedName());
            return new Item();
        }

        return food;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(getAgeProperty(), meta);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        this.checkAndDropBlock(worldIn, pos, state);

        if (worldIn.getLightFromNeighbors(pos.up()) >= 9) {
            int currentGrowthLevel = getMetaFromState(state);

            if (currentGrowthLevel < getMatureAge()) {
                float f = getGrowthChance(this, worldIn, pos);

                if (rand.nextInt((int) (50.0F / f) + 1) == 0) {
                    worldIn.setBlockState(pos, this.getStateFromMeta(currentGrowthLevel + 1), 2);
                }
            }
        }
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        if (!isMature(state)) {
            return getSeed();
        } else {
            return getCrop();
        }
    }

    public int getMetaFromState(IBlockState state) {
        return state.getValue(getAgeProperty());
    }

    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos) {
        Block soilBlock = world.getBlockState(pos.down()).getBlock();

        return isSuitableSoilBlock(soilBlock);
    }

    @Override
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
        if (!worldIn.isRemote && !worldIn.restoringBlockSnapshots) {
            final List<ItemStack> items = getDrops(worldIn, pos, state, fortune);
            chance = ForgeEventFactory.fireBlockHarvesting(items, worldIn, pos, state, fortune, chance, false, harvesters.get());

            for (ItemStack item : items) {
                if (worldIn.rand.nextFloat() <= chance) {
                    spawnAsEntity(worldIn, pos, item);
                }
            }
        }
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return EnumPlantType.Plains;
    }

    @Override
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, AGE);
    }

    private int getRandomInt(World world) {
        return MathHelper.getInt(world.rand, 1, 3);
    }

    @Override
    public void grow(World worldIn, BlockPos pos, IBlockState state) {
        int newGrowth = getMetaFromState(state) + getRandomInt(worldIn);

        if (newGrowth > MATURE_AGE) {
            newGrowth = MATURE_AGE;
        }

        worldIn.setBlockState(pos, getStateFromMeta(newGrowth), 2);
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        grow(worldIn, pos, state);
    }

    @Override
    public int hashCode() {
        return registerName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof BlockCrop && registerName.equals(((BlockCrop) obj).registerName));
    }

    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {

        final List<ItemStack> ret = new java.util.ArrayList<ItemStack>();

        final Random rand = world instanceof World ? ((World) world).rand : new Random();

        final int age = getMetaFromState(state);

        final int count = quantityDropped(state, fortune, rand);

        for (int i = 0; i < count; i++) {
            final Item item = this.getItemDropped(state, rand, fortune);
            if (item != null) {
                ret.add(new ItemStack(item, 1, this.damageDropped(state)));
            }
        }

        if (age >= getMatureAge()) {
            for (int i = 0; i < 3 + fortune; ++i) {
                if (rand.nextInt(2 * getMatureAge()) <= age) {
                    ret.add(new ItemStack(getSeed(), 1, 0));
                }
            }
        }

        return ret;
    }

    @Override
    protected boolean canSustainBush(IBlockState state) {
        return isSuitableSoilBlock(state.getBlock());
    }

    @Override
    public int getMaxAge() {
        return getMatureAge();
    }

    @Override
    protected int getAge(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    public IBlockState withAge(int age) {
        return getDefaultState().withProperty(AGE, age);
    }

    @Override
    public boolean isMaxAge(IBlockState state) {
        return getAge(state) >= getMaxAge();
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return getAge(state) < getMaxAge();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if(!world.isRemote) {
            if (this.isMaxAge(state)) {
                Random r = new Random();
                int Low = 1;
                int High = 6;
                int Result = r.nextInt(High-Low) + Low;
                EntityItem item = new EntityItem(world,pos.getX(), pos.getY(), pos.getZ(), new ItemStack(getCrop(), Result));
                world.spawnEntity((item));
                world.setBlockState(pos, this.withAge(6));
                return true;
            }
        }
        return false;
    }

}
