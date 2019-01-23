package net.minecraft.Resiliant.Module.Modules.Render;

import org.lwjgl.input.Keyboard;

import net.minecraft.Resiliant.Module.Category;
import net.minecraft.Resiliant.Module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.src.EntityRenderer;

public class jvision extends Module{

	private static EntityRenderer er;
	private static Minecraft mc;
	public static final int[] blockList = { 56, 15 };
	
	public jvision() {
		super("Wallhack", Keyboard.KEY_X, 0xffB0D1D8, Category.RENDER);
		// TODO Auto-generated constructor stub
	}
	
	public void onEnable() {
        Minecraft.renderGlobal.loadRenderers();
		
	}
	
	public void onDisable() {
        Minecraft.renderGlobal.loadRenderers();

	}
	
	

}
