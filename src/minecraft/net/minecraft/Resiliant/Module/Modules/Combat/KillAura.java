package net.minecraft.Resiliant.Module.Modules.Combat;

import org.lwjgl.input.Keyboard;

import net.minecraft.Resiliant.Resiliant;
import net.minecraft.Resiliant.Module.Category;
import net.minecraft.Resiliant.Module.Module;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityClientPlayerMP;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerSP;

public class KillAura extends Module{

    public static EntityClientPlayerMP mpplayer;
    public static EntityAnimal animal;
	public KillAura() {
		super("Kill Aura", Keyboard.KEY_K, 0xffcc0000, Category.COMBAT);
		// TODO Auto-generated constructor stub
	}
	
	public void onTick() {
		if(this.getState()) {
			
		
			
			Entity entity = Resiliant.mc.thePlayer;
			
			int distance = (int) Resiliant.mc.thePlayer.getDistanceToEntity(entity);
			
			if(distance > 6 || entity instanceof EntityPlayerSP ) {
				return;
			}
			
			if(distance < 5 && entity instanceof EntityAnimal) {
				Resiliant.mc.thePlayer.attackTargetEntityWithCurrentItem(animal);
			}
			
			if(distance < 5 && entity instanceof EntityClientPlayerMP) {
				Resiliant.mc.thePlayer.attackTargetEntityWithCurrentItem(entity);
			}
		}
			
	}
	
	public void onDisable() {
		
	}

}
