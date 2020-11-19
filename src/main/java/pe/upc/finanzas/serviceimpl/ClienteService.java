package pe.upc.finanzas.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.finanzas.entity.Cliente;
import pe.upc.finanzas.repository.IClienteRepository;
import pe.upc.finanzas.service.IClienteService;

@Service
public class ClienteService implements IClienteService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IClienteRepository clienteRepository;

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



}
