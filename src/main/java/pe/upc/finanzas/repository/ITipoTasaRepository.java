package pe.upc.finanzas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.upc.finanzas.entity.TipoTasa;

@Repository
public interface ITipoTasaRepository extends JpaRepository<TipoTasa, Long> {

	List<TipoTasa> findByNTipoTasa(String NTipoTasa) throws Exception;
	
}
