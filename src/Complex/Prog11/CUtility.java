package Complex.Prog11;

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

   public static double log10(double arg) {
      return Math.log(arg) / kLog10;
   }

   public static String nns(double arg, int sig) {
      if (sig <= 0) {
         sig = 1;
      }

      if (arg == 0.0) {
         return "0";
      } else if (arg < 0.0) {
         return "-" + nns(-arg, sig);
      } else {
         double magnitude = Math.floor(log10(arg));
         double stepSize = Math.pow(10.0, magnitude - sig + 1.0);
         long var7 = Math.round(arg / stepSize);
         String var9 = String.valueOf(var7 * stepSize);
         String var10 = "";
         int var11 = var9.indexOf("E-");
         if (var11 > -1) {
            var10 = var9.substring(var11);
            var9 = var9.substring(0, var11);
            stepSize = Math.pow(10.0, -sig);

            try {
               arg = java.lang.Double.parseDouble(var9);
            } catch (NumberFormatException ex) {
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
               var9 = var9.substring(0, var13 + 1);
            }

            String var14 = var9.substring(0, var13);

            double var15;
            try {
               var15 = java.lang.Double.parseDouble(var14);
            } catch (NumberFormatException ex) {
               break;
            }

            if (Math.abs(arg - var15) > stepSize) {
               break;
            }

            var9 = var14;
         }

         return var9 + var10;
      }
   }

   public static String nns(double arg) {
      return nns(arg, 4);
   }

   public static Color RatColor(Color c1, Color c2, double ratio) {
      if (ratio <= 0.0) {
         return c1;
      } else if (ratio >= 1.0) {
         return c2;
      } else {
         int var4 = c1.getRed() + (int)(ratio * (c2.getRed() - c1.getRed()));
         int var5 = c1.getGreen() + (int)(ratio * (c2.getGreen() - c1.getGreen()));
         int var6 = c1.getBlue() + (int)(ratio * (c2.getBlue() - c1.getBlue()));
         return new Color(var4, var5, var6);
      }
   }

   public static int DrawString(Graphics g, String theString, int x, int y) {
      FontMetrics var5 = g.getFontMetrics();
      int var6 = var5.stringWidth(theString);
      g.drawString(theString, x, y);
      return x + var6;
   }

   public static void JDrawString(Graphics g, String arg, int x, int y, int hAlign, int vAlign) {
      FontMetrics var6 = g.getFontMetrics();
      int var7 = var6.stringWidth(arg);
      int var8 = var6.getMaxAscent();
      int var9 = var6.getMaxDescent();
      switch (hAlign) {
         case -1:
            x -= var7;
            break;
         case 0:
            x -= var7 / 2;
      }

      switch (vAlign) {
         case -2:
            y += var8;
            break;
         case -1:
            y += (var9 + var8) / 2;
         case 0:
         default:
            break;
         case 1:
            y -= var9;
      }

      g.drawString(arg, x, y);
   }

   public static void DrawHelp(Graphics g, Point mArrow, int wid, int hei, String message) {
      g.setPaintMode();
      int var5 = 12;
      int var6 = 5;
      int var7 = 10;
      int var8 = 20;
      int var9 = 0;
      int var10 = 2 * var6;
      StringTokenizer var11 = new StringTokenizer(message, "\n");

      while (var11.hasMoreTokens()) {
         var10 += var5;
         int var12 = g.getFontMetrics().stringWidth(var11.nextToken());
         if (var12 > var9) {
            var9 = var12;
         }
      }

      var9 += 2 * var7;
      int var20 = 1;
      int var13 = 1;
      if (mArrow.x + var7 + var9 > wid) {
         var20 = -1;
      }

      if (mArrow.y + var7 + var10 > hei) {
         var13 = -1;
      }

      Polygon var14 = new Polygon();
      var14.addPoint(mArrow.x, mArrow.y);
      var14.addPoint(mArrow.x + var20 * var7, mArrow.y + var13 * var8);
      var14.addPoint(mArrow.x + var20 * var7, mArrow.y + var13 * (var7 + var10));
      var14.addPoint(mArrow.x + var20 * (var7 + var9), mArrow.y + var13 * (var7 + var10));
      var14.addPoint(mArrow.x + var20 * (var7 + var9), mArrow.y + var13 * var7);
      var14.addPoint(mArrow.x + var20 * var8, mArrow.y + var13 * var7);
      var14.addPoint(mArrow.x, mArrow.y);
      g.setColor(Color.white);
      g.fillPolygon(var14);
      g.setColor(Color.black);
      g.drawPolygon(var14);
      int var15;
      if (var20 > 0) {
         var15 = mArrow.x + 2 * var7;
      } else {
         var15 = mArrow.x - var9;
      }

      int var16;
      if (var13 > 0) {
         var16 = mArrow.y + var7 + var6 + var5;
      } else {
         var16 = mArrow.y - var7 - var10 + var6 + var5;
      }

      int var17 = -1;
      var11 = new StringTokenizer(message, "\n");

      while (var11.hasMoreTokens()) {
         g.drawString(var11.nextToken(), var15, var16 + ++var17 * var5);
      }
   }

   public static void DrawStringHalo(Graphics g, String s, int xx, int yy) {
      Color var4 = g.getColor();
      g.setColor(Color.white);
      g.drawString(s, xx + 1, yy + 1);
      g.drawString(s, xx, yy + 1);
      g.drawString(s, xx - 1, yy + 1);
      g.drawString(s, xx - 1, yy);
      g.drawString(s, xx - 1, yy - 1);
      g.drawString(s, xx, yy - 1);
      g.drawString(s, xx + 1, yy - 1);
      g.drawString(s, xx + 1, yy);
      g.setColor(var4);
      g.drawString(s, xx, yy);
   }

   public static void DrawDoughnut(Graphics g, int x, int y, int rad, int thick) {
      Color var5 = g.getColor();

      for (int i = -1; i <= thick; i++) {
         if (i >= 0 && i != thick) {
            g.setColor(var5);
         } else {
            g.setColor(Color.white);
         }

         g.drawOval(x - rad + i, y - rad + i, 2 * (rad - i), 2 * (rad - i));
      }

      g.setColor(var5);
   }

   public static double RangeRandom(double minV, double maxV, double step) {
      double var6 = minV + (maxV - minV) * Math.random();
      return step <= 0.0 ? var6 : step * Math.round(var6 / step);
   }

   public static void DrawThickLine(Graphics g, int x1, int y1, int x2, int y2) {
      Point point = new Point(Math.abs(x2 - x1), y2 - y1);
      if (point.y <= point.x && point.y >= -point.x) {
         point.x = 0;
         point.y = -1;
      } else {
         point.x = -1;
         point.y = 0;
      }

      Point var6 = new Point(x1, y1);
      Point var7 = new Point(x2, y2);
      g.drawLine(var6.x, var6.y, var7.x, var7.y);
      var6.x = var6.x + point.x;
      var6.y = var6.y + point.y;
      var7.x = var7.x + point.x;
      var7.y = var7.y + point.y;
      g.drawLine(var6.x, var6.y, var7.x, var7.y);
   }

   public static Rectangle TwoPointRect(Point p1, Point p2) {
      if (p1 == null && p2 != null) {
         p1 = p2;
      } else if (p1 != null && p2 == null) {
         p2 = p1;
      } else if (p1 == null && p2 == null) {
         return null;
      }

      int var2 = Math.min(p1.x, p2.x);
      int var3 = Math.min(p1.y, p2.y);
      int var4 = Math.abs(p2.x - p1.x);
      int var5 = Math.abs(p2.y - p1.y);
      return new Rectangle(var2, var3, var4, var5);
   }

   public static void DiagnosticOut(String s) {
   }

   public static Color GetPixelColor(Image im, int x, int y, ImageObserver ob) {
      if (im == null) {
         return null;
      } else {
         int var4 = im.getWidth(ob);
         int var5 = im.getHeight(ob);
         if (x >= 0 && var4 >= x && y >= 0 && var5 >= y) {
            int[] var6 = new int[1];
            PixelGrabber var7 = new PixelGrabber(im, x, y, 1, 1, var6, 0, 0);

            try {
               var7.grabPixels();
            } catch (InterruptedException ex) {
               System.err.println("interrupted waiting for pixels!");
               return null;
            }

            if ((var7.status() & 128) != 0) {
               System.err.println("image fetch aborted or errored");
               return null;
            } else {
               int var8 = var6[0];
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
