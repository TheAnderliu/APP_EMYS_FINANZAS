package pe.upc.finanzas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.upc.finanzas.entity.Tipo_Delivery;

@Repository
public interface ITipo_DeliveryRepository extends JpaRepository<Tipo_Delivery, Integer>{

}
