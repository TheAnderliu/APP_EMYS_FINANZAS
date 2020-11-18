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
@Table(name = "TipoTasa")
public class TipoTasa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CTipoTasa")
	private Long CTipoTasa;
	
	@Column(name ="NTipoTasa", nullable=false)
	private String NTipoTasa;

	@OneToMany(mappedBy = "TipoTasa", cascade = CascadeType.ALL)
	private List<Linea> LineaCreditos;
	
	
	
	public TipoTasa() {
		
		LineaCreditos=new ArrayList<Linea>();
		
	}

	public List<Linea> getLineaCreditos() {
		return LineaCreditos;
	}

	public void setLineaCreditos(List<Linea> lineaCreditos) {
		LineaCreditos = lineaCreditos;
	}

	public Long getCTipoTasa() {
		return CTipoTasa;
	}

	public void setCTipoTasa(Long cTipoTasa) {
		CTipoTasa = cTipoTasa;
	}

	public String getNTipoTasa() {
		return NTipoTasa;
	}

	public void setNTipo_Tasa(String nTipoTasa) {
		NTipoTasa = nTipoTasa;
	}
	
	
	
}
