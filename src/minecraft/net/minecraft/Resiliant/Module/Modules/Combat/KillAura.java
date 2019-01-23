package net.minecraft.Resiliant.Module.Modules.Combat;

import net.minecraft.src.*;
import org.lwjgl.input.Keyboard;

import net.minecraft.Resiliant.Resiliant;
import net.minecraft.Resiliant.Module.Category;
import net.minecraft.Resiliant.Module.Module;

public class KillAura extends Module {

	public double range = 6;
	public static EntityClientPlayerMP mpplayer;

	public KillAura() {
		super("Kill Aura", Keyboard.KEY_K, 0xffcc0000, Category.COMBAT);
		// TODO Auto-generated constructor stub
	}

	public void onTick() {
		if (this.getState()) {
			Entity player = Resiliant.mc.thePlayer;
			World world = player.worldObj;

			if (world != null) {

				AxisAlignedBB boundBox = AxisAlignedBB.getBoundingBox(player.posX - (range / 2D), player.posY - (range / 2D), player.posZ - (range / 2D),
						player.posX + (range / 2D), player.posY + (range / 2D), player.posZ + (range / 2D));

				for (Object object : world.getEntitiesWithinAABB(Entity.class, boundBox)) {
					if (object instanceof EntityPlayer) {
						EntityPlayer playerOther = (EntityPlayer) object;
						if (!playerOther.equals(player) && (!playerOther.isDead || playerOther.health > 0)) {
							((EntityPlayerSP) player).attackTargetEntityWithCurrentItem(playerOther);
						}
					} else if (object instanceof EntityLiving) {
						EntityLiving entityLiving = (EntityLiving) object;
						if (!entityLiving.isDead || entityLiving.health > 0) {
							System.out.println("hitting! + " + object);
							((EntityPlayerSP) player).attackTargetEntityWithCurrentItem(entityLiving);
						}
					}
					for (Object mpobject : world.getEntitiesWithinAABB(Entity.class, boundBox)) {
						EntityPlayer playerOther = (EntityPlayer) mpobject;
						if (!playerOther.equals(player) && (!playerOther.isDead || playerOther.health > 0)) {
							((EntityPlayerSP) player).attackTargetEntityWithCurrentItem(playerOther);
						} else if (mpobject instanceof EntityLiving) {
							EntityLiving entityLiving = (EntityLiving) mpobject;
							if (!entityLiving.isDead || entityLiving.health > 0) {
								System.out.println("hitting! + " + mpobject);
								((EntityPlayerSP) player).attackTargetEntityWithCurrentItem(entityLiving);
							}
						}
					}
				}
			}


		}
	}
}
