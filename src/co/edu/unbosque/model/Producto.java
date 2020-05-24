package co.edu.unbosque.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.ImageIcon;

@Entity
@Table(name="Producto")
public class Producto implements Serializable{


private String nombre;
private String categoria;
private String descripcion;
private double precio;
private int unidades;
private ImageIcon imagen;

private static final long serialVersionUID = 1L;

public Producto() {
	
}

public Producto(String nombre, String categoria, String descripcion, double precio, int unidades) {
	super();
	this.nombre = nombre;
	this.categoria = categoria;
	this.descripcion = descripcion;
	this.precio = precio;
	this.unidades = unidades;
}
@Id
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public ImageIcon getImagen() {
	return imagen;
}
public void setImagen(ImageIcon imagen) {
	this.imagen = imagen;
}
public String getCategoria() {
	return categoria;
}
public void setCategoria(String categoria) {
	this.categoria = categoria;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public double getPrecio() {
	return precio;
}
public void setPrecio(double precio) {
	this.precio = precio;
}
public int getUnidades() {
	return unidades;
}
public void setUnidades(int unidades) {
	this.unidades = unidades;
}

}
