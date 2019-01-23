// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL21;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL40;

import net.minecraft.Resiliant.Rainbow;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, StringTranslate, GuiButton, GuiOptions, 
//            GuiSelectWorld, GuiMultiplayer, GuiTexturePacks, Tessellator, 
//            RenderEngine, MathHelper, FontRenderer

public class GuiMainMenu extends GuiScreen
{

    public GuiMainMenu()
    {
        updateCounter = 0.0F;
        splashText = "missingno";
        try
        {
            ArrayList arraylist = new ArrayList();
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader((net.minecraft.src.GuiMainMenu.class).getResourceAsStream("/title/splashes.txt"), Charset.forName("UTF-8")));
            String s = "";
            do
            {
                String s1;
                if((s1 = bufferedreader.readLine()) == null)
                {
                    break;
                }
                s1 = s1.trim();
                if(s1.length() > 0)
                {
                    arraylist.add(s1);
                }
            } while(true);
            splashText = (String)arraylist.get(rand.nextInt(arraylist.size()));
        }
        catch(Exception exception) { }
    }

    public void updateScreen()
    {
        updateCounter++;
    }

    protected void keyTyped(char c, int i)
    {
    }

    @SuppressWarnings("unchecked")
	public void initGui()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        if(calendar.get(2) + 1 == 11 && calendar.get(5) == 9)
        {
            splashText = "Happy birthday, ez!";
        } else
        if(calendar.get(2) + 1 == 6 && calendar.get(5) == 1)
        {
            splashText = "Happy birthday, Notch!";
        } else
        if(calendar.get(2) + 1 == 12 && calendar.get(5) == 24)
        {
            splashText = "Merry X-mas!";
        } else
        if(calendar.get(2) + 1 == 1 && calendar.get(5) == 1)
        {
            splashText = "Happy new year!";
        }
        StringTranslate stringtranslate = StringTranslate.getInstance();
        int i = height / 4 + 48;
        controlList.add(new GuiButton(1, width / 2 - 100, i, stringtranslate.translateKey("menu.singleplayer")));
        controlList.add(multiplayerButton = new GuiButton(2, width / 2 - 100, i + 24, stringtranslate.translateKey("menu.multiplayer")));
        controlList.add(new GuiButton(3, width / 2 - 100, i + 48, stringtranslate.translateKey("menu.mods")));
        
        if(mc.hideQuitButton)
        {
            controlList.add(new GuiButton(0, width / 2 - 100, i + 72, stringtranslate.translateKey("menu.options")));
          
        } else
        {
        	//  controlList.add(new GuiButton(42, 20, 20, stringtranslate.translateKey("ChangeLog")));
        //	controlList.add(new GuiButton(i, i, i, i, i, splashText)
            controlList.add(new GuiButton(0, width / 2 - 100, i + 72 + 12, 98, 20, stringtranslate.translateKey("menu.options")));
            controlList.add(new GuiButton(4, width / 2 + 2, i + 72 + 12, 98, 20, stringtranslate.translateKey("menu.quit")));
            controlList.add(new GuiButton(42, 4,11, 98, 20, stringtranslate.translateKey("ChangeLog")));
        }
        if(mc.session == null)
        {
            multiplayerButton.enabled = false;
        }
    }

    protected void actionPerformed(GuiButton guibutton)
    {
        if(guibutton.id == 0)
        {
            mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
        }
        if(guibutton.id == 1)
        {
            mc.displayGuiScreen(new GuiSelectWorld(this));
        }
        if(guibutton.id == 2)
        {
            mc.displayGuiScreen(new GuiMultiplayer(this));
        }
        if(guibutton.id == 3)
        {
            mc.displayGuiScreen(new GuiTexturePacks(this));
        }
        if(guibutton.id == 4)
        {
            mc.shutdown();
        }
        if(guibutton.id == 42)
        {
            mc.displayGuiScreen(new GuiChange(this, mc.gameSettings));
        }
    }
    private static final double twicePI = Math.PI*2;
    public void drawScreen(int i, int j, float f)
    {
        drawDefaultBackground();
       
//        Tessellator tessellator = Tessellator.instance;
//        char c = '\u0112';
//        int k = width / 2 - c / 2;
//        byte byte0 = 30;
//        GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, mc.renderEngine.getTexture("/title/mclogo.png"));
//        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//        drawTexturedModalRect(k + 0, byte0 + 0, 0, 0, 155, 44);
//        drawTexturedModalRect(k + 155, byte0 + 0, 0, 45, 155, 44);
//        tessellator.setColorOpaque_I(0xffffff);
        //Start
       
    
        float angle = (float) Math.toRadians(System.currentTimeMillis() / 7  % 360);

        float radius = (float) 2.0D;
        float vx = (float) (radius * Math.sin(angle));
        float vz = (float) (radius * Math.cos(angle));
        
        float f1 = 1.8F - MathHelper.abs(MathHelper.cos(((float)(System.currentTimeMillis() % 1000L) / 1000F) * 3.141593F));  
        f1 = (f1 * 100F) / (float)(fontRenderer.getStringWidth("Resiliant") + 32);
        
        GL11.glPushMatrix();
        GL11.glTranslatef(50, 70F, 0.0F);
        //GL11.glRotatef(angle, 1, 0, vx);
        GL11.glRotatef(1, 0, 0, angle);
     
        //static float angle; // initializes angle to 0.0f

       // GL11.glRotatef(angle, 0.0f, 0.0f, 1.0f); // Rotate around the y and z axis.

        

        ///DrawSomeCube();

       
        
      //  GL11.glRotatef(f1,1, 0, 0);
        GL11.glScalef(3, 3, f1);//0x0652DD
        
        drawCenteredString(fontRenderer, "Resiliant", this.width / 4 - 97 + (int)f1, this.height / 4 - 78 - 30, Rainbow.getRainbow(9990, -68980));
        GL11.glPopMatrix();
        drawRect(2, height - 14, width - 2, height - 2, 0x80000000);
        drawString(fontRenderer, "�7Minecraft version 1.7.3, I've gotten us up to 0.9! Check changelog for updates. MAJOR: New gui press Right shift to toggle, still being tweaked", (int) ((System.currentTimeMillis() /  25)  % this.width - this.width), this.height - 12, 0xffffff);
        drawString(fontRenderer, "�7Minecraft version 1.7.3, I've gotten us up to 0.9! Check changelog for updates. MAJOR: New gui press Right shift to toggle, still being tweaked", (int) ((System.currentTimeMillis() /  25)  % this.width), this.height - 12, 0xffffff);
        String session = mc.session.username.toUpperCase().toString();
        drawString(fontRenderer,"Current login: " + session,2,2, 0xffffff);
        String se = "Resiliant - Coded by KryisK";
        drawString(fontRenderer, se, width - fontRenderer.getStringWidth(se) - 2, 0, 0xffffff);
        String s = "Minecraft version 1.7.3";
        drawString(fontRenderer, s, width - fontRenderer.getStringWidth(s) - 2, 10, 0xffffff);
        super.drawScreen(i, j, f);
        
    }
    
   

    private static final Random rand = new Random();
    private float updateCounter;
    private String splashText;
    private GuiButton multiplayerButton;

}
