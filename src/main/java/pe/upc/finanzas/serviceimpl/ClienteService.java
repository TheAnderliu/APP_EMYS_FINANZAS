package pe.upc.finanzas.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.finanzas.entity.Cliente;
import pe.upc.finanzas.entity.Linea;
import pe.upc.finanzas.repository.IClienteRepository;
import pe.upc.finanzas.repository.ILineaRepository;

import java.util.ArrayList;
import java.util.Date;
import pe.upc.finanzas.service.IClienteService;

@Service
public class ClienteService implements IClienteService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IClienteRepository clienteRepository;
	
	@Autowired
	private ILineaRepository lineaRepository;

	@Transactional
	@Override
	public Integer save(Cliente cliente) {
		int rpta = clienteRepository.searchNumDNICliente(cliente.getNumDNI()); //0 si no existe el CIP
		if(rpta==0) {
			
			clienteRepository.save(cliente);
			
		}
		
		return rpta;
	}

	@Transactional
	@Override
	public void update(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteRepository.save(cliente);
	}

	@Transactional
	@Override
	public void delete(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteRepository.delete(cliente);
	}

	@Override
	public Cliente findByID(Long CCliente) {
		// TODO Auto-generated method stub
		return clienteRepository.findByCClienteCliente(CCliente);
	}

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Override
	public Cliente findByNumTelefono(int NumTelefono) {
		// TODO Auto-generated method stub
		return clienteRepository.findByNumTelefono(NumTelefono);
	}

	@Override
	public Cliente findByNumDNI(String NumDNI) {
		// TODO Auto-generated method stub
		return clienteRepository.findByNumDNI(NumDNI);
	}

	@Override
	public List<Cliente> encontrarClientesDeudores(Date FechaActual) {
		// TODO Auto-generated method stub
		
		
		//Se extraen todas las lineas
		List<Linea> listadoLineas = lineaRepository.findAll();
		
		List<Linea> listadoLineasDespuesDeFechaDeCierre = new ArrayList<Linea>();
		
		
		List<Cliente> listadoClientesDedudores = new ArrayList<Cliente>();
		
		
		if (listadoLineas.isEmpty()==false) {
			
		
		
			for (Linea linea : listadoLineas) {
				
				if (linea.getDFechaCierre()!=null) {
					
					//Si la FechaActual consultada está es igual a la Fecha de Cierre o está despues de esta, se carga al listado de listadoLineasDespuesDeFechaDeCierre 
					if (FechaActual.equals(linea.getDFechaCierre())||FechaActual.after(linea.getDFechaCierre())) {
						//Añade al listadoLineasDespuesDeFechaDeCierre aquellas lineas que esten en el periodo de pago, o sea que la fecha actual esté luego de la fecha de cierre
						listadoLineasDespuesDeFechaDeCierre.add(linea);
					}
					
				}
	
			}
			
			if (listadoLineasDespuesDeFechaDeCierre.isEmpty()==false) {
				
				for (Linea lineaDespuesDeLaFechaDeCierre : listadoLineasDespuesDeFechaDeCierre) {
					
					//Se extrae cada linea de listadoLineasDespuesDeFechaDeCierre, para encontrar su cliente
					Cliente clienteDeudor = clienteRepository.encontrarClientePorLinea(lineaDespuesDeLaFechaDeCierre);
					
					//Una vez encontrado le cliente, este es cargado a una nueva lista, la cual es vargada a la lista final de clientesDeudores
					listadoClientesDedudores.add(clienteDeudor);
					
				}
				
				
			}
		
		}
		
		
		for (Cliente cliente : listadoClientesDedudores) {
			if (FechaActual.after(cliente.getLinea().getDUltimoDiaDePago())) {
				cliente.setBEstado(false);
				clienteRepository.save(cliente);
			}
			
		}
		
		
		//Se envia la lista de ClientesDeudores
		return listadoClientesDedudores;
	}

	@Override
	public int cantidadClientes() {
		// TODO Auto-generated method stub
		return clienteRepository.cantidadClientes();
	}

	@Override
	public int cantidadClientesDeudores() {
		// TODO Auto-generated method stub
		return clienteRepository.cantidadClientesDeudores();
	}



}
