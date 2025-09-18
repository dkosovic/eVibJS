import java.awt.Color;
import java.awt.Graphics;

class CFrameGraph extends CFrame {
   public static final int kkCode = 1;
   public static final int kmCode = 2;
   public static final int kcCode = 3;
   public static final double kStartk = 400000.0;
   public static final double kStartm = 1.0;
   public static final double kStartc = 50.0;
   public static final int kXo = 40;
   public static final int kYo = 370;
   public static final double kScale = 1.0E7;
   public static final double kWmax = 200.0;
   public static final int kResponsePoints = 1601;
   double[] mRec1 = new double[1601];
   double mk = 400000.0;
   double mm = 1.0;
   double mc = 50.0;
   double mw;
   double wmax;
   double recptmax;
   double w1;
   double w2;
   double deltaw;
   int smax;
   double mTime;

   public CFrameGraph(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
   }

   public void Frame(Graphics g) {
      Color mass = new Color(0.18F, 0.58F, 0.58F);
      new Color(0.77F, 0.38F, 0.0F);
      g.setPaintMode();
      g.setColor(Color.black);
      g.drawLine(38, 370, 440, 370);
      g.drawLine(38, 371, 440, 371);
      g.drawLine(39, 374, 39, 15);
      g.drawLine(40, 374, 40, 15);

      for (int p = 0; p < 8; p++) {
         g.drawLine(40, 370 - p * 50, 37, 370 - p * 50);
      }

      for (int var5 = 1; var5 < 5; var5++) {
         g.drawLine(40 + var5 * 100, 370, 40 + var5 * 100, 374);
      }

      this.response();
      g.setColor(mass);

      for (int var6 = 2; var6 < 400; var6++) {
         g.drawLine(
            40 + (var6 - 1), (int)(370.0 - Math.abs(this.mRec1[(var6 - 1) * 4] * 1.0E7)), 40 + var6, (int)(370.0 - Math.abs(this.mRec1[var6 * 4] * 1.0E7))
         );
      }

      this.peak();
      g.setColor(Color.blue);
      g.drawLine(40 + (int)(this.wmax / Math.PI), 370, 40 + (int)(this.wmax / Math.PI), (int)(370.0 - this.recptmax * 1.0E7));
      g.drawLine(
         40 + (int)(this.wmax / Math.PI) - 10, (int)(369.0 - this.recptmax * 1.0E7), 40 + (int)(this.wmax / Math.PI) + 10, (int)(369.0 - this.recptmax * 1.0E7)
      );
      g.drawLine(
         40 + (int)(this.w1 / Math.PI),
         (int)(370.0 - this.recptmax * 1.0E7 / Math.sqrt(2.0)),
         40 + (int)(this.w2 / Math.PI),
         (int)(370.0 - this.recptmax * 1.0E7 / Math.sqrt(2.0))
      );
      g.setColor(Color.white);
      g.fillRect(0, 0, 440, 20);
      g.setColor(Color.black);
      g.drawString(" Resonant frequency", 285, 50);
      g.drawString(CUtility.nns(this.wmax / (Math.PI * 2)) + " Hz", 288, 66);
      g.drawString(" Delta omega =" + CUtility.nns(this.deltaw / (Math.PI * 2)) + " Hz", 285, 80);
      g.drawString(" Q = " + CUtility.nns(this.wmax / this.deltaw), 288, 95);
      g.drawString(CUtility.nns(Math.sqrt(this.mk / this.mm) / (Math.PI * 2)) + " Hz", 525, 225);
      g.drawString(CUtility.nns(this.mc / (2.0 * Math.sqrt(this.mm * this.mk))), 536, 256);
      g.drawString(CUtility.nns(Math.sqrt(this.mm * this.mk) / this.mc), 515, 292);
   }

   public double log10(double arg) {
      return Math.log(arg) / Math.log(10.0);
   }

   public String nns(double arg, int sig) {
      if (sig <= 0) {
         sig = 1;
      }

      if (arg == 0.0) {
         return new String("0");
      } else if (arg < 0.0) {
         return new String("-" + this.nns(-arg, sig));
      } else {
         double oom = Math.floor(this.log10(arg));
         double power = Math.pow(10.0, oom - sig + 1.0);
         long intArg = Math.round(arg / power);
         String result = new String(String.valueOf(intArg * power));

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

            Double newNum;
            try {
               newNum = new Double(shortStr);
            } catch (NumberFormatException var15) {
               break;
            }

            if (Math.abs(arg - newNum) > power) {
               break;
            }

            result = shortStr;
         }

         return result;
      }
   }

   public String nns(double arg) {
      return this.nns(arg, 4);
   }

   public void ControlMessage(CFrame controller, int code, double val) {
      boolean mustRedraw = false;
      switch (code) {
         case 1:
            this.mk = val;
            this.response();
            break;
         case 2:
            this.mm = val;
            this.response();
            break;
         case 3:
            this.mc = val;
            this.response();
      }

      if (mustRedraw) {
         this.repaint();
      }
   }

   public void response() {
      for (int s = 1; s < 1601; s++) {
         this.mw = s * 200.0 * 2.0 * Math.PI / 1600.0;
         this.mRec1[s] = 1.0
            / Math.sqrt((this.mk - this.mm * this.mw * this.mw) * (this.mk - this.mm * this.mw * this.mw) + this.mc * this.mc * this.mw * this.mw);
      }
   }

   public void peak() {
      double max = 0.0;

      for (int s = 1; s < 1601; s++) {
         if (this.mRec1[s] > max) {
            max = this.mRec1[s];
            this.smax = s;
            this.wmax = s * 200.0 * 2.0 * Math.PI / 1600.0;
         }
      }

      this.recptmax = max;
      this.w1 = 0.0;
      this.w2 = 200.0;

      for (int var4 = this.smax; var4 > 0; var4--) {
         if (this.mRec1[var4] < max / Math.sqrt(2.0) & this.mRec1[var4 + 1] > max / Math.sqrt(2.0)) {
            this.w1 = var4 * 200.0 * 2.0 * Math.PI / 1600.0
               + (Math.PI / 4) * (max / Math.sqrt(2.0) - this.mRec1[var4]) / (this.mRec1[var4 + 1] - this.mRec1[var4]);
         }
      }

      for (int var5 = this.smax; var5 < 1601; var5++) {
         if (this.mRec1[var5] < max / Math.sqrt(2.0) & this.mRec1[var5 - 1] > max / Math.sqrt(2.0)) {
            this.w2 = var5 * 200.0 * 2.0 * Math.PI / 1600.0
               - (Math.PI / 4) * (max / Math.sqrt(2.0) - this.mRec1[var5]) / (this.mRec1[var5 - 1] - this.mRec1[var5]);
         }
      }

      this.deltaw = this.w2 - this.w1;
   }

   public double GetTime() {
      return this.mTime;
   }

   public boolean MouseEvent(int code, boolean prevHit) {
      if (prevHit) {
         return false;
      } else {
         boolean hit = this.inside(super.mFramePanel.mThisPt.x, super.mFramePanel.mThisPt.y);
         switch (code) {
            case 0:
            case 1:
               double newOmega = (super.mFramePanel.mThisPt.x - 40) * 200.0 / 400.0;
               if (newOmega > 5000.0) {
                  newOmega = 5000.0;
               }

               if (newOmega < 50.0) {
                  newOmega = 50.0;
               }
            default:
               return true;
         }
      }
   }
}
