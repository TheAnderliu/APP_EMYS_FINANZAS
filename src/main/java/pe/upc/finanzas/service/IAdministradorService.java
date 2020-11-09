package pe.upc.finanzas.service;

import java.util.Optional;

import pe.upc.finanzas.entity.Administrador;

public interface IAdministradorService extends CrudService<Administrador, Integer>{

	Optional<Administrador> findByNAdministrador(String NAdministrador) throws Exception;
}
