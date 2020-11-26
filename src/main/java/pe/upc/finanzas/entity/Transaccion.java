package pe.upc.finanzas.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Transaccion")
public class Transaccion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CTransaccion")
	private Long CTransaccion;
	
	@NotEmpty(message = "Debe ingresar una descripción")
	@Column(name ="TDescripcion", nullable=false)
	private String TDescripcion;
	
	@NotNull(message = "Debe ingresar fecha*")
	@Temporal(TemporalType.DATE)	
	@DateTimeFormat(pattern = "yy-MM-dd")
	@Column(name ="DFecha", nullable=false)
	private Date DFecha;
	
	@NotNull(message = "Debe ingresar un monto")
	@Column(name ="Monto", nullable=false)
	private float Monto;
	
	@Column(name ="BTipo", nullable=false)
	private boolean BTipo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tipodelivery_id")
	private TipoDelivery TipoDelivery;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="linea_id")
	private Linea linea;

	
	public TipoDelivery getTipoDelivery() {
		return TipoDelivery;
	}

	public void setTipoDelivery(TipoDelivery tipoDelivery) {
		TipoDelivery = tipoDelivery;
	}

	
	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	public Long getCTransaccion() {
		return CTransaccion;
	}

	public void setCTransaccion(Long cTransaccion) {
		CTransaccion = cTransaccion;
	}

	public String getTDescripcion() {
		return TDescripcion;
	}

	public void setTDescripcion(String tDescripcion) {
		TDescripcion = tDescripcion;
	}

	public Date getDFecha() {
		return DFecha;
	}

	public void setDFecha(Date dFecha) {
		DFecha = dFecha;
	}

	public float getMonto() {
		return Monto;
	}

	public void setMonto(float Monto) {
		this.Monto = Monto;
	}

	public boolean isBTipo() {
		return BTipo;
	}

	public void setBTipo(boolean bTipo) {
		BTipo = bTipo;
	}
	
	
	

}
