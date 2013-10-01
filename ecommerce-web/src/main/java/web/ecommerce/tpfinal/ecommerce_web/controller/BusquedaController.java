package web.ecommerce.tpfinal.ecommerce_web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping(value="/buscar/**")
public class BusquedaController {
	@Autowired
	private ProductoRepository ProductoRepository;
	
	@RequestMapping(value="/busqueda", method=RequestMethod.POST)
	public ModelAndView busqueda(@RequestParam String nombre, int minimo, int maximo){
		ModelAndView mav = new ModelAndView(/*pagina de la lista*/);
		ArrayList<Productos> productos = new ArrayList<Productos>();
		//temporales
		Productos elProducto = null;
		int precio = 0;
		//base de datos
		if (baseDatos.nombre.equals(nombre) || nombre == null){
			if (precio < maximo || (maximo == 0)){
				if (precio > minimo){
					productos.add(elProducto);
				}
			}

		}
		mav.getModelMap().addAttribute("productos", productos);
		return mav;
	}
	
}
