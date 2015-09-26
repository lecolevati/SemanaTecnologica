package model;

public class DataEvento {

	private Evento evento;
	private String dtEvento;
	private String dtConvertida;
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public String getDtEvento() {
		return dtEvento;
	}
	public void setDtEvento(String dtEvento) {
		this.dtEvento = dtEvento;
	}
	public String getDtConvertida() {
		return dtConvertida;
	}
	public void setDtConvertida(String dtConvertida) {
		this.dtConvertida = dtConvertida;
	}
	@Override
	public String toString() {
		return this.dtEvento;
	}
	
	
}
