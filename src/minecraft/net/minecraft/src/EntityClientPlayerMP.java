// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.lwjgl.input.Keyboard;

import net.minecraft.Resiliant.Resiliant;
import net.minecraft.Resiliant.Module.Modules.World.Flight;
import net.minecraft.Resiliant.Module.Modules.World.Nuker;
import net.minecraft.Resiliant.Module.Modules.Player.reversenuke;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            EntityPlayerSP, MathHelper, World, Packet19EntityAction, 
//            NetClientHandler, AxisAlignedBB, Packet11PlayerPosition, Packet13PlayerLookMove, 
//            Packet12PlayerLook, Packet10Flying, Packet14BlockDig, Packet3Chat, 
//            Packet18Animation, Packet9Respawn, Packet101CloseWindow, Container, 
//            InventoryPlayer, StatBase, Session, Entity, 
//            EntityItem

public class EntityClientPlayerMP extends EntityPlayerSP
{

    public EntityClientPlayerMP(Minecraft minecraft, World world, Session session, NetClientHandler netclienthandler)
    {
        super(minecraft, world, session, 0);
        field_9380_bx = 0;
        field_21093_bH = false;
        field_9382_bF = false;
        wasSneaking = false;
        field_12242_bI = 0;
        sendQueue = netclienthandler;
    }

    public boolean attackEntityFrom(Entity entity, int i)
    {
        return false;
    }

    public void heal(int i)
    {
    }

    public void onUpdate()
    {
    	this.onReverseNuke();
    	this.onNuke();
    	this.setFlying();
        if(!worldObj.blockExists(MathHelper.floor_double(posX), 64, MathHelper.floor_double(posZ)))
        {
            return;
        } else
        {
            super.onUpdate();
            func_4056_N();
            return;
        }
    }

    public void func_4056_N()
    {
        if(field_9380_bx++ == 20)
        {
            sendInventoryChanged();
            field_9380_bx = 0;
        }
        boolean flag = isSneaking();
        if(flag != wasSneaking)
        {
            if(flag)
            {
                sendQueue.addToSendQueue(new Packet19EntityAction(this, 1));
            } else
            {
                sendQueue.addToSendQueue(new Packet19EntityAction(this, 2));
            }
            wasSneaking = flag;
        }
        double d = posX - oldPosX;
        double d1 = boundingBox.minY - field_9378_bz;
        double d2 = posY - oldPosY;
        double d3 = posZ - oldPosZ;
        double d4 = rotationYaw - oldRotationYaw;
        double d5 = rotationPitch - oldRotationPitch;
        boolean flag1 = d1 != 0.0D || d2 != 0.0D || d != 0.0D || d3 != 0.0D;
        boolean flag2 = d4 != 0.0D || d5 != 0.0D;
        if(ridingEntity != null)
        {
            if(flag2)
            {
                sendQueue.addToSendQueue(new Packet11PlayerPosition(motionX, -999D, -999D, motionZ, onGround));
            } else
            {
                sendQueue.addToSendQueue(new Packet13PlayerLookMove(motionX, -999D, -999D, motionZ, rotationYaw, rotationPitch, onGround));
            }
            flag1 = false;
        } else
        if(flag1 && flag2)
        {
            sendQueue.addToSendQueue(new Packet13PlayerLookMove(posX, boundingBox.minY, posY, posZ, rotationYaw, rotationPitch, onGround));
            field_12242_bI = 0;
        } else
        if(flag1)
        {
            sendQueue.addToSendQueue(new Packet11PlayerPosition(posX, boundingBox.minY, posY, posZ, onGround));
            field_12242_bI = 0;
        } else
        if(flag2)
        {
            sendQueue.addToSendQueue(new Packet12PlayerLook(rotationYaw, rotationPitch, onGround));
            field_12242_bI = 0;
        } else
        {
            sendQueue.addToSendQueue(new Packet10Flying(onGround));
            if(field_9382_bF != onGround || field_12242_bI > 200)
            {
                field_12242_bI = 0;
            } else
            {
                field_12242_bI++;
            }
        }
        field_9382_bF = onGround;
        if(flag1)
        {
            oldPosX = posX;
            field_9378_bz = boundingBox.minY;
            oldPosY = posY;
            oldPosZ = posZ;
        }
        if(flag2)
        {
            oldRotationYaw = rotationYaw;
            oldRotationPitch = rotationPitch;
        }
    }

    public void dropCurrentItem()
    {
        sendQueue.addToSendQueue(new Packet14BlockDig(4, 0, 0, 0, 0));
    }

    private void sendInventoryChanged()
    {
    }

    protected void joinEntityItemWithWorld(EntityItem entityitem)
    {
    }
    static String filePath = "C:\\Users\\Nick\\Desktop\\Resiliant\\jars\\ResiliantRea\\song.wav";
    public static void setMusic() {
		 try {
			   File file = new File(filePath);
			   Clip clip = AudioSystem.getClip();
			   clip.open(AudioSystem.getAudioInputStream(file));
			   clip.start();
			  
			   
			  } catch (Exception e) {
				  
			   System.err.println(e.getMessage());
			  }
			 }
    public void sendChatMessage(String s)
    {	
    	//TODO:
    	if(s.startsWith(".help")) {
    		addChatMessage("�7[�4Resiliant�7]�f	Commands are .who - asks server whos on, .c claims town blocks on towny servers, .drop drops a stack of items hovered, .mods list mods, .drop drops current hand, .log lists logs");
    		return;
    	}
    	
    	if(s.startsWith(".who")) {
    		addChatMessage("�7[�4Resiliant�7]�f	Searching");
    		sendQueue.addToSendQueue(new Packet3Chat("/who"));
    		return;
    	}
    	
    	if(s.startsWith(".music")) {
    		addChatMessage("�7[�4Resiliant�7]�f	Playing all out life");
    		try {
 			   File file = new File(filePath);
 			   Clip clip = AudioSystem.getClip();
 			   clip.open(AudioSystem.getAudioInputStream(file));
 			 
 			   clip.start();
 			  
 			   
 			  } catch (Exception e) {
 				  
 			   System.err.println(e.getMessage());
 			  }
    		
    		
    		
    		return;
    	}
    	  if(s.startsWith(".stop")) {
    		addChatMessage("�7[�4Resiliant�7]�f Stopping");
    		return;
    	}
    	
    	
    	
    	if(s.startsWith(".c")) {
    		addChatMessage("�7[�4Resiliant�7]�f	Claiming land");
    		sendQueue.addToSendQueue(new Packet3Chat("/town claim"));
    		return;
    	}
    	if(s.startsWith(".drop")) {
    		addChatMessage("�7[�4Resiliant�7]�f	Dropping entire invintory");
    		int x = 1; 
    		  
            // Exit when x becomes greater than 4 
            while (x <= 64) 
            { 
    			dropCurrentItem();
      
                // Increment the value of x for 
                // next iteration 
                x++;
            }
    		
    		return;
    	}
    	int var = 10;
    	if(s.startsWith(".up")) {
    		addChatMessage("�7[�4Resiliant�7]�f	Pos updated");
    		mc.thePlayer.lastTickPosY += 10;
    		return;
    	}
    	
    	if(s.startsWith(".mods")) {
    		addChatMessage("�7[�4Resiliant�7]�f	Resiliant has " + Resiliant.modulemanager.getModules().size() + " Mods Loaded");
    	
    		return;
    	}
    	
    	if(s.startsWith(".log")) {
    		addChatMessage("�7[�4Resiliant�7]�f	Resiliant has " + Resiliant.log.activelogs.size() + " logs Stored");
    	
    		return;
    	}
    	
        sendQueue.addToSendQueue(new Packet3Chat(s));
    }

 
    public void swingItem()
    {
        super.swingItem();
        sendQueue.addToSendQueue(new Packet18Animation(this, 1));
    }

    public void respawnPlayer()
    {
        sendInventoryChanged();
        sendQueue.addToSendQueue(new Packet9Respawn((byte)dimension));
    }

    protected void damageEntity(int i)
    {
        health -= i;
    }

    public void closeScreen()
    {
        sendQueue.addToSendQueue(new Packet101CloseWindow(craftingInventory.windowId));
        inventory.setItemStack(null);
        super.closeScreen();
    }

    public void setHealth(int i)
    {
        if(field_21093_bH)
        {
            super.setHealth(i);
        } else
        {
            health = i;
            field_21093_bH = true;
        }
    }

    public void addStat(StatBase statbase, int i)
    {
        if(statbase == null)
        {
            return;
        }
        if(statbase.field_27088_g)
        {
            super.addStat(statbase, i);
        }
    }

    public void func_27027_b(StatBase statbase, int i)
    {
        if(statbase == null)
        {
            return;
        }
        if(!statbase.field_27088_g)
        {
            super.addStat(statbase, i);
        }
    }
    
    public void setFlying() {
    	if(Resiliant.modulemanager.getModule(Flight.class).getState()) {
    		this.onGround = false;
    		this.motionX = 0.0D;
    		this.motionY = 0.0D;
    		this.motionZ = 0.0D;
        
        double d2 = this.rotationYaw + 90.0F;
        
        boolean flag = (Keyboard.isKeyDown(17));
        boolean flag1 = (Keyboard.isKeyDown(31)) ;
        boolean flag2 = (Keyboard.isKeyDown(30)) ;
        boolean flag3 = (Keyboard.isKeyDown(32)) ;
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
        	this.motionX = Math.cos(Math.toRadians(d2));
        	this.motionZ = Math.sin(Math.toRadians(d2));
        }
        if ((Keyboard.isKeyDown(57))) {
        	this.motionY += 3.0D;
        } else if ((Keyboard.isKeyDown(42))) {
        	this.motionY -= 3.0D;
        } else if ((Keyboard.isKeyDown(82))) {
        	this.motionY -= 4.0D;
        } else if ((Keyboard.isKeyDown(77))) {
        	this.motionY += 4.0D;
        }
        this.motionX *= 1;
        this.motionY *= 1;
        this.motionZ *= 1;
    	}
    	
    	
    }
    public void onReverseNuke() {
    	if(Resiliant.modulemanager.getModule(reversenuke.class).getState()) {
    		
    	
    		 byte byte0 = 3;
             byte byte1 = 3;
             byte byte2 = 3;
          
             for(int k = byte0; k > -byte0; k--)
             {
                 for(int i1 = byte1; i1 > -byte1; i1--)
                 {
                     for(int j1 = byte2; j1 > -byte2; j1--)
                     {
                         double d1 = mc.thePlayer.posX + (double)k;
                         double d3 = mc.thePlayer.posY + (double)i1;
                         double d5 = mc.thePlayer.posZ + (double)j1;
                         int k1 = (int)d1;
                         int l1 = (int)d3;
                         int i2 = (int)d5;
                         int j2 = mc.theWorld.getBlockId(k1, l1, i2);
                         Block block = Block.blocksList[j2];
                         if(block != null && block.blockID == 50)
                         {
                        	 ((EntityClientPlayerMP)mc.thePlayer).sendQueue.addToSendQueue(new Packet14BlockDig(0, k1, l1, i2, 1));
                             ((EntityClientPlayerMP)mc.thePlayer).sendQueue.addToSendQueue(new Packet14BlockDig(2, k1, l1, i2, 1));
                         }
                     }

                 }

             }

    	}
    }
    public void onNuke() {
    	if(Resiliant.modulemanager.getModule(Nuker.class).getState()) {
    		
    	
    		 byte byte0 = 3;
             byte byte1 = 3;
             byte byte2 = 3;
          
             for(int k = byte0; k > -byte0; k--)
             {
                 for(int i1 = byte1; i1 > -byte1; i1--)
                 {
                     for(int j1 = byte2; j1 > -byte2; j1--)
                     {
                         double d1 = mc.thePlayer.posX + (double)k;
                         double d3 = mc.thePlayer.posY + (double)i1;
                         double d5 = mc.thePlayer.posZ + (double)j1;
                         int k1 = (int)d1;
                         int l1 = (int)d3;
                         int i2 = (int)d5;
                         int j2 = mc.theWorld.getBlockId(k1, l1, i2);
                         Block block = Block.blocksList[j2];
                         if(block != null)
                         {
                             ((EntityClientPlayerMP)mc.thePlayer).sendQueue.addToSendQueue(new Packet14BlockDig(0, k1, l1, i2, 1));
                             ((EntityClientPlayerMP)mc.thePlayer).sendQueue.addToSendQueue(new Packet14BlockDig(2, k1, l1, i2, 1));
                         }
                     }

                 }

             }

    	}
    }

    public NetClientHandler sendQueue;
    private int field_9380_bx;
    private boolean field_21093_bH;
    private double oldPosX;
    private double field_9378_bz;
    private double oldPosY;
    private double oldPosZ;
    private float oldRotationYaw;
    private float oldRotationPitch;
    private boolean field_9382_bF;
    private boolean wasSneaking;
    private int field_12242_bI;
}
