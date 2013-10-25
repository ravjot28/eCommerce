package web.ecommerce.tpfinal.clasesDominio;

public class Producto {
		private String nombre;
		private Fabricante fabricante;
		private float precio;
					
		public Producto(String nombre, Fabricante fabricante, float precio) {
			this.nombre = nombre;
			this.fabricante = fabricante;
			this.precio = precio;
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
		
		
}
