package net.minecraft.Resiliant.Module.Modules.World;

import net.minecraft.Resiliant.Module.Category;
import net.minecraft.Resiliant.Module.Module;
import net.minecraft.Resiliant.Resiliant;
import org.lwjgl.input.Keyboard;

public class Rise extends Module{

    public Rise() {
        super("No Clip", Keyboard.KEY_M, 0xffff0000, Category.PLAYER);
        // TODO Auto-generated constructor stub
    }

    public void onTick(){
        if(this.getState()) {
           Resiliant.mc.thePlayer.noClip = true;

        }
    }

    public void onDisable(){
        Resiliant.mc.thePlayer.noClip = false;
    }
}
