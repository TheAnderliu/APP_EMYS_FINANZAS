package pe.upc.finanzas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tipo_Delivery")
public class Tipo_Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CTipoDelivery;
	
	private float $TipoDelivery;

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
