package Simulacion;

import java.util.*;
import java.text.DecimalFormat;

public class Periodicos
{
	/*
	 * dtd=digitos tipo de dia td=tipo de dia ddem=digistos aleatorios para
	 * demanda predida de beneficios de exceso dem=demanda ipv=ingresos por
	 * venta pbe=Pérdida de Beneficios de Exceso de demanda rvd=rescate de venta
	 * de desecho gd=ganancia diaria peri=Periodicos
	 */
	private int dtd, dem, ddem, dia;
	private double ipv, pbe, rvd, gd;
	private String td;
	private Random obr = new Random();
	private DecimalFormat df = new DecimalFormat("0.00");

	public void Lectura(int peri, int dia)
	{
		this.dia = dia;
		do
			dtd = obr.nextInt(101);
		while (dtd < 1);
		if (dtd >= 1 && dtd <= 35)
			td = "Buena" + "\t";
		else
			if (dtd >= 36 && dtd <= 80)
				td = "Aceptable";
			else
				if (dtd >= 81 && dtd <= 100)
					td = "Malo" + "\t";
		do
			ddem = obr.nextInt(101);
		while (ddem < 1);
		if (td.equals("Malo"))
		{
			if (ddem >= 1 && ddem <= 44)
				dem = 40;
			else
				if (ddem >= 45 && ddem >= 66)
					dem = 50;
				else
					if (ddem >= 67 && ddem >= 82)
						dem = 60;
					else
						if (ddem >= 83 && ddem >= 94)
							dem = 70;
						else
							if (ddem >= 95 && ddem <= 100)
								dem = 80;
		}
		else
			if (td.equals("Aceptable"))
			{
				if (ddem >= 1 && ddem <= 10)
					dem = 40;
				else
					if (ddem >= 11 && ddem <= 28)
						dem = 50;
					else
						if (ddem >= 29 && ddem <= 68)
							dem = 60;
						else
							if (ddem >= 69 && ddem <= 88)
								dem = 70;
							else
								if (ddem >= 89 && ddem <= 96)
									dem = 80;
								else
									if (ddem >= 97 && ddem <= 100)
										dem = 90;
			}
			else
				if (td.equals("Buena"))
				{
					if (ddem >= 1 && ddem <= 3)
						dem = 40;
					else
						if (ddem >= 4 && ddem >= 8)
							dem = 50;
						else
							if (ddem >= 9 && ddem <= 23)
								dem = 60;
							else
								if (ddem >= 24 && ddem <= 43)
									dem = 70;
								else
									if (ddem >= 44 && ddem <= 78)
										dem = 80;
									else
										if (ddem >= 79 && ddem <= 93)
											dem = 90;
										else
											if (ddem >= 94 && ddem <= 100)
												dem = 100;
				}
		this.Calculos(peri);
	}

	private void Calculos(int peri)
	{
		if (dem > peri)
		{
			pbe = (dem - peri) * .17;
			ipv = 40;
		}
		else
		{
			ipv = dem * .5;
			pbe = 0;
		}
		if (dem < peri)
			rvd = (peri - dem) * .05;
		else
			rvd = 0;

		gd = (ipv + rvd - 26.4) - pbe;
	}

	public void Mostrar()
	{
		System.out.println(dia + "\t\t" + dtd + "\t\t" + td + "\t\t" + ddem + "\t\t   " + dem + "\t\t\t" + ipv
				+ "\t\t\t    " + df.format(pbe) + "\t\t\t" + df.format(rvd) + "\t\t\t    " + df.format(gd));
	}
}