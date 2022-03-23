package Simulacion;

import EDI.*;

public class MenuPseudoAleatorios
{
	public static void main(String[] args)
	{
		System.out.println("Tres metodos");
		PseudoAleatorios obp = new PseudoAleatorios();
		Menu obm=new Menu("PseudoAleatorios", new String[]{"Cuadrados Medios","Productos Medios", "Producto por factor"});
		int op; 
		do
			switch (op=obm.Opcion())
			{
				case 1:
					obp.Leer1();
					obp.Producto1();
					break;
				case 2:
					obp.Leer();
					obp.Producto();
					break;
				case 3:
					obp.Leer2();
					obp.Producto2();
			}
		while(op!=obm.Salir());
	}
}
