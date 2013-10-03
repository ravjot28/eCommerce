package web.ecommerce.tpfinal.ecommerce_web.clasesDominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Comentario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String texto;
	
	private transient IComentable comentable;
	
	@OneToOne
	private Usuario usuario;
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
