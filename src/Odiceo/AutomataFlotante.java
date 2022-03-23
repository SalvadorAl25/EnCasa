package Odiceo;

import EDI.Datos;

public class AutomataFlotante
{
	private Datos obd = new Datos();
	private char fl[];
	private int x, y;
	private String cad, E1 = "0123456789", E2 = "123456789", q,
			tab[][] = { { " ", "0", "-", E2, E1, "eE", "+-", "." },
					{ "0", "1", "3", "2", "Error", "Error", "Error", "Error" },
					{ "1", "Error", "Error", "Error", "Error", "Error", "Error", "4" },
					{ "2", "Error", "Error", "Error", "2", "Error", "Error", "4" },
					{ "3", "2", "Error", "2", "Error", "Error", "Error", "Error" },
					{ "4", "6", "Error", "5", "Error", "Error", "Error", "Error" },
					{ "5", "Error", "Error", "Error", "5", "8", "Error", "Error" },
					{ "6", "Error", "Error", "Error", "7", "Error", "Error", "Error" },
					{ "7", "Error", "Error", "5", "7", "Error", "Error", "Error" },
					{ "8", "Error", "Error", "Error", "Error", "Error", "9", "Error" },
					{ "9", "Error", "Error", "10", "Error", "Error", "Error", "Error" },
					{ "10", "Error", "Error", "10", "10", "Error", "Error", "Error" } };

	public void Inicio()
	{
		// 12.12e-1
		x = 0;
		y = 0;
		q="0";
		cad = obd.Cadena("Valor a validar");
		fl = cad.toCharArray();
		Motor();
	}

	public void Motor()
	{
		for (int ind = 0; ind < fl.length; ind++)
		{
			for (int ren = 0; ren < tab.length; ren++) // Busca el Estado... la
														// 'q' ps...
				if (q.equals(tab[ren][0]))
					x = ren;

			if (q.equals("0") || q.equals("4") || q.equals("9") || q.equals("3"))
			{
				for (int col = 0; col < tab[0].length; col++) // Busca la
																// interaccion
																// sea simbolo o
																// caso que
																// sepresente
					if (tab[0][col].indexOf(fl[ind]) >= 0)
					{
						y = col;
						break;
					}
			}
			else
			{
				if (q.equals("7") && ind == fl.length - 1)
				{
					for (int col = 0; col < tab[0].length; col++)
						if (tab[0][col].indexOf(fl[ind]) >= 0)
						{
							y = col;
							break;
						}
				}
				else
				{
					for (int col = 0; col < tab[0].length; col++)
						if (tab[0][col].indexOf(fl[ind]) >= 0)
							y = col;
				}
			}

			q = tab[x][y];

			if (q.equals("Error"))
			{
				System.out.println("-------------------------------------------------------");
				System.out.println("------------------------¡Error!------------------------");
				System.out.println("-------------------------------------------------------");
				this.Inicio();
			}
		}
		Validacion();
	}

	public void Validacion()
	{
		if (q.equals("5") || q.equals("6") || q.equals("10"))
		{
			System.out.println("-------------------------------------------------------");
			System.out.println("-------------------¡Valor Correcto!--------------------");
			System.out.println("-------------------------------------------------------");
		}
		else
		{
			System.out.println("-------------------------------------------------------");
			System.out.println("-------------------¡Valor Incorrecto!------------------");
			System.out.println("-------------------------------------------------------");
		}
		this.Inicio();
	}

	public static void main(String[] args)
	{
		AutomataFlotante obaf = new AutomataFlotante();
		obaf.Inicio();
	}
}
