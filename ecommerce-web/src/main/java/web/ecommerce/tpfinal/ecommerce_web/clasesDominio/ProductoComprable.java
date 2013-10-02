package web.ecommerce.tpfinal.ecommerce_web.clasesDominio;

public class ProductoComprable implements IComentable{
	//La clave primaria es el id de Producto
		private Producto producto;
		private float precioPagado;
		private int cantidad;
		public ProductoComprable(Producto producto, float precioUnitario, int cantidad) {
			
			this.producto = producto;
			this.precioPagado = precioUnitario*cantidad;
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
		
		//Extienden de la IComentable
		public String getName(){
			return producto.getNombre();
		}
		
		public int getId(){
			return producto.getId();
		}
}
