package pe.upc.finanzas.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sistema implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long CSistema;
	
	private float DeudaTotalSinIntereses;
	
	private float DeudaTotal;
	
	private float InteresesGenerados;
	
	private float CreditoDisponible;

	
	
	public Sistema() {
		super();
		CSistema=(long)1;
	}

	public float getDeudaTotalSinIntereses() {
		return DeudaTotalSinIntereses;
	}

	public void setDeudaTotalSinIntereses(float deudaTotalSinIntereses) {
		DeudaTotalSinIntereses = deudaTotalSinIntereses;
	}

	public float getDeudaTotal() {
		return DeudaTotal;
	}

	public void setDeudaTotal(float deudaTotal) {
		DeudaTotal = deudaTotal;
	}

	public float getInteresesGenerados() {
		return InteresesGenerados;
	}

	public void setInteresesGenerados(float interesesGenerados) {
		InteresesGenerados = interesesGenerados;
	}

	public float getCreditoDisponible() {
		return CreditoDisponible;
	}

	public void setCreditoDisponible(float creditoDisponible) {
		CreditoDisponible = creditoDisponible;
	}
	
	
	
	
}
