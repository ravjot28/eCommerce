package web.ecommerce.tpfinal.ecommerce_web.clasesDominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Compra {
<<<<<<< HEAD
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	private Usuario usuario;
	
	@OneToMany
	private List<ProductoComprable> productos;
	
	private String estadoCompra;
	
	public Compra(Usuario usuario, List<ProductoComprable> productos) {
		this.usuario = usuario;
		this.productos = productos;
	}
=======

		private boolean estado = false;
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long id;
		
		@OneToOne
		private Usuario usuario;
		
		@OneToMany
		private List<ProductoComprable> productos;
		
		public Compra(Usuario usuario, List<ProductoComprable> productos, boolean estado) {
			this.estado = true;
			this.usuario = usuario;
			this.productos = productos;
		}
>>>>>>> d3ce3a7d18a7738151b44c9a20719494a4752dd0

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

		public void setProductos(List<ProductoComprable> productos) {
			this.productos = productos;
		}

		public boolean isEstado() {
			return estado;
		}

		public void setEstado(boolean estado) {
			this.estado = estado;
		}

	public List<ProductoComprable> getProductos() {
		return productos;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
<<<<<<< HEAD

	public String getEstadoCompra() {
		return estadoCompra;
	}

	public void setEstadoCompra(String estadoCompra) {
		this.estadoCompra = estadoCompra;
	}




=======
>>>>>>> d3ce3a7d18a7738151b44c9a20719494a4752dd0
}
