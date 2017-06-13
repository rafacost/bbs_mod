package com.rafacost3d.bbs_mod.items;

import com.rafacost3d.bbs_mod.BBSMod;
import com.rafacost3d.bbs_mod.creativetabs.CreativeTabsBBS;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BeerBucket extends ItemBucket {
    protected String name;
    protected String hopsType;
    protected Double hops;


    public static BeerBucket instance;

    public BeerBucket(Block containedBlockIn) {
        super(containedBlockIn);
        name = "beerbucket";
        setRegistryName(name);
        setUnlocalizedName(BBSMod.MODID + "." + name);
        GameRegistry.register(this);
        this.setCreativeTab(CreativeTabsBBS.BBSTabsFluids);
        hopsType = "No Hop";
        hops = 0.0;
    }


    public String getHopsType() {
        return hopsType;
    }

    public void setHopsType(String hopsType) {
        this.hopsType = hopsType;
    }

    public Double getHopsQuant() {
        return hops;
    }

    public void setHopsQuant(Double hopsQuant) {
        this.hops = hopsQuant;
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        final ModelResourceLocation srm0Model = new ModelResourceLocation(getRegistryName() + "_srm0", "inventory");
        final ModelResourceLocation srm1Model = new ModelResourceLocation(getRegistryName() + "_srm1", "inventory");
        final ModelResourceLocation srm2Model = new ModelResourceLocation(getRegistryName() + "_srm2", "inventory");
        final ModelResourceLocation srm3Model = new ModelResourceLocation(getRegistryName() + "_srm3", "inventory");
        final ModelResourceLocation srm4Model = new ModelResourceLocation(getRegistryName() + "_srm4", "inventory");
        final ModelResourceLocation srm5Model = new ModelResourceLocation(getRegistryName() + "_srm5", "inventory");
        final ModelResourceLocation srm6Model = new ModelResourceLocation(getRegistryName() + "_srm6", "inventory");
        final ModelResourceLocation srm7Model = new ModelResourceLocation(getRegistryName() + "_srm7", "inventory");
        final ModelResourceLocation srm8Model = new ModelResourceLocation(getRegistryName() + "_srm8", "inventory");
        final ModelResourceLocation srm9Model = new ModelResourceLocation(getRegistryName() + "_srm9", "inventory");
        final ModelResourceLocation srm10Model = new ModelResourceLocation(getRegistryName() + "_srm10", "inventory");

        ModelBakery.registerItemVariants(this, srm0Model, srm1Model, srm2Model, srm3Model, srm4Model, srm5Model, srm6Model, srm7Model, srm8Model, srm9Model, srm10Model);

        ModelLoader.setCustomMeshDefinition(this, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                int srm = getSRM(stack);
                switch (srm) {
                    case 0:
                        return srm0Model;
                    case 1:
                        return srm1Model;
                    case 2:
                        return srm2Model;
                    case 3:
                        return srm3Model;
                    case 4:
                        return srm4Model;
                    case 5:
                        return srm5Model;
                    case 6:
                        return srm6Model;
                    case 7:
                        return srm7Model;
                    case 8:
                        return srm8Model;
                    case 9:
                        return srm9Model;
                    case 10:
                        return srm10Model;
                    default:
                        return srm0Model;

                }
            }
        });
    }

    private Integer getSRM(ItemStack stack) {
        int SRM;
        if(stack.hasTagCompound()) {
            SRM = (int) Math.round(stack.getTagCompound().getDouble("srm"));
        } else {
            SRM = 0;
        }
        return SRM;
    }

    private NBTTagCompound getTagCompoundSafe(ItemStack stack) {
        NBTTagCompound tagCompound = stack.getTagCompound();
        if (tagCompound == null) {
            tagCompound = new NBTTagCompound();
            stack.setTagCompound(tagCompound);
        }
        return tagCompound;
    }

    String[] wortTypes = { "hopsleaf"};

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        if (stack.hasTagCompound())
        {
            NBTTagCompound itemData = stack.getTagCompound();
            if (itemData.hasKey("wortTypes"))
            {
                return "item." + BBSMod.MODID + ".beertype." + itemData.getString("beerType");
            }
        }
        return "item.bbs_mod.beertype.nullBeer";
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List itemList)
    {
        for (int pos = 0; pos < wortTypes.length; pos++)
        {
            ItemStack wortStack = new ItemStack(item);
            wortStack.setTagCompound(new NBTTagCompound());
            wortStack.getTagCompound().setString("beerType", wortTypes[pos]);
            itemList.add(wortStack);
        }
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player,
                               List tooltip, boolean isAdvanced)
    {
        if ( stack.hasTagCompound()
                && stack.getTagCompound().hasKey("beerType"))
        {
            tooltip.add("Hops: " + I18n.format("item." + stack.getTagCompound().getString("beerType") + ".hop.name"));
            tooltip.add("IBU: " + String.format("%.2f",stack.getTagCompound().getDouble("ibu")));
            tooltip.add("SRM: " + String.format("%.2f",stack.getTagCompound().getDouble("srm")));
            tooltip.add("ABV: " + String.format("%.2f",stack.getTagCompound().getDouble("abv")) + "%");
            tooltip.add("OG: " + String.format("%.3f",stack.getTagCompound().getDouble("og")));
            tooltip.add("FG: " + String.format("%.3f",stack.getTagCompound().getDouble("fg")));
        }
        else
        {
            tooltip.add(I18n.format("tooltip.bbs_mod.beertype.nullBeer.desc"));
        }
    }
}
