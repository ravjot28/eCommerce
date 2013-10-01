package web.ecommerce.tpfinal.ecommerce_web.clasesDominio;

public class Usuario {
		private String email;
		private String password;
		private String perfil;
		
		public Usuario(String email, String password, String perfil) {
			
			this.email = email;
			this.password = password;
			this.perfil = perfil;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPerfil() {
			return perfil;
		}

		public void setPerfil(String perfil) {
			this.perfil = perfil;
		}
		
		
		
}
