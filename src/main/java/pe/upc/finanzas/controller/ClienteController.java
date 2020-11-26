package pe.upc.finanzas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.upc.finanzas.entity.Cliente;
import pe.upc.finanzas.service.IClienteService;


@Controller

public class ClienteController {

	@Autowired
	private IClienteService clienteService;
	
	@PostMapping("/insertarCliente")
	public String insertarClienteo(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("mensaje", "Error al inicio de la funcion");
			return "registrarcliente";
			
		} else {
			
			int rpta = clienteService.save(cliente);
			if (rpta >0) {
				model.addAttribute("mensaje", "Ya existe un cliente registrado con el mismo DNI");
				return "registrarcliente";
			} else {
				model.addAttribute("mensaje", "¡Cliente registrado!");
				status.setComplete();
			}
			
			
		}
		
		
		return "registrarcliente";
		
	}
	
	

	
}
