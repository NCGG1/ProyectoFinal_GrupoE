package co.edu.unbosque.controller;

import java.util.ArrayList;

import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.Producto;
import co.edu.unbosque.model.Usuario;

public class Controller {
//	private DAO dao;
	private DAO_Usuarios orm;
	public Controller() {
//		dao = new DAO();
		orm = new DAO_Usuarios();
		ArrayList<Producto> compras;
		Usuario c = new Usuario("xd", "xd", "777", "xd", "xd", "xdxd", "xd");
		orm.agregar(c);
		
	}
}
