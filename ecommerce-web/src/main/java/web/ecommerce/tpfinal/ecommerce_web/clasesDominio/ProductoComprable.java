package web.ecommerce.tpfinal.ecommerce_web.clasesDominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ProductoComprable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	private Producto producto;
	private float precioPagado;
	private int cantidad;

	public ProductoComprable(){}
	
	public ProductoComprable(Producto producto, float precioPagado,
			int cantidad ) {

		this.producto = producto;
		this.precioPagado = precioPagado;
		this.cantidad = cantidad;

	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public float getPrecioPagado() {
		return precioPagado;
	}
	public void setPrecioPagado(float precioPagado) {
		this.precioPagado = precioPagado;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}




}
