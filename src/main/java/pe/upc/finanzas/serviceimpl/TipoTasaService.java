package pe.upc.finanzas.serviceimpl;

import java.io.Serializable;
import java.util.List;


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
	public Integer save(TipoTasa tipotasa) {
		// TODO Auto-generated method stub
		int rpta = tipotasaRepository.searchCTipoTasaTipoTasa(tipotasa.getCTipoTasa());
		if (rpta==0) {
			tipotasaRepository.save(tipotasa);
		}
		
		return rpta;
	}

	@Transactional
	@Override
	public void update(TipoTasa tipotasa) {
		// TODO Auto-generated method stub
		tipotasaRepository.save(tipotasa);
	}

	@Transactional
	@Override
	public void delete(TipoTasa tipotasa) {
		// TODO Auto-generated method stub
		tipotasaRepository.delete(tipotasa);
	}

	@Override
	public TipoTasa finByID(Long CTipoTasa) {
		// TODO Auto-generated method stub
		return tipotasaRepository.findByCTipoTasa(CTipoTasa);
	}

	@Override
	public List<TipoTasa> findAll() {
		// TODO Auto-generated method stub
		return tipotasaRepository.findAll();
	}

	@Override
	public List<TipoTasa> findByNTipoTasa(String NTipoTasa) {
		// TODO Auto-generated method stub
		return tipotasaRepository.findByNTipoTasa(NTipoTasa);
	}
	
	

}
