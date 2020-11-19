package pe.upc.finanzas.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Linea")
public class Linea implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLinea")
	private Long CLinea;
	
	@NotNull(message = "Debe ingresar fecha*")
	@Temporal(TemporalType.DATE)	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="DFechaEmision")
	private Date DFechaEmision;
	
	@Column(name="NumMantenimiento", nullable=false)
	private float NumMantenimiento;
	
	@NotNull(message = "Debe ingresar el límite del crédito*")
	@Column(name="NumCredito", nullable=false)
	private int NumCredito;
	
	@NotNull(message = "Debe ingresar el porcentaje de la tasa*")
	@Column(name="NTasa")
	private float NTasa;
	
	@NotNull(message = "Debe ingresar el número de días de la capitalización*")
	@Column(name="NCapitalizacion", nullable=false)
	private int NCapitalizacion;
	
	@Column(name="NumAnio", nullable=false)
	private int NumAnio;
	
	
/*	@OneToOne(mappedBy = "Linea")
    private Cliente Cliente;
*/	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id")
	private Cliente Cliente;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="administrador_id")
	private Administrador Administrador;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tipomoneda_id")
	private TipoMoneda TipoMoneda;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tipomantenimiento_id")
	private TipoMantenimiento TipoMantenimiento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tipotasa_id")
	private TipoTasa TipoTasa;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="periodotasa_id")
	private PeriodoTasa PeriodoTasa;

	@OneToMany(mappedBy = "linea", cascade = CascadeType.ALL)
	private List<Transaccion> Transacciones;

	public Linea() {
		this.NumMantenimiento=2.5f;
		this.NumAnio=360;
		Transacciones = new ArrayList<Transaccion>();
		
	}
	
	
	
	public List<Transaccion> getTransacciones() {
		return Transacciones;
	}



	public void setTransacciones(List<Transaccion> transacciones) {
		Transacciones = transacciones;
	}



	public TipoMantenimiento getTipoMantenimiento() {
		return TipoMantenimiento;
	}



	public void setTipoMantenimiento(TipoMantenimiento tipoMantenimiento) {
		TipoMantenimiento = tipoMantenimiento;
	}





	public TipoTasa getTipoTasa() {
		return TipoTasa;
	}



	public void setTipoTasa(TipoTasa tipoTasa) {
		TipoTasa = tipoTasa;
	}



	



	public PeriodoTasa getPeriodoTasa() {
		return PeriodoTasa;
	}



	public void setPeriodoTasa(PeriodoTasa periodoTasa) {
		PeriodoTasa = periodoTasa;
	}



	public TipoMoneda getTipoMoneda() {
		return TipoMoneda;
	}


	public void setTipoMoneda(TipoMoneda tipoMoneda) {
		TipoMoneda = tipoMoneda;
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

	public int getNumCredito() {
		return NumCredito;
	}

	public void setNumCredito(int NumCredito) {
		this.NumCredito = NumCredito;
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
