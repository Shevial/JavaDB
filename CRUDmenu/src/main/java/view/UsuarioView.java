package view;
import java.util.Scanner;
import controllers.UsuarioController;
import models.Usuario;

public class UsuarioView {

	public static void main(String[] args) {


		Scanner lector = new Scanner (System.in);

		UsuarioController usuarioController = new UsuarioController(); // Única instancia


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

				String usuarioCreate = usuarioController.createUsuario(name, surname, city);
				System.out.println("User created with name " + name + " and surname " + surname + " and city " + city );

				break;
			case 2:
				System.out.println("Delete user");
				System.out.println("Introduce ID for deleting a user");
				int idEdit = lector.nextInt();
				lector.nextLine(); //limpia buffer

					System.out.println("Deleting user with Id " + idEdit);
					String usuarioDel = new UsuarioController().deleteUsuario(idEdit);

				break;
			case 3:

				System.out.println("Edit user");
				System.out.println("Introduce ID for editing a user");
				int idE = lector.nextInt();
				lector.nextLine(); //limpia buffer

				System.out.println("Editing user with Id " + idE);
				System.out.println("Introduce new name");
				String nameE = lector.nextLine();

				System.out.println("Introduce new surname");
				String surnameE = lector.nextLine();

				System.out.println("Introduce new City");
				String cityE = lector.nextLine();

				System.out.println("Editing user with Id " + idE + "New name is " + nameE + " New surname is " + surnameE + " New city is " + cityE);
				String usuarioEdit = usuarioController.updateUsuario(idE, nameE, surnameE, cityE);
				System.out.println("User updated: " + usuarioEdit);


				break;
			case 4:
				System.out.println("Retrieve  user");
				System.out.println("Introduce ID for retrieving a user");
				int idR = lector.nextInt();
				lector.nextLine(); //limpia buffer

				System.out.println("Retrieving  user with Id " + idR);
				String usuarioRetrieve = new UsuarioController().getUsuario(idR);
				System.out.println(usuarioRetrieve);

				break;

			default:
				System.out.println("Invalid option");
				break;

		}

		lector.close();








	}

}
