package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import models.Usuario;

public class UsuarioController {

	private static SessionFactory sessionFactory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Usuario.class)
			.buildSessionFactory();

	// Método para crear un usuario
	public String createUsuario(String nombre, String apellido, String direccion) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Usuario usuario = new Usuario(nombre, apellido, direccion);
			session.save(usuario);

			session.getTransaction().commit();
			return "Usuario creado";
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();  // Si ocurre un error, deshacer la transacción
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();  // Cerrar la sesión al finalizar
			}
		}
		return "Error al crear usuario";
	}

	// Método para eliminar un usuario
	public String deleteUsuario(int id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Usuario usuario = session.get(Usuario.class, id);
			if (usuario != null) {
				session.delete(usuario);
				session.getTransaction().commit();
				return "Usuario borrado correctamente";
			} else {
				return "Usuario no existe";
			}
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return "Error al borrar usuario";
	}

	// Método para actualizar un usuario
	public String updateUsuario(int id, String nombre, String apellido, String direccion) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Usuario usuario = session.get(Usuario.class, id);
			if (usuario != null) {
				usuario.setNombre(nombre);
				usuario.setApellido(apellido);
				usuario.setDireccion(direccion);
				session.update(usuario);
				session.getTransaction().commit();
				return "Usuario actualizado correctamente";
			} else {
				return "Usuario no encontrado";
			}
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return "Error al actualizar usuario";
	}

	// Método para obtener un usuario
	public String getUsuario(int id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Usuario usuario = session.get(Usuario.class, id);
			if (usuario != null) {
				session.getTransaction().commit();
				return usuario.toString();
			} else {
				return "El usuario no existe";
			}
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return "Error al obtener usuario";
	}

	// Cerrar el SessionFactory cuando la aplicación finaliza
	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
