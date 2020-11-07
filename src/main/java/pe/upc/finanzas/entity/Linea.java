package pe.upc.finanzas.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Linea")
public class Linea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CLinea;
	
	private Date DFechaEmision;
	
	private float NumMantenimiento;
	
	private int $Credito;
	
	private float NTasa;
	
	private int NCapitalizacion;
	
	private int NumAnio;

	public Long getCLinea() {
		return CLinea;
	}

	public void setCLinea(Long cLinea) {
		CLinea = cLinea;
	}

	public Date getDFechaEmision() {
		return DFechaEmision;
	}

	public void setDFechaEmision(Date dFechaEmision) {
		DFechaEmision = dFechaEmision;
	}

	public float getNumMantenimiento() {
		return NumMantenimiento;
	}

	public void setNumMantenimiento(float numMantenimiento) {
		NumMantenimiento = numMantenimiento;
	}

	public int get$Credito() {
		return $Credito;
	}

	public void set$Credito(int $Credito) {
		this.$Credito = $Credito;
	}

	public float getNTasa() {
		return NTasa;
	}

	public void setNTasa(float nTasa) {
		NTasa = nTasa;
	}

	public int getNCapitalizacion() {
		return NCapitalizacion;
	}

	public void setNCapitalizacion(int nCapitalizacion) {
		NCapitalizacion = nCapitalizacion;
	}

	public int getNumAnio() {
		return NumAnio;
	}

	public void setNumAnio(int numAnio) {
		NumAnio = numAnio;
	}
	
	
	
}
