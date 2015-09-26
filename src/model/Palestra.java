package model;

public class Palestra {

	private String codigo;
	private String titulo;
	private String titulacao;
	private String palestrante;
	private String empresa;
	private int duracao;
	private String dt;
	private String hr;
	private TipoPalestra tipo;
	private Curso curso;
	private Evento evento;
	private Sala sala;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTitulacao() {
		return titulacao;
	}
	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}
	public String getPalestrante() {
		return palestrante;
	}
	public void setPalestrante(String palestrante) {
		this.palestrante = palestrante;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public String getHr() {
		return hr;
	}
	public void setHr(String hr) {
		this.hr = hr;
	}
	public TipoPalestra getTipo() {
		return tipo;
	}
	public void setTipo(TipoPalestra tipo) {
		this.tipo = tipo;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	@Override
	public String toString() {
		return this.titulo;
	}
}
