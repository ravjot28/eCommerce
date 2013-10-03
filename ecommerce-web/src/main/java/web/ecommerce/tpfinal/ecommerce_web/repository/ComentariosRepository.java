package web.ecommerce.tpfinal.ecommerce_web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Comentario;
//import web.ecommerce.tpfinal.ecommerce_web.controller.ComentarioController;


@Repository
@Transactional(readOnly = true)
public class ComentariosRepository {
	private static final Logger LOG = LoggerFactory.getLogger(ComentariosRepository.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Comentario> findAll(int id){
		TypedQuery<Comentario> q = entityManager.createQuery("select a from Comentario a", Comentario.class);
		List<Comentario> comentarios = q.getResultList();
		LOG.info("Se obtuvieron {} comentarios", comentarios.size());

		return comentarios;
	}
	public void create(Comentario comentario){
		entityManager.persist(comentario);
	}
	
	@Transactional
	public Comentario save(Comentario comentario){
		
		entityManager.flush();
		System.out.println("aceptado llega aca como: "+comentario.isAceptado());
		return comentario;
	}
	
	public void block(int id){
		
		if(get(id).isAceptado()){
			
			get(id).setAceptado(false);
			
		}else{
			
			get(id).setAceptado(true);
			
		}
		save(get(id));
	}
	public void delete(int numeroComentario){
		entityManager.remove(numeroComentario);
	}

	public Comentario get(int numeroComentario){
		Comentario comentarios = entityManager.find(Comentario.class, numeroComentario);
		return comentarios;
	}
}

