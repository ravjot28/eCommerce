package web.ecommerce.tpfinal.clasesDominio;

public class ProductoComprable {
		private Producto producto;
		private float precioPagado;
		private int cantidad;
		public ProductoComprable(Producto producto, float precioPagado,
				int cantidad) {
			
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
		
		
		
		
}
