package com.rafacost3d.bbs_mod.proxy;

import com.rafacost3d.bbs_mod.objects.blocks.containers.MicroPackContainer;
import com.rafacost3d.bbs_mod.objects.blocks.containers.MicroPackGui;
import com.rafacost3d.bbs_mod.objects.blocks.containers.MicroPackTileEntity;
import com.rafacost3d.bbs_mod.objects.blocks.machines.MicroBrewerContainer;
import com.rafacost3d.bbs_mod.objects.blocks.machines.MicroBrewerGui;
import com.rafacost3d.bbs_mod.objects.blocks.machines.TileEntityMicroBrewer;
import com.rafacost3d.bbs_mod.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiProxy implements IGuiHandler{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof MicroPackTileEntity) {
            return new MicroPackContainer(player.inventory, (MicroPackTileEntity) te);
        }
        {
            if(ID == Reference.GUI_MICROBREWER) return new MicroBrewerContainer(player.inventory, (TileEntityMicroBrewer) world.getTileEntity(new BlockPos(x,y,z)));
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof MicroPackTileEntity) {
            MicroPackTileEntity containerTileEntity = (MicroPackTileEntity) te;
            return new MicroPackGui(containerTileEntity, new MicroPackContainer(player.inventory, containerTileEntity));
        }
        if(ID == Reference.GUI_MICROBREWER) return new MicroBrewerGui(player.inventory, (TileEntityMicroBrewer)world.getTileEntity(new BlockPos(x,y,z)));

        return null;
    }
}
