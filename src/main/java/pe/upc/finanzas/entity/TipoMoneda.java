package pe.upc.finanzas.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TipoMoneda")
public class TipoMoneda implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CTipoMoneda")
	private Long CTipoMoneda;
	
	@Column(name ="NTipoMoneda", nullable=false)
	private String NTipoMoneda;
	
	@OneToMany(mappedBy = "TipoMoneda", cascade = CascadeType.ALL)
	private List<Linea> LineaCreditos;

	
	
	public TipoMoneda() {
		
		LineaCreditos=new ArrayList<Linea>();
	}

	public List<Linea> getLineaCreditos() {
		return LineaCreditos;
	}

	public void setLineaCreditos(List<Linea> lineaCreditos) {
		LineaCreditos = lineaCreditos;
	}

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
