package web.ecommerce.tpfinal.ecommerce_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import web.ecommerce.tpfinal.ecommerce_web.account.Account;
import web.ecommerce.tpfinal.ecommerce_web.account.AccountForm;
import web.ecommerce.tpfinal.ecommerce_web.account.AccountRepository;
import web.ecommerce.tpfinal.ecommerce_web.account.FabricanteForm;
import web.ecommerce.tpfinal.ecommerce_web.account.ProductoForm;
import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Fabricante;
import web.ecommerce.tpfinal.ecommerce_web.clasesDominio.Producto;
import web.ecommerce.tpfinal.ecommerce_web.repository.FabricanteRepository;
import web.ecommerce.tpfinal.ecommerce_web.repository.ProductoRepository;

@Controller
@RequestMapping(value = "/administrador/**")
public class AdminController {
	
	@Autowired
	private FabricanteRepository fabricanteRepository;
	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private AccountRepository accountRepository;
		
	@RequestMapping(value = "/mainAdmin", method = RequestMethod.GET)
	public ModelAndView mainAdmin() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}	
	@RequestMapping(value = "/errorFabricante", method = RequestMethod.GET)
	public ModelAndView errorFabricante() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	@RequestMapping(value = "/verProd", method = RequestMethod.GET)
	public ModelAndView verProd(@RequestParam ("id")int id) {
		ModelAndView mav = new ModelAndView();
		mav.getModelMap().addAttribute("productos", fabricanteRepository.getAllProdFab(fabricanteRepository.getF(id)));
		mav.getModelMap().addAttribute("fab",fabricanteRepository.getF(id));
		return mav;
	}
	@RequestMapping(value = "/cargarFabricante", method = RequestMethod.GET)
	public ModelAndView cargarFabricante() {
		ModelAndView mav = new ModelAndView();
		//obtener lista de fabricantes
		mav.getModelMap().addAttribute("fabricantes", fabricanteRepository.getAllFabricantes());
		return mav;
	}
	@RequestMapping(value = "/cargarProducto", method = RequestMethod.GET)
	public ModelAndView cargarProducto() {
		ModelAndView mav = new ModelAndView();
		//obtener lista de fabricantes
		mav.getModelMap().addAttribute("fabricantes", fabricanteRepository.getAllFabricantes());
		
		//obtener lista de productos
		mav.getModelMap().addAttribute("productos", productoRepository.getAll());
		return mav;
	}
	@RequestMapping(value = "/consultarUsuario", method = RequestMethod.GET)
	public ModelAndView consultarUsuario() {
		ModelAndView mav = new ModelAndView();
		
		List<Account> lista = accountRepository.getAll();
		System.out.println(lista);
		
		mav.getModelMap().addAttribute("accounts", lista);
		System.out.println("mostrame esto");
		return mav;
	}
	@RequestMapping(value="/createF", method=RequestMethod.POST)
	public ModelAndView createF(@ModelAttribute FabricanteForm fabricanteForm){
		ModelAndView mav = new ModelAndView("redirect:cargarFabricante");

		Fabricante fabri = new Fabricante(fabricanteForm.getNombre());
		
		fabricanteRepository.createF(fabri);
		System.out.println("el fabricante creado tiene id = " + fabri.getId());


		return mav;
	}
	@RequestMapping(value="/createP", method=RequestMethod.POST)
	public ModelAndView createP(@RequestParam ("nombre")String nombre,@RequestParam ("idFabricante")int idFabricante,@RequestParam ("precio")int precio){
		ModelAndView mav = new ModelAndView("redirect:cargarProducto");
		
		Fabricante fab = fabricanteRepository.getF(idFabricante);
		Producto prod = new Producto(nombre,fab,precio);
		
		System.out.println("ACA ES EL ERROR");
		productoRepository.createP(prod);
		System.out.println("O NO.");
		System.out.println("el producto creado tiene id = " + prod.getId());


		return mav;
	}
	@RequestMapping(value="/createU", method=RequestMethod.POST)
	public ModelAndView createU(@RequestParam ("email")String email,@RequestParam ("password")String password,@RequestParam ("role")String role){
		ModelAndView mav = new ModelAndView("redirect:consultarUsuario");
		
		Account account = new Account(email,password,role);
		
		accountRepository.save(account);
		return mav;
	}
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ModelAndView delete(@RequestParam ("id") int id, @RequestParam ("tipo") String tipo){
		ModelAndView mav = null;

			if (tipo.equals("producto")){
				System.out.println(" NO SE HACE EL DELETEP");
				productoRepository.deleteP(id);
				System.out.println("SE HACE EL DELETEP");
			}else if (tipo.equals("fabricante")){
				try {
					fabricanteRepository.deleteF(id);
				} catch (RuntimeException e) {
					mav = new ModelAndView("redirect:errorFabricante");
					return mav;
				}
				
			}else if (tipo.equals("account")){
				accountRepository.deleteU(id);
			}
		mav = new ModelAndView("redirect:mainAdmin");
		return mav;
	}
	@RequestMapping(value="/editarP", method=RequestMethod.GET)
	public ModelAndView editarP(@RequestParam int id){
		ModelAndView mav = new ModelAndView();

		Producto producto = productoRepository.getP(id);
		mav.getModelMap().addAttribute("producto", producto);
		mav.getModelMap().addAttribute("fabricantes", fabricanteRepository.getAllFabricantes());

		return mav;
	}

	@RequestMapping(value="/editarP", method=RequestMethod.POST)
	public ModelAndView editarP(@ModelAttribute ProductoForm productoForm){
		ModelAndView mav = new ModelAndView("redirect:cargarProducto");

		Producto producto = productoRepository.getP(productoForm.getId());
		producto.setNombre(productoForm.getNombre());
		producto.setPrecio(productoForm.getPrecio());
		System.out.println("Cambia todo");
		productoRepository.saveP(producto);
		System.out.println("EDITO");
		
		return mav;
	}
	@RequestMapping(value="/editarF", method=RequestMethod.GET)
	public ModelAndView editarF(@RequestParam int id){
		ModelAndView mav = new ModelAndView();

		Fabricante fabricante = fabricanteRepository.getF(id);
		mav.getModelMap().addAttribute("fabricante", fabricante);

		return mav;
	}

	@RequestMapping(value="/editarF", method=RequestMethod.POST)
	public ModelAndView editarF(@ModelAttribute FabricanteForm fabricanteForm){
		ModelAndView mav = new ModelAndView("redirect:cargarFabricante");

		Fabricante fabricante = fabricanteRepository.getF(fabricanteForm.getId());
		fabricante.setNombre(fabricanteForm.getNombre());
		System.out.println("Cambia todo");
		fabricanteRepository.saveF(fabricante);
		System.out.println("EDITO");
		
		return mav;
	}
	@RequestMapping(value="/editarU", method=RequestMethod.GET)
	public ModelAndView editarU(@RequestParam int id){
		ModelAndView mav = new ModelAndView();

		Account account = accountRepository.getU(id);
		mav.getModelMap().addAttribute("account", account);

		return mav;
	}

	@RequestMapping(value="/editarU", method=RequestMethod.POST)
	public ModelAndView editarU(@ModelAttribute AccountForm accountForm){
		ModelAndView mav = new ModelAndView("redirect:consultarUsuario");

		Account account = accountRepository.getU(accountForm.getId());
		account.setEmail(accountForm.getEmail());
		System.out.println("Cambia todo");
		accountRepository.saveU(account);
		System.out.println("EDITO");
		
		return mav;
	}
}