package com.rafacost3d.bbs_mod.objects.blocks.containers;

import com.rafacost3d.bbs_mod.util.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class MicroPackGui extends GuiContainer {
    public static final int WIDTH = 180;
    public static final int HEIGHT = 152;

    private static final ResourceLocation background = new ResourceLocation(Reference.MODID, "textures/gui/micropackgui.png");

    public MicroPackGui(MicroPackTileEntity tileEntity, MicroPackContainer container) {
        super(container);
        xSize = WIDTH;
        ySize = HEIGHT;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
