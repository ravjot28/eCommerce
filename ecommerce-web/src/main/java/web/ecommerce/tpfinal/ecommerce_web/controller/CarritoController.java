package web.ecommerce.tpfinal.ecommerce_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class CarritoController {
	@Controller
	@RequestMapping(value="/commerce/**")
	public class CommerceController {
		
		@Autowired
		private ProductoRepository ProductoComprableRepository;
		
		@RequestMapping(value="/carrito", method=RequestMethod.GET)
		public ModelAndView index(){
			ModelAndView mav = new ModelAndView();	
			mav.getModelMap().addAttribute("carrito", ProductoComprableRepository.findAll());
			return mav;
		}
	}
}
