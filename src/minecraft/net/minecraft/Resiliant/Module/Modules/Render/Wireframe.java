package net.minecraft.Resiliant.Module.Modules.Render;

import org.lwjgl.input.Keyboard;

import net.minecraft.Resiliant.Module.Category;
import net.minecraft.Resiliant.Module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.src.EntityRenderer;

public class Wireframe  extends Module{

	private static EntityRenderer er;
	
	public Wireframe() {
		super("Wireframe", 12342134, 0xffEAa713, Category.RENDER);
		// TODO Auto-generated constructor stub
	}
	
	public void onEnable() {
        Minecraft.renderGlobal.loadRenderers();
		
	}
	
	public void onDisable() {
        Minecraft.renderGlobal.loadRenderers();

	}

}
