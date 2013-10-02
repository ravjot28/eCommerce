package web.ecommerce.tpfinal.ecommerce_web.clasesDominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Compra {
		private Usuario usuario;
		private List<ProductoComprable> productos;
		private boolean estado = false;
		
		@Id
		@GeneratedValue
		private int id;
		
		public Compra(Usuario usuario, List<ProductoComprable> productos, boolean estado) {
			this.estado = true;
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

		public boolean isEstado() {
			return estado;
		}

		public void setEstado(boolean estado) {
			this.estado = estado;
		}

}
