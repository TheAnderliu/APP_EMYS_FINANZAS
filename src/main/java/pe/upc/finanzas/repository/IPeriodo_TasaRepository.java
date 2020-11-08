package pe.upc.finanzas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.upc.finanzas.entity.Periodo_Tasa;

@Repository
public interface IPeriodo_TasaRepository extends JpaRepository<Periodo_Tasa, Integer>{

}
