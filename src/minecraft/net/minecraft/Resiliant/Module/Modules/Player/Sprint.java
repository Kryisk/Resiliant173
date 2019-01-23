package net.minecraft.Resiliant.Module.Modules.Player;

import org.lwjgl.input.Keyboard;

import net.minecraft.Resiliant.Resiliant;
import net.minecraft.Resiliant.Module.Category;
import net.minecraft.Resiliant.Module.Module;
import net.minecraft.client.Minecraft;

public class Sprint extends Module{

	public Sprint() {
		super("Step", Keyboard.KEY_LCONTROL, 0xff008B45, Category.PLAYER);
		// TODO Auto-generated constructor stub
	}
	private Minecraft mc = null;
	public void onEnable() {
	
		mc.thePlayer.stepHeight = 1.0f;
	}
	
	public void onDisable() {
		mc.thePlayer.stepHeight = 0.5f;

	}

}
