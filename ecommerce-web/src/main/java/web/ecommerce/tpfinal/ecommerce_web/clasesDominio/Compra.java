package web.ecommerce.tpfinal.ecommerce_web.clasesDominio;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Compra {
		private Usuario usuario;
		private List<ProductoComprable> productos;
		
		public Compra(Usuario usuario, List<ProductoComprable> productos) {
			
			this.usuario = usuario;
			this.productos = productos;
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
		
		
		
		
}
