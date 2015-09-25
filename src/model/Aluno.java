package model;

public class Aluno {

	private String ra;
	private String nome;
	private String email;
	private boolean emailvalido;
	private String senha;
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
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
