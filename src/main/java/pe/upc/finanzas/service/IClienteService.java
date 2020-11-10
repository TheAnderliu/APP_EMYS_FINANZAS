package pe.upc.finanzas.service;

import java.util.Optional;

import pe.upc.finanzas.entity.Cliente;

public interface IClienteService extends CrudService<Cliente,Long>{

	Optional<Cliente> findByNumTelefono(int NumTelefono) throws Exception;
	Optional<Cliente> findByNumDNI(String NumDNI) throws Exception;
}
