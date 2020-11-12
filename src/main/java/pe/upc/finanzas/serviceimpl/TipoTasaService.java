package pe.upc.finanzas.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.finanzas.entity.TipoTasa;
import pe.upc.finanzas.repository.ITipoTasaRepository;
import pe.upc.finanzas.service.ITipoTasaService;

@Service
public class TipoTasaService implements ITipoTasaService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ITipoTasaRepository tipotasaRepository;
	
	@Transactional
	@Override
	public TipoTasa save(TipoTasa entity) throws Exception {
		// TODO Auto-generated method stub
		return tipotasaRepository.save(entity);
	}

	@Transactional
	@Override
	public TipoTasa update(TipoTasa entity) throws Exception {
		// TODO Auto-generated method stub
		return tipotasaRepository.save(entity);
	}

	@Override
	public void deletedById(Long id) {
		// TODO Auto-generated method stub
		tipotasaRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<TipoTasa> findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return tipotasaRepository.findById(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<TipoTasa> findAll() throws Exception {
		// TODO Auto-generated method stub
		return tipotasaRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<TipoTasa> findByNTipoTasa(String NTipoTasa) throws Exception {
		// TODO Auto-generated method stub
		return tipotasaRepository.findByNTipoTasa(NTipoTasa);
	}

}
