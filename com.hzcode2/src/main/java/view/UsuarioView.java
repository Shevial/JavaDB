package view;

import controllers.UsuarioController;

public class UsuarioView {

	public static void main(String[] args) {
		
		//String usuario = new UsuarioController().createUsuario("Luisa","Lebrel","Sevilla");
		//String usuario = new UsuarioController().deleteUsuario(4);
		
		//String usuario = new UsuarioController().updateUsuario(1, "Rodrigo", "Díaz", "Guadalajara");
		String usuario = new UsuarioController().getUsuario(1);
		System.out.println(usuario);

	}

}
