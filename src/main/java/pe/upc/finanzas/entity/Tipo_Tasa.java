package pe.upc.finanzas.entity;

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
@Table(name = "Tipo_Tasa")
public class Tipo_Tasa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long CTipo_Tasa;
	
	@Column(name ="nombre_tipo_tasa", nullable=false)
	private String NTipo_Tasa;

	@OneToMany(mappedBy = "Tipo_Tasa", cascade = CascadeType.ALL)
	private List<Linea> LineaCreditos;
	
	
	
	public Tipo_Tasa() {
		
		LineaCreditos=new ArrayList<Linea>();
		
	}

	public List<Linea> getLineaCreditos() {
		return LineaCreditos;
	}

	public void setLineaCreditos(List<Linea> lineaCreditos) {
		LineaCreditos = lineaCreditos;
	}

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
