package pe.upc.finanzas.entity;

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
public class Linea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long CLinea;
	
	@NotNull(message = "Debe ingresar fecha*")
	@Temporal(TemporalType.DATE)	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name="fecha_emision", nullable=false)
	private Date DFechaEmision;
	
	@Column(name="numero_mantenimiento", nullable=false)
	private float NumMantenimiento;
	
	@NotEmpty(message = "Debe ingresar el límite del crédito*")
	@Column(name="credito", nullable=false)
	private int $Credito;
	
	@NotEmpty(message = "Debe ingresar el porcentaje de la tasa*")
	@Column(name="porcentaje_tasa")
	private float NTasa;
	
	@NotEmpty(message = "Debe ingresar el número de días de la capitalización*")
	@Column(name="capitalizacion_dias", nullable=false)
	private int NCapitalizacion;
	
	@Column(name="dias_año", nullable=false)
	private int NumAnio;
	
	
/*	@OneToOne(mappedBy = "Linea")
    private Cliente Cliente;
*/	
	@OneToOne
	@JoinColumn(name = "cliente_id")
	private Cliente Cliente;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="administrador_id")
	private Administrador Administrador;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tipo_moneda_id")
	private TipoMoneda TipoMoneda;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tipo_mantenimiento_id")
	private TipoMantenimiento TipoMantenimiento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tipo_tasa_id")
	private Tipo_Tasa Tipo_Tasa;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="periodo_tasa_id")
	private Periodo_Tasa Periodo_Tasa;

	@OneToMany(mappedBy = "Linea", cascade = CascadeType.ALL)
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



	public Tipo_Tasa getTipo_Tasa() {
		return Tipo_Tasa;
	}



	public void setTipo_Tasa(Tipo_Tasa tipo_Tasa) {
		Tipo_Tasa = tipo_Tasa;
	}



	public Periodo_Tasa getPeriodo_Tasa() {
		return Periodo_Tasa;
	}



	public void setPeriodo_Tasa(Periodo_Tasa periodo_Tasa) {
		Periodo_Tasa = periodo_Tasa;
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
