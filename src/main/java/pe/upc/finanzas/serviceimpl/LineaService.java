package pe.upc.finanzas.serviceimpl;

import java.io.Serializable;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import pe.upc.finanzas.repository.ITransaccionRepository;
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
	
	@Autowired
	private ITransaccionRepository transaccionRepository;
	
	
	
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
	public Sistema Resultados(Cliente cliente, Date FechaHasta) {
		
		
		//Iniciciamos la variable de Sistema
		
		Sistema respuestadesistema = new Sistema();
		
		//Traemos la linea del cliente
		Linea LineaEncontradaDeCliente= lineaRepository.findByCliente(cliente);
		
		//Contamos cuántas transacciones totales tiene (para luego iterar)
		int CantidadDeTransacciones =lineaRepository.CantidadDeTransaccionesPorLinea(LineaEncontradaDeCliente); //ACA AÑADIRLE EL ATRIBUTO FECHAMAX
		
		
		//Obtenemos los datos de la linea
		float Limite = LineaEncontradaDeCliente.getNumCredito();
		String TipoTasa = (LineaEncontradaDeCliente.getTipoTasa()).getNTipoTasa();
		double ValorTasa = LineaEncontradaDeCliente.getNTasa();
		
		float Capitalizacion = 0;
		
		String PeriodoTasa = "";
		
		float monto = 0;
		
		Boolean TipoMonto ;
		
		float tiempo = 0;
		
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
		
		List<Transaccion> ListadoTransacciones = lineaRepository.ListaDeTransaccionees(LineaEncontradaDeCliente, FechaHasta); //ACA AÑADIRLE EL ATRIBUTO FECHAMAX
		
		//For iiterando por cada transaccion
		for (int i = 0; i < ListadoTransacciones.size(); i++) {
			
			transacionactual=ListadoTransacciones.get(i);
			
			
			
			m = transacionactual.getMonto();
			
			TipoMonto = transacionactual.isBTipo();
			
			
			
			//Debido a que se calculan los resultados hasta 30 después de la primera tansaccion, se le resta 1 a la fecha de cierre
			GregorianCalendar Dia30avoLuegoDeLaPrimeraTransaccion = new GregorianCalendar();
			
			Dia30avoLuegoDeLaPrimeraTransaccion.setTime(LineaEncontradaDeCliente.getDFechaCierre());
			
			Dia30avoLuegoDeLaPrimeraTransaccion.add(Calendar.DATE, -1);
			
			
			
			
			
			if (i+1<ListadoTransacciones.size()) {
				//PARA LAS TRANSACCIONES ANTERIORES A LA ULTIMA
				
				transacionsiguiente=ListadoTransacciones.get(i+1);
				//Validacion para el caso de que la siguiente transaccion a analizar sea menor que la fecha de cierre
				if (transacionsiguiente.getDFecha().before(LineaEncontradaDeCliente.getDFechaCierre())) {
				
				//Si la siguiente fecha de la transaccion es menor que la Fecha de Cierre, entonces se procederá a hallar la diferenncia de días entre las dos
					tiempo = lineaRepository.DiferenciaEntreFecha(transacionsiguiente.getDFecha(), transacionactual.getDFecha());
					
					
					
				} else {
					
					
					
					//Si la fecha de la siguiente transaccion es mayor que la Fecha de Cierre, entonces el tiempo de esta transaccion se igualará a cero, simulando que se realizó un día antes de la Fecha de Cierre 
					tiempo = 0;
				}
				
				
				
				
			} else {
				
				//PARA LA ULTIMA TRANSACCION
				
				
				
				if (FechaHasta.after(Dia30avoLuegoDeLaPrimeraTransaccion.getTime())) {
					
					
					if (transacionactual.getDFecha().before(LineaEncontradaDeCliente.getDFechaCierre())) {
						tiempo = lineaRepository.DiferenciaEntreFecha(Dia30avoLuegoDeLaPrimeraTransaccion.getTime(), transacionactual.getDFecha());
					}else {
						
						tiempo = 0;
					}
					
					
				} else {
					//El tiempo para la ultima transaccion realizada 
					tiempo = lineaRepository.DiferenciaEntreFecha(FechaHasta, transacionactual.getDFecha());
				}
				
				
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
					
					resultado = mtotal*Math.pow((1+(ValorTasa/ResultadoM)), (tiempo/Capitalizacion))   ;
					
					break;
					
				case "Efectiva":
					
					resultado = mtotal*Math.pow((1+ValorTasa), ((tiempo/Capitalizacion)/ResultadoM))   ;
					
					break;
					
				default: resultado = 0;
					break;
				}
				
				mtotal=(float) resultado;
				
				DeudasTotales=DeudasTotales+m;
				
				
				System.out.println("Del calculo de tasa cuando hay deuda: Resultado= " + resultado + ", m= "+m+" DeudasTotales");
				 
				
			} else {
				
				mtotal = mtotal - m;
				
				resultado=0;
				switch (TipoTasa) {
				case "Simple":
					
					resultado = mtotal*(1+(ValorTasa*(tiempo/360)));
					
					break;

				case "Nominal":
					
					resultado = mtotal*Math.pow((1+(ValorTasa/ResultadoM)), (tiempo/Capitalizacion))   ;
					
					break;
					
				case "Efectiva":
					
					resultado = mtotal*Math.pow((1+ValorTasa), ((tiempo/Capitalizacion)/ResultadoM))   ;
					
					break;
					
				default: resultado = 0;
					break;
				}
				
				mtotal=(float) resultado;
				
				PagoTotal=PagoTotal+m;
				
				
				System.out.println("Del calculo de tasa cuando hay pago: Resultado= " + resultado + ", m= "+m+" DeudasTotales");
				
			}
			
			
			
			m=0;
			TipoMonto = null;
			tiempo = 0 ;
			
					
			
			
		}
		
		
		if (mtotal<=0) {
			
			respuestadesistema.setCreditoDisponible(Limite);
			respuestadesistema.setDeudaTotal(0);
			respuestadesistema.setDeudaTotalSinIntereses(0);
			respuestadesistema.setInteresesGenerados(0);

			LineaEncontradaDeCliente.setDFechaCierre(null);
			LineaEncontradaDeCliente.setDUltimoDiaDePago(null);
		
			transaccionRepository.borrarTodasLasTransaccionesDeLinea(LineaEncontradaDeCliente);
			System.out.println("-----El mtotal es igual a 0");
		} 
		else {
			
			
			System.out.println("El mtotal es: " + mtotal);
			respuestadesistema.setCreditoDisponible(Limite-mtotal);
			respuestadesistema.setDeudaTotal(mtotal);
			respuestadesistema.setDeudaTotalSinIntereses( DeudasTotales-PagoTotal);
			respuestadesistema.setInteresesGenerados(mtotal - (DeudasTotales - PagoTotal));
			
			//Guarda la DeudaTotal en la Linea del cliente
			LineaEncontradaDeCliente.setDeudaTotal((float)respuestadesistema.getDeudaTotal());
			
			lineaRepository.save(LineaEncontradaDeCliente);
			
			System.out.println("DeudaTotal: " + LineaEncontradaDeCliente.getDeudaTotal());
			
			System.out.println("---------El mtotal es menor al limite");
		}
		
		
		
	
		
		
		
		
		
		
		
		
		return respuestadesistema;
	}


	@Override
	public Linea encontrarLineaDeCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return lineaRepository.findByCliente(cliente);
	}


	@Override
	public void cancelarDeuda(Linea lineaencontrada) {
		// TODO Auto-generated method stub
		
		lineaencontrada.setDeudaTotal(0);
		lineaencontrada.setDFechaCierre(null);
		lineaencontrada.setDUltimoDiaDePago(null);
		
		Cliente clientedelalinea = lineaencontrada.getCliente();
		clientedelalinea.setBEstado(true);
		clienteRepository.save(clientedelalinea);
		
		transaccionRepository.borrarTodasLasTransaccionesDeLinea(lineaencontrada);
	}

	
	
	
}
