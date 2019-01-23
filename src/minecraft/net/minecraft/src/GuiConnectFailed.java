// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, StringTranslate, GuiButton, GuiMainMenu

public class GuiConnectFailed extends GuiScreen
{

    public GuiConnectFailed(String s, String s1, Object aobj[])
    {
        StringTranslate stringtranslate = StringTranslate.getInstance();
        errorMessage = stringtranslate.translateKey(s);
        if(aobj != null)
        {
            errorDetail = stringtranslate.translateKeyFormat(s1, aobj);
        } else
        {
            errorDetail = stringtranslate.translateKey(s1);
        }
    }

    public void updateScreen()
    {
    }

    protected void keyTyped(char c, int i)
    {
    }

    public void initGui()
    {
        StringTranslate stringtranslate = StringTranslate.getInstance();
        controlList.clear();
        controlList.add(new GuiButton(0, width / 2 - 100, height / 4 + 120 + 12, stringtranslate.translateKey("gui.toMenu")));
        controlList.add(new GuiButton(1, width / 2 - 100, height / 4 + 120 + 52, stringtranslate.translateKey("Reconnect")));

    }

    protected void actionPerformed(GuiButton guibutton)
    {
        if(guibutton.id == 0)
        {
            mc.displayGuiScreen(new GuiMainMenu());
        }
        if(guibutton.id == 1)
        {
        	String s = "Betalands.com";
            mc.gameSettings.lastServer = s.replaceAll(":", "_");
            mc.gameSettings.saveOptions();
            String as[] = s.split(":");
            if(s.startsWith("["))
            {
                int i = s.indexOf("]");
                if(i > 0)
                {
                    String s1 = s.substring(1, i);
                    String s2 = s.substring(i + 1).trim();
                    if(s2.startsWith(":") && s2.length() > 0)
                    {
                        s2 = s2.substring(1);
                        as = new String[2];
                        as[0] = s1;
                        as[1] = s2;
                    } else
                    {
                        as = new String[1];
                        as[0] = s1;
                    }
                }
            }
            if(as.length > 2)
            {
                as = new String[1];
                as[0] = s;
            }
            mc.displayGuiScreen(new GuiConnecting(mc, as[0], as.length <= 1 ? 25565 : parseIntWithDefault(as[1], 25565)));
        
        }
    }
    private int parseIntWithDefault(String s, int i)
    {
        try
        {
            return Integer.parseInt(s.trim());
        }
        catch(Exception exception)
        {
            return i;
        }
    }

    public void drawScreen(int i, int j, float f)
    {
        drawDefaultBackground();
        drawCenteredString(fontRenderer, errorMessage, width / 2, height / 2 - 50, 0xffffff);
        drawCenteredString(fontRenderer, errorDetail, width / 2, height / 2 - 10, 0xffffff);
        super.drawScreen(i, j, f);
    }

    private String errorMessage;
    private String errorDetail;
    
}
