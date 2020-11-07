package pe.upc.finanzas.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Administrador")
public class Administrador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CAdministrador;
	
	@Column(name="nombres_apellidos", length = 50, nullable=false)
	private String NAdministrador;
	
	@Column(name="correo_electronico", length=30, nullable=false)
	private String NCorreo;
	
	@Column(name="contraseña", length=10, nullable=false)
	private String NContrasenia;
	
	@OneToMany(mappedBy = "administrador")
	private List<Linea> LineaCreditos;
	
	
	public Administrador() {
		
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
