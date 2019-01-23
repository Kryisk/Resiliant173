package net.minecraft.Resiliant.Module.Modules.Player;

import org.lwjgl.input.Keyboard;

import net.minecraft.Resiliant.Module.Category;
import net.minecraft.Resiliant.Module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.src.EntityPlayerSP;

public class Flight extends Module{

	public static Minecraft mc = null;
	public static EntityPlayerSP et;
	public Flight() {
		super("Flight", Keyboard.KEY_V, 0xffFFC312, Category.PLAYER);
		// TODO Auto-generated constructor stub
	}
	public void onEnable() {
		
	}

	public void onDisable() {
		

	}
}