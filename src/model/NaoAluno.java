package model;

public class NaoAluno {

	private String rg;
	private String uf;
	private String nome;
	private String email;
	private boolean emailvalido;
	private String senha;

	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEmailvalido() {
		return emailvalido;
	}
	public void setEmailvalido(boolean emailvalido) {
		this.emailvalido = emailvalido;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return this.nome;
	}
	
}
