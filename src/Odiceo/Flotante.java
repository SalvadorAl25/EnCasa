package Odiceo;

import EDI.Datos;

public class Flotante
{
	public static void main(String[] args)
	{
		String val, E1 = "0123456789", E2 = "123456789", E3 = "eE+-";

		char fl[];
		boolean ban = false, bans = false, bane = false;
		int con = 0, punto = 0, es = 0, e = 0, sig = 0;
		Datos obd = new Datos();

		System.out.println("-----------------Validacion de Valor Flotante-------------------");
		System.out.println();

		do
			val = obd.Cadena("Valor a validar");
		while (val == null);
		fl = val.toCharArray();

		for (int ind = 0; ind < fl.length; ind++)
		{
			if (fl[0] == '0') // caso 0.0
			{
				if (fl[1] == '.')
				{
					punto = 1;
					con = 1;
					if (fl[2] == '0')
					{
						if (fl.length > 3)
						{
							if (ind > 2)
								if (E1.indexOf(fl[ind]) >= 0)
								{
									if (fl.length > 4)
									{
										if (E2.indexOf(fl[ind]) >= 0)
											ban = true;
									}
									else
										ban = true;
								}
						}
						else
							ban = true;
					}
					else
						if (E2.indexOf(fl[ind]) >= 0 || E3.indexOf(fl[ind]) >= 0)
							ban = true;
				}
			}
			if (E2.indexOf(fl[0]) >= 0) // caso del 1...9
			{
				if (con == 0)
				{
					if (E2.indexOf(fl[ind]) >= 0)
						ban = true;
					else
						if (fl[ind] == '.')
						{
							con++;
							if (con == 1)
								punto = ind;
						}
				}
				else
				{
					if (fl[ind] == '.')
						con++;
					if (E1.indexOf(fl[ind]) >= 0 || E3.indexOf(fl[ind]) >= 0)
						if (bans == false)
							ban = true;
					if (ind == fl.length)
						if (E2.indexOf(fl[ind]) >= 0)
							ban = true;
				}
			}
			if (fl[0] == '-') // caso del - 1...9
			{
				if (ind >= 1)
					if (E2.indexOf(fl[ind]) >= 0)
						ban = true;
					else
					{
						if (fl[ind] == '.')
						{
							con++;
							if (con == 1)
								punto = ind;
						}
						if (ind > punto + 1)
						{
							if (E1.indexOf(fl[ind]) >= 0 || E3.indexOf(fl[ind]) >= 0)
								ban = true;
						}
						if (ind == fl.length)
							if (E2.indexOf(fl[ind]) >= 0)
								ban = true;
					}
			}

			if (ind > punto) // busqueda de E's y simbolos +-
			{
				if (fl[ind] == 'E' || fl[ind] == 'e')
				{
					es++;
					bane = true;
					if (es == 1)
					{
						e = ind;
						if (fl[ind - 1] == '.')
							ban = false;
					}
				}
				if (fl[ind] == '+' || fl[ind] == '-')
				{
					sig++;
					if (sig == 1)
						ban = true;
					else
						ban = false;
				}
				if (ind == fl.length)
					if (E3.indexOf(fl[ind]) >= 0)
						ban = false;
				if (bane == false && ind > punto && ind < fl.length && punto != 0)

				{
					if (fl[ind] == '+' || fl[ind] == '-')
					{
						ban = false;
						bans = true;
					}
				}
				else
					if (bane == true && ind > punto && ind < e && punto != 0)
					{
						ban = false;
						bans = true;
					}
			}
			if (es >= 2 || sig >= 2 || con >= 2 || con == 0)
				ban = false;

		}

		if (ban == false)
		{
			System.out.println();
			System.out.println("Valor flotante, ¡Incorrecto!");
		}
		if (ban == true)
		{
			System.out.println();
			System.out.println("Valor flotante, ¡Correcto!");
		}
	}
}