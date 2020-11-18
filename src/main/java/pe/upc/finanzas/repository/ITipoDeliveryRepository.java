package pe.upc.finanzas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.upc.finanzas.entity.TipoDelivery;

@Repository
public interface ITipoDeliveryRepository extends JpaRepository<TipoDelivery, Long>{

	@Query("select count(e.CTipoDelivery) from TipoDelivery e where e.CTipoDelivery =:CTipoDelivery")
	public int searchCTipoDeliveryTipoDelivery(@Param("CTipoDelivery")Long CTipoDelivery);
	
	@Query("select e from TipoDelivery e where e.CTipoDelivery = :CTipoDelivery")
	public TipoDelivery findByCTipoDelivery(@Param("CTipoDelivery")Long CTipoDelivery);
}
