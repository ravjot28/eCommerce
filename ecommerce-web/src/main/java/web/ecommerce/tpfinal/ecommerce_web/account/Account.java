package web.ecommerce.tpfinal.ecommerce_web.account;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "account")
@NamedQuery(name = Account.FIND_BY_EMAIL, query = "select a from Account a where a.email = :email")
public class Account implements java.io.Serializable {

	public static final String FIND_BY_EMAIL = "Account.findByEmail";

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String email;
	
	@JsonIgnore
	private String password;


	private String role = "ROLE_USER";

	protected Account() {

	}
	
	public Account(String email, String password, String role) {
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public int getPermiso(){
		int respuesta;
		if(this.getRole().equals("ROLE_ADMIN")){
			respuesta = 1;
		} else {
			respuesta = 0;
		}
		return respuesta;
	}
	
	public int getEqualMail(String nombreDeComentario){
		int respuesta;
		if(this.getEmail().equals(nombreDeComentario)){
			respuesta = 1;
		} else {
			respuesta = 0;
		}
		return respuesta;
		
	}
	
	public int resolver(boolean aceptado){
		int resultado;
		if((getPermiso() == 1) || aceptado){
			resultado = 1;
		} else {
			resultado = 0;
		}
		return resultado;
	}
}
