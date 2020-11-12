package pe.upc.finanzas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.upc.finanzas.entity.Cliente;
import pe.upc.finanzas.entity.Linea;
import pe.upc.finanzas.service.IClienteService;
import pe.upc.finanzas.service.ILineaService;

@Controller
@RequestMapping("/linea")
public class LineaController {

	@Autowired
	private ILineaService lineaService;
	
	@Autowired
	private IClienteService clienteService;
	
	
	
	
	@GetMapping("/save")
	public String saveLinea(@Valid Cliente cliente, @Valid Linea linea, BindingResult result, Model model, SessionStatus status) throws Exception{
		
		if (result.hasErrors()) {
			return "sistema/registrolinea";
		} else {
			
			if (clienteService.findByNumDNI(cliente.getNumDNI())!=null) {
				model.addAttribute("mensaje", "Ya existe un cliente registrado con el mismo DNI");
				return "sistema/registrolinea";
				
			} else {

				clienteService.save(cliente);
				
				
				int rpta = lineaService.insert(linea, cliente);
				
				if (rpta==0) {
					model.addAttribute("mensaje", "Error al registrar la linea de crédito");
				}else {
					model.addAttribute("mensaje", "!Cliente y línea registrados!");
					status.setComplete();
				}
				
				
			}
			
			
		}
		
		
		
		return "sistema/registrolinea";
	}
	
}
