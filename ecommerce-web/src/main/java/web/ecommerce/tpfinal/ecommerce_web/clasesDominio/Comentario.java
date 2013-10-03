package web.ecommerce.tpfinal.ecommerce_web.clasesDominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import web.ecommerce.tpfinal.ecommerce_web.account.Account;

@Entity
public class Comentario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int idFabrica;
	private int idProducto;
	public int getIdFabrica() {
		return idFabrica;
	}

	public void setIdFabrica(int idFabrica) {
		this.idFabrica = idFabrica;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	private String texto;
	
	private transient IComentable comentable;
	
	@OneToOne
	private Account account;
	private boolean aceptado = true;
	
	public Comentario(){
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Comentario(String texto, IComentable comentable,
			Account account, boolean aceptado) {

		this.texto = texto;
		this.comentable = comentable;
		this.account = account;
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

	public Account getaccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}
}
