package rendyak.ManiaPP;

import static java.lang.Math.pow;

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
	private static int TotalPP;
	private static int od;
	private static int starrate;
	private static double perfectw;
	private static double ObjectsDouble;
	private static double MinAcc;
	
	public String calculator(String osulink){
		starrate = rendyak.ManiaPP.ApiDecoder.getStarRate();
		od = rendyak.ManiaPP.ApiDecoder.getOD();
		perfectw = rendyak.ManiaPP.ApiDecoder.getPerfectWindow();
		AccValueTemp1 = 150 / perfectw;
		AccTemp = 100 / 100;
		AccValueTemp2 = Math.pow(AccTemp, 1.8);
		TotalObjects = rendyak.ManiaPP.osuFile.osuFile(osulink);
		ObjectsDouble = TotalObjects / 1500;
		AccValueTemp3 = Math.pow(ObjectsDouble, 0.3);
		MinAcc = Math.min(1.15, AccValueTemp3);
		AccValueTemp4 = AccValueTemp1 * AccValueTemp2 * 2.5 * MinAcc;
		AccValue = Math.pow(AccValueTemp4);
	}
}
