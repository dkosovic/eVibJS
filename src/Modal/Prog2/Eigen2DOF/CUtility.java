package Modal.Prog2.Eigen2DOF;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.awt.image.PixelGrabber;
import java.util.StringTokenizer;

public class CUtility {
   static final double kLog10 = Math.log(10.0);

   public static double log10(double var0) {
      return Math.log(var0) / kLog10;
   }

   public static String nns(double var0, int var2) {
      if (var2 <= 0) {
         var2 = 1;
      }

      if (var0 == 0.0) {
         return new String("0");
      } else if (var0 < 0.0) {
         return new String("-" + nns(-var0, var2));
      } else {
         double var3 = Math.floor(log10(var0));
         double var5 = Math.pow(10.0, var3 - var2 + 1.0);
         long var7 = Math.round(var0 / var5);
         String var9 = new String(String.valueOf(var7 * var5));
         String var10 = "";
         int var11 = var9.indexOf("E-");
         if (var11 > -1) {
            var10 = var9.substring(var11);
            var9 = var9.substring(0, var11);
            var5 = Math.pow(10.0, -var2);

            try {
               var0 = java.lang.Double.parseDouble(var9);
            } catch (NumberFormatException var16) {
            }
         } else if (var9.indexOf("E") > -1) {
            return var9;
         }

         while (var9.length() > 1 && var9.indexOf(46) > -1) {
            boolean var12 = false;

            int var13;
            for (var13 = var9.length() - 1; var9.charAt(var13) == '0'; var12 = true) {
               var13--;
            }

            if (var12) {
               var9 = new String(var9.substring(0, var13 + 1));
            }

            String var14 = new String(var9.substring(0, var13));

            double var15;
            try {
               var15 = java.lang.Double.parseDouble(var14);
            } catch (NumberFormatException var17) {
               break;
            }

            if (Math.abs(var0 - var15) > var5) {
               break;
            }

            var9 = var14;
         }

         return new String(var9 + var10);
      }
   }

   public static String nns(double var0) {
      return nns(var0, 4);
   }

   public static Color RatColor(Color var0, Color var1, double var2) {
      if (var2 <= 0.0) {
         return var0;
      } else if (var2 >= 1.0) {
         return var1;
      } else {
         int var4 = var0.getRed() + (int)(var2 * (var1.getRed() - var0.getRed()));
         int var5 = var0.getGreen() + (int)(var2 * (var1.getGreen() - var0.getGreen()));
         int var6 = var0.getBlue() + (int)(var2 * (var1.getBlue() - var0.getBlue()));
         return new Color(var4, var5, var6);
      }
   }

   public static int DrawString(Graphics var0, String var1, int var2, int var3) {
      FontMetrics var5 = var0.getFontMetrics();
      int var6 = var5.stringWidth(var1);
      var0.drawString(var1, var2, var3);
      return var2 + var6;
   }

   public static void JDrawString(Graphics var0, String var1, int var2, int var3, int var4, int var5) {
      FontMetrics var6 = var0.getFontMetrics();
      int var7 = var6.stringWidth(var1);
      int var8 = var6.getMaxAscent();
      int var9 = var6.getMaxDescent();
      switch (var4) {
         case -1:
            var2 -= var7;
            break;
         case 0:
            var2 -= var7 / 2;
      }

      switch (var5) {
         case -2:
            var3 += var8;
            break;
         case -1:
            var3 += (var9 + var8) / 2;
         case 0:
         default:
            break;
         case 1:
            var3 -= var9;
      }

      var0.drawString(var1, var2, var3);
   }

   public static void DrawHelp(Graphics var0, Point var1, int var2, int var3, String var4) {
      var0.setPaintMode();
      byte var5 = 12;
      byte var6 = 5;
      byte var7 = 10;
      byte var8 = 20;
      int var9 = 0;
      int var10 = 2 * var6;
      StringTokenizer var11 = new StringTokenizer(var4, "\n");

      while (var11.hasMoreTokens()) {
         var10 += var5;
         int var12 = var0.getFontMetrics().stringWidth(var11.nextToken());
         if (var12 > var9) {
            var9 = var12;
         }
      }

      var9 += 2 * var7;
      byte var20 = 1;
      byte var13 = 1;
      if (var1.x + var7 + var9 > var2) {
         var20 = -1;
      }

      if (var1.y + var7 + var10 > var3) {
         var13 = -1;
      }

      Polygon var14 = new Polygon();
      var14.addPoint(var1.x, var1.y);
      var14.addPoint(var1.x + var20 * var7, var1.y + var13 * var8);
      var14.addPoint(var1.x + var20 * var7, var1.y + var13 * (var7 + var10));
      var14.addPoint(var1.x + var20 * (var7 + var9), var1.y + var13 * (var7 + var10));
      var14.addPoint(var1.x + var20 * (var7 + var9), var1.y + var13 * var7);
      var14.addPoint(var1.x + var20 * var8, var1.y + var13 * var7);
      var14.addPoint(var1.x, var1.y);
      var0.setColor(Color.white);
      var0.fillPolygon(var14);
      var0.setColor(Color.black);
      var0.drawPolygon(var14);
      int var15;
      if (var20 > 0) {
         var15 = var1.x + 2 * var7;
      } else {
         var15 = var1.x - var9;
      }

      int var16;
      if (var13 > 0) {
         var16 = var1.y + var7 + var6 + var5;
      } else {
         var16 = var1.y - var7 - var10 + var6 + var5;
      }

      int var17 = -1;
      var11 = new StringTokenizer(var4, "\n");

      while (var11.hasMoreTokens()) {
         var0.drawString(var11.nextToken(), var15, var16 + ++var17 * var5);
      }
   }

   public static void DrawStringHalo(Graphics var0, String var1, int var2, int var3) {
      Color var4 = var0.getColor();
      var0.setColor(Color.white);
      var0.drawString(var1, var2 + 1, var3 + 1);
      var0.drawString(var1, var2, var3 + 1);
      var0.drawString(var1, var2 - 1, var3 + 1);
      var0.drawString(var1, var2 - 1, var3);
      var0.drawString(var1, var2 - 1, var3 - 1);
      var0.drawString(var1, var2, var3 - 1);
      var0.drawString(var1, var2 + 1, var3 - 1);
      var0.drawString(var1, var2 + 1, var3);
      var0.setColor(var4);
      var0.drawString(var1, var2, var3);
   }

   public static void DrawDoughnut(Graphics var0, int var1, int var2, int var3, int var4) {
      Color var5 = var0.getColor();

      for (int var6 = -1; var6 <= var4; var6++) {
         if (var6 >= 0 && var6 != var4) {
            var0.setColor(var5);
         } else {
            var0.setColor(Color.white);
         }

         var0.drawOval(var1 - var3 + var6, var2 - var3 + var6, 2 * (var3 - var6), 2 * (var3 - var6));
      }

      var0.setColor(var5);
   }

   public static double RangeRandom(double var0, double var2, double var4) {
      double var6 = var0 + (var2 - var0) * Math.random();
      return var4 <= 0.0 ? var6 : var4 * Math.round(var6 / var4);
   }

   public static void DrawThickLine(Graphics var0, int var1, int var2, int var3, int var4) {
      Point var5 = new Point(Math.abs(var3 - var1), var4 - var2);
      if (var5.y <= var5.x && var5.y >= -var5.x) {
         var5.x = 0;
         var5.y = -1;
      } else {
         var5.x = -1;
         var5.y = 0;
      }

      Point var6 = new Point(var1, var2);
      Point var7 = new Point(var3, var4);
      var0.drawLine(var6.x, var6.y, var7.x, var7.y);
      var6.x = var6.x + var5.x;
      var6.y = var6.y + var5.y;
      var7.x = var7.x + var5.x;
      var7.y = var7.y + var5.y;
      var0.drawLine(var6.x, var6.y, var7.x, var7.y);
   }

   public static Rectangle TwoPointRect(Point var0, Point var1) {
      if (var0 == null && var1 != null) {
         var0 = var1;
      } else if (var0 != null && var1 == null) {
         var1 = var0;
      } else if (var0 == null && var1 == null) {
         return null;
      }

      int var2 = Math.min(var0.x, var1.x);
      int var3 = Math.min(var0.y, var1.y);
      int var4 = Math.abs(var1.x - var0.x);
      int var5 = Math.abs(var1.y - var0.y);
      return new Rectangle(var2, var3, var4, var5);
   }

   public static void DiagnosticOut(String var0) {
   }

   public static Color GetPixelColor(Image var0, int var1, int var2, ImageObserver var3) {
      if (var0 == null) {
         return null;
      } else {
         int var4 = var0.getWidth(var3);
         int var5 = var0.getHeight(var3);
         if (var1 >= 0 && var4 >= var1 && var2 >= 0 && var5 >= var2) {
            int[] var6 = new int[1];
            PixelGrabber var7 = new PixelGrabber(var0, var1, var2, 1, 1, var6, 0, 0);

            try {
               var7.grabPixels();
            } catch (InterruptedException var13) {
               System.err.println("interrupted waiting for pixels!");
               return null;
            }

            if ((var7.status() & 128) != 0) {
               System.err.println("image fetch aborted or errored");
               return null;
            } else {
               int var8 = var6[0];
               int var9 = var8 >> 24 & 0xFF;
               int var10 = var8 >> 16 & 0xFF;
               int var11 = var8 >> 8 & 0xFF;
               int var12 = var8 & 0xFF;
               return new Color(var10, var11, var12);
            }
         } else {
            return null;
         }
      }
   }
}
