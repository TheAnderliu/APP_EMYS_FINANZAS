package pe.upc.finanzas.service;


import java.util.Date;
import java.util.List;

import pe.upc.finanzas.entity.Cliente;

public interface IClienteService {

	public Integer save(Cliente cliente);
	
	public void update(Cliente cliente);
	
	public void delete(Cliente cliente);
	
	public Cliente findByID(Long CCliente);
	
	public List<Cliente> findAll();
	
	public Cliente findByNumTelefono(int NumTelefono);
	
	public Cliente findByNumDNI(String NumDNI);
	
	public List<Cliente> encontrarClientesDeudores(Date FechaActual);
	
	public int cantidadClientes();
	
	public int cantidadClientesDeudores();
}
