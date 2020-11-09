package pe.upc.finanzas.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.finanzas.entity.Cliente;
import pe.upc.finanzas.repository.IClienteRepository;
import pe.upc.finanzas.service.IClienteService;

public class ClienteService implements IClienteService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IClienteRepository clienteRepository;

	@Transactional
	@Override
	public Cliente save(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.save(entity);
	}

	@Transactional
	@Override
	public Cliente update(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.save(entity);
	}
	
	@Transactional
	@Override
	public void deletedById(Integer id) {
		// TODO Auto-generated method stub
		clienteRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Cliente> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Cliente> findByNumTelefono(int NumTelefono) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findByNumTelefono(NumTelefono);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Cliente> findByNumDNI(String NumDNI) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findByNumDNI(NumDNI);
	}

}
