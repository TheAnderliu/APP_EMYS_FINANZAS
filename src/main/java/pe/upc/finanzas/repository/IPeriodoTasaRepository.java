package pe.upc.finanzas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.upc.finanzas.entity.PeriodoTasa;

@Repository
public interface IPeriodoTasaRepository extends JpaRepository<PeriodoTasa, Long>{

	@Query("select count(e.CPeriodoTasa) from PeriodoTasa e where e.CPeriodoTasa =:CPeriodoTasa")
	public int searchCPeriodoTasaPeriodoTasa(@Param("CPeriodoTasa")Long CPeriodoTasa);
	
	@Query("select e from PeriodoTasa e where e.CPeriodoTasa = :CPeriodoTasa")
	public PeriodoTasa findByCPeriodoTasa(@Param("CPeriodoTasa")Long CPeriodoTasa);
	
}
