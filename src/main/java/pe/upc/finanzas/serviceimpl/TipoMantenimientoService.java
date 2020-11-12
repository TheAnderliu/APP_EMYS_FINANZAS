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
	public TipoMantenimiento save(TipoMantenimiento entity) throws Exception {
		// TODO Auto-generated method stub
		return tipomantenimientoRepository.save(entity);
	}

	@Transactional
	@Override
	public TipoMantenimiento update(TipoMantenimiento entity) throws Exception {
		// TODO Auto-generated method stub
		return tipomantenimientoRepository.save(entity);
	}

	@Override
	public void deletedById(Long id) {
		// TODO Auto-generated method stub
		tipomantenimientoRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<TipoMantenimiento> findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return tipomantenimientoRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<TipoMantenimiento> findAll() throws Exception {
		// TODO Auto-generated method stub
		return tipomantenimientoRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<TipoMantenimiento> findByNTipoMantenimiento(String NTipoMantenimiento) {
		// TODO Auto-generated method stub
		return tipomantenimientoRepository.findByNTipoMantenimiento(NTipoMantenimiento);
	}

}
