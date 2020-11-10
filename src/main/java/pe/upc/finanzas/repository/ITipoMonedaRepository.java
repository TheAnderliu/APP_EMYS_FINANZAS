package pe.upc.finanzas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.upc.finanzas.entity.TipoMoneda;

@Repository
public interface ITipoMonedaRepository extends JpaRepository<TipoMoneda, Long> {
	
	List<TipoMoneda> findByNTipoMoneda(String NTipoMoneda);

	
}
