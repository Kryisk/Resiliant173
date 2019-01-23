package net.minecraft.Resiliant.Module.Modules.Player;

import org.lwjgl.input.Keyboard;

import net.minecraft.Resiliant.Resiliant;
import net.minecraft.Resiliant.Module.Category;
import net.minecraft.Resiliant.Module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.src.Entity;

public class fastwalk extends Module{

	public fastwalk() {
		super("Sneak Enabled", Keyboard.KEY_C, 0xff00aa00, Category.PLAYER);
		// TODO Auto-generated constructor stub#eb3b5a
	}
	
	public void onTick() {
		if(this.getState()) {
		}
	
		
	}
	
	public void onDisable() {
		

	}

}
