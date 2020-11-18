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
@Table(name = "TipoDelivery")
public class TipoDelivery implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CTipoDelivery")
	private Long CTipoDelivery;
	
	@Column(name ="MontoTipoDelivery", nullable=false)
	private float MontoTipoDelivery;

	@OneToMany(mappedBy = "TipoDelivery", cascade = CascadeType.ALL)
	private List<Transaccion> Transacciones;
	
	
	
	public TipoDelivery() {
		Transacciones = new ArrayList<Transaccion>();
	}

	
	
	public List<Transaccion> getTransacciones() {
		return Transacciones;
	}

	public void setTransacciones(List<Transaccion> transacciones) {
		Transacciones = transacciones;
	}

	public Long getCTipoDelivery() {
		return CTipoDelivery;
	}

	public void setCTipoDelivery(Long cTipoDelivery) {
		CTipoDelivery = cTipoDelivery;
	}

	public float getMontoTipoDelivery() {
		return MontoTipoDelivery;
	}

	public void setMontoTipoDelivery(float MontoTipoDelivery) {
		this.MontoTipoDelivery = MontoTipoDelivery;
	}
	
	
	
}
