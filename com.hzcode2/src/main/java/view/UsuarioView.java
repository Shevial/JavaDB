package view;
import java.util.Scanner;
import controllers.UsuarioController;

public class UsuarioView {

	public static void main(String[] args) {


		Scanner lector = new Scanner (System.in);


		System.out.println("User introduce one opción");
		System.out.println("1 --- Create usuario");
		System.out.println("2 --- Delete usuario");
		System.out.println("3 --- View usuario");

		int menu = lector.nextInt();
		lector.nextLine(); //limpia buffer

		switch (menu) {
			case 1:
				System.out.println("Introduce name");
				String name = lector.nextLine();

				System.out.println("Introduce surname");
				String surname = lector.nextLine();

				System.out.println("Introduce City");
				String city = lector.nextLine();

				String usuario = new UsuarioController().createUsuario(name, surname, city);
			case 2:
				System.out.println("Delete usuario");
				System.out.println("Introduce ID para borrar");
				int opcion = lector.nextInt();
				if (opcion != null) {
					System.out.println("Borrando usuario con Id " + opcion);
					String usuario = new UsuarioController().deleteUsuario(4);
				}
				else {
					System.out.println("El usuario con Id" + opcion + " no existe");
				}
			case 3:
				System.out.println("Delete usuario");


		}






		//String usuario = new UsuarioController().updateUsuario(1, "Rodrigo", "Díaz", "Guadalajara");
		String usuario = new UsuarioController().getUsuario(1);
		System.out.println(usuario);

	}

}
