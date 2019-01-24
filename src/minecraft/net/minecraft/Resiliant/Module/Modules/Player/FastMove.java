package net.minecraft.Resiliant.Module.Modules.Player;

import net.minecraft.Resiliant.Module.Module;
import org.lwjgl.input.Keyboard;

import net.minecraft.Resiliant.Module.Category;
public class FastMove extends Module {

    public FastMove() {
        super("Sprint", Keyboard.KEY_I, 0xffFFC312, Category.PLAYER);
        // TODO Auto-generated constructor stub#eb3b5a
    }

    public void onTick(){
        if(this.getState()){

        }
    }


}
