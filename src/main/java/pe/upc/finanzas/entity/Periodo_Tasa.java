package pe.upc.finanzas.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Periodo_Tasa")
public class Periodo_Tasa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Long CPeriodo_Tasa;
	
	@Column(name ="nombre_periodo_tasa", nullable=false)
	private String NPeriodo_Tasa;
	
	
	@Column(name ="numero_periodo_tasa", nullable=false)
	private int NumPeriodo_Tasa;
	
	@OneToMany(mappedBy = "Periodo_Tasa", cascade = CascadeType.ALL)
	private List<Linea> LineaCreditos;

	
	
	public Periodo_Tasa() {
		LineaCreditos=new ArrayList<Linea>();
	}

	public List<Linea> getLineaCreditos() {
		return LineaCreditos;
	}

	public void setLineaCreditos(List<Linea> lineaCreditos) {
		LineaCreditos = lineaCreditos;
	}

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
