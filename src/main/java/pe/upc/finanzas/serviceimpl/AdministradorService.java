package pe.upc.finanzas.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.finanzas.entity.Administrador;
import pe.upc.finanzas.repository.IAdministradorRepository;
import pe.upc.finanzas.service.IAdministradorService;

@Service
public class AdministradorService implements IAdministradorService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Autowired
	private IAdministradorRepository administradorRepository;

	@Transactional
	@Override
	public Administrador save(Administrador entity) throws Exception {
		// TODO Auto-generated method stub
		return administradorRepository.save(entity);
	}

	@Transactional
	@Override
	public Administrador update(Administrador entity) throws Exception {
		// TODO Auto-generated method stub
		return administradorRepository.save(entity);
	}

	@Override
	public void deletedById(Long id) {
		// TODO Auto-generated method stub
		administradorRepository.deleteById(id);
	}

	@Transactional
	@Override
	public Optional<Administrador> findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return administradorRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Administrador> findAll() throws Exception {
		// TODO Auto-generated method stub
		return administradorRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Administrador> findByNAdministrador(String NAdministrador) throws Exception {
		// TODO Auto-generated method stub
		return administradorRepository.findByNAdministrador(NAdministrador);
	}

}
