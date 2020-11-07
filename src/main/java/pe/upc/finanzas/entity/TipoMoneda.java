package pe.upc.finanzas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TipoMoneda")
public class TipoMoneda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CTipoMoneda;
	
	private String NTipoMoneda;

	public Long getCTipoMoneda() {
		return CTipoMoneda;
	}

	public void setCTipoMoneda(Long cTipoMoneda) {
		CTipoMoneda = cTipoMoneda;
	}

	public String getNTipoMoneda() {
		return NTipoMoneda;
	}

	public void setNTipoMoneda(String nTipoMoneda) {
		NTipoMoneda = nTipoMoneda;
	}
	
	
	
}
