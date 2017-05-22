package com.rafacost3d.bbs_mod.init;


import com.rafacost3d.bbs_mod.blocks.machines.pelleter.ContainerPelleter;
import com.rafacost3d.bbs_mod.blocks.machines.pelleter.GuiPelleter;
import com.rafacost3d.bbs_mod.blocks.machines.pelleter.TileEntityPelleter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class BBSGuiHandler implements IGuiHandler {
    public static final int PELLETER = 0;

    @Override
    public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case PELLETER:
                return new ContainerPelleter(player.inventory, (TileEntityPelleter) world.getTileEntity(new BlockPos(x, y, z)));
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case PELLETER:
                return new GuiPelleter(getServerGuiElement(ID, player, world, x, y, z), player.inventory);
            default:
                return null;
        }
    }

}
