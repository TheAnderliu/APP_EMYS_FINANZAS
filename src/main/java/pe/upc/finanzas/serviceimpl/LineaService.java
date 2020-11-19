package pe.upc.finanzas.serviceimpl;

import java.io.Serializable;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.finanzas.entity.Administrador;
import pe.upc.finanzas.entity.Cliente;
import pe.upc.finanzas.entity.Linea;
import pe.upc.finanzas.entity.Sistema;
import pe.upc.finanzas.entity.Transaccion;
import pe.upc.finanzas.repository.IAdministradorRepository;
import pe.upc.finanzas.repository.IClienteRepository;
import pe.upc.finanzas.repository.ILineaRepository;
import pe.upc.finanzas.service.ILineaService;

@Service
public class LineaService implements ILineaService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ILineaRepository lineaRepository;
	
	@Autowired
	private IClienteRepository clienteRepository;
	
	
	
	@Transactional
	@Override
	public Integer save(Linea linea) {
		// TODO Auto-generated method stub
		int rpta = lineaRepository.searchCLineaLinea(linea.getCLinea());
		if (rpta==0) {
			lineaRepository.save(linea);
		}
		
		return rpta;
		
	}


	@Transactional
	@Override
	public void update(Linea linea) {
		// TODO Auto-generated method stub
		lineaRepository.save(linea);
	}


	@Transactional
	@Override
	public void delete(Linea linea) {
		// TODO Auto-generated method stub
		lineaRepository.delete(linea);
	}



	@Override
	public Linea findByID(Long CLinea) {
		// TODO Auto-generated method stub
		return lineaRepository.findByCLineaLinea(CLinea);
	}



	@Override
	public List<Linea> findAll() {
		// TODO Auto-generated method stub
		return lineaRepository.findAll();
	}



	@Override
	public List<Linea> findByDFechaEmision(Date DFechaEmision) {
		// TODO Auto-generated method stub
		return lineaRepository.findByDFechaEmision(DFechaEmision);
	}


	@Override
	public Sistema Resultados(Cliente cliente) {
		
		
		//Iniciciamos la variable de Sistema
		
		Sistema respuestadesistema = new Sistema();
		
		//Traemos la linea del cliente
		Linea LineaEncontradaDeCliente= lineaRepository.findByCliente(cliente);
		
		//Contamos cuántas transacciones totales tiene (para luego iterar)
		int CantidadDeTransacciones =lineaRepository.CantidadDeTransaccionesPorLinea(LineaEncontradaDeCliente);
		
		
		//Obtenemos los datos de la linea
		int Limite = LineaEncontradaDeCliente.getNumCredito();
		String TipoTasa = (LineaEncontradaDeCliente.getTipoTasa()).getNTipoTasa();
		double ValorTasa = LineaEncontradaDeCliente.getNTasa();
		
		int Capitalizacion = 0;
		
		String PeriodoTasa = "";
		
		float monto = 0;
		
		Boolean TipoMonto ;
		
		int tiempo = 0;
		
		float mtotal = 0;
		
		float DeudasTotales = 0;
		
		float PagoTotal = 0;
		
		double ResultadoM = 0;
		
		double resultado = 0;
		
		float m = 0;
		
		
		
		
		
		ValorTasa = ValorTasa / 100 ;
		
		
		
		if (TipoTasa.equals("Simple")) {	
		
			Capitalizacion = 0;
			PeriodoTasa = "";
			
		} else {
		PeriodoTasa = (LineaEncontradaDeCliente.getPeriodoTasa()).getNPeriodoTasa();
			
		Capitalizacion = LineaEncontradaDeCliente.getNCapitalizacion();
			
		}
		
		//Calculamos ResultadoM
		
		switch (PeriodoTasa) {
		case "Quincenal":
			
			ResultadoM = 15 / Capitalizacion;
			
			break;
			
		case "Mensual":
			
			ResultadoM=30/Capitalizacion;
			
			break;

		case "Bimestral":
			
			ResultadoM=60/Capitalizacion;
			
			break;
			
		case "Trimestral":
			
			ResultadoM=90/Capitalizacion;
			
			break;
			
		case "Semestral":
			
			ResultadoM=180/Capitalizacion;
			
			break;
			
		default:
			
			ResultadoM = 0;
			
			break;
		}
		
		Transaccion transacionactual = new Transaccion();
		Transaccion transacionsiguiente = new Transaccion();
		
		List<Transaccion> ListadoTransacciones = lineaRepository.ListaDeTransaccionees(LineaEncontradaDeCliente); 
		
		//For iiterando por cada transaccion
		for (int i = 0; i < ListadoTransacciones.size(); i++) {
			
			transacionactual=ListadoTransacciones.get(i);
			
			
			
			m = transacionactual.getMonto();
			
			TipoMonto = transacionactual.isBTipo();
			
			
			
			
			
			//Obtener la diferencia de dias entre transaccion
			if (i+1<ListadoTransacciones.size()) {
				
				transacionsiguiente=ListadoTransacciones.get(i+1);
				tiempo = lineaRepository.DiferenciaEntreFecha(transacionsiguiente.getDFecha(), transacionactual.getDFecha());
			} else {
				tiempo = 0;
			}
			
			
			
			
			//Calcula el resultado total de la tasa
			
			if (TipoMonto==true) {
				
				mtotal = mtotal+m;
				
				resultado=0;
				
				switch (TipoTasa) {
				case "Simple":
					
					resultado = mtotal*(1+(ValorTasa*(tiempo/360)));
					
					break;

				case "Nominal":
					
					resultado = Math.pow(mtotal*(1+(ValorTasa/ResultadoM)), (tiempo/Capitalizacion))   ;
					
					break;
					
				case "Efectiva":
					
					resultado = Math.pow(mtotal*(1+ValorTasa), ((tiempo/Capitalizacion)/ResultadoM))   ;
					
					break;
					
				default: resultado = 0;
					break;
				}
				
				mtotal=(float) resultado;
				
				DeudasTotales=DeudasTotales+m;
				
				
				
				 
				
			} else {
				
				mtotal = mtotal - m;
				
				resultado=0;
				switch (TipoTasa) {
				case "Simple":
					
					resultado = mtotal*(1+(ValorTasa*(tiempo/360)));
					
					break;

				case "Nominal":
					
					resultado = Math.pow(mtotal*(1+(ValorTasa/ResultadoM)), (tiempo/Capitalizacion))   ;
					
					break;
					
				case "Efectiva":
					
					resultado = Math.pow(mtotal*(1+ValorTasa), ((tiempo/Capitalizacion)/ResultadoM))   ;
					
					break;
					
				default: resultado = 0;
					break;
				}
				
				mtotal=(float) resultado;
				
				PagoTotal=PagoTotal+m;
				
				
				
				
			}
			
			
			
			m=0;
			TipoMonto = null;
			tiempo = 0 ;
			
					
			
			
		}
		
		
		//Si supera el limite su tarjeta de credito
		if (mtotal>=Limite) {
			
			respuestadesistema.setCreditoDisponible(0);
			respuestadesistema.setDeudaTotal(mtotal);
			respuestadesistema.setDeudaTotalSinIntereses(DeudasTotales-PagoTotal);
			respuestadesistema.setInteresesGenerados(mtotal - (DeudasTotales - PagoTotal));
			
			
			
		}else {
			
			respuestadesistema.setCreditoDisponible(Limite-mtotal);
			respuestadesistema.setDeudaTotal(mtotal);
			respuestadesistema.setDeudaTotalSinIntereses( DeudasTotales-PagoTotal);
			respuestadesistema.setInteresesGenerados(mtotal - (DeudasTotales - PagoTotal));
			
			
		}
		
		
		
	
		
		
		
		
		
		
		
		
		return respuestadesistema;
	}

	
	
	
}
