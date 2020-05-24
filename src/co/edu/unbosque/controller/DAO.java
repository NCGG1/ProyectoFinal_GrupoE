package co.edu.unbosque.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.Usuario;

public class DAO {
	public DAO() {
		Usuario xd = new Usuario();
		 EntityManagerFactory emf =
		 Persistence.createEntityManagerFactory("Proyecto Final");
		 EntityManager em = emf.createEntityManager();
		 try {
			 xd.setCedula("1020036532");
			 xd.setNombre("Juan David");
			 xd.setApellido("Flórez Godoy");
			 xd.setDepartamento("Bogotá DC");
			 xd.setCiudad("Bogotá");
			 xd.setDireccion("Calle 152 No. 54-39");
		Usuario us	= em.find(Usuario.class, "1000036533");
		 em.getTransaction().begin();
		 em.persist(us);
		 em.getTransaction().commit();
		 } catch (Exception e) {
		 System.out.println("Error "+e.getMessage());
		 } finally {
		 em.close();
		 }
	}
}
