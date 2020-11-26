package pe.upc.finanzas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.upc.finanzas.entity.TipoMoneda;

@Repository
public interface ITipoMonedaRepository extends JpaRepository<TipoMoneda, Long> {
	
	@Query("select count(e.CTipoMoneda) from TipoMoneda e where e.CTipoMoneda =:CTipoMoneda")
	public int searchCTipoMonedaTipoMoneda(@Param("CTipoMoneda")Long CTipoMoneda);
	
	@Query("select e from TipoMoneda e where e.CTipoMoneda = :CTipoMoneda")
	public TipoMoneda findByCTipoMoneda(@Param("CTipoMoneda")Long CTipoMoneda);
	
	
	@Query("select e from TipoMoneda e where e.NTipoMoneda = :NTipoMoneda")
	List<TipoMoneda> findByNTipoMoneda(@Param("NTipoMoneda")String NTipoMoneda);

	
}
