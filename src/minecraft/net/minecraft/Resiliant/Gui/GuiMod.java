package net.minecraft.Resiliant.Gui;

import net.minecraft.Resiliant.Resiliant;
import net.minecraft.Resiliant.Module.Modules.Player.Actualysppeedd;
import net.minecraft.Resiliant.Module.Modules.Player.Flight;
import net.minecraft.Resiliant.Module.Modules.Player.Jesus;
import net.minecraft.Resiliant.Module.Modules.Player.Nuker;
import net.minecraft.Resiliant.Module.Modules.Player.Speedmine;
import net.minecraft.Resiliant.Module.Modules.Player.fastwalk;
import net.minecraft.Resiliant.Module.Modules.Player.nameprotect;
import net.minecraft.Resiliant.Module.Modules.Player.waterplace;
import net.minecraft.Resiliant.Module.Modules.Render.Fullbright;
import net.minecraft.Resiliant.Module.Modules.Render.jvision;
import net.minecraft.src.EnumOptions;
import net.minecraft.src.GameSettings;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiControls;
import net.minecraft.src.GuiIngame;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSmallButton;
import net.minecraft.src.GuiVideoSettings;
import net.minecraft.src.StringTranslate;

public class GuiMod extends GuiScreen{
	
	
	
	public GuiMod(GuiScreen guiscreen) {
		screenTitle = "ModManager";
	    parentScreen = guiscreen;
	}
	
	@SuppressWarnings("unchecked")
	public void initGui() {
        StringTranslate stringtranslate = StringTranslate.getInstance();
          controlList.add(new CustomButton(1, 100, 400, stringtranslate.translateKey("gui.done")));
		  controlList.add(new CustomButton(2,10 , 10, stringtranslate.translateKey("Nofall")));
	      controlList.add(new CustomButton(3,10 , 50, stringtranslate.translateKey("Sneak")));
	      controlList.add(new CustomButton(4,10 , 90, stringtranslate.translateKey("Brightness")));
	      controlList.add(new CustomButton(5,10 , 130, stringtranslate.translateKey("Flight")));
	      controlList.add(new CustomButton(6,10 , 170, stringtranslate.translateKey("SpeedMine")));
	      controlList.add(new CustomButton(7,10 , 210, stringtranslate.translateKey("Jesus")));
	      controlList.add(new CustomButton(8,10 , 250, stringtranslate.translateKey("WaterPlace")));
	      controlList.add(new CustomButton(9,10 , 290, stringtranslate.translateKey("Nuker")));
	      controlList.add(new CustomButton(10,10 , 330, stringtranslate.translateKey("Wallhack")));
	      controlList.add(new CustomButton(11,10 , 370, stringtranslate.translateKey("Nameprotect")));

	}
	
	public void drawScreen(int i, int j, float f)
    {
	    drawDefaultBackground();
	    drawCenteredString(fontRenderer, screenTitle, width / 2, 20, 0xffffff);
	    super.drawScreen(i, j, f);
	}
	 

    protected void actionPerformed(GuiButton guibutton)
    {
    	if(guibutton.id == 1)
        {
          
           mc.setIngameFocus();
        }
    	if(guibutton.id == 2)
        {
          
          Resiliant.modulemanager.getModule(Actualysppeedd.class).toggleModule();
        }
    	if(guibutton.id == 3)
        {
          
            Resiliant.modulemanager.getModule(fastwalk.class).toggleModule();
            
        }
    	if(guibutton.id == 4)
        {
          
            Resiliant.modulemanager.getModule(Fullbright.class).toggleModule();
        }
    	if(guibutton.id == 5)
        {
          
            Resiliant.modulemanager.getModule(Flight.class).toggleModule();
        }
    	if(guibutton.id == 6)
        {
          
            Resiliant.modulemanager.getModule(Speedmine.class).toggleModule();
        }
    	if(guibutton.id == 7)
        {
          
            Resiliant.modulemanager.getModule(Jesus.class).toggleModule();
        }
    	if(guibutton.id == 8)
        {
          
            Resiliant.modulemanager.getModule(waterplace.class).toggleModule();
        }
    	if(guibutton.id == 9)
        {
          
            Resiliant.modulemanager.getModule(Nuker.class).toggleModule();
        }
        if(guibutton.id == 10)
        {
          
            Resiliant.modulemanager.getModule(jvision.class).toggleModule();
        }
        if(guibutton.id == 11)
        {
          
            Resiliant.modulemanager.getModule(nameprotect.class).toggleModule();
        }
    }
	 
	    private GuiScreen parentScreen;
	    protected String screenTitle;
	    private GameSettings options;
}
