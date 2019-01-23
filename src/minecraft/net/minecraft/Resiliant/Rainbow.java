package net.minecraft.Resiliant;

import java.awt.Color;

public class Rainbow
{
  public static int getRainbow(int speed, int offset)
  {
    float hue = (float)((System.currentTimeMillis() + offset) % speed);
    hue /= speed;
    return Color.getHSBColor(hue, 1.0F, 0.5F).getRGB();
  }
}
