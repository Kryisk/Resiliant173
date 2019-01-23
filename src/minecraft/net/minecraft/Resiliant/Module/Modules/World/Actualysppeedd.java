package net.minecraft.Resiliant.Module.Modules.World;

import org.lwjgl.input.Keyboard;

import net.minecraft.Resiliant.Resiliant;
import net.minecraft.Resiliant.Module.Category;
import net.minecraft.Resiliant.Module.Module;
import net.minecraft.client.Minecraft;

public class Actualysppeedd extends Module{

	public Actualysppeedd() {
		super("NoFall", Keyboard.KEY_Z, 0xffff0000, Category.PLAYER);
		// TODO Auto-generated constructor stub#eb3b5a
	}
	
    
  
    
	public void onTick() {
		if(this.getState()) {
			
		}
	
		
	}
	
	public void onDisable() {
		

	}

}
