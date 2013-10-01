package web.ecommerce.tpfinal.ecommerce_web.clasesDominio;


public class Comentario {
		private String texto;
		private IComentable comentable;
		private Usuario usuario;
		private boolean aceptado = true;
		private int numeroComentario;
		
		public int getNumeroComentario() {
			return numeroComentario;
		}

		public void setNumeroComentario(int id) {
			this.numeroComentario = id;
		}

		public Comentario(String texto, IComentable comentable,
				Usuario usuario, boolean aceptado) {
			
			this.texto = texto;
			this.comentable = comentable;
			this.usuario = usuario;
			this.aceptado = aceptado;
		}

		public String getTexto() {
			return texto;
		}

		public void setTexto(String texto) {
			this.texto = texto;
		}

		public IComentable getComentable() {
			return comentable;
		}

		public void setComentable(IComentable comentable) {
			this.comentable = comentable;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public boolean isAceptado() {
			return aceptado;
		}

		public void setAceptado(boolean aceptado) {
			this.aceptado = aceptado;
		}
		
		
		
		
		
}
