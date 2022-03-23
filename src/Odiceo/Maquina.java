package Odiceo;

import java.util.Stack;

import EDI.Datos;

public class Maquina
{
	Stack<Character> pila = new Stack<Character>();
	private Datos obd = new Datos();
	private int ren = 0, col = 0, x, y;
	private char caf[], a012, acc[];
	private String cad, inst, q, tab[][] = { { "--", "z,a", "a,a", "a,b", "b,b", "b,c", "c,c", "c,$" },
			{ "0", "0,0", "0,0", "1,0", null, null, null, null }, { "1", null, null, null, "1,0", "2,0", null, null },
			{ "2", null, null, null, null, null, "2,1", "3,1" } };

	public void Inicio()
	{
		q = "0";
		do
			cad = obd.Cadena("Ingrese cadena con caracteres [abc]: ").toLowerCase();
		while (!cad.matches("[abc]*"));
		cad = "z" + cad + "$";
		this.Proceso();
	}

	public void Proceso()
	{
		caf = cad.toCharArray();
		for (int ind = 0; ind < caf.length; ind++)
		{
			/*
			 * if (cad.indexOf("z", ind) == 0) pila.push('z');
			 * if(cad.indexOf("$",ind)==0) pila.push('$');
			 */
			if (ind > 0 && caf[ind] != '$')
			{
				inst = caf[ind] + "," + caf[ind + 1];

				for (col = 0; col < tab[0].length; col++)
					if (inst.equals(tab[0][col]))
						y = col;

				for (ren = 0; ren < tab.length; ren++)
					if (q.equals(tab[ren][0]))
						x = ren;

				acc = tab[x][y].toCharArray(); // accion en la tabla "-,-"
				q = "" + acc[0];
				a012 = acc[2];

				// Accion
				switch (a012) {
					case '0':
						pila.push(caf[ind]);
						break;
					case '1':
						pila.pop();
				}
			}
		}
		this.Resultado();
	}

	public void Resultado()
	{
		if (q.equals("3"))
		{
			System.out.println();
			System.out.println("-------------------------------------------------------");
			System.out.println("--------------------¡Cadena Valida!--------------------");
			System.out.println("-------------------------------------------------------");
			System.out.println();
		}
		else
		{
			System.out.println();
			System.out.println("-------------------------------------------------------");
			System.out.println("------------------¡Cadena Invalida!--------------------");
			System.out.println("-------------------------------------------------------");
			System.out.println();
		}
		this.Inicio();
	}

	public static void main(String[] args)
	{
		Maquina obt = new Maquina();
		obt.Inicio();
	}
}
