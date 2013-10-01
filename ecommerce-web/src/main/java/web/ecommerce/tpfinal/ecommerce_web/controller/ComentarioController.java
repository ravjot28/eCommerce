package web.ecommerce.tpfinal.ecommerce_web.controller;

import java.util.ArrayList;
import java.util.List;

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

	@RequestMapping(value="/mostrar", method=RequestMethod.GET)
	public ModelAndView mostrar(@RequestParam("id") int id, @RequestParam("nombre") String nombre){
		ModelAndView mav = new ModelAndView();
		mav.getModelMap().addAttribute("comentarios", comentariosRepository.findAll(id));
		mav.getModelMap().addAttribute("nombre", nombre);
		return mav;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute Comentario unComentario){
		ModelAndView mav = new ModelAndView("redirect:mostrar?id=" + unComentario.getComentable());
		comentariosRepository.create(unComentario);
		return mav;
	}

	@RequestMapping(value="/block", method=RequestMethod.GET)
	public ModelAndView block(@RequestParam("id") int id){
		ModelAndView mav = new ModelAndView("redirect:mostrar?id=" + id);
		comentariosRepository.block(id);
		return mav;
	}

	@RequestMapping(value="/remove", method=RequestMethod.GET)
	public ModelAndView remove(@RequestParam("id") int id){
		ModelAndView mav = new ModelAndView("redirect:mostrar?id=" + id);
		comentariosRepository.borrar(id);
		return mav;
	}

	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id") int id){
		ModelAndView mav = new ModelAndView();
		Comentario elComentario = comentariosRepository.get(id);
		mav.getModelMap().addAttribute("comentario", elComentario);
		return mav;
	}

	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute Comentario unComentario){
		ModelAndView mav = new ModelAndView("redirect:mostrar?id=" + unComentario.getComentable());
		comentariosRepository.save(unComentario);
		return mav;
	}

}


