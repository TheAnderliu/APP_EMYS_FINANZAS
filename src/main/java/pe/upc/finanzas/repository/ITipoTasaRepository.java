package pe.upc.finanzas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.upc.finanzas.entity.TipoTasa;

@Repository
public interface ITipoTasaRepository extends JpaRepository<TipoTasa, Long> {

	@Query("select count(e.CTipoTasa) from TipoTasa e where e.CTipoTasa =:CTipoTasa")
	public int searchCTipoTasaTipoTasa(@Param("CTipoTasa")Long CTipoTasa);
	
	@Query("select e from TipoTasa e where e.CTipoTasa = :CTipoTasa")
	public TipoTasa findByCTipoTasa(@Param("CTipoTasa")Long CTipoTasa);
	
	@Query("select e from TipoTasa e where e.NTipoTasa = :NTipoTasa")
	List<TipoTasa> findByNTipoTasa(String NTipoTasa);
	
}
