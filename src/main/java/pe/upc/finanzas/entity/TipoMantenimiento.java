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
@Table(name = "TipoMantenimiento")
public class TipoMantenimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long CTipoMantenimiento;
	
	@Column(name="nombre_tipo_mantenimiento", nullable=false)
	private String NTipoMantenimiento;
	
	@Column(name ="numero_tipo_mantenimiento", nullable=false)
	private int NumTipoMantenimiento;
	
	@OneToMany(mappedBy = "TipoMantenimiento", cascade = CascadeType.ALL)
	private List<Linea> LineaCreditos;

	
	
	public TipoMantenimiento() {
		LineaCreditos=new ArrayList<Linea>();
	}

	public List<Linea> getLineaCreditos() {
		return LineaCreditos;
	}

	public void setLineaCreditos(List<Linea> lineaCreditos) {
		LineaCreditos = lineaCreditos;
	}

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
