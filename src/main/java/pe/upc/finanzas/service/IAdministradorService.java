package pe.upc.finanzas.service;

import java.util.List;


import pe.upc.finanzas.entity.Administrador;

public interface IAdministradorService{

	public Integer save(Administrador administrador);
	
	public void update(Administrador administrador);
	
	public void delete(Administrador administrador);
	
	public Administrador findByID(Long CAdministrador);
	
	public List<Administrador> findAll();
	
	public Administrador findByNAdministrador(String NAdministrador);
	
	
}
