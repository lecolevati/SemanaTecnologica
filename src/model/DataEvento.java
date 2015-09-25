package model;

public class DataEvento {

	private Evento evento;
	private String dtEvento;
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
	@Override
	public String toString() {
		return this.dtEvento;
	}
	
	
}
