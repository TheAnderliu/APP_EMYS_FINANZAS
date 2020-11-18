package pe.upc.finanzas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.upc.finanzas.entity.TipoMantenimiento;

@Repository
public interface ITipoMantenimientoRepository extends JpaRepository<TipoMantenimiento, Long> {

	@Query("select count(e.CTipoMantenimiento) from TipoMantenimiento e where e.CTipoMantenimiento =:CTipoMantenimiento")
	public int searchCTipoMantenimientoTipoMantenimiento(@Param("CTipoMantenimiento")Long CTipoMantenimiento);
	
	@Query("select e from TipoMantenimiento e where e.CTipoMantenimiento = :CTipoMantenimiento")
	public TipoMantenimiento findByCTipoMantenimiento(@Param("CTipoMantenimiento") Long CTipoMantenimiento);
	
	@Query("select e from TipoMantenimiento e where e.NTipoMantenimiento = :NTipoMantenimiento")
	List<TipoMantenimiento> findByNTipoMantenimiento(String NTipoMantenimiento);
}
