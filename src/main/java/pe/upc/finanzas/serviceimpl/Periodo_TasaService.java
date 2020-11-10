package pe.upc.finanzas.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import pe.upc.finanzas.entity.Periodo_Tasa;
import pe.upc.finanzas.repository.IPeriodo_TasaRepository;
import pe.upc.finanzas.service.IPeriodo_TasaService;

public class Periodo_TasaService implements IPeriodo_TasaService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IPeriodo_TasaRepository periodoTasa_Repository;

	@Override
	public Periodo_Tasa save(Periodo_Tasa entity) throws Exception {
		// TODO Auto-generated method stub
		return periodoTasa_Repository.save(entity);
	}

	@Override
	public Periodo_Tasa update(Periodo_Tasa entity) throws Exception {
		// TODO Auto-generated method stub
		return periodoTasa_Repository.save(entity);
	}

	@Override
	public void deletedById(Long id) {
		// TODO Auto-generated method stub
		periodoTasa_Repository.deleteById(id);
	}

	@Override
	public Optional<Periodo_Tasa> findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return periodoTasa_Repository.findById(id);
	}

	@Override
	public List<Periodo_Tasa> findAll() throws Exception {
		// TODO Auto-generated method stub
		return periodoTasa_Repository.findAll();
	}

}
