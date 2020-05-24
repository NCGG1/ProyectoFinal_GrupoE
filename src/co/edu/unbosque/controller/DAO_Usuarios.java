package co.edu.unbosque.controller;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import co.edu.unbosque.model.Usuario;

public class DAO_Usuarios {
	SessionFactory factory;
	Session session;
	List<Usuario> lista;
	/** Crear SessionFactory*/
	DAO_Usuarios(){
		
	try {
		iniciarSesion();

	}
	catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

	public void iniciarSesion() {
		factory = new Configuration()
		.configure()
		.addAnnotatedClass(Usuario.class)
		.buildSessionFactory();

		session = factory.getCurrentSession();
	}
	
	public void commit() {
		session.getTransaction().commit();
	}
	
	public void cerrarSesion() {
		factory.close();
	}
	
	public void agregar(String nombre, String apellido, String cedula, String correo, String departamento, String ciudad,
			String direccion) {
		session.beginTransaction();
			Usuario us = new Usuario( nombre,  apellido,  cedula,  correo,  departamento,  ciudad, direccion);	
			session.save(us);
			commit();
	}
	
	public void agregar(Usuario us) {
			session.beginTransaction();
			session.save(us);
			commit();
	}
	// Si se agrega un usuario con la misma llave, lo reemplaza.
	public void agregar_o_actualizar(String nombre, String apellido, String cedula, String correo, String departamento, String ciudad,
			String direccion) {
			session.beginTransaction();
			Usuario us = new Usuario( nombre,  apellido,  cedula,  correo,  departamento,  ciudad, direccion);	
			session.saveOrUpdate(us);
			commit();
	}
	
	public void eliminar(String llave) {
		session.beginTransaction();
		Usuario buscar=session.get(Usuario.class, llave);
		buscar=session.get(Usuario.class, llave);
		session.delete(buscar);
		lista= session.createQuery("from Usuario").list();
		mostrarLista(lista);
		commit();
	}
	
	public Usuario buscar(String llave) {
		session.beginTransaction();
		Usuario usuario=session.get(Usuario.class, llave);
		lista= session.createQuery("from Usuario").list();
		mostrarLista(lista);
		return usuario;
	}
	// FIltra de la lista de usuarios a partir de una variable y la entrada.
	public List<Usuario> leer(String variable, String filtro) {
		session.beginTransaction();
		lista= session.createQuery("from Usuario").list();
		mostrarLista(lista);
		lista= session.createQuery("from Usuario p where p.'"+variable+"'='"+filtro+"'").list();
		mostrarLista(lista);
		session.getTransaction().commit();
		return lista;
	}

	
	
	private static void mostrarLista(List<Usuario> lista) {
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
	}

}
