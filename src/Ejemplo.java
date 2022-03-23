import java.util.regex.*;

public class Ejemplo
{
	public static void main(String args[])
	{
		// compilamos el patron
		Pattern patron = Pattern.compile("a*b");
		// creamos el Matcher a partir del patron, la cadena como parametro
		Matcher encaja = patron.matcher("aabmanoloaabmanoloabmanolob");
		// invocamos el metodo replaceAll
		String resultado = encaja.replaceAll("-");
		System.out.println(resultado);
	}
}
