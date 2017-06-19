package rendyak.ManiaPP;

import java.io.IOException;

import javax.naming.MalformedLinkException;

public class CalculatePP {
	private static double AccValue;
	private static double StrainBase;
	private static double StrainMult;
	private static double AccValueTemp1;
	private static double AccValueTemp2;
	private static double AccValueTemp3;
	private static double AccValueTemp4;
	private static int TotalObjects;
	private static double AccTemp;
	private static double TotalPP;
	private static int od;
	private static int starrate;
	private static double perfectw;
	private static double ObjectsDouble;
	private static double MinAcc;
	private static double SRBase;
	private static double SROut;
	private static double SRPow;
	private static double StrainTemp1;
	private static double StrainBase1;
	private static double ObjectsBase;
	private static double MinObjects;
	private static double StrainBase2;
	private static double AccValuePP;
	private static double StrainPP;
	private static double StrainTotal;
	private static double AccStrain;
	private static double AccStrainPP;
	
	public static double calculator(String osulink) throws MalformedLinkException, IOException{
		starrate = rendyak.ManiaPP.ApiDecoder.getStarRate();
		od = rendyak.ManiaPP.ApiDecoder.getOD();
		perfectw = rendyak.ManiaPP.ApiDecoder.getPerfectWindow();
		AccValueTemp1 = 150 / perfectw;
		AccTemp = 100 / 100;
		AccValueTemp2 = Math.pow(AccTemp, 1.8);
		TotalObjects = osuFile.doAll(osulink);
		ObjectsDouble = TotalObjects / 1500;
		AccValueTemp3 = Math.pow(ObjectsDouble, 0.3);
		MinAcc = Math.min(1.15, AccValueTemp3);
		AccValueTemp4 = AccValueTemp1 * AccValueTemp2 * 2.5 * MinAcc;
		AccValue = Math.pow(AccValueTemp4, 0);
		SRBase = starrate / 0.0825;
		SROut = Math.max(1, SRBase);
		SRPow = 5 * SROut - 4;
		StrainTemp1 = Math.pow(SRPow, 3);
		StrainBase1 = StrainTemp1 / 110000;
		ObjectsBase = TotalObjects / 1500;
		MinObjects = Math.min(1, ObjectsBase);
		StrainBase2 = 1 + 0.1 * MinObjects;
		StrainBase = StrainBase1 * StrainBase2;
		StrainMult = 1;
		AccValuePP = Math.pow(AccValue, 1.1);
		StrainTotal = StrainBase * StrainMult;
		StrainPP = Math.pow(StrainTotal , 1.1);
		AccStrain = AccValuePP + StrainPP;
		AccStrainPP = Math.pow(AccStrain, 1/1.1);
		TotalPP = AccStrainPP * 1.1;
		return TotalPP;
	}
	
	public static double getPP(){
		return TotalPP;
	}
}
