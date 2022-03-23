
public class Matriz
{
	int q = 0;
	String E = "", vec[][], e = "", linea = "";
	Estados obj = new Estados();

	public Matriz()
	{
		boolean ver = false;
		q = obj.LeerInt("Cuantas 'q' ahi en tu tabla: ");
		E = obj.Leer("Dame el alfabeto sin espacios: ");
		ordenado();
		LLenado();
		do
		{
			linea = obj.Leer("Dame la cadena a revizar: ");
			ver = Corregida(linea, vec);
		}
		while (ver != true);
	}

	private void ordenado()
	{
		int n = E.length() + 1, n1 = q + 1;
		vec = new String[n1][n];
		// System.out.println(n1+"\t"+n);
		vec[0][0] = " ";

		for (int x = 0; x < q; x++)
		{
			vec[x + 1][0] = "q" + x;
		}

		for (int y = 1; y < E.length() + 1; y++)
			vec[0][y] = E.substring(y - 1, y);
	}

	private boolean Corregida(String linea, String[][] vec2)
	{
		boolean c = false;
		int i = 0, n = 0, pos = 1;
		String cad = "", cad2 = "";
		System.out.println();
		do
		{
			cad = linea.substring(i, i + 1);
			if (cad.equals("a"))
				n = 1;
			else
				if (cad.equals("b"))
					n = 2;
				else
					if (cad.equals("c"))
						n = 3;
			cad2 = vec[pos][n];
			System.out.print(cad2 + " ");
			pos = Integer.parseInt(cad2.substring(1, 2));
			pos = pos + 1;
			i++;
			c = true;
		}
		while (i != linea.length());
		System.out.println();
		return c;
	}

	private void LLenado()
	{
		int x, y, z;
		for (x = 1; x < q + 1; x++)
		{
			for (y = 1; y < E.length() + 1; y++)
			{
				do
				{
					z = 0;
					do
						e = obj.Leer("Dame la posicion de " + x + "," + y + ": ");
					while (e.length() != 2);

					if (e.substring(0, 1).equals("q"))
					{
						z = z + 1;
					}
					if (Numero(e) != true)
					{
						z = z + 1;
						/* System.out.print("HolaAqui") */;
					}
				}
				while (z != 2);
				vec[x][y] = e;
			}
		}
	}

	private boolean Numero(String e)
	{
		String A = "1234567890", t = "";
		boolean num = false;
		t = e.substring(1, 2);
		for (int i = 0; i > A.length(); i++)
		{
			if (A.substring(i, i + 1).equals(t))
				num = true;
		}
		return num;
	}

	public void Mostrar()
	{
		for (int x = 0; x < q + 1; x++)
		{
			for (int y = 0; y < E.length() + 1; y++)
			{
				System.out.print(vec[x][y] + "\t");
			}
			System.out.println();
		}
	}
}
