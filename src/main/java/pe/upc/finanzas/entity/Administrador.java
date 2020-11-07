package pe.upc.finanzas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Administrador")
public class Administrador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CAdministrador;
	
	private String NAdministrador;
	
	private String NCorreo;
	
	private String NContrasenia;

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
