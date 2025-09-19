package Continuous.Prog5.Multiforced;

import java.awt.Color;
import java.awt.Font;
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
         return new String("0");
      } else if (arg < 0.0) {
         return new String("-" + nns(-arg, sig));
      } else {
         double oom = Math.floor(log10(arg));
         double power = Math.pow(10.0, oom - sig + 1.0);
         long intArg = Math.round(arg / power);
         String result = new String(String.valueOf(intArg * power));
         String expStr = "";
         int expPos = result.indexOf("E-");
         if (expPos > -1) {
            expStr = result.substring(expPos);
            result = result.substring(0, expPos);
            power = Math.pow(10.0, -sig);

            try {
               arg = java.lang.Double.parseDouble(result);
            } catch (NumberFormatException var16) {
            }
         } else if (result.indexOf("E") > -1) {
            return result;
         }

         while (result.length() > 1 && result.indexOf(46) > -1) {
            boolean trimmed = false;

            int lastChar;
            for (lastChar = result.length() - 1; result.charAt(lastChar) == '0'; trimmed = true) {
               lastChar--;
            }

            if (trimmed) {
               result = new String(result.substring(0, lastChar + 1));
            }

            String shortStr = new String(result.substring(0, lastChar));

            double newNum;
            try {
               newNum = java.lang.Double.parseDouble(shortStr);
            } catch (NumberFormatException var17) {
               break;
            }

            if (Math.abs(arg - newNum) > power) {
               break;
            }

            result = shortStr;
         }

         return new String(result + expStr);
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
         int newRed = c1.getRed() + (int)(ratio * (c2.getRed() - c1.getRed()));
         int newGreen = c1.getGreen() + (int)(ratio * (c2.getGreen() - c1.getGreen()));
         int newBlue = c1.getBlue() + (int)(ratio * (c2.getBlue() - c1.getBlue()));
         return new Color(newRed, newGreen, newBlue);
      }
   }

   public static int DrawString(Graphics g, String theString, int x, int y) {
      Font font = g.getFont();
      FontMetrics fm = g.getFontMetrics();
      int wid = fm.stringWidth(theString);
      g.drawString(theString, x, y);
      return x + wid;
   }

   public static void JDrawString(Graphics g, String arg, int x, int y, int hAlign, int vAlign) {
      FontMetrics fm = g.getFontMetrics();
      int sLen = fm.stringWidth(arg);
      int maxAsc = fm.getMaxAscent();
      int maxDesc = fm.getMaxDescent();
      switch (hAlign) {
         case -1:
            x -= sLen;
            break;
         case 0:
            x -= sLen / 2;
      }

      switch (vAlign) {
         case -2:
            y += maxAsc;
            break;
         case -1:
            y += (maxDesc + maxAsc) / 2;
         case 0:
         default:
            break;
         case 1:
            y -= maxDesc;
      }

      g.drawString(arg, x, y);
   }

   public static void DrawHelp(Graphics g, Point mArrow, int wid, int hei, String message) {
      g.setPaintMode();
      int kLineSpacing = 12;
      int kLineGap = 5;
      int gap1 = 10;
      int gap2 = 20;
      int ww = 0;
      int hh = 2 * kLineGap;
      StringTokenizer st = new StringTokenizer(message, "\n");

      while (st.hasMoreTokens()) {
         hh += kLineSpacing;
         int thisWidth = g.getFontMetrics().stringWidth(st.nextToken());
         if (thisWidth > ww) {
            ww = thisWidth;
         }
      }

      ww += 2 * gap1;
      int xMult = 1;
      int yMult = 1;
      if (mArrow.x + gap1 + ww > wid) {
         xMult = -1;
      }

      if (mArrow.y + gap1 + hh > hei) {
         yMult = -1;
      }

      Polygon p = new Polygon();
      p.addPoint(mArrow.x, mArrow.y);
      p.addPoint(mArrow.x + xMult * gap1, mArrow.y + yMult * gap2);
      p.addPoint(mArrow.x + xMult * gap1, mArrow.y + yMult * (gap1 + hh));
      p.addPoint(mArrow.x + xMult * (gap1 + ww), mArrow.y + yMult * (gap1 + hh));
      p.addPoint(mArrow.x + xMult * (gap1 + ww), mArrow.y + yMult * gap1);
      p.addPoint(mArrow.x + xMult * gap2, mArrow.y + yMult * gap1);
      p.addPoint(mArrow.x, mArrow.y);
      g.setColor(Color.white);
      g.fillPolygon(p);
      g.setColor(Color.black);
      g.drawPolygon(p);
      int tx;
      if (xMult > 0) {
         tx = mArrow.x + 2 * gap1;
      } else {
         tx = mArrow.x - ww;
      }

      int ty;
      if (yMult > 0) {
         ty = mArrow.y + gap1 + kLineGap + kLineSpacing;
      } else {
         ty = mArrow.y - gap1 - hh + kLineGap + kLineSpacing;
      }

      int tokenNo = -1;
      st = new StringTokenizer(message, "\n");

      while (st.hasMoreTokens()) {
         g.drawString(st.nextToken(), tx, ty + ++tokenNo * kLineSpacing);
      }
   }

   public static void DrawStringHalo(Graphics g, String s, int xx, int yy) {
      Color saveColor = g.getColor();
      g.setColor(Color.white);
      g.drawString(s, xx + 1, yy + 1);
      g.drawString(s, xx, yy + 1);
      g.drawString(s, xx - 1, yy + 1);
      g.drawString(s, xx - 1, yy);
      g.drawString(s, xx - 1, yy - 1);
      g.drawString(s, xx, yy - 1);
      g.drawString(s, xx + 1, yy - 1);
      g.drawString(s, xx + 1, yy);
      g.setColor(saveColor);
      g.drawString(s, xx, yy);
   }

   public static void DrawDoughnut(Graphics g, int x, int y, int rad, int thick) {
      Color saveColor = g.getColor();

      for (int i = -1; i <= thick; i++) {
         if (i >= 0 && i != thick) {
            g.setColor(saveColor);
         } else {
            g.setColor(Color.white);
         }

         g.drawOval(x - rad + i, y - rad + i, 2 * (rad - i), 2 * (rad - i));
      }

      g.setColor(saveColor);
   }

   public static double RangeRandom(double minV, double maxV, double step) {
      double raw = minV + (maxV - minV) * Math.random();
      return step <= 0.0 ? raw : step * Math.round(raw / step);
   }

   public static void DrawThickLine(Graphics g, int x1, int y1, int x2, int y2) {
      Point delta = new Point(Math.abs(x2 - x1), y2 - y1);
      if (delta.y <= delta.x && delta.y >= -delta.x) {
         delta.x = 0;
         delta.y = -1;
      } else {
         delta.x = -1;
         delta.y = 0;
      }

      Point p1 = new Point(x1, y1);
      Point p2 = new Point(x2, y2);
      g.drawLine(p1.x, p1.y, p2.x, p2.y);
      p1.x = p1.x + delta.x;
      p1.y = p1.y + delta.y;
      p2.x = p2.x + delta.x;
      p2.y = p2.y + delta.y;
      g.drawLine(p1.x, p1.y, p2.x, p2.y);
   }

   public static Rectangle TwoPointRect(Point p1, Point p2) {
      if (p1 == null && p2 != null) {
         p1 = p2;
      } else if (p1 != null && p2 == null) {
         p2 = p1;
      } else if (p1 == null && p2 == null) {
         return null;
      }

      int xx = Math.min(p1.x, p2.x);
      int yy = Math.min(p1.y, p2.y);
      int ww = Math.abs(p2.x - p1.x);
      int hh = Math.abs(p2.y - p1.y);
      return new Rectangle(xx, yy, ww, hh);
   }

   public static void DiagnosticOut(String s) {
   }

   public static Color GetPixelColor(Image im, int x, int y, ImageObserver ob) {
      if (im == null) {
         return null;
      } else {
         int w = im.getWidth(ob);
         int h = im.getHeight(ob);
         if (x >= 0 && w >= x && y >= 0 && h >= y) {
            int[] pixels = new int[1];
            PixelGrabber pg = new PixelGrabber(im, x, y, 1, 1, pixels, 0, 0);

            try {
               pg.grabPixels();
            } catch (InterruptedException var13) {
               System.err.println("interrupted waiting for pixels!");
               return null;
            }

            if ((pg.status() & 128) != 0) {
               System.err.println("image fetch aborted or errored");
               return null;
            } else {
               int pixel = pixels[0];
               int alpha = pixel >> 24 & 0xFF;
               int red = pixel >> 16 & 0xFF;
               int green = pixel >> 8 & 0xFF;
               int blue = pixel & 0xFF;
               return new Color(red, green, blue);
            }
         } else {
            return null;
         }
      }
   }
}
