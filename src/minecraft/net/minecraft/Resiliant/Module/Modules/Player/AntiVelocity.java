package net.minecraft.Resiliant.Module.Modules.Player;

import org.lwjgl.input.Keyboard;

import net.minecraft.Resiliant.Module.Category;
import net.minecraft.Resiliant.Module.Module;

public class AntiVelocity extends Module{

	public AntiVelocity() {
		super("Anti Velocity", Keyboard.KEY_J, 0xff00aa00, Category.PLAYER);
		// TODO Auto-generated constructor stub#eb3b5a
	}
	
	public void onTick() {
		if(this.getState()) {
		}
	
		
	}
	
	public void onDisable() {
		

	}

}
