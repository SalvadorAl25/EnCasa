package Odiceo;

import java.util.Stack;
import EDI.Datos;

public class sintactico
{
	Datos obd = new Datos();
	String tab[][] = new String[19][33], comp, tran, ord, a[];
	int ren, col, x, y, ind;
	Stack<String> error = new Stack<String>();
	Stack<String> pila = new Stack<String>();
	Stack<String> err2 = new Stack<String>();

	public sintactico(String comp) 
	{
		this.comp=comp; 
		pila.push(this.comp); 
	}

	public void Buscar()
	{
		String aux;
		tran = pila.peek();
		// componentes
		for (col = 0; col < tab[0].length; col++)
			if (comp.equals(tab[0][col]))
				y = col;
		// transiciones
		for (ren = 0; ren < tab.length; ren++)
			if (tran.equals(tab[ren][0]))
				x = ren;
		ord = tab[x][y];
		if (ord.substring(0, 5).equals("Error"))
			this.ApilarErrores(ord);
		else
		{
			this.Apilar();
			aux = pila.peek();
			if (!Determinista(aux))
				this.Buscar();
			else
				if (aux.equals("€"))
					pila.pop();
		}
	}

	public void ApilarErrores(String ord)
	{
		err2.push(ord);
	}

	private void Apilar()
	{
		pila.pop();
		a = ord.split(" ");
		for (ind = a.length; ind != -1; ind--)
		{
			pila.push(a[ind]);
		}
	}

	public void Switch()
	{
		if (Determinista(comp))
		{
			if (pila.peek().equals(comp))
				pila.pop();
			else
				error.push(pila.pop());
		}
		else
			if (comp.equals("if") || comp.equals("else") || comp.equals("do") || comp.equals("while")
					|| comp.equals("mientras"))
			{
				this.Buscar();
				pila.pop();
			}
			else
				this.Buscar();
	}

	@SuppressWarnings("unused")
	private boolean Determinista(String com)
	{
		String det[] =
		{ "programa", ",", "id", "cadena", "entero", "flotante", "boolean", "inicio", ";", "=", "num", "(", ")", "<",
				">", "&", "<=", ">=", "!=", "==", "|", "!", "fin", "*", "+", "-", "€", "literal", "car", "true",
				"false", "/", "sinc" };
		for (int i = 0; i < det.length; i++)
		{
			if (det[i].equals(com))
				return true;
			else
				return false;
		}
		return false;
	}

	public void Errores()
	{
		int errnum;
		String err[] =
		{ "Error Sintactico", "¡Error! tipo de dato incorrecto" }, erre;
		while (!err2.empty())
		{
			erre = err2.pop().substring(6, 8);
			errnum = Integer.parseInt(erre);
			System.out.println(err[errnum]);
		}
		this.ErroresFaltantes();
	}

	private void ErroresFaltantes()
	{
		Stack<String> aux = new Stack<String>();
		String err;
		while (!error.empty())
		{
			err = error.pop();
			System.err.println("¡Error! Falta elemento: " + err);
			aux.push(err);
		}
		while (!aux.empty())
			error.push(aux.pop());
	}

	public void Verificar()
	{
		if(pila.peek().equals("$"))
		{
			System.out.println("Automata Finalizado");
			this.Errores();
		}
	}
}
