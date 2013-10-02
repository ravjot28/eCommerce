package web.ecommerce.tpfinal.ecommerce_web.ordenDeCompra;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.ProductoComprable;
import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Usuario;

@Entity
public class ComprasVerificadas {
	@Id
	@GeneratedValue
	private int id;
	private Usuario usuario;
	private List<ProductoComprable> producto;
	private String estadoCompra;
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<ProductoComprable> getProducto() {
		return producto;
	}
	public void setProducto(List<ProductoComprable> producto) {
		this.producto = producto;
	}
	public String getEstadoCompra() {
		return estadoCompra;
	}
	public void setEstadoCompra(String estadoCompra) {
		this.estadoCompra = estadoCompra;
	}
	
	
	
	
	

}
