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
@Table(name = "PeriodoTasa")
public class PeriodoTasa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CPeriodoTasa")
	private Long CPeriodoTasa;
	
	@Column(name ="NPeriodoTasa", nullable=false)
	private String NPeriodoTasa;
	
	
	@Column(name ="NumPeriodoTasa", nullable=false)
	private int NumPeriodoTasa;
	
	@OneToMany(mappedBy = "PeriodoTasa", cascade = CascadeType.ALL)
	private List<Linea> LineaCreditos;

	
	
	public PeriodoTasa() {
		LineaCreditos=new ArrayList<Linea>();
	}

	public List<Linea> getLineaCreditos() {
		return LineaCreditos;
	}

	public void setLineaCreditos(List<Linea> lineaCreditos) {
		LineaCreditos = lineaCreditos;
	}

	public Long getCPeriodoTasa() {
		return CPeriodoTasa;
	}

	public void setCPeriodoTasa(Long cPeriodoTasa) {
		CPeriodoTasa = cPeriodoTasa;
	}

	public String getNPeriodoTasa() {
		return NPeriodoTasa;
	}

	public void setNPeriodoTasa(String nPeriodoTasa) {
		NPeriodoTasa = nPeriodoTasa;
	}

	public int getNumPeriodoTasa() {
		return NumPeriodoTasa;
	}

	public void setNumPeriodoTasa(int numPeriodoTasa) {
		NumPeriodoTasa = numPeriodoTasa;
	}
	
	
	
}
