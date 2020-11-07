package pe.upc.finanzas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TipoMantenimiento")
public class TipoMantenimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CTipoMantenimiento;
	
	private String NTipoMantenimiento;
	
	private int NumTipoMantenimiento;

	public Long getCTipoMantenimiento() {
		return CTipoMantenimiento;
	}

	public void setCTipoMantenimiento(Long cTipoMantenimiento) {
		CTipoMantenimiento = cTipoMantenimiento;
	}

	public String getNTipoMantenimiento() {
		return NTipoMantenimiento;
	}

	public void setNTipoMantenimiento(String nTipoMantenimiento) {
		NTipoMantenimiento = nTipoMantenimiento;
	}

	public int getNumTipoMantenimiento() {
		return NumTipoMantenimiento;
	}

	public void setNumTipoMantenimiento(int numTipoMantenimiento) {
		NumTipoMantenimiento = numTipoMantenimiento;
	}
	
	
}
