package Complex.Prog9.Transverse;

import java.awt.Color;
import java.awt.Graphics;

class CFrameGraph extends CFrame {
   public static final int kLCode = 1;
   public static final int kD1Code = 2;
   public static final int kmCode = 3;
   public static final double kStartL = 1.2;
   public static final double kStartD1 = 0.15;
   public static final double kStartm = 2.0;
   public static final int kXo = 40;
   public static final int kYo = 370;
   public static final double kE = 2.0E11;
   public static final double kDensity = 7800.0;
   public static final double kScale = 1.0E8;
   public static final double kWmax = 200.0;
   public static final int kResponsePoints = 401;
   double[] mRec1 = new double[401];
   double[] mRec2 = new double[401];
   double[] mRec3 = new double[401];
   double mL = 1.2;
   double mD1 = 0.15;
   double mm = 2.0;
   double mk;
   double malpha;
   double mlambda1;
   double mw;
   double mArea1;
   double mInertia1;
   double mMax;
   double mMax1;
   double mMax2;
   double mTime;

   public CFrameGraph(CFramePanel var1, int var2, int var3, int var4, int var5) {
      super(var1, var2, var3, var4, var5);
   }

   public void Frame(Graphics var1) {
      Color var3 = new Color(0.18F, 0.58F, 0.58F);
      new Color(0.77F, 0.38F, 0.0F);
      var1.setPaintMode();
      var1.setColor(Color.black);
      var1.drawLine(38, 370, 440, 370);
      var1.drawLine(38, 371, 440, 371);
      var1.drawLine(39, 374, 39, 15);
      var1.drawLine(40, 374, 40, 15);

      for (int var2 = 0; var2 < 8; var2++) {
         var1.drawLine(40, 370 - var2 * 50, 37, 370 - var2 * 50);
      }

      for (int var5 = 1; var5 < 5; var5++) {
         var1.drawLine(40 + var5 * 100, 370, 40 + var5 * 100, 374);
      }

      this.response();
      var1.setColor(Color.red);

      for (int var6 = 2; var6 < 400; var6++) {
         var1.drawLine(40 + (var6 - 1), (int)(370.0 - Math.abs(this.mRec1[var6 - 1] * 1.0E8)), 40 + var6, (int)(370.0 - Math.abs(this.mRec1[var6] * 1.0E8)));
      }

      this.Optimise();
      var1.setColor(var3);

      for (int var7 = 2; var7 < 400; var7++) {
         var1.drawLine(40 + (var7 - 1), (int)(370.0 - this.mRec3[var7 - 1] * 1.0E8), 40 + var7, (int)(370.0 - this.mRec3[var7] * 1.0E8));
      }

      var1.setColor(Color.black);
      var1.drawString(" Optimum values", 485, 34);
      var1.drawString(" Absorber stiffness", 485, 50);
      var1.drawString(CUtility.nns(this.mk) + " N/m", 488, 66);
      var1.drawString(" Hysteretic damping ratio", 485, 82);
      var1.drawString(CUtility.nns(this.malpha), 488, 98);
      var1.setColor(Color.white);
      var1.fillRect(0, 0, 440, 20);
   }

   public double log10(double var1) {
      return Math.log(var1) / Math.log(10.0);
   }

   public String nns(double var1, int var3) {
      if (var3 <= 0) {
         var3 = 1;
      }

      if (var1 == 0.0) {
         return new String("0");
      } else if (var1 < 0.0) {
         return new String("-" + this.nns(-var1, var3));
      } else {
         double var4 = Math.floor(this.log10(var1));
         double var6 = Math.pow(10.0, var4 - var3 + 1.0);
         long var8 = Math.round(var1 / var6);
         String var10 = new String(String.valueOf(var8 * var6));

         while (var10.length() > 1 && var10.indexOf(46) > -1) {
            boolean var11 = false;

            int var12;
            for (var12 = var10.length() - 1; var10.charAt(var12) == '0'; var11 = true) {
               var12--;
            }

            if (var11) {
               var10 = new String(var10.substring(0, var12 + 1));
            }

            String var13 = new String(var10.substring(0, var12));

            double var14;
            try {
               var14 = java.lang.Double.parseDouble(var13);
            } catch (NumberFormatException var15) {
               break;
            }

            if (Math.abs(var1 - var14) > var6) {
               break;
            }

            var10 = var13;
         }

         return var10;
      }
   }

   public String nns(double var1) {
      return this.nns(var1, 4);
   }

   public void ControlMessage(CFrame var1, int var2, double var3) {
      boolean var5 = false;
      switch (var2) {
         case 1:
            this.mL = var3;
            this.response();
            break;
         case 2:
            this.mD1 = var3;
            this.response();
            break;
         case 3:
            this.mm = var3;
            this.response();
      }

      if (var5) {
         this.repaint();
      }
   }

   public void response() {
      this.mArea1 = Math.PI * this.mD1 * this.mD1 / 4.0;
      this.mInertia1 = this.mArea1 * this.mD1 * this.mD1 / 16.0;

      for (int var1 = 1; var1 < 401; var1++) {
         this.mw = var1 * 200.0 * 2.0 * Math.PI / 400.0;
         this.mlambda1 = Math.sqrt(Math.sqrt(this.mw * this.mw * this.mArea1 * 7800.0 / (2.0E11 * this.mInertia1)));
         double var14 = this.mlambda1 * this.mL;
         double var2 = Math.sin(var14);
         double var4 = Math.cos(var14);
         double var16 = Math.exp(var14);
         double var6 = (var16 - 1.0 / var16) / 2.0;
         double var8 = (var16 + 1.0 / var16) / 2.0;
         double var10 = var4 * var8 + 1.0;
         double var12 = var4 * var6 - var2 * var8;
         double var18 = 1.0 / (2.0E11 * this.mInertia1 * this.mlambda1 * this.mlambda1 * this.mlambda1 * var10);
         this.mRec1[var1] = -var12 * var18;
         this.mRec2[var1] = -1.0 / (this.mm * this.mw * this.mw);
         double var20 = this.mRec2[var1] + 1.0 / this.mk / (1.0 + this.malpha * this.malpha);
         double var22 = -this.malpha / this.mk / (1.0 + this.malpha * this.malpha);
         double var24 = 1.0 / this.mRec1[var1] + var20 / (var20 * var20 + var22 * var22);
         double var26 = -var22 / (var20 * var20 + var22 * var22);
         this.mRec3[var1] = Math.abs(1.0 / Math.sqrt(var24 * var24 + var26 * var26));
      }
   }

   public void Maximum() {
      this.mMax = this.mRec3[0];

      for (int var1 = 1; var1 < 401; var1++) {
         if (this.mRec3[var1] > this.mMax) {
            this.mMax = this.mRec3[var1];
         }
      }
   }

   public void Optimise() {
      this.mArea1 = Math.PI * this.mD1 * this.mD1 / 4.0;
      this.mInertia1 = this.mArea1 * this.mD1 * this.mD1 / 16.0;
      double var6 = 3.52 * Math.sqrt(2.0E11 * this.mInertia1 / (7800.0 * this.mArea1)) / this.mL / this.mL;
      this.mk = var6 * var6 * this.mm;
      this.malpha = 0.2;
      double var1 = 0.1 * this.mk;
      double var3 = 0.1 * this.malpha;
      this.response();
      this.Maximum();
      this.mMax1 = this.mMax;

      for (int var5 = 1; var5 < 4; var5++) {
         this.mk += var1;
         this.response();
         this.Maximum();
         this.mMax2 = this.mMax;
         if (this.mMax2 < this.mMax1) {
            while (this.mMax2 < this.mMax1) {
               this.mMax1 = this.mMax2;
               this.mk += var1;
               this.response();
               this.Maximum();
               this.mMax2 = this.mMax;
            }
         } else {
            this.mk -= 2.0 * var1;
            this.response();
            this.Maximum();

            for (this.mMax2 = this.mMax; this.mMax2 < this.mMax1; this.mMax2 = this.mMax) {
               this.mMax1 = this.mMax2;
               this.mk -= var1;
               this.response();
               this.Maximum();
            }
         }

         this.response();
         this.Maximum();
         this.mMax1 = this.mMax;
         this.malpha += var3;
         this.response();
         this.Maximum();
         this.mMax2 = this.mMax;
         if (this.mMax2 < this.mMax1) {
            while (this.mMax2 < this.mMax1) {
               this.mMax1 = this.mMax2;
               this.malpha += var3;
               this.response();
               this.Maximum();
               this.mMax2 = this.mMax;
            }
         } else {
            this.malpha -= 2.0 * var3;
            this.response();
            this.Maximum();

            for (this.mMax2 = this.mMax; this.mMax2 < this.mMax1; this.mMax2 = this.mMax) {
               this.mMax1 = this.mMax2;
               this.malpha -= var3;
               this.response();
               this.Maximum();
            }
         }

         var1 = 0.1 * var1;
         var3 = 0.1 * var3;
      }
   }

   public double GetTime() {
      return this.mTime;
   }

   public boolean MouseEvent(int var1, boolean var2) {
      if (var2) {
         return false;
      } else {
         boolean var3 = this.contains(super.mFramePanel.mThisPt.x, super.mFramePanel.mThisPt.y);
         switch (var1) {
            case 0:
            case 1:
               double var4 = (super.mFramePanel.mThisPt.x - 40) * 200.0 / 400.0;
               if (var4 > 5000.0) {
                  var4 = 5000.0;
               }

               if (var4 < 50.0) {
                  var4 = 50.0;
               }
            default:
               return true;
         }
      }
   }
}
