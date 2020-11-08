package pe.upc.finanzas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.upc.finanzas.entity.Linea;

@Repository
public interface ILineaRepository extends JpaRepository<Linea, Integer>{

	List<Linea> findByDFechaEmision(Date DFechaEmision) throws Exception;
}
