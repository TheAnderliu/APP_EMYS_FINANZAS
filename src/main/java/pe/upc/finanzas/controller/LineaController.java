package pe.upc.finanzas.controller;

import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.upc.finanzas.entity.Cliente;
import pe.upc.finanzas.entity.Linea;
import pe.upc.finanzas.service.IClienteService;
import pe.upc.finanzas.service.ILineaService;

@Controller
public class LineaController {

	@Autowired
	private ILineaService lineaService;
	
	
	
	
	@PostMapping("/insertarLinea")
	public String insertarLinea(@Valid Linea linea, BindingResult result, Model model, SessionStatus status) {
		
		
		/*
		Date fechaconvertida=(Date)linea.getDFechaEmision();
		linea.setDFechaEmision(fechaconvertida);*/
		
		if (result.hasErrors()) {
			model.addAttribute("mensaje", "Error al inicio de la funcion");
			return "registrarlineadecredito";
			
		} else {
			
			 
			int rpta = lineaService.save(linea);
			if (rpta>0) {
				model.addAttribute("mensaje", "Ya existe una linea con el mismo ID");
				return "registrarlineadecredito";
			} else {
				model.addAttribute("mensaje", "¡Linea registrada!");
				status.setComplete();
				
				
			}
			
		}
		
		
		
		return "registrarlineadecredito";
	}
	
}
