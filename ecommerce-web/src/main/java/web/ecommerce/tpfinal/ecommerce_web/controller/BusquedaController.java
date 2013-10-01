package web.ecommerce.tpfinal.ecommerce_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class BusquedaController {
	@Autowired
	private ProductoRepository ProductoRepository;
	
	@RequestMapping(value="/busqueda", method=RequestMethod.GET)
	public ModelAndView busquedaP(){
		ModelAndView mav = new ModelAndView();
				
		return mav;
	}
	
}
