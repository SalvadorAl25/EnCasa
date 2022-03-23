import java.util.LinkedList;
import java.util.Random;
import EDI.Datos;

public class Tarea1
{
	private int ind, a, c, x;
	private String nc, vec[], a2, c2;
	private char nuctrol[];
	private Datos obd = new Datos();

	public Tarea1()
	{
		do
			ind = obd.Entero("Tamaño del vector");
		while (ind < 1);
		vec = new String[ind];
		ind = 0;
	}

	public void Aleatorios()
	{
		Random obr = new Random();
		a = obr.nextInt(20);
		if (a < 10)
			a2 = "0" + a;
		else
			a2 = "" + a;
		c = obr.nextInt(901);
		if (c < 100)
			if (c < 10)
				c2 = "00" + c;
			else
				c2 = "0" + c;
		else
			c2 = "" + c;
		nc = "" + a2 + "420" + c2;
		this.Llenar();
	}

	public void Llenar()
	{

		String auxi = " ";
		if (!auxi.equals(nc))
		{
			auxi = nc;
			if (ind < vec.length)
			{
				vec[ind] = nc;
				System.out.println("" + vec[ind]);
				ind++;
			}
			if (ind == vec.length)
				this.Radix();
			else
				this.Aleatorios();
		}
	}

	public void Radix()
	{
		int j=0;
		@SuppressWarnings("unchecked")
		String numm="0123456789";
		
		
		
		LinkedList<String> lista[] = new LinkedList[10];
		for (ind = 0; ind < lista.length; ind++)
			lista[ind] = new LinkedList<String>();
		for(ind=0; ind<=vec.length; ind++)
		{
			nuctrol=vec[ind].toCharArray();
			for (int i = 0; i < nuctrol.length; i++)
			{
				if(numm.indexOf(nuctrol[i])>=0)
					j=numm.indexOf(nuctrol[i]);
			}
		}
		
		
		/*for (x = 0; x < lista.length; x++)
			while (!lista[x].isEmpty())
				vec[ind++] = lista[x].removeFirst();*/
	}
	
	/*private int Digitos()
	{
		int may = vec[0];
		for (ind = 1; ind < vec.length; ind++)
			if (vec[ind] > may)
				may = vec[ind];
		return (may + "").length();
	}*/

	public void Mostrar()
	{
		System.out.println("Contenido del arreglo...");
		for (ind = 0; ind < vec.length; ind++)
		{
			System.out.print(vec[ind] + "\t");
			if ((ind + 1) % 5 == 0) // es para ordenarlos en filas de 5 en 5
				System.out.println();
		}
	}

	public static void main(String[] args)
	{
		Tarea1 obt = new Tarea1();
		obt.Aleatorios();
	}
}
