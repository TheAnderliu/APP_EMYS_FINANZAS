package pe.upc.finanzas.entity;

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
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Transaccion")
public class Transaccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long CTransacción;
	
	
	@Column(name ="descripcion", nullable=false)
	private String TDescripción;
	
	@NotNull(message = "Debe ingresar fecha*")
	@Temporal(TemporalType.DATE)	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name ="fecha", nullable=false)
	private Date DFecha;
	
	@Column(name ="monto", nullable=false)
	private float $Monto;
	
	@Column(name ="tipo", nullable=false)
	private boolean BTipo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tipo_delivery_id")
	private Tipo_Delivery Tipo_Delivery;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="linea_id")
	private Linea Linea;

	
	public Tipo_Delivery getTipo_Delivery() {
		return Tipo_Delivery;
	}

	public void setTipo_Delivery(Tipo_Delivery tipo_Delivery) {
		Tipo_Delivery = tipo_Delivery;
	}

	public Linea getLinea() {
		return Linea;
	}

	public void setLinea(Linea linea) {
		Linea = linea;
	}

	public Long getCTransacción() {
		return CTransacción;
	}

	public void setCTransacción(Long cTransacción) {
		CTransacción = cTransacción;
	}

	public String getTDescripción() {
		return TDescripción;
	}

	public void setTDescripción(String tDescripción) {
		TDescripción = tDescripción;
	}

	public Date getDFecha() {
		return DFecha;
	}

	public void setDFecha(Date dFecha) {
		DFecha = dFecha;
	}

	public float get$Monto() {
		return $Monto;
	}

	public void set$Monto(float $Monto) {
		this.$Monto = $Monto;
	}

	public boolean isBTipo() {
		return BTipo;
	}

	public void setBTipo(boolean bTipo) {
		BTipo = bTipo;
	}
	
	
	

}
