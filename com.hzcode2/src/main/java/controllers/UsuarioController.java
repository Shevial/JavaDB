package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Usuario;

public class UsuarioController {
	public String createUsuario(String nombre, String apellido, String direccion){
		
		SessionFactory sessionFactory=new
		Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();	
		
		Session session=sessionFactory.openSession();
		
		try {
			
			Usuario usuario = new Usuario(nombre, apellido, direccion);
			session.beginTransaction();
			session.save(usuario);
			
			session.getTransaction().commit();
			sessionFactory.close();			
			return "Usuario creado";
			
		}catch(Exception e) {
			e.printStackTrace();
			
	}
		return "Error al crear usuario";
	}
public String deleteUsuario(int id){
		
		SessionFactory sessionFactory=new
		Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();	
		
		Session session=sessionFactory.openSession();
		
		try {
			
			
			session.beginTransaction();
			
			Usuario usuario=session.get(Usuario.class, id);
			
			session.delete(usuario);
			
			session.getTransaction().commit();
			sessionFactory.close();			
			return "Usuario borrado correctamente";
			
		}catch(Exception e) {
			e.printStackTrace();
			
	}
		return "Usuario no existe";
	}
public String updateUsuario(int id, String nombre, String apellido, String direccion){
	
	SessionFactory sessionFactory=new
	Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();	
	
	Session session=sessionFactory.openSession();
	
	try {
		
		
		session.beginTransaction();
		
		Usuario usuario=session.get(Usuario.class, id);
		
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setDireccion(direccion);
		
		session.update(usuario);
		
		session.getTransaction().commit();
		sessionFactory.close();			
		return "Usuario actualizado correctamente";
		
	}catch(Exception e) {
		e.printStackTrace();
		
}
	return "Error al actualizar usuario";
}
public String getUsuario(int id){
	
	SessionFactory sessionFactory=new
	Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();	
	
	Session session=sessionFactory.openSession();
	
	try {
		
		
		session.beginTransaction();
		
		Usuario usuario=session.get(Usuario.class, id);
		
				
		
		session.getTransaction().commit();
		sessionFactory.close();			
		return usuario.toString();
		
	}catch(Exception e) {
		e.printStackTrace();
		
}
	return "El usuario no existe";
}





}
