package pe.upc.finanzas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.upc.finanzas.entity.TipoMantenimiento;

@Repository
public interface ITipoMantenimientoRepository extends JpaRepository<TipoMantenimiento, Long> {

	List<TipoMantenimiento> findByNTipoMantenimiento(String NTipoMantenimiento);
}
