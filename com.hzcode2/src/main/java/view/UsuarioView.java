package view;
import java.util.Scanner;
import controllers.UsuarioController;

public class UsuarioView {

	public static void main(String[] args) {


		Scanner lector = new Scanner (System.in);


		System.out.println("User introduce one opción");
		System.out.println("1 --- Create usuario");
		System.out.println("2 --- Delete usuario");
		System.out.println("3 --- Edit usuario");
		System.out.println("4 --- Retrieve users");


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
				System.out.println("Delete user");
				System.out.println("Introduce ID for deleting a user");
				int opcion = lector.nextInt();
				if (opcion != null) {
					System.out.println("Deleting user with Id " + opcion);
					String usuario = new UsuarioController().deleteUsuario(4);
				}
				else {
					System.out.println("El usuario con Id" + opcion + " no existe");
				}
			case 3:
				System.out.println("Edit user");
				System.out.println("Introduce ID for editing a user");
				int id = lector.nextInt();
				System.out.println("Editing user with Id " + id);
				System.out.println("Introduce new name");
				String name = lector.nextLine();

				System.out.println("Introduce new surname");
				String surname = lector.nextLine();

				System.out.println("Introduce new City");
				String city = lector.nextLine();

				System.out.println("Editing user with Id " + id + "New name is " + name + " New surname is " + surname + " New city is " + city);
				String usuario = new UsuarioController().updateUsuario(id, name, surname, city);

			case 4:
				System.out.println("Retrieve  user");
				System.out.println("Introduce ID for retrieving a user");
				int opcion = lector.nextLine();
				System.out.println("Retrieving  user with Id " + opcion);
				String usuario = new UsuarioController().getUsuario(opcion);
				System.out.println(usuario);



		}








	}

}
