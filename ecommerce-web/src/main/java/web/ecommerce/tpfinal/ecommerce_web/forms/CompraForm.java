package web.ecommerce.tpfinal.ecommerce_web.forms;

import java.util.List;


import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.ProductoComprable;
import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Usuario;

public class CompraForm {

	private boolean estado = false;
	
	private long id;
	
	private Usuario usuario;
	
	private List<ProductoComprable> productos;
	
	private String estadoCompra;

	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ProductoComprable> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoComprable> productos) {
		this.productos = productos;
	}

	public String getEstadoCompra() {
		return estadoCompra;
	}

	public void setEstadoCompra(String estadoCompra) {
		this.estadoCompra = estadoCompra;
	}
	
	
	
}
