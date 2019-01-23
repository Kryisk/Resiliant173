package net.minecraft.Resiliant.Gui;

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


import net.minecraft.client.Minecraft;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.GuiButton;

public class CustomButton extends GuiButton {

	public void drawBorderedRect(int x, int y, int x1, int y1, int size, int borderC, int insideC)
	{
	    drawRect(x + size, y + size, x1 - size, y1 - size, insideC);
	    drawRect(x + size, y + size, x1, y, borderC);
	    drawRect(x, y, x + size, y1, borderC);
	    drawRect(x1, y1, x1 - size, y + size, borderC);
	    drawRect(x, y1 - size, x1, y1, borderC);
	}
	
public CustomButton(int i, int j, int k, String s)
{
    this(i, j, k, 120, 20, s);
}

public CustomButton(int i, int j, int k, int l, int i1, String s)
{
    super(i, j, k, l, i1, s);
}

protected int getHoverState(boolean flag)
{
    byte byte0 = 1;
    if (!enabled)
    {
            byte0 = 0;
            }
    else if (flag)
    {
            byte0 = 2;
    }
    return byte0;
    }

public void drawButton(Minecraft mc, int mx, int my)
{
    FontRenderer fontrenderer = mc.fontRenderer;
    boolean flag = mx >= xPosition && my >= yPosition && mx < xPosition + width && my < yPosition + height;  //Flag, tells if your mouse is hovering the button
    if (flag)
    { // Hover Action
            drawBorderedRect(xPosition, yPosition, xPosition + width, yPosition + height, 1, 0x90FFFFFF, 0x80000000);
            drawCenteredString(fontrenderer, displayString, xPosition + width / 2, yPosition + (height - 8) / 2, 0xFFFFFFFF);
    }
    else { // Normal
            drawBorderedRect(xPosition, yPosition, xPosition + width, yPosition + height, 1, 0x90FFFFFF, 0x60000000);
            drawCenteredString(fontrenderer, displayString, xPosition + width / 2, yPosition + (height - 8) / 2, 0xFFCCCCCC);
    }
}

}