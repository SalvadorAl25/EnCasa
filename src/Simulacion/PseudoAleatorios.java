package Simulacion;

import EDI.Datos;
import java.util.*;

public class PseudoAleatorios
{
	private int sem1, sem2, iteraciones, fact;
	private boolean fac;
	private int prod, xn;
	double na;

	public void Leer()
	{
		Datos obd = new Datos();
		System.out.println("Productos Medios");
		do
		{
			sem1 = obd.Entero("Valor de la semilla 1 inicial: ");
		}
		while (sem1 < 1000 || sem1 > 9999);
		do
		{
			sem2 = obd.Entero("Valor de la semilla 2 inicial: ");
		}
		while (sem1 < 1000 || sem1 > 9999);
		do
		{
			iteraciones = obd.Entero("Numero de iteraciones: ");
		}
		while (iteraciones <= 0);
	}

	public void Producto()
	{
		String lado = "";
		String inter = "", cad = "";
		System.out.println("Numero\tSe1\tSe2\tProduc\tNumeros medios");
		System.out.println("-------------------------------------------------------");
		for (int i = 0; i < iteraciones; i++)
		{
			prod = sem1 * sem2;
			cad = String.valueOf(prod);
			cad = Integer.toString(prod);
			inter = cad.substring(2, 6);
			xn = Integer.parseInt(inter);
			na = xn / 10000.0;

			System.out.println((i + 1) + "\t" + sem1 + "\t" + sem2 + "\t" + prod + "\t" + xn + "\t" + lado);
			Random obr = new Random();
			if (xn < 1)
			{
				System.out.println("No se puede trabajar con 0's absolutos, se generará aleatoriamente Xn");
				xn = obr.nextInt(10000);
			}
			if (xn < 1000)
				xn = xn * 10;
			if (xn < 100)
				xn = xn * 100;
			if (xn < 10)
				xn = xn * 1000;
			sem1 = xn;
		}
		System.out.println("-------------------------------------------------------");
	}

	public void Leer1()
	{
		Datos obd = new Datos();
		System.out.println("Cuadrados Medios");
		do
		{
			sem1 = obd.Entero("Valor de la semilla 1 inicial: ");
		}
		while (sem1 < 1000 || sem1 > 9999);

		do
		{
			iteraciones = obd.Entero("Numero de iteraciones: ");
		}
		while (iteraciones <= 0);
	}

	public void Producto1()
	{
		String lado = "";
		String inter = "", cad = "";
		System.out.println("Numero\tSe1\tSe*2          \tNumeros medios");

		System.out.println("-------------------------------------------------------");
		for (int i = 0; i < iteraciones; i++)
		{
			prod = sem1 * sem1;
			cad = String.valueOf(prod);
			cad = Integer.toString(prod);
			inter = cad.substring(2, 6);
			xn = Integer.parseInt(inter);
			na = xn / 10000.0;

			System.out.println((i + 1) + "\t" + sem1 + "\t" + prod + "\t" + xn + "\t" + lado);
			Random obr = new Random();
			if (xn < 1)
			{
				System.out.println("No se puede trabajar con 0's absolutos, se generará aleatoriamente Xn");
				xn = obr.nextInt(10000);
			}
			if (xn < 1000)
				xn = xn * 10;
			if (xn < 100)
				xn = xn * 100;
			if (xn < 10)
				xn = xn * 1000;
			sem1 = xn;
		}
		System.out.println("-------------------------------------------------------");
	}

	public void Leer2()
	{
		Datos obd = new Datos();
		System.out.println("Producto por factor");
		do
		{
			sem1 = obd.Entero("Valor de la semilla 1 inicial: ");
		}
		while (sem1 < 1000 || sem1 > 9999);
		do
		{
			fact = obd.Entero("Valor del factor: ");
		}

		while (fac);

		do
		{
			iteraciones = obd.Entero("Numero de iteraciones: ");
		}
		while (iteraciones <= 0);
	}

	public void Producto2()
	{
		String lado = "";
		String inter = "", cad = "";
		System.out.println("Numero\tFctor\tSemi\tNumeros medios");

		System.out.println("-------------------------------------------------------");
		for (int i = 0; i < iteraciones; i++)
		{
			prod = sem1 * fact;
			cad = String.valueOf(prod);
			cad = Integer.toString(prod);
			inter = cad.substring(2, 6);
			xn = Integer.parseInt(inter);
			na = xn / 10000.0;

			System.out.println((i + 1) + "\t" + fact + "\t" + sem1 + "\t" + xn + "\t" + lado);
			Random obr = new Random();
			if (xn < 1)
			{
				System.out.println("No se puede trabajar con 0's absolutos, se generará aleatoriamente Xn");
				xn = obr.nextInt(10000);
			}
			if (xn < 1000)
				xn = xn * 10;
			if (xn < 100)
				xn = xn * 100;
			if (xn < 10)
				xn = xn * 1000;
			sem1 = xn;
		}
		System.out.println("-------------------------------------------------------");
	}
}