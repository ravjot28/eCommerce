package web.ecommerce.tpfinal.ecommerce_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Comentario;
import web.ecommerce.tpfinal.ecommerce_web.repository.ComentariosRepository;

@Controller
@RequestMapping(value="/comentario/**")

public class ComentarioController {

	@Autowired
	private ComentariosRepository comentariosRepository;

	@RequestMapping(value="/comentario", method=RequestMethod.GET)
	public ModelAndView comentario(@RequestParam("id") int id, @RequestParam("nombre") String nombre){
		ModelAndView mav = new ModelAndView();
		mav.getModelMap().addAttribute("comentarios", comentariosRepository.findAll(id));
		mav.getModelMap().addAttribute("nombre", nombre);
		mav.getModelMap().addAttribute("idComentable", id);
		return mav;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute Comentario unComentario){
		ModelAndView mav = null;
		/** TODO: Esto no tiene mucha pinta
		ModelAndView mav = new ModelAndView(
				"redirect:comentario?id={}&nombre={}",
				Integer.toString(unComentario.getComentable().getID()), 
				unComentario.getComentable().getNombre());
		comentariosRepository.create(unComentario);
		**/
		return mav;
	}

	@RequestMapping(value="/block", method=RequestMethod.GET)
	public ModelAndView block(@RequestParam("numeroComentario") int numeroComentario){
		ModelAndView mav = new ModelAndView();
		comentariosRepository.block(numeroComentario);
		return mav;
	}

	@RequestMapping(value="/remove", method=RequestMethod.GET)
	public ModelAndView remove(@RequestParam("numeroComentario") int numeroComentario){
		ModelAndView mav = new ModelAndView();
		comentariosRepository.delete(numeroComentario);
		return mav;
	}

	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("numeroComentario") int numeroComentario){
		ModelAndView mav = new ModelAndView();
		Comentario elComentario = comentariosRepository.get(numeroComentario);
		mav.getModelMap().addAttribute("comentario", elComentario);
		return mav;
	}

	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute Comentario unComentario){
		ModelAndView mav = new ModelAndView();
		comentariosRepository.save(unComentario);
		return mav;
	}

}


