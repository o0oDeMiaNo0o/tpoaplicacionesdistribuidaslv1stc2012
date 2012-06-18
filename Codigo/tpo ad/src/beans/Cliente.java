package beans;

import vistasbeans.ClienteVista;

public class Cliente {

	private String condIVA;
	private String CUIT;
	private String direccion;
	private String razonSocial;
	public String getCondIVA() {
		return condIVA;
	}
	public void setCondIVA(String condIVA) {
		this.condIVA = condIVA;
	}
	public String getCUIT() {
		return CUIT;
	}
	public void setCUIT(String cUIT) {
		CUIT = cUIT;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	public ClienteVista getVista(){
		ClienteVista vista=new ClienteVista();
		vista.setCondIVA(condIVA);
		vista.setCUIT(CUIT);
		vista.setDireccion(direccion);
		vista.setRazonSocial(razonSocial);		
		return vista;		
	}
	
}
