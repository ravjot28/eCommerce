package web.ecommerce.tpfinal.ecommerce_web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projecto_finall.clasesDominio.Comentario;
import projecto_finall.controller.ComentarioController;

@Repository
@Transactional(readOnly = true)
public class ComentariosRepository {
	private static final Logger LOG = LoggerFactory.getLogger(ComentarioController.class);

	@PersistenceContext
	private EntityManager entityManager;

	public List<Comentario> findAll(int id){
		TypedQuery<Comentario> q = entityManager.createQuery("select a from Comentario c", Comentario.class);
		List<Comentario> comentarios = q.getResultList();
		LOG.info("Se obtuvieron {} comentarios", comentarios.size());

		return comentarios;
	}
	public void create(Comentario comentario){
		entityManager.persist(comentario);
	}
	public void block(int numeroComentario){
		if(get(numeroComentario).isAceptado()){
			get(numeroComentario).setAceptado(false);
		}else{
			get(numeroComentario).setAceptado(true);
		}
	}
	public void delete(int numeroComentario){
		entityManager.remove(numeroComentario);
	}
	public Comentario save(Comentario comentario){
		comentario.setTexto(comentario.getTexto());		
		entityManager.persist(comentario);
		return null;

	}
	public Comentario get(int numeroComentario){
		Comentario comentarios = entityManager.find(Comentario.class, numeroComentario);
		return comentarios;
	}
}

