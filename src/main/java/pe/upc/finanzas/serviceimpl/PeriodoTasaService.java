package pe.upc.finanzas.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.finanzas.entity.PeriodoTasa;
import pe.upc.finanzas.repository.IPeriodoTasaRepository;
import pe.upc.finanzas.service.IPeriodoTasaService;

@Service
public class PeriodoTasaService implements IPeriodoTasaService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IPeriodoTasaRepository periodoTasaRepository;

	@Transactional
	@Override
	public Integer save(PeriodoTasa periodotasa) {
		int rpta = periodoTasaRepository.searchCPeriodoTasaPeriodoTasa(periodotasa.getCPeriodoTasa()); //0 si no existe el CIP
		if(rpta==0) {
			
			periodoTasaRepository.save(periodotasa);
			
		}
		
		return rpta;
	}

	@Transactional
	@Override
	public void update(PeriodoTasa periodotasa) {
		periodoTasaRepository.save(periodotasa);
		
	}

	@Transactional
	@Override
	public void delete(PeriodoTasa periodotasa) {
		periodoTasaRepository.delete(periodotasa);
		
	}

	@Transactional
	@Override
	public PeriodoTasa findByID(Long CPeriodoTasa) {
		// TODO Auto-generated method stub
		return periodoTasaRepository.findByCPeriodoTasa(CPeriodoTasa);
	}

	@Override
	public List<PeriodoTasa> findAll() {
		// TODO Auto-generated method stub
		return periodoTasaRepository.findAll();
	}

	

}
