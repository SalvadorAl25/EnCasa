import java.io.*;

public class Estados
{
	private BufferedReader obb = new BufferedReader(new InputStreamReader(System.in));

	public String Leer(String msj)
	{
		String var = "";
		try
		{
			System.out.print(msj + " ");
			var = obb.readLine().trim();
		}
		catch (NumberFormatException e)
		{
			var = Leer(msj);
		}
		catch (IOException e)
		{
			System.out.println("Error en el Dispositivo de Entrada");
		}
		return var;
	}

	public int LeerInt(String msj)
	{
		int var = 0;
		try
		{
			do
			{
				System.out.print(msj + " ");
				var = Integer.parseInt(obb.readLine());
			}
			while (var < 0);
		}
		catch (NumberFormatException e)
		{
			var = LeerInt(msj);
		}
		catch (IOException e)
		{
			System.out.println("Error en el Dispositivo de Entrada");
		}
		return var;
	}
}
