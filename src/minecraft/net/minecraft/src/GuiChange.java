package net.minecraft.src;

public class GuiChange extends GuiScreen
{

    public GuiChange(GuiScreen guiscreen, GameSettings gamesettings)
    {
        screenTitle = "Options";
        parentScreen = guiscreen;
        options = gamesettings;
    }

    public void initGui()
    {
        StringTranslate stringtranslate = StringTranslate.getInstance();
        screenTitle = stringtranslate.translateKey("ChangeLog");
       
        controlList.add(new GuiButton(200, this.width - 220, height - 40, stringtranslate.translateKey("gui.done")));
    }

    protected void actionPerformed(GuiButton guibutton)
    {
 
        if(guibutton.id == 200)
        {
            mc.gameSettings.saveOptions();
            mc.displayGuiScreen(parentScreen);
        }
    }

    public void drawScreen(int i, int j, float f)
    {
        drawDefaultBackground();
        drawCenteredString(fontRenderer, screenTitle, width / 2, 10, 0xffffff);
        super.drawScreen(i, j, f);
        drawString(fontRenderer, "Version: 0.0", 20, 10, 0xffffff);
        drawString(fontRenderer, "-First decompiled", 45, 21, 0xffffff);
        drawString(fontRenderer, "-Added Full Bright", 45, 32, 0xffffff);
        drawString(fontRenderer, "-Added Sneak", 45, 43, 0xffffff);
        drawString(fontRenderer, "Version: 0.1", 20, 54, 0xffffff);
        drawString(fontRenderer, "-Added No Fall", 45, 65, 0xffffff);
        drawString(fontRenderer, "-Added Flight", 45, 76, 0xffffff);
        drawString(fontRenderer, "-Added Xray", 45, 87, 0xffffff);
        drawString(fontRenderer, "-Added Basic Commands", 45, 98, 0xffffff);
        drawString(fontRenderer, "Version: 0.2", 20, 109, 0xffffff);
        drawString(fontRenderer, "-Added .help and .who", 45, 120, 0xffffff);
        drawString(fontRenderer, "-Added .up", 45, 131, 0xffffff);
        drawString(fontRenderer, "Version: 0.3", 20, 142, 0xffffff);
        drawString(fontRenderer, "-Added Speedy Gonzalas", 45, 153, 0xffffff);
        drawString(fontRenderer, "-Added Speedy Gonzalas working as instant in singleplayer", 45, 164, 0xffffff);
        drawString(fontRenderer, "Version: 0.4", 20, 175, 0xffffff);
        drawString(fontRenderer, "-Removed .up", 45, 186, 0xffffff);
        drawString(fontRenderer, "-Added New gui updates", 45, 197, 0xffffff);
        drawString(fontRenderer, "Version: 0.4", 20, 208, 0xffffff);
        drawString(fontRenderer, "-Added NameTags", 45, 219, 0xffffff);
        drawString(fontRenderer, "Version: 0.5", 20, 230, 0xffffff);
        drawString(fontRenderer, "-Added Name Protect", 45, 241, 0xffffff);
        drawString(fontRenderer, "Version: 0.6", 20, 252, 0xffffff);
        drawString(fontRenderer, "-Added X,Y,Z Coords in Guiingame", 45, 263, 0xffffff);
        drawString(fontRenderer, "Version: 0.7", 20, 274, 0xffffff);
        drawString(fontRenderer, "-Added Changelog", 45, 285, 0xffffff);
        drawString(fontRenderer, "-Optimized Code", 45, 296, 0xffffff);
        drawString(fontRenderer, "-Added Fastplace", 45, 307, 0xffffff);
        drawString(fontRenderer, "-Added .drop", 45, 318, 0xffffff);
        drawString(fontRenderer, "Version: 0.8", 20, 329, 0xffffff);
        drawString(fontRenderer, "-Updated GuiMainMenu", 45, 340, 0xffffff);
        drawString(fontRenderer, "-Added No Collision", 45, 351, 0xffffff);
        drawString(fontRenderer, "Version: 0.9", 20, 362, 0xffffff);
        drawString(fontRenderer, "-Added Gui for modules -rshift", 45, 373, 0xffffff);
        drawString(fontRenderer, "-Added TorchNuke", 45, 384, 0xffffff);
        drawString(fontRenderer, "-Added Toggleable name protect", 45, 395, 0xffffff);
        drawString(fontRenderer, "-Added .music", 45, 406, 0xffffff);
        drawString(fontRenderer, "-Added Kill Aura", 45, 417, 0xffffff);
        drawRect(2, height - 14, width - 2, height - 2, 0x80000000);
        drawString(fontRenderer, "§7Minecraft version 1.7.3, I've gotten us up to 0.9! Check changelog for updates. MAJOR: New gui press Right shift to toggle, still being tweaked", (int) ((System.currentTimeMillis() /  25)  % this.width - this.width), this.height - 12, 0xffffff);
        drawString(fontRenderer, "§7Minecraft version 1.7.3, I've gotten us up to 0.9! Check changelog for updates. MAJOR: New gui press Right shift to toggle, still being tweaked", (int) ((System.currentTimeMillis() /  25)  % this.width), this.height - 12, 0xffffff);

    }

    private GuiScreen parentScreen;
    protected String screenTitle;
    private GameSettings options;
    private static EnumOptions field_22135_k[];

    static 
    {
        field_22135_k = (new EnumOptions[] {
            EnumOptions.MUSIC, EnumOptions.SOUND, EnumOptions.INVERT_MOUSE, EnumOptions.SENSITIVITY, EnumOptions.DIFFICULTY
        });
    }
}
