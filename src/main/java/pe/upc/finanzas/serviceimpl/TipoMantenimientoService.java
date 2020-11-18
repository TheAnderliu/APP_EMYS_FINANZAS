package pe.upc.finanzas.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.finanzas.entity.TipoMantenimiento;
import pe.upc.finanzas.repository.ITipoMantenimientoRepository;
import pe.upc.finanzas.service.ITipoMantenimientoService;

@Service
public class TipoMantenimientoService implements ITipoMantenimientoService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ITipoMantenimientoRepository tipomantenimientoRepository;

	@Transactional
	@Override
	public Integer save(TipoMantenimiento tipoMantenimiento) {
		// TODO Auto-generated method stub
		int rpta = tipomantenimientoRepository.searchCTipoMantenimientoTipoMantenimiento(tipoMantenimiento.getCTipoMantenimiento());
		if (rpta==0) {
			tipomantenimientoRepository.save(tipoMantenimiento);
		}
		
		return rpta;
	}

	@Transactional
	@Override
	public void update(TipoMantenimiento tipoMantenimiento) {
		// TODO Auto-generated method stub
		tipomantenimientoRepository.save(tipoMantenimiento);
	}

	@Transactional
	@Override
	public void delete(TipoMantenimiento tipoMantenimiento) {
		// TODO Auto-generated method stub
		tipomantenimientoRepository.delete(tipoMantenimiento);
	}

	@Override
	public TipoMantenimiento findByID(Long CTipoMantenimiento) {
		// TODO Auto-generated method stub
		return tipomantenimientoRepository.findByCTipoMantenimiento(CTipoMantenimiento);
	}

	@Override
	public List<TipoMantenimiento> findAll() {
		// TODO Auto-generated method stub
		return tipomantenimientoRepository.findAll();
	}

	@Override
	public List<TipoMantenimiento> findByNTipoMantenimiento(String NTipoMantenimiento) {
		// TODO Auto-generated method stub
		return tipomantenimientoRepository.findByNTipoMantenimiento(NTipoMantenimiento);
	}
	
	

}
