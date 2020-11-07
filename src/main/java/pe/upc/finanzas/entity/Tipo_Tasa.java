package pe.upc.finanzas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tipo_Tasa")
public class Tipo_Tasa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CTipo_Tasa;
	
	private String NTipo_Tasa;

	public Long getCTipo_Tasa() {
		return CTipo_Tasa;
	}

	public void setCTipo_Tasa(Long cTipo_Tasa) {
		CTipo_Tasa = cTipo_Tasa;
	}

	public String getNTipo_Tasa() {
		return NTipo_Tasa;
	}

	public void setNTipo_Tasa(String nTipo_Tasa) {
		NTipo_Tasa = nTipo_Tasa;
	}
	
	
	
}
