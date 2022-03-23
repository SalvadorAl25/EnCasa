import EDI.Datos;
import java.util.regex.*;

public class Uniones
{
	public static void main(String[] args)
	{
		Datos obd = new Datos();
		String cad;
		int ind;
		boolean ban = true;
		cad = obd.Cadena("Exprecion Regular a validar").toLowerCase();
		char ca[] = cad.toCharArray();

		do
		{
			Pattern p = Pattern.compile("[^a-z)(*+ ]+");
			Matcher m = p.matcher(cad);
			StringBuffer sb = new StringBuffer();
			boolean resultado = m.find();
			boolean caracteresIlegales = false;

			while (resultado)
			{
				caracteresIlegales = true;
				m.appendReplacement(sb, "");
				resultado = m.find();
			}

			if (caracteresIlegales)
			{
				System.err.println("La Expresion no contine Caracteres del alfabeto");
				ban = false;
				break;
			}

			p = Pattern.compile("uu");
			m = p.matcher(cad);
			if (m.find())
			{
				System.err.println("No puede haber uu");
				ban = false;
				break;
			}
		}
		while (!ban);

		if (ban)
		{
			int con = 0;
			for (ind = 0; ind < ca.length; ind++)
			{
				if (ca[ind] == '(')
					con++;
				if (ca[ind] == ')')
					con--;
				do
					switch (ca[ind]) {
						case '(':
							if (ca[ind + 1] == '*' || ca[ind + 1] == '+' || ca[ind + 1] == 'u' || ca[ind + 1] == ')')
							{
								System.err.println(
										"Despues del ' ( ' no puede haber un simbolo, otro ' ) ' junto o caracter diferente al del alfabeto o al operando...");
								ban = false;
							}
							break;
						case ')':
							if (ca[ind - 1] == 'u')
							{
								System.err.println(
										"antes del ) no puede haber caracter diferente al del alfabeto, a los exponentes o al operando...");
								ban = false;
							}
							break;
						case 'u':
							if (ca[ind + 1] == '+' || ca[ind + 1] == '*')
							{
								System.err.println("no puede haber exponentes en un operador");
								ban = false;
							}
							break;
						case '*':
							if (ca[ind] <= cad.length())
							{
								if (ca[ind + 1] == '*' || ca[ind + 1] == '+')
								{
									System.err.println("los caracteres exactamente **, o *+ son incorrectos");
									ban = false;
								}
							}
							else if (ca[ind - 1] == '*' || ca[ind - 1] == '+')
							{
								System.err.println("los caracteres exactamente **, o *+ son incorrectos");
								ban = false;
							}
							break;
						case '+':
							if (ca[ind] <= cad.length())
							{
								if (ca[ind + 1] == '+' || ca[ind + 1] == '*')
								{
									System.err.println("los caracteres exactamente ++, o +* son incorrectos");
									ban = false;
								}
							}
							else if (ca[ind - 1] == '+' || ca[ind - 1] == '*')
							{
								System.err.println("los caracteres exactamente **, o *+ son incorrectos");
								ban = false;
							}
							break;
					}
				while (!ban);
			}
			if (con == 0)
				if (cad.length() >=0 )
				{
					System.out.println("Cadena Correcta");
				}
				else
					System.err.println("Cadena Vacia...");
		}
	}
}