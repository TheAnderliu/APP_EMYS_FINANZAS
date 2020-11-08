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
@Table(name = "Tipo_Delivery")
public class Tipo_Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long CTipoDelivery;
	
	@Column(name ="monto_tipo_delivery", nullable=false)
	private float $TipoDelivery;

	@OneToMany(mappedBy = "Tipo_Delivery", cascade = CascadeType.ALL)
	private List<Transaccion> Transacciones;
	
	
	
	public Tipo_Delivery() {
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

	public float get$TipoDelivery() {
		return $TipoDelivery;
	}

	public void set$TipoDelivery(float $TipoDelivery) {
		this.$TipoDelivery = $TipoDelivery;
	}
	
	
	
}
