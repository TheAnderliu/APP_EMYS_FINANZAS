package pe.upc.finanzas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Periodo_Tasa")
public class Periodo_Tasa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CPeriodo_Tasa;
	
	private String NPeriodo_Tasa;
	
	private int NumPeriodo_Tasa;

	public Long getCPeriodo_Tasa() {
		return CPeriodo_Tasa;
	}

	public void setCPeriodo_Tasa(Long cPeriodo_Tasa) {
		CPeriodo_Tasa = cPeriodo_Tasa;
	}

	public String getNPeriodo_Tasa() {
		return NPeriodo_Tasa;
	}

	public void setNPeriodo_Tasa(String nPeriodo_Tasa) {
		NPeriodo_Tasa = nPeriodo_Tasa;
	}

	public int getNumPeriodo_Tasa() {
		return NumPeriodo_Tasa;
	}

	public void setNumPeriodo_Tasa(int numPeriodo_Tasa) {
		NumPeriodo_Tasa = numPeriodo_Tasa;
	}
	
	
	
}
