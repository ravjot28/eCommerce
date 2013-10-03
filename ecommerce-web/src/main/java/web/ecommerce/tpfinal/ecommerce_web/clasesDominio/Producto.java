package web.ecommerce.tpfinal.ecommerce_web.clasesDominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	@OneToOne
	private Fabricante fabricante;
	private float precio;
	
	public Producto(){
		
	}


	public Producto(String nombre, Fabricante fabricante, float precio, Long idProducto) {
		this.nombre = nombre;
		this.fabricante = fabricante;
		this.precio = precio;
		this.id = idProducto;
	}
	
	public Producto(String nombre,Fabricante fabricante, float precio){
		this.nombre=nombre;
		this.fabricante=fabricante;
		this.precio=precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long idProducto) {
		this.id = idProducto;
	}


}
