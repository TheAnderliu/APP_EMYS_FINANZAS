package pe.upc.finanzas.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transaccion")
public class Transaccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CTransacción;
	
	private String TDescripción;
	
	private Date DFecha;
	
	private float $Monto;
	
	private boolean BTipo;

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
