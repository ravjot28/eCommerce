package web.ecommerce.tpfinal.ecommerce_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/commerce/**")
public class CommerceController {
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView mav = new ModelAndView();		
		return mav;
	}
}
