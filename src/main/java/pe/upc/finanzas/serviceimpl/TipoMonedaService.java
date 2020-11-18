package pe.upc.finanzas.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.finanzas.entity.TipoMoneda;
import pe.upc.finanzas.repository.ITipoMonedaRepository;
import pe.upc.finanzas.service.ITipoMonedaService;

@Service
public class TipoMonedaService implements ITipoMonedaService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ITipoMonedaRepository tipomonedaRepository;

	@Transactional
	@Override
	public Integer save(TipoMoneda tipomoneda) {
		// TODO Auto-generated method stub
		int rpta = tipomonedaRepository.searchCTipoMonedaTipoMoneda(tipomoneda.getCTipoMoneda());
		if (rpta==0) {
			tipomonedaRepository.save(tipomoneda);
		}
		
		return rpta;
	}

	@Transactional
	@Override
	public void update(TipoMoneda tipomoneda) {
		// TODO Auto-generated method stub
		tipomonedaRepository.save(tipomoneda);
	}

	@Transactional
	@Override
	public void delete(TipoMoneda tipomoneda) {
		// TODO Auto-generated method stub
		tipomonedaRepository.delete(tipomoneda);
	}

	@Override
	public TipoMoneda findByID(Long CTipoMoneda) {
		// TODO Auto-generated method stub
		return tipomonedaRepository.findByCTipoMoneda(CTipoMoneda);
	}

	@Override
	public List<TipoMoneda> findAll() {
		// TODO Auto-generated method stub
		return tipomonedaRepository.findAll();
	}

	@Override
	public List<TipoMoneda> findByNTipoMoneda(String NTipoMoneda) {
		// TODO Auto-generated method stub
		return tipomonedaRepository.findByNTipoMoneda(NTipoMoneda);
	}
	
	

}
