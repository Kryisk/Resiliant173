package net.minecraft.Resiliant.Module.Modules;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.src.EntityPlayerSP;

public class Fly {
	
	public static Minecraft mc = null;
	 
	public void fly(EntityPlayerSP et) {
		et.onGround = false;
		et.motionX = 0.0D;
		et.motionY = 0.0D;
		et.motionZ = 0.0D;
    
    double d2 = et.rotationYaw + 90.0F;
    
    boolean flag = (Keyboard.isKeyDown(17)) && (mc.inGameHasFocus);
    boolean flag1 = (Keyboard.isKeyDown(31)) && (mc.inGameHasFocus);
    boolean flag2 = (Keyboard.isKeyDown(30)) && (mc.inGameHasFocus);
    boolean flag3 = (Keyboard.isKeyDown(32)) && (mc.inGameHasFocus);
    if (flag)
    {
      if (flag2) {
        d2 -= 45.0D;
      } else if (flag3) {
        d2 += 45.0D;
      }
    }
    else if (flag1)
    {
      d2 += 180.0D;
      if (flag2) {
        d2 += 45.0D;
      } else if (flag3) {
        d2 -= 45.0D;
      }
    }
    else if (flag2)
    {
      d2 -= 90.0D;
    }
    else if (flag3)
    {
      d2 += 90.0D;
    }
    if ((flag) || (flag2) || (flag1) || (flag3))
    {
    	et.motionX = Math.cos(Math.toRadians(d2));
    	et.motionZ = Math.sin(Math.toRadians(d2));
    }
    if ((Keyboard.isKeyDown(57)) && (mc.inGameHasFocus)) {
    	et.motionY += 3.0D;
    } else if ((Keyboard.isKeyDown(42)) && (mc.inGameHasFocus)) {
    	et.motionY -= 3.0D;
    } else if ((Keyboard.isKeyDown(82)) && (mc.inGameHasFocus)) {
    	et.motionY -= 4.0D;
    } else if ((Keyboard.isKeyDown(77)) && (mc.inGameHasFocus)) {
    	et.motionY += 4.0D;
    }
    et.motionX *= 1;
    et.motionY *= 1;
    et.motionZ *= 1;
  }
}
