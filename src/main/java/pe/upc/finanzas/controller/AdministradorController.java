package pe.upc.finanzas.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import pe.upc.finanzas.entity.Administrador;
import pe.upc.finanzas.entity.Cliente;
import pe.upc.finanzas.service.IAdministradorService;
import pe.upc.finanzas.service.IClienteService;

@Controller
public class AdministradorController {

	@Autowired
	private IAdministradorService administradorService;
	
	@Autowired
	private IClienteService clienteService;
	
	
	
	
	
	@PostMapping("/validarAdministrador")
	public String validarAdministrador(Administrador administrador, Model model) {
		
		if (administradorService.validarAdministrador(administrador)==1) {
			
			model.addAttribute("cantidadClientes", clienteService.cantidadClientes());
			
			model.addAttribute("cantidadClientesDeudores", clienteService.cantidadClientesDeudores());
			
			model.addAttribute("cliente", new Cliente());
			
			model.addAttribute("FechaActual", new Date());
			
			return "dashboard";
			
		} else {
			model.addAttribute("administrador", new Administrador());
			model.addAttribute("mensaje", "Ingrese su correo y constraseña correctamente");
			return "login";
		}
		
		
		
		
	}
	
	
	
	
	
}
