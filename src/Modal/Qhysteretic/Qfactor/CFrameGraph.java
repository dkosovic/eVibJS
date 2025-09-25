package Modal.Qhysteretic.Qfactor;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
class CFrameGraph extends CFrame {
   public static final int km1Code = 1;
   public static final int kk1Code = 2;
   public static final int kh1Code = 3;
   public static final int km2Code = 4;
   public static final int kk2Code = 5;
   public static final int kh2Code = 6;
   public static final double kStartm1 = 1.5;
   public static final double kStartk1 = 400000.0;
   public static final double kStarth1 = 40000.0;
   public static final double kStartm2 = 1.2;
   public static final double kStartk2 = 200000.0;
   public static final double kStarth2 = 10000.0;
   public static final int kXo = 40;
   public static final int kYo = 410;
   public static final double kScale = 1.0E7;
   public static final double kWmax = 200.0;
   public static final int kResponsePoints = 1601;
   double[] mRec = new double[1601];
   double[] mRec1 = new double[1601];
   double[] mRec2 = new double[1601];
   double[] mRec3 = new double[1601];
   double mm1 = 1.5;
   double mk1 = 400000.0;
   double mh1 = 40000.0;
   double mm2 = 1.2;
   double mk2 = 200000.0;
   double mh2 = 10000.0;
   double mw;
   double w1max;
   double recpt1max;
   double w11;
   double w12;
   double delta1w;
   double w2max;
   double recpt2max;
   double w21;
   double w22;
   double delta2w;
   double mwn1;
   double mu1;
   double mwn2;
   double mu2;
   int s1max;
   int s2max;
   double malpha1;
   double malpha2;
   double mTime;

   public CFrameGraph(CFramePanel thePanel, int xx, int yy, int ww, int hh) {
      super(thePanel, xx, yy, ww, hh);
   }

   public void Frame(Graphics g) {
      new Color(0.18F, 0.58F, 0.58F);
      new Color(0.77F, 0.38F, 0.0F);
      g.setPaintMode();
      g.setColor(Color.black);
      g.drawLine(38, 410, 440, 410);
      g.drawLine(38, 411, 440, 411);
      g.drawLine(39, 414, 39, 55);
      g.drawLine(40, 414, 40, 55);

      for (int p = 0; p < 8; p++) {
         g.drawLine(40, 410 - p * 50, 37, 410 - p * 50);
      }

      for (int var5 = 1; var5 < 5; var5++) {
         g.drawLine(40 + var5 * 100, 410, 40 + var5 * 100, 414);
      }

      this.response();
      this.peak();
      this.Modes();
      this.Modesum();
      g.setColor(Color.orange);

      for (int var6 = 2; var6 < 400; var6++) {
         g.drawLine(
            40 + (var6 - 1), (int)(410.0 - Math.abs(this.mRec1[(var6 - 1) * 4] * 1.0E7)), 40 + var6, (int)(410.0 - Math.abs(this.mRec1[var6 * 4] * 1.0E7))
         );
      }

      g.setColor(Color.green);

      for (int var7 = 2; var7 < 400; var7++) {
         g.drawLine(
            40 + (var7 - 1), (int)(410.0 - Math.abs(this.mRec2[(var7 - 1) * 4] * 1.0E7)), 40 + var7, (int)(410.0 - Math.abs(this.mRec2[var7 * 4] * 1.0E7))
         );
      }

      g.setColor(Color.black);

      for (int var8 = 2; var8 < 400; var8++) {
         g.drawLine(
            40 + (var8 - 1), (int)(410.0 - Math.abs(this.mRec[(var8 - 1) * 4] * 1.0E7)), 40 + var8, (int)(410.0 - Math.abs(this.mRec[var8 * 4] * 1.0E7))
         );
      }

      g.setColor(Color.red);

      for (int var9 = 2; var9 < 400; var9++) {
         g.drawLine(
            40 + (var9 - 1), (int)(410.0 - Math.abs(this.mRec3[(var9 - 1) * 4] * 1.0E7)), 40 + var9, (int)(410.0 - Math.abs(this.mRec3[var9 * 4] * 1.0E7))
         );
      }

      g.setColor(Color.blue);
      g.drawLine(40 + (int)(this.w1max / Math.PI), 410, 40 + (int)(this.w1max / Math.PI), (int)(410.0 - this.recpt1max * 1.0E7));
      g.drawLine(
         40 + (int)(this.w1max / Math.PI) - 10,
         (int)(409.0 - this.recpt1max * 1.0E7),
         40 + (int)(this.w1max / Math.PI) + 10,
         (int)(409.0 - this.recpt1max * 1.0E7)
      );
      g.drawLine(
         40 + (int)(this.w11 / Math.PI),
         (int)(410.0 - this.recpt1max * 1.0E7 / Math.sqrt(2.0)),
         40 + (int)(this.w12 / Math.PI),
         (int)(410.0 - this.recpt1max * 1.0E7 / Math.sqrt(2.0))
      );
      g.drawLine(40 + (int)(this.w2max / Math.PI), 410, 40 + (int)(this.w2max / Math.PI), (int)(410.0 - this.recpt2max * 1.0E7));
      g.drawLine(
         40 + (int)(this.w2max / Math.PI) - 10,
         (int)(409.0 - this.recpt2max * 1.0E7),
         40 + (int)(this.w2max / Math.PI) + 10,
         (int)(409.0 - this.recpt2max * 1.0E7)
      );
      g.drawLine(
         40 + (int)(this.w21 / Math.PI),
         (int)(410.0 - this.recpt2max * 1.0E7 / Math.sqrt(2.0)),
         40 + (int)(this.w22 / Math.PI),
         (int)(410.0 - this.recpt2max * 1.0E7 / Math.sqrt(2.0))
      );
      g.setColor(Color.white);
      g.fillRect(0, 0, 440, 20);
      g.setColor(Color.black);
      g.drawString(CUtility.nns(this.w1max / (Math.PI * 2)) + " Hz", 24 + (int)(this.w1max / Math.PI), -5 + (int)(409.0 - this.recpt1max * 1.0E7));
      g.drawString(" Q = " + CUtility.nns(this.w1max / this.delta1w), 56 + (int)(this.w1max / Math.PI), 9 + (int)(409.0 - this.recpt1max * 1.0E7));
      g.setColor(Color.black);
      g.drawString(CUtility.nns(this.w2max / (Math.PI * 2)) + " Hz", 24 + (int)(this.w2max / Math.PI), -5 + (int)(409.0 - this.recpt2max * 1.0E7));
      g.drawString(" Q = " + CUtility.nns(this.w2max / this.delta2w), 56 + (int)(this.w2max / Math.PI), 9 + (int)(409.0 - this.recpt2max * 1.0E7));
      g.drawString(CUtility.nns(this.mwn1 / (Math.PI * 2)) + " Hz", 538, 315);
      g.drawString(CUtility.nns(this.mu1), 538, 335);
      g.drawString(CUtility.nns(this.mwn2 / (Math.PI * 2)) + " Hz", 538, 372);
      g.drawString(CUtility.nns(this.mu2), 538, 392);
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

            double newNum;
            try {
               newNum = java.lang.Double.parseDouble(shortStr);
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
            this.mm1 = val;
            this.response();
            break;
         case 2:
            this.mk1 = val;
            this.response();
            break;
         case 3:
            this.mh1 = val;
            this.response();
            break;
         case 4:
            this.mm2 = val;
            this.response();
            break;
         case 5:
            this.mk2 = val;
            this.response();
            break;
         case 6:
            this.mh2 = val;
            this.response();
      }

      if (mustRedraw) {
         this.repaint();
      }
   }

   public void response() {
      for (int s = 1; s < 1601; s++) {
         this.mw = s * 200.0 * 2.0 * Math.PI / 1600.0;
         double mD = this.mk2 * this.mk2 + this.mh2 * this.mh2;
         double mA = this.mk2 / mD - 1.0 / (this.mm2 * this.mw * this.mw);
         double mB = -this.mh2 / mD;
         double mC = this.mk1 - this.mm1 * this.mw * this.mw + mA / (mA * mA + mB * mB);
         mD = this.mh1 - mB / (mA * mA + mB * mB);
         double mReal = mC / (mC * mC + mD * mD);
         double mQuad = -mD / (mC * mC + mD * mD);
         this.mRec[s] = Math.sqrt(mReal * mReal + mQuad * mQuad);
      }
   }

   public void peak() {
      int n = 0;

      for (int s = 3; s < 1601; s++) {
         if (this.mRec[s] < this.mRec[s - 1] & this.mRec[s - 1] > this.mRec[s - 2]) {
            if (++n == 1) {
               this.s1max = s - 1;
               this.recpt1max = this.mRec[s - 1];
               this.w1max = (s - 1) * 200.0 * 2.0 * Math.PI / 1600.0;
            }

            if (n == 2) {
               this.s2max = s - 1;
               this.recpt2max = this.mRec[s - 1];
               this.w2max = (s - 1) * 200.0 * 2.0 * Math.PI / 1600.0;
            }
         }
      }

      this.w11 = 0.0;
      this.w12 = 200.0;

      for (int var3 = this.s1max; var3 > 0; var3--) {
         if (this.mRec[var3] < this.recpt1max / Math.sqrt(2.0) & this.mRec[var3 + 1] > this.recpt1max / Math.sqrt(2.0)) {
            this.w11 = var3 * 200.0 * 2.0 * Math.PI / 1600.0
               + (Math.PI / 4) * (this.recpt1max / Math.sqrt(2.0) - this.mRec[var3]) / (this.mRec[var3 + 1] - this.mRec[var3]);
         }
      }

      for (int var4 = this.s1max; var4 < this.s2max; var4++) {
         if (this.mRec[var4] < this.recpt1max / Math.sqrt(2.0) & this.mRec[var4 - 1] > this.recpt1max / Math.sqrt(2.0)) {
            this.w12 = var4 * 200.0 * 2.0 * Math.PI / 1600.0
               - (Math.PI / 4) * (this.recpt1max / Math.sqrt(2.0) - this.mRec[var4]) / (this.mRec[var4 - 1] - this.mRec[var4]);
         }
      }

      this.delta1w = this.w12 - this.w11;
      this.malpha1 = this.delta1w / this.w1max;
      this.w21 = 0.0;
      this.w22 = 200.0;

      for (int var5 = this.s2max; var5 > this.s1max; var5--) {
         if (this.mRec[var5] < this.recpt2max / Math.sqrt(2.0) & this.mRec[var5 + 1] > this.recpt2max / Math.sqrt(2.0)) {
            this.w21 = var5 * 200.0 * 2.0 * Math.PI / 1600.0
               + (Math.PI / 4) * (this.recpt2max / Math.sqrt(2.0) - this.mRec[var5]) / (this.mRec[var5 + 1] - this.mRec[var5]);
         }
      }

      for (int var6 = this.s2max + 1; var6 < 1601; var6++) {
         if (this.mRec[var6] < this.recpt2max / Math.sqrt(2.0) & this.mRec[var6 - 1] > this.recpt2max / Math.sqrt(2.0)) {
            this.w22 = var6 * 200.0 * 2.0 * Math.PI / 1600.0
               - (Math.PI / 4) * (this.recpt2max / Math.sqrt(2.0) - this.mRec[var6]) / (this.mRec[var6 - 1] - this.mRec[var6]);
         }
      }

      this.delta2w = this.w22 - this.w21;
      this.malpha2 = this.delta2w / this.w2max;
   }

   public void Modes() {
      double A = this.mm1 * this.mm2;
      double B = -(this.mm2 * this.mk1 + this.mm2 * this.mk2 + this.mm1 * this.mk2);
      double C = this.mk1 * this.mk2;
      this.mwn1 = Math.sqrt((-B - Math.sqrt(B * B - 4.0 * A * C)) / 2.0 / A);
      this.mwn2 = Math.sqrt((-B + Math.sqrt(B * B - 4.0 * A * C)) / 2.0 / A);
      this.mu1 = this.mk2 / (this.mk2 - this.mm2 * this.mwn1 * this.mwn1);
      this.mu2 = this.mk2 / (this.mk2 - this.mm2 * this.mwn2 * this.mwn2);
   }

   public void Modesum() {
      double C1 = (1.0 - this.mu2) / (this.mu1 - this.mu2);
      double C2 = (this.mu1 - 1.0) / (this.mu1 - this.mu2);
      double mode1k = this.mk1 / C1;
      double mode2k = this.mk1 / C2;

      for (int s = 1; s < 1601; s++) {
         this.mw = s * 200.0 * 2.0 * Math.PI / 1600.0;
         double mA = 1.0 - this.mw * this.mw / this.mwn1 / this.mwn1;
         double mB = -this.malpha1;
         double mC = mA * mA + mB * mB;
         double mReal1 = mA / mC / mode1k;
         double mQuad1 = mB / mC / mode1k;
         this.mRec1[s] = Math.sqrt(mReal1 * mReal1 + mQuad1 * mQuad1);
         mA = 1.0 - this.mw * this.mw / this.mwn2 / this.mwn2;
         mB = -this.malpha2;
         mC = mA * mA + mB * mB;
         double mReal2 = mA / mC / mode2k;
         double mQuad2 = mB / mC / mode2k;
         this.mRec2[s] = Math.sqrt(mReal2 * mReal2 + mQuad2 * mQuad2);
         this.mRec3[s] = Math.sqrt((mReal1 + mReal2) * (mReal1 + mReal2) + (mQuad1 + mQuad2) * (mQuad1 + mQuad2));
      }
   }

   public double GetTime() {
      return this.mTime;
   }

   public boolean MouseEvent(int code, boolean prevh1t) {
      if (prevh1t) {
         return false;
      } else {
         boolean h1t = this.contains(super.mFramePanel.mThisPt.x, super.mFramePanel.mThisPt.y);
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
