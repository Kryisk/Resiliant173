package net.minecraft.Resiliant.Module.Modules.Render;

import org.lwjgl.input.Keyboard;

import net.minecraft.Resiliant.Resiliant;
import net.minecraft.Resiliant.Gui.GuiMod;
import net.minecraft.Resiliant.Module.Category;
import net.minecraft.Resiliant.Module.Module;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSelectWorld;


public class GuiAllocation extends Module{

	GuiScreen gui;
	
	public GuiAllocation() {
		super("Gui", Keyboard.KEY_RSHIFT, 0xf, Category.GUI);
		// TODO Auto-generated constructor stub
	}
	
	public void onEnable() {
		
			
	}
	
	public void onDisable() {
	}

}
