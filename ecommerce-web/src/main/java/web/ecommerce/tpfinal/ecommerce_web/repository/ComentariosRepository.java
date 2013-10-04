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
	//Trae una lista de comentarios, con el flag puede diferenciar si es de la lista de fabricas o de productos
	//luego utiliza el id para buscar todos los comentarios que tengan el mismo id
	public List<Comentario> findAll(int id, boolean flag){
		List<Comentario> comentarios;
		if(flag){
			TypedQuery<Comentario> q = entityManager.createQuery("select a from Comentario a where idProducto = :id", Comentario.class)
					.setParameter("id", id);
			comentarios = q.getResultList();
		} else {
			TypedQuery<Comentario> q = entityManager.createQuery("select a from Comentario a where idFabrica = :id", Comentario.class)
					.setParameter("id", id);
			comentarios = q.getResultList();
		}
		LOG.info("Se obtuvieron {} comentarios", comentarios.size());
		return comentarios;
	}
	//Guarda un comentario en la bd
	public void create(Comentario comentario){
		entityManager.persist(comentario);
	}
	//pone en false o true un comentario(bloquea o desbloquea) 
	public void block(int id){
		Comentario unCometnario = get(id);
		if(unCometnario.isAceptado()){
			unCometnario.setAceptado(false);
		}else{
			unCometnario.setAceptado(true);
		}
		save(unCometnario);
		
	}
	//elimina un comentario, utuliza la funcion get(id) para llamar al comentario
	//flush para actualizar la bd
	public void delete(int id){
		entityManager.remove(get(id));
		entityManager.flush();
	}
	//actualiza la bd
	public Comentario save(Comentario unComentario){
		Comentario elComentario = get(unComentario.getId());
		elComentario.setTexto(unComentario.getTexto());
		elComentario.setAceptado(unComentario.isAceptado());
		entityManager.flush();
		return elComentario;

	}
	//me devuelve un comentario
	public Comentario get(int id){
		Comentario comentarios = entityManager.find(Comentario.class, id);
		return comentarios;
	}
}

