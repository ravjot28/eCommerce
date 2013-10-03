package web.ecommerce.tpfinal.ecommerce_web.account;

public class ProductoForm {
	private String nombre;
	private int idFabricante;
	private float precio;
	private Long id;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public void setId(Long id) {
		this.id = id;
	}
	public int getIdFabricante() {
		return idFabricante;
	}
	public void setIdFabricante(int idFabricante) {
		this.idFabricante = idFabricante;
	}
	
}
