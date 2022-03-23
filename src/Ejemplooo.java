
public class Ejemplooo
{
	public static void main(String[] Args)
	{
		String cadena = "ffeeddaa";
		System.out.println("Original: " + cadena);
		cadena = cadena.replaceAll("(.)\\1", "$1");
		System.out.println("Resultado: " + cadena);
		
		// Cadena sobre la que realizaremos la sustitución
		String cadena1 = "En un lugar de La Mancha";
		 
		// Cadena en la que almacenaremos el resultado
		String cadena2 = null;
		 
		cadena2 = cadena1.replaceAll("a", "e");
		 
		System.out.println(cadena2);
		// En un luger de Le Menche
		 
		cadena2 = cadena1.replaceAll("[a|u]", "e");
		System.out.println(cadena2);
		// En en leger de Le Menche
		 
		System.out.println(cadena1);
		// En un lugar de La Mancha
		/* Como vemos, el ejecutar el método
		replaceAll no afecta a la cadena original */
	}
}
