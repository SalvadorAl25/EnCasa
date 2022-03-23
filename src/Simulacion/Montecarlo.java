package Simulacion;

import java.text.DecimalFormat;
import java.util.Random;

import EDI.Datos;
import EDI.Menu;

public class Montecarlo
{
	private double x, y,val1, pi = 3.14, inte = 0.3333;
	private int cen, eve, aci, acie=1, bc, evn = 0, prob, prob2;
	private Random obr = new Random();
	private DecimalFormat df = new DecimalFormat("0.00000");

	public void Calcularpi(int eve)
	{
		do
			x = obr.nextInt(100001);
		while (x < 100);
		x=x/100000;
		do
			y = obr.nextInt(100001);
		while (y < 100);
		y=y/100000;
		val1 = Math.pow(x, 2) + Math.pow(y, 2);
		if (Math.sqrt(val1) <= 100000)
			cen = 1;
		else
			cen = 0;
		if (cen != 0)
			aci++;
		this.eve = eve;
		prob = this.eve / aci;
		prob2 = 4 * prob;
		System.out.println(x + "\t\t" + y + "\t\t" + df.format(val1) + "\t\t\t" + cen + "\t\t\t" + this.eve + "\t\t" + aci + "\t\t"
				+ prob + "\t\t" + prob2 + "\t\t" + pi);
	}

	public void CalcularArea(int eve)
	{
		do
			x = obr.nextInt(100001);
		while (x < 100);
		x=x/100000;
		do
			y = obr.nextInt(100001);
		while (y < 100);
		y=y/100000;
		val1 = Math.pow(x, 2);
		if (y <= val1)
			bc = 1;
		else
			bc = 0;
		if (y <= val1)
			acie++;
		evn = eve;
		prob = evn / acie;
		prob2 = prob / acie;
		System.out.println(x + "\t\t" + y + "\t\t" + df.format(val1) + "\t\t\t" + bc + "\t\t   " + evn + "\t\t" + acie+ "\t\t" + prob
				+ "\t\t" + prob2 + "\t\t  " + inte);
	}

	public static void main(String[] args)
	{
		int op, mue, eve = 0;
		Menu obm = new Menu("Metodo de Montecarlo", new String[]
		{ "Aproximacion de Pi", "Aproximacion de Area Bajo La Curva" });
		Montecarlo obo[] = null;
		Datos obd = new Datos();

		do
			switch (op = obm.Opcion())
			{
				case 1:
					do
						mue = obd.Entero("Cantidad de Muestras");
					while (mue <= 1);
					obo = new Montecarlo[mue];
					if (obo != null)
					{
						System.out.println("Aleat. X" + "\t" + "Aleat.y" + "\t\t" + "X^2+Y^2" + "\t\t"
								+ "  CENTRO CIRCULO" + "\t" + "EVENTO" + "\t\t" + "ACIERTOS" + "\t" + "PROBABILIDAD"
								+ "\t" + "INT=4*prob" + "\t" + "Pi");
						for (int ind = 0; ind < obo.length; ind++)
						{
							obo[ind] = new Montecarlo();
							if (eve <= mue)
								eve = eve + 1;
							obo[ind].Calcularpi(eve);
						}
					}
					break;
				case 2:
					do
						mue = obd.Entero("Cantidad de Muestras");
					while (mue <= 1);
					obo = new Montecarlo[mue];
					if (obo != null)
					{
						System.out.println("Aleat. X" + "\t" + "Aleat.y" + "\t\t" + "f(x)=x^2" + "\t"
								+ "  Bajo la curva" + "\t\t" + "Eventos" + "\t" + "     ACIERTOS" + "\t"
								+ "   PROBABILIDAD" + "\t" + "      int=prob" + "\t\t" + "integral x^2");
						for (int ind = 0; ind < obo.length; ind++)
						{
							obo[ind] = new Montecarlo();
							if (eve <= mue)
								eve = eve + 1;
							obo[ind].CalcularArea(eve);
						}
					}
			}
		while (op != obm.Salir());
	}
}
