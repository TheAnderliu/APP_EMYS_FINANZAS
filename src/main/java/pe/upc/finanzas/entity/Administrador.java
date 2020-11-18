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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Administrador")
public class Administrador implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	/*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
	@Column(name = "CAdministrador")
	private Long CAdministrador;
	
	
	@Column(name="NAdministrador", length = 50, nullable=false)
	private String NAdministrador;
	
	@NotEmpty(message = "Debe Ingresar correo eletrónico*")
	@Email(message = "Ingrese un verdadero correo electrónico*")
	@Column(name="NCorreo", length=30, nullable=false)
	private String NCorreo;
	
	@NotEmpty(message = "Debe ingresar contraseña*")
	@Column(name="NContrasenia", length=10, nullable=false)
	private String NContrasenia;
	
	@OneToMany(mappedBy = "Administrador", cascade = CascadeType.ALL)
	private List<Linea> LineaCreditos;
	
	
	public Administrador() {
		
		CAdministrador=(long)2;
		NAdministrador="George Gutierrez";
		NCorreo="huneterhot@gmail.com";
		NContrasenia="123";
		
		
		LineaCreditos=new ArrayList<Linea>();
	}

	public List<Linea> getLineaCreditos() {
		return LineaCreditos;
	}

	public void setLineaCreditos(List<Linea> lineaCreditos) {
		LineaCreditos = lineaCreditos;
	}

	public Long getCAdministrador() {
		return CAdministrador;
	}

	public void setCAdministrador(Long cAdministrador) {
		CAdministrador = cAdministrador;
	}

	public String getNAdministrador() {
		return NAdministrador;
	}

	public void setNAdministrador(String nAdministrador) {
		NAdministrador = nAdministrador;
	}

	public String getNCorreo() {
		return NCorreo;
	}

	public void setNCorreo(String nCorreo) {
		NCorreo = nCorreo;
	}

	public String getNContrasenia() {
		return NContrasenia;
	}

	public void setNContrasenia(String nContrasenia) {
		NContrasenia = nContrasenia;
	}
	
	
	
}
