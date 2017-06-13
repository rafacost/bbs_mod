package com.rafacost3d.bbs_mod.blocks.machines.fermentorbucket;

import com.rafacost3d.bbs_mod.BBSMod;
import com.rafacost3d.bbs_mod.init.BBSBlocks;
import com.rafacost3d.bbs_mod.init.BBSConstants;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiFermentor extends GuiContainer {
    private static final ResourceLocation BG_TEXTURE = new ResourceLocation(BBSMod.MODID, "textures/gui/aluminium_kettle.png");
    private InventoryPlayer playerInv;

    public GuiFermentor(Container container, InventoryPlayer playerInv) {
        super(container);
        this.playerInv = playerInv;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1, 1, 1, 1);
        mc.getTextureManager().bindTexture(BG_TEXTURE);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String name = I18n.format(BBSBlocks.fermentorBucket.getUnlocalizedName() + ".name");
        fontRendererObj.drawString(name, xSize / 2 - fontRendererObj.getStringWidth(name) / 2, 6, 0x404040);
        fontRendererObj.drawString(playerInv.getDisplayName().getUnformattedText(), 8, ySize - 94, 0x404040);
        fontRendererObj.drawString(BBSConstants.ROOM_TEMP + " " + BBSConstants.DEGREE, 138, 73, 0x404040);
        fontRendererObj.drawString("Water", 27, 21, 0x404040);
        fontRendererObj.drawString("Yeast", 27, 40, 0x404040);
        fontRendererObj.drawString("Extras", 27, 59, 0x404040);
        fontRendererObj.drawString("Wort", 74, 53, 0x404040);
    }
}
