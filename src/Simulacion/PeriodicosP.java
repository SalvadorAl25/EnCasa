package Simulacion;

import EDI.*;

public class PeriodicosP
{
	public static void main(String[] args)
	{
		int op, pe=-1, dia;
		Menu obm=new Menu("Simulacion de Periodicos", new String[]{"70","80","90","Otra Cantidad"});
		Periodicos obp[]=null;
		Datos obd=new Datos();
		
		do
			switch(op=obm.Opcion())
			{
				case 1:
					pe=70;
					do
						dia=obd.Entero("Dias");
					while(dia<=1);
					obp=new Periodicos[dia];
					dia=-1;
					if(obp!=null)
						System.out.println("Dia"+"\t"+"Dig. Aleat/Tip De Dia"+"\t"+"Tipo De Dia"+"\t"+"Dig. Aleat/Demanda"+"\t"+"Demanda"+"\t\t"+"Ingreso por venta"+"\t"+"Perd. Benef. Exceso Demanda"+"\t"+"Resc. Venta de Desecho"+"\t\t"+"Ganancia Diaria");
						for (dia = 0; dia < obp.length; dia++)
						{
							obp[dia]=new Periodicos();
							obp[dia].Lectura(pe, dia+1);
							obp[dia].Mostrar();
						}
					break;
				case 2:
					pe=80;
					do
						dia=obd.Entero("Dias");
					while(dia<=1);
					obp=new Periodicos[dia];
					dia=-1;
					if(obp!=null)
						System.out.println("Dia"+"\t"+"Dig. Aleat/Tip De Dia"+"\t"+"Tipo De Dia"+"\t"+"Dig. Aleat/Demanda"+"\t"+"Demanda"+"\t\t"+"Ingreso por venta"+"\t"+"Perd. Benef. Exceso Demanda"+"\t"+"Resc. Venta de Desecho"+"\t\t"+"Ganancia Diaria");
						for (dia = 0; dia < obp.length; dia++)
						{
							obp[dia]=new Periodicos();
							obp[dia].Lectura(pe, dia+1);
							obp[dia].Mostrar();
						}
					break;
				case 3:
					pe=90;
					do
						dia=obd.Entero("Dias");
					while(dia<=1);
					obp=new Periodicos[dia];
					dia=-1;
					if(obp!=null)
						System.out.println("Dia"+"\t"+"Dig. Aleat/Tip De Dia"+"\t"+"Tipo De Dia"+"\t"+"Dig. Aleat/Demanda"+"\t"+"Demanda"+"\t\t"+"Ingreso por venta"+"\t"+"Perd. Benef. Exceso Demanda"+"\t"+"Resc. Venta de Desecho"+"\t\t"+"Ganancia Diaria");
						for (dia = 0; dia < obp.length; dia++)
						{
							obp[dia]=new Periodicos();
							obp[dia].Lectura(pe, dia+1);
							obp[dia].Mostrar();
						}
					break;
				case 4:
					do
						pe=obd.Entero("Periodicos Comprados: ");
					while(pe<1);
					do
						dia=obd.Entero("Dias");
					while(dia<=1);
					obp=new Periodicos[dia];
					dia=-1;
					if(obp!=null)
						System.out.println("Dia"+"\t"+"Dig. Aleat/Tip De Dia"+"\t"+"Tipo De Dia"+"\t"+"Dig. Aleat/Demanda"+"\t"+"Demanda"+"\t\t"+"Ingreso por venta"+"\t"+"Perd. Benef. Exceso Demanda"+"\t"+"Resc. Venta de Desecho"+"\t\t"+"Ganancia Diaria");
						for (dia = 0; dia < obp.length; dia++)
						{
							obp[dia]=new Periodicos();
							obp[dia].Lectura(pe, dia+1);
							obp[dia].Mostrar();
						}
			}
		while(op!=obm.Salir());
	}
}
