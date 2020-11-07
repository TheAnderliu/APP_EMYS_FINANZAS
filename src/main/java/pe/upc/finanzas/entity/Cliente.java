package pe.upc.finanzas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CCliente;
	
	private String NApellido;
	
	private String NNombre;
	
	private int NumDNI;
	
	private int NumTelefono;
	
	private boolean BEstado;

	public Long getCCliente() {
		return CCliente;
	}

	public void setCCliente(Long cCliente) {
		CCliente = cCliente;
	}

	public String getNApellido() {
		return NApellido;
	}

	public void setNApellido(String nApellido) {
		NApellido = nApellido;
	}

	public String getNNombre() {
		return NNombre;
	}

	public void setNNombre(String nNombre) {
		NNombre = nNombre;
	}

	public int getNumDNI() {
		return NumDNI;
	}

	public void setNumDNI(int numDNI) {
		NumDNI = numDNI;
	}

	public int getNumTelefono() {
		return NumTelefono;
	}

	public void setNumTelefono(int numTelefono) {
		NumTelefono = numTelefono;
	}

	public boolean isBEstado() {
		return BEstado;
	}

	public void setBEstado(boolean bEstado) {
		BEstado = bEstado;
	}
	
	

}
