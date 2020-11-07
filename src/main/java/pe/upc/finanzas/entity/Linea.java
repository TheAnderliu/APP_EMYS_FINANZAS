package pe.upc.finanzas.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "lineas")
public class Linea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CLinea;
	
	@Column(name="fecha_emision", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date DFechaEmision;
	
	@Column(name="numero_mantenimiento", nullable=false)
	private float NumMantenimiento;
	
	@Column(name="credito", nullable=false)
	private int $Credito;
	
	@Column(name="tasa%")
	private float NTasa;
	
	@Column(name="capitalizacion_dias", nullable=false)
	private int NCapitalizacion;
	
	@Column(name="dias_año", nullable=false)
	private int NumAnio;
	
	
	@OneToOne(mappedBy = "linea")
    private Cliente Cliente;
	
	
	@ManyToOne
	@JoinColumn(name="administrador_id")
	private Administrador Administrador;
	
	public Linea() {
		this.NumMantenimiento=2.5f;
		this.NumAnio=360;
		
	}
	

	public Cliente getCliente() {
		return Cliente;
	}


	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}


	public Administrador getAdministrador() {
		return Administrador;
	}


	public void setAdministrador(Administrador administrador) {
		Administrador = administrador;
	}


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
