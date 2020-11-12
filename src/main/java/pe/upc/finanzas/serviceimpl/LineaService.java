package pe.upc.finanzas.serviceimpl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.finanzas.entity.Administrador;
import pe.upc.finanzas.entity.Cliente;
import pe.upc.finanzas.entity.Linea;
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
	
	
	@Autowired
	private IAdministradorRepository administradorRepository; 
	
	@Transactional
	@Override
	public Linea save(Linea entity) throws Exception {
		// TODO Auto-generated method stub
		return lineaRepository.save(entity);
	}

	@Transactional
	@Override
	public Linea update(Linea entity) throws Exception {
		// TODO Auto-generated method stub
		return lineaRepository.save(entity);
	}

	@Override
	public void deletedById(Long id) {
		lineaRepository.deleteById(id);
		
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Linea> findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return lineaRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Linea> findAll() throws Exception {
		// TODO Auto-generated method stub
		return lineaRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Linea> findByDFechaEmision(Date DFechaEmision) throws Exception {
		// TODO Auto-generated method stub
		return lineaRepository.findByDFechaEmision(DFechaEmision);
	}

	@Override
	public Integer insert(Linea linea, Cliente cliente) throws Exception {
		// TODO Auto-generated method stub
		
		
		if (clienteRepository.findByNumDNI(cliente.getNumDNI())!=null) {
			
		
		
		Optional<Cliente> optionalCliente = clienteRepository.findByNumDNI(cliente.getNumDNI());
		Cliente clienteguardado = optionalCliente.get();
		
		Optional<Administrador> optionalAdministrador = administradorRepository.findByNAdministrador("Aldo Mendoza Marín");
		Administrador administradorguardado = optionalAdministrador.get();
		
		
		Linea lineaParaRegistrar=linea;
		
		
		lineaParaRegistrar.setCliente(clienteguardado);
		lineaParaRegistrar.setAdministrador(administradorguardado);
		
		lineaRepository.save(lineaParaRegistrar);
		
		return 1;
		
		}
		else
		
		return 0;
	}

	
	
	
}
