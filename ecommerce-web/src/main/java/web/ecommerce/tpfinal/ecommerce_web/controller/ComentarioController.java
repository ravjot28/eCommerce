package web.ecommerce.tpfinal.ecommerce_web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import web.ecommerce.tpfinal.ecommerce_web.account.Account;
import web.ecommerce.tpfinal.ecommerce_web.account.AccountRepository;
import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Comentario;
import web.ecommerce.tpfinal.ecommerce_web.repository.ComentariosRepository;

@Controller
@RequestMapping(value="/comentario/**")

public class ComentarioController {

	@Autowired
	private ComentariosRepository comentariosRepository;
	@Autowired
	AccountRepository accountRepository;
	//Recibe como parametro el id y un flag, con el flag va saber si es un producto o un fabricante.
	//Y lo muestra en pantalla
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView indexproducto(@RequestParam("id") int id, @RequestParam("flag") boolean flag, Principal principal){	
	ModelAndView mav = new ModelAndView();
		mav.getModelMap().addAttribute("comentarios", comentariosRepository.findAll(id, flag));
		mav.getModelMap().addAttribute("idComentable", id);
		mav.getModelMap().addAttribute("flag", flag);
		Account account = accountRepository.findByEmail(principal.getName());
		mav.getModelMap().addAttribute("account", account); 
		
		return mav;
	}
	//Agrega un nuevo comentario y lo diferencia
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute Comentario unComentario,@RequestParam("flag") boolean flag,@RequestParam("idComentable") int idComentable, Principal principal){
		ModelAndView mav = new ModelAndView("redirect:index?id=" + idComentable + "&flag=" + flag);
		Account a = accountRepository.findByEmail(principal.getName());
		unComentario.setAccount(a);
		
		if(flag){
			unComentario.setIdProducto(idComentable);
		}else {
			unComentario.setIdFabrica(idComentable);
		}
		
		comentariosRepository.create(unComentario);
		return mav;
	}
	//Bloquea un comentario
	@RequestMapping(value="/block", method=RequestMethod.GET)
	public ModelAndView block(@RequestParam("id") int id,@RequestParam("flag") boolean flag,@RequestParam("idComentable") int idComentable){
		ModelAndView mav = new ModelAndView("redirect:index?id=" + idComentable + "&flag=" + flag);
		comentariosRepository.block(id);
		return mav;
	}
	//Remueve el comentario
	@RequestMapping(value="/remove", method=RequestMethod.GET)
	public ModelAndView remove(@RequestParam("id") int id,@RequestParam("flag") boolean flag,@RequestParam("idComentable") int idComentable){
		ModelAndView mav = new ModelAndView("redirect:index?id=" + idComentable + "&flag=" + flag);
		comentariosRepository.delete(id);
		return mav;
	}

//	@RequestMapping(value="/edit", method=RequestMethod.GET)
//	public ModelAndView edit(@RequestParam("numeroComentario") int numeroComentario,@RequestParam("flag") boolean flag,@RequestParam("idComentable") int idComentable){
//		ModelAndView mav = new ModelAndView();
//		Comentario elComentario = comentariosRepository.get(numeroComentario);
//		mav.getModelMap().addAttribute("comentario", elComentario);
//		return mav;
//	}
//
//	@RequestMapping(value="/edit", method=RequestMethod.POST)
//	public ModelAndView edit(@ModelAttribute Comentario unComentario){
//		ModelAndView mav = new ModelAndView();
//		comentariosRepository.save(unComentario);
//
//		return mav;
//	}

}

