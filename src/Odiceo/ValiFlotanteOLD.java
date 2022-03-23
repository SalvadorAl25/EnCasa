package Odiceo;

import EDI.Datos;

public class ValiFlotanteOLD
{
	public static void main(String[] args)
	{
		String val, err = "", vali = "1234567890.";

		char fl[];
		int con = 0, r = 0;
		Datos obd = new Datos();

		System.out.println("-----------------Validacion de Valor Flotante-------------------");

		do
			val = obd.Cadena("Valor a validar");
		while (val == null);
		fl = val.toCharArray();

		for (int ind = 0; ind < fl.length; ind++)
		{
			if (vali.indexOf(fl[ind]) == -1)
			{
				err += "'" + fl[ind] + "' ";
			}

			if (fl[ind] == '.')
				con++;
			r++;
		}
		if (err.length() > 0)
		{
			System.out.println();
			System.out.println("Caracteres Erroneos: " + err);
		}
		if (con == 1 && fl[r - 1] != '.')
		{
			System.out.println();
			System.out.println("Valor flotante, ¡Correcto!");
		}
		if(fl[r - 1] == '.')
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
