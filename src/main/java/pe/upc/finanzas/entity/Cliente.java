package pe.upc.finanzas.entity;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CCliente")
	private Long CCliente;
	

	@NotEmpty(message = "Debe ingresar apellidos*")
	@Column(name="NApellido", length = 50, nullable=false)
	private String NApellido;
	

	@NotEmpty(message = "Debe ingresar nombres*")
	@Column(name="NNombre", length=50, nullable=false)
	private String NNombre;
	
	@Size(min = 8, max = 8)
	@NotEmpty(message = "Debe ingresar DNI")
	@Column(name="numDNI", nullable=false, length = 8)
	private String numDNI;
	
	@NotNull(message = "Debe ingresar un número de teléfono")
	@Column(name="numTelefono", nullable=false)
	private int numTelefono;
	
	
	@Column(name="BEstado", nullable=false)
	private boolean BEstado;
	
	/*
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "linea_id", referencedColumnName = "id")
    private Linea Linea;
	*/
	
	@OneToOne(mappedBy = "Cliente", fetch= FetchType.LAZY )
	private Linea Linea;
	
	public Cliente() {
		this.BEstado=true;
		
	}
	
	
	public Linea getLinea() {
		return Linea;
	}


	public void setLinea(Linea linea) {
		Linea = linea;
	}


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



	public String getNumDNI() {
		return numDNI;
	}


	public void setNumDNI(String numDNI) {
		this.numDNI = numDNI;
	}


	public int getNumTelefono() {
		return numTelefono;
	}


	public void setNumTelefono(int numTelefono) {
		this.numTelefono = numTelefono;
	}


	public boolean isBEstado() {
		return BEstado;
	}

	public void setBEstado(boolean bEstado) {
		BEstado = bEstado;
	}


	
	
	

}
