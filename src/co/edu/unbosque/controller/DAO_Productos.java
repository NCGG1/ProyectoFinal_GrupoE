package co.edu.unbosque.controller;

import java.util.List;

import javax.swing.ImageIcon;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import co.edu.unbosque.model.Producto;

public class DAO_Productos {
	SessionFactory factory;
	Session session;
	List<Producto> lista;
	public DAO_Productos() {
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
		.addAnnotatedClass(Producto.class)
		.buildSessionFactory();

		session = factory.getCurrentSession();
	}
	
	public void commit() {
		session.getTransaction().commit();
	}
	
	public void cerrarSesion() {
		factory.close();
	}
	
	public void agregar(String nombre, String categoria, String descripcion, double precio, int unidades) {
			session.beginTransaction();
			Producto us = new Producto(nombre, categoria, descripcion, precio, unidades);	
			session.save(us);
			commit();
	}
	// Si se agrega un usuario con la misma llave, lo reemplaza.
	public void agregar_o_actualizar(String nombre, String categoria, String descripcion, double precio, int unidades) {
			session.beginTransaction();
			Producto us = new Producto(nombre, categoria, descripcion, precio, unidades);	
			session.saveOrUpdate(us);
			commit();
	}
	
	public void agregar_imagen(String llave, String ruta) {
		session.beginTransaction();
		ImageIcon img = new ImageIcon(ruta);
		Producto prod = buscar(llave);
		prod.setImagen(img);
		session.saveOrUpdate(prod);
		commit();
	}
	
	public void eliminar(String llave) {
		session.beginTransaction();
		Producto buscar=session.get(Producto.class, llave);
		buscar=session.get(Producto.class, llave);
		session.delete(buscar);
		lista= session.createQuery("from Producto").list();
		mostrarLista(lista);
		commit();
	}
	
	public Producto buscar(String llave) {
		session.beginTransaction();
		Producto usuario=session.get(Producto.class, llave);
		lista= session.createQuery("from Producto").list();
		mostrarLista(lista);
		return usuario;
	}
	
	public List<Producto> leer(String variable, String filtro) {
		session.beginTransaction();
		lista= session.createQuery("from Producto").list();
		mostrarLista(lista);
		lista= session.createQuery("from Producto p where p.'"+variable+"'='"+filtro+"'").list();
		mostrarLista(lista);
		session.getTransaction().commit();
		return lista;
	}

	
	
	private static void mostrarLista(List<Producto> lista) {
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
	}
}

