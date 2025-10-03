package Continuous.Prog13.Transverse;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Vector;

@SuppressWarnings("serial")
class CFrameGraph extends CFrame {
   public static final int kLCode = 1;
   public static final int kBCode = 2;
   public static final int kHCode = 3;
   public static final int kWanimateCode = 4;
   public static final int kDeltaTimeCode = 5;
   public static final double kStartL = 1.5;
   public static final double kStartB = 0.12;
   public static final double kStartH = 0.12;
   public static final double kStartWanimate = 500.0;
   public static final int kXo = 40;
   public static final int kYo = 370;
   public static final double kE = 2.0E11;
   public static final double kDensity = 7800.0;
   public static final double kScale = 30.0;
   public static final double kWmax = 5000.0;
   public static final int kResponsePoints = 401;
   double[] mRec = new double[401];
   double[] mxp = new double[31];
   double[] mAmp = new double[31];
   public Vector mElements;
   double mL = 1.5;
   double mB = 0.12;
   double mH = 0.12;
   double mWanimate = 500.0;
   double mlambda;
   double mw;
   double mArea;
   double mInertia;
   double mTime = 0.0;

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

      for (int var2 = 0; var2 < 12; var2++) {
         var1.drawLine(40, 370 - var2 * 30, 37, 370 - var2 * 30);
      }

      for (int var5 = 1; var5 < 6; var5++) {
         var1.drawLine(40 + var5 * 80, 370, 40 + var5 * 80, 367);
      }

      var1.setColor(var3);
      this.response();

      for (int var6 = 2; var6 < 400; var6++) {
         var1.drawLine(
            40 + (var6 - 1),
            (int)(10.0 - Math.log(Math.abs(this.mRec[var6 - 1])) / Math.log(10.0) * 30.0),
            40 + var6,
            (int)(10.0 - Math.log(Math.abs(this.mRec[var6])) / Math.log(10.0) * 30.0)
         );
      }

      int var7 = (int)(this.mWanimate * 400.0 / 5000.0);
      var1.setColor(Color.blue);
      var1.drawLine(40 + var7, 370, 40 + var7, (int)(10.0 - Math.log(Math.abs(this.mRec[var7])) / Math.log(10.0) * 30.0));
      var1.drawLine(40 + var7, 373, 40 + var7, 368);
      var1.drawString(this.nns(this.mWanimate) + " Hz", 40 + var7 + 2, 385);
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

   public void DrawModeShape(Graphics var1, int var2, int var3) {
      var1.setColor(Color.white);
      var1.fillRect(0, 390, 600, 190);
      var1.fillRect(0, 0, 450, 20);
      byte var8 = 20;
      byte var10 = 30;
      double var11 = 1.0472;
      short var13 = 470;
      Color var15 = new Color(0.18F, 0.58F, 0.58F);
      new Color(0.35F, 0.7F, 0.7F);
      Color var17 = new Color(0.52F, 0.82F, 0.82F);
      Color var18 = new Color(0.77F, 0.38F, 0.0F);
      Color var19 = new Color(1.0F, 1.0F, 0.4F);
      Color var20 = new Color(1.0F, 0.89F, 0.2F);
      byte var22 = 90;
      var1.setColor(var19);
      int var23 = (int)(var22 * Math.cos(var11) / 2.0);
      int var24 = (int)(var22 * Math.sin(var11) / 2.0);
      var1.fillRect(var8, var13 - (int)(var22 / 2.0) + var24, var10, var22);
      var1.setColor(var20);
      Polygon var25 = new Polygon();
      var25.addPoint(var8, var13 - (int)(var22 / 2.0) + var24);
      var25.addPoint(var8 + 2 * var23, var13 - (int)(var22 / 2.0) - var24);
      var25.addPoint(var8 + var10 + 2 * var23, var13 - (int)(var22 / 2.0) - var24);
      var25.addPoint(var8 + var10, var13 - (int)(var22 / 2.0) + var24);
      var1.fillPolygon(var25);
      var1.setColor(Color.orange);
      Polygon var26 = new Polygon();
      var26.addPoint(var8 + var10, var13 - (int)(var22 / 2.0) + var24);
      var26.addPoint(var8 + var10 + 2 * var23, var13 - (int)(var22 / 2.0) - var24);
      var26.addPoint(var8 + var10 + 2 * var23, var13 + (int)(var22 / 2.0) - var24);
      var26.addPoint(var8 + var10, var13 + (int)(var22 / 2.0) + var24);
      var1.fillPolygon(var26);
      this.setOmegaDisp(this.mWanimate);
      this.mAmp[0] = 0.0;

      for (int var4 = 0; var4 < 31; var4++) {
         this.mAmp[var4] = this.mxp[var4] * Math.cos(0.7 * this.mTime * 2.0 * Math.PI);
      }

      var1.setColor(var17);
      Polygon var27 = new Polygon();
      int var28 = (int)(250.0 * this.mB * Math.cos(var11) / 2.0);
      int var29 = (int)(250.0 * this.mB * Math.sin(var11) / 2.0);

      for (int var32 = 0; var32 < 31; var32++) {
         var27.addPoint(var8 + var10 + var23 + (int)(var32 * 250.0 * this.mL / 30.0) - var28, var13 - (int)(this.mAmp[var32] - this.mH * 250.0 / 2.0) + var29);
      }

      var27.addPoint(var8 + var10 + var23 + (int)(250.0 * this.mL) - var28, var13 - (int)(this.mAmp[30] + this.mH * 250.0 / 2.0) + var29);

      for (int var33 = 29; var33 > -1; var33--) {
         var27.addPoint(var8 + var10 + var23 + (int)(var33 * 250.0 * this.mL / 30.0) - var28, var13 - (int)(this.mAmp[var33] + this.mH * 250.0 / 2.0) + var29);
      }

      var1.drawPolygon(var27);
      var1.fillPolygon(var27);
      var1.setColor(var15);
      Polygon var30 = new Polygon();

      for (int var34 = 0; var34 < 31; var34++) {
         var30.addPoint(var8 + var10 + var23 + (int)(var34 * 250.0 * this.mL / 30.0) - var28, var13 - (int)(this.mAmp[var34] + this.mH * 250.0 / 2.0) + var29);
      }

      var30.addPoint(var8 + var10 + var23 + (int)(250.0 * this.mL) + var28, var13 - (int)(this.mAmp[30] + this.mH * 250.0 / 2.0) - var29);

      for (int var35 = 29; var35 > -1; var35--) {
         var30.addPoint(var8 + var10 + var23 + (int)(var35 * 250.0 * this.mL / 30.0) + var28, var13 - (int)(this.mAmp[var35] + this.mH * 250.0 / 2.0) - var29);
      }

      var1.drawPolygon(var30);
      var1.fillPolygon(var30);
      var1.setColor(var15);
      Polygon var31 = new Polygon();
      var31.addPoint(var8 + var10 + var23 + (int)(250.0 * this.mL) - var28, var13 - (int)(this.mAmp[30] + this.mH * 250.0 / 2.0) + var29);
      var31.addPoint(var8 + var10 + var23 + (int)(250.0 * this.mL) + var28, var13 - (int)(this.mAmp[30] + this.mH * 250.0 / 2.0) - var29);
      var31.addPoint(var8 + var10 + var23 + (int)(250.0 * this.mL) + var28, var13 - (int)(this.mAmp[30] - this.mH * 250.0 / 2.0) - var29);
      var31.addPoint(var8 + var10 + var23 + (int)(250.0 * this.mL) - var28, var13 - (int)(this.mAmp[30] - this.mH * 250.0 / 2.0) + var29);
      var1.drawPolygon(var31);
      var1.fillPolygon(var31);
      var1.setColor(var18);
      var1.drawLine(
         var8 + var10 + (int)(250.0 * this.mL) + var23,
         var13 - (int)this.mAmp[30],
         var8 + var10 + (int)(250.0 * this.mL) + var23 + 20,
         var13 - (int)this.mAmp[30]
      );
      int var14 = (int)(20.0 * Math.cos(0.7 * this.mTime * 2.0 * Math.PI));
      if (var14 != 0) {
         if (var14 > 0) {
            var1.drawLine(
               var8 + var10 + (int)(250.0 * this.mL) + var23 + 12,
               var13 - (int)this.mAmp[30],
               var8 + var10 + (int)(250.0 * this.mL) + var23 + 12,
               var13 - var14 - (int)this.mAmp[30]
            );
            var1.drawLine(
               var8 + var10 + (int)(250.0 * this.mL) + var23 + 13,
               var13 - (int)this.mAmp[30],
               var8 + var10 + (int)(250.0 * this.mL) + var23 + 13,
               var13 - var14 - (int)this.mAmp[30] - 1
            );
            var1.drawLine(
               var8 + var10 + (int)(250.0 * this.mL) + var23 + 14,
               var13 - (int)this.mAmp[30],
               var8 + var10 + (int)(250.0 * this.mL) + var23 + 14,
               var13 - var14 - (int)this.mAmp[30]
            );
         }

         if (var14 < 0) {
            var1.drawLine(
               var8 + var10 + (int)(250.0 * this.mL) + var23 + 12,
               var13 - (int)this.mAmp[30],
               var8 + var10 + (int)(250.0 * this.mL) + var23 + 12,
               var13 - var14 - (int)this.mAmp[30]
            );
            var1.drawLine(
               var8 + var10 + (int)(250.0 * this.mL) + var23 + 13,
               var13 - (int)this.mAmp[30],
               var8 + var10 + (int)(250.0 * this.mL) + var23 + 13,
               var13 - var14 - (int)this.mAmp[30] + 1
            );
            var1.drawLine(
               var8 + var10 + (int)(250.0 * this.mL) + var23 + 14,
               var13 - (int)this.mAmp[30],
               var8 + var10 + (int)(250.0 * this.mL) + var23 + 14,
               var13 - var14 - (int)this.mAmp[30]
            );
         }
      }
   }

   public void ControlMessage(CFrame var1, int var2, double var3) {
      boolean var5 = false;
      switch (var2) {
         case 1:
            this.mL = var3;
            this.response();
            break;
         case 2:
            this.mB = var3;
            this.response();
            break;
         case 3:
            this.mH = var3;
            this.response();
            break;
         case 4:
            this.mWanimate = var3;
            this.setOmegaDisp(this.mWanimate);
            var5 = true;
            break;
         case 5:
            this.mTime += var3;
            var5 = true;
      }

      if (var5) {
         this.repaint();
      }
   }

   public void response() {
      this.mArea = Math.PI * this.mB * this.mH;
      this.mInertia = this.mArea * this.mH * this.mH / 12.0;

      for (int var1 = 1; var1 < 401; var1++) {
         this.mw = var1 * 5000.0 * 2.0 * Math.PI / 400.0;
         this.mlambda = Math.sqrt(Math.sqrt(this.mw * this.mw * this.mArea * 7800.0 / (2.0E11 * this.mInertia)));
         double var14 = this.mlambda * this.mL;
         double var2 = Math.sin(var14);
         double var4 = Math.cos(var14);
         double var16 = Math.exp(var14);
         double var6 = (var16 - 1.0 / var16) / 2.0;
         double var8 = (var16 + 1.0 / var16) / 2.0;
         double var10 = var4 * var8 + 1.0;
         double var12 = var4 * var6 - var2 * var8;
         double var18 = 1.0 / (2.0E11 * this.mInertia * this.mlambda * this.mlambda * this.mlambda * var10);
         this.mRec[var1] = -var12 * var18;
      }

      this.setOmegaDisp(this.mWanimate);
   }

   public void setOmegaDisp(double var1) {
      this.mArea = Math.PI * this.mB * this.mH;
      this.mInertia = this.mArea * this.mH * this.mH / 12.0;
      this.mlambda = Math.sqrt(Math.sqrt(var1 * 2.0 * Math.PI * var1 * 2.0 * Math.PI * this.mArea * 7800.0 / (2.0E11 * this.mInertia)));
      double var12 = this.mlambda * this.mL;
      double var14 = Math.sin(var12);
      double var16 = Math.cos(var12);
      double var22 = Math.exp(var12);
      double var18 = (var22 - 1.0 / var22) / 2.0;
      double var20 = (var22 + 1.0 / var22) / 2.0;
      double var6 = var14 + var18;
      double var8 = var16 + var20;
      double var4 = var16 * var20 + 1.0;
      double var10 = 1.0 / (2.0E11 * this.mInertia * this.mL * this.mL * this.mL * var4);
      double var34 = 0.0;

      for (int var3 = 0; var3 < 31; var3++) {
         double var24 = this.mlambda * var3 * this.mL / 30.0;
         double var26 = Math.sin(var24);
         double var28 = Math.cos(var24);
         var22 = Math.exp(var24);
         double var30 = (var22 - 1.0 / var22) / 2.0;
         double var32 = (var22 + 1.0 / var22) / 2.0;
         this.mxp[var3] = -(var6 * (var28 - var32) - var8 * (var26 - var30)) * var10;
         if (Math.abs(this.mxp[var3]) > var34) {
            var34 = Math.abs(this.mxp[var3]);
         }
      }

      for (int var36 = 0; var36 < 31; var36++) {
         this.mxp[var36] = this.mxp[var36] * 20.0 / var34;
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
               double var4 = (super.mFramePanel.mThisPt.x - 40) * 5000.0 / 400.0;
               if (var4 > 5000.0) {
                  var4 = 5000.0;
               }

               if (var4 < 20.0) {
                  var4 = 20.0;
               }

               this.ControlMessage(this, 4, var4);
            default:
               return true;
         }
      }
   }
}
