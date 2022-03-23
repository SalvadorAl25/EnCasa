package Odiceo;

import EDI.Datos;

public class ValiFlotante
{
	public static void main(String[] args)
	{
		String val, err = "", vali = "1234567890.eE-+", val2 = "1234567890eE-+", val3 = "1234567890",
				val9 = "123456789";

		char fl[];
		boolean ban = false, bane = false;
		int con = 0, r = 0, punto = 0, es = 0, e = 0, sig = 0;
		Datos obd = new Datos();

		System.out.println("-----------------Validacion de Valor Flotante-------------------");

		do
			val = obd.Cadena("Valor a validar");
		while (val == null);
		fl = val.toCharArray();

		for (int ind = 0; ind < fl.length; ind++) // valida puntos y caracteres validos
		{
			if (vali.indexOf(fl[ind]) == -1)
			{
				err += "'" + fl[ind] + "' ";
			}

			if (fl[ind] == '.')
			{
				con++;
				if (con == 1)
					punto = ind;
			}
			r++;
		}

		if (val3.indexOf(fl[punto + 1]) >= 0) /// valida caracteres validos despues de un punto
			ban = true;

		for (int ind = 0; ind < fl.length; ind++) // valida E's y Simbolos +-
		{
			if (ind < punto)
			{
				if (fl[ind] == 'e' || fl[ind] == 'E')
				{
					e++;
					if (e == 1)
						ban = true;
					else
						ban = false;
				}
			}
			if (ind > punto)
			{
				if (val2.indexOf(fl[ind]) >= 0)
					if (fl[ind] == 'e' || fl[ind] == 'E')
					{
						es++;
						if (es == 1)
						{
							if (fl[ind - 1] == '.')
								ban = false;
							else
								if (fl[ind + 1] == 'e' || fl[ind] == 'E')
								{
									bane = true;
									ban = false;
								}
						}
					}
				if (bane == false)
					if (fl[ind] == '-' || fl[ind] == '+')
					{
						sig++;
						if (sig == 1)
							ban = true;
						else
							ban = false;
					} else
						bane = false;
			}
		}
		if (con == 1) // valida 0's
			if (fl[0] == '0' && fl[1] == '.')
				for (int ind = 0; ind < fl.length; ind++)
				{
					// 0.000
					if (ind == punto + 2)
					{
						if (val3.indexOf(fl[ind]) == -1)
							ban = false;
					}
					if (ind == punto + 3)
						if (val9.indexOf(fl[ind]) == -1)
							ban = true;
						else
							ban = false;
				}
			else
				if (fl[0] == '-' && fl[1] == '0' && fl[2] == '.')
					ban = false;

		if (err.length() > 0)
		{
			System.out.println();
			System.out.println("Caracteres Erroneos: " + err);
		}
		if (ban == false)
		{
			System.out.println();
			System.out.println("Valor flotante, ¡Incorrecto!");
		}
		if (con == 1 && fl[r - 1] != '.' && ban == true)
		{
			System.out.println();
			System.out.println("Valor flotante, ¡Correcto!");
		}
		if (fl[r - 1] == '.')
		{
			System.out.println();
			System.out.println("No hay valor despues del punto, valor incorrecto");
		}
		if (con >= 2 || con == 0)
		{
			System.out.println();
			System.out.println("tiene " + con + " puntos, valor invalido");
		}
	}
}
