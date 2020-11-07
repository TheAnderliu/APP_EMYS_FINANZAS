package pe.upc.finanzas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CCliente;
	
	@Column(name="apellidos", length = 50, nullable=false)
	private String NApellido;
	
	@Column(name="nombres", length=50, nullable=false)
	private String NNombre;
	
	@Column(name="numero_dni", nullable=false)
	private int NumDNI;
	
	@Column(name="numero_telefono", nullable=false)
	private int NumTelefono;
	
	@Column(name="estado_cliente", nullable=false)
	private boolean BEstado;
	
	@OneToOne(mappedBy = "linea")
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
