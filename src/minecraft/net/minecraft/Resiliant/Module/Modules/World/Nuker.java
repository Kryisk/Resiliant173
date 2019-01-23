package net.minecraft.Resiliant.Module.Modules.World;

import org.lwjgl.input.Keyboard;

import net.minecraft.Resiliant.Resiliant;
import net.minecraft.Resiliant.Module.Category;
import net.minecraft.Resiliant.Module.Module;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Packet14BlockDig;

public class Nuker extends Module{

	public Nuker() {
		super("Nuker", Keyboard.KEY_N, 0xffff0000, Category.PLAYER);
		// TODO Auto-generated constructor stub
	}
	
	private int radius = 5;
	
	private EntityPlayer ep;
	
	public void onTick() {
		if(!this.getState()) {
			return;	
		}
		
//		byte byte0 = 3;
//		byte byte1 = 3;
//		byte byte2 = 3;
//		byte byte3 = 3;
//		byte byte4 = 3;
//		byte byte5 = 3;
//
//		for(int k = byte0; k > -byte0; k--) {
//			
//			for(int i1 = byte1; i1 > -byte1; i1--) {
//				
//				for(int j1 = byte2; j1 > - byte2; j1--) {
//					double d1 = Resiliant.mc.thePlayer.posX + (double)k;
//					double d2 = Resiliant.mc.thePlayer.posY + (double)i1;
//					double d3 = Resiliant.mc.thePlayer.posZ + (double)j1;
//					
//					int k1 = (int)d1;
//					int l1 = (int)d2;
//					int i2 = (int)d3;
//					
//					int j2 = Resiliant.mc.theWorld.getBlockId(k1, l1, i2);
//					
//					Block block = Block.blocksList[j2];
//					
//					if(block != null) {
//						Resiliant.mc.thePlayer.sendQueue.addToSendQueue(new Packet14BlockDig(0, k1, l1, i2, 1));
//						Resiliant.mc.thePlayer.sendQueue.addToSendQueue(new Packet14BlockDig(2, k1, l1, i2, 1));
//
//					}
//
//
//				}
//			}
//		}
		
	}
	
	public void onDisable() {
		

	}

}
