package web.ecommerce.tpfinal.ecommerce_web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Comentario;


@Repository
@Transactional(readOnly = true)
public class ComentariosRepository {
	

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Comentario> findAll(){
		TypedQuery<Comentario> q = entityManager.createQuery("select a from Comentario c", Comentario.class);
		List<Comentario> comentarios = q.getResultList();
		
		return comentarios;
	}
	public void create(){
		
	}
	public void block(){
		
	}
	public void delete(){
		
	}
	public void save(){
		
	}
	public void get(){
		
	}
	

}
