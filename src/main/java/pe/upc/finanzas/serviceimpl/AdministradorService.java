package pe.upc.finanzas.serviceimpl;

import java.io.Serializable;
import java.util.List;


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
	public Integer save(Administrador administrador) {
		int rpta = administradorRepository.searchCAdministradorAdministrador(administrador.getCAdministrador()); //0 si no existe el CIP
		if(rpta==0) {
			
			administradorRepository.save(administrador);
			
		}
		
		return rpta;
	}


	@Transactional
	@Override
	public void update(Administrador administrador) {
		
		administradorRepository.save(administrador);
		
	}

	@Transactional
	@Override
	public void delete(Administrador administrador) {
		
		
		
		administradorRepository.delete(administrador);
		
	}


	@Override
	public Administrador findByID(Long CAdministrador) {
		// TODO Auto-generated method stub
		return administradorRepository.findByCAdministrador(CAdministrador);
	}


	@Override
	public List<Administrador> findAll() {
		// TODO Auto-generated method stub
		return administradorRepository.findAll();
	}


	@Override
	public Administrador findByNAdministrador(String NAdministrador) {
		// TODO Auto-generated method stub
		return administradorRepository.findByNAdministrador(NAdministrador);
	}



}
