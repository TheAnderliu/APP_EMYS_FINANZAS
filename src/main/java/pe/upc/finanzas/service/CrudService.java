package pe.upc.finanzas.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {

	T save(T entity) throws Exception;
	
	T update(T entity) throws Exception;
	
	void deletedById(ID id);
	
	Optional<T> findById(ID id) throws Exception; // busca el objeto, si no hay no hay problema para que no devuelva
	// nulo

	List<T> findAll() throws Exception;
	
}
