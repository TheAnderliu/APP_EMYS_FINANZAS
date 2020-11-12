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
	public TipoMoneda save(TipoMoneda entity) throws Exception {
		// TODO Auto-generated method stub
		return tipomonedaRepository.save(entity);
	}

	@Transactional
	@Override
	public TipoMoneda update(TipoMoneda entity) throws Exception {
		// TODO Auto-generated method stub
		return tipomonedaRepository.save(entity);
	}


	@Override
	public void deletedById(Long id) {
		// TODO Auto-generated method stub
		tipomonedaRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<TipoMoneda> findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return tipomonedaRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<TipoMoneda> findAll() throws Exception {
		// TODO Auto-generated method stub
		return tipomonedaRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<TipoMoneda> findByNTipoMoneda(String NTipoMoneda) {
		// TODO Auto-generated method stub
		return tipomonedaRepository.findByNTipoMoneda(NTipoMoneda);
	}

}
