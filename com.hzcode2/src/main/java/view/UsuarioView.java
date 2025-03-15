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
		lector.nextLinr(); //limpia buffer

		switch (menu) {
			case 1:
				System.out.println("Introduce name");
				String name = lector.nextInt();

				System.out.println("Introduce surname");
				String surname = lector.nextInt();

				System.out.println("Introduce City");
				String city = lector.nextInt();




		}





		//String usuario = new UsuarioController().createUsuario("Luisa","Lebrel","Sevilla");
		//String usuario = new UsuarioController().deleteUsuario(4);
		
		//String usuario = new UsuarioController().updateUsuario(1, "Rodrigo", "Díaz", "Guadalajara");
		String usuario = new UsuarioController().getUsuario(1);
		System.out.println(usuario);

	}

}
