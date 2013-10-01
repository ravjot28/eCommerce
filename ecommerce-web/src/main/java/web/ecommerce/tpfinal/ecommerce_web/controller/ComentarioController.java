package web.ecommerce.tpfinal.ecommerce_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class ComentarioController {
	@Controller
	@RequestMapping(value="/commerce/**")
	public class CommerceController {
		
		@Autowired
		private ProductoRepository ComentarioRepository;
		
		@RequestMapping(value="/mostrar", method=RequestMethod.GET)
		public ModelAndView index(){
			ModelAndView mav = new ModelAndView();		
			return mav;
		}
		@RequestMapping(value="/busquedaProductos", method=RequestMethod.GET)
		public ModelAndView busquedaP(){
			ModelAndView mav = new ModelAndView();
			
			return mav;
		}
	}
}

