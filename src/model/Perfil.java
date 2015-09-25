package model;

public class Perfil {

	private int codigo;
	private String perfil;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	@Override
	public String toString() {
		return this.perfil;
	}
	
}
