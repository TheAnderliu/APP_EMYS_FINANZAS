package pe.upc.finanzas.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
@Table(name = "Cliente")
public class Cliente {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long CCliente;
	

	@NotEmpty(message = "Debe ingresar apellidos*")
	@Column(name="apellidos", length = 50, nullable=false)
	private String NApellido;
	

	@NotEmpty(message = "Debe ingresar nombres*")
	@Column(name="nombres", length=50, nullable=false)
	private String NNombre;
	
	@Size(min = 8, max = 8)
	@NotEmpty(message = "Debe ingresar DNI")
	@Column(name="numero_dni", nullable=false, length = 8)
	private String NumDNI;
	
	@NotEmpty(message = "Debe ingresar un número de teléfono")
	@Column(name="numero_telefono", nullable=false)
	private int NumTelefono;
	
	
	@Column(name="estado_cliente", nullable=false)
	private boolean BEstado;
	
	/*
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "linea_id", referencedColumnName = "id")
    private Linea Linea;
	*/
	
	@OneToOne(mappedBy = "Cliente", cascade = CascadeType.ALL)
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
		return NumDNI;
	}

	public void setNumDNI(String numDNI) {
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
