package model;

public class Sala {

	private int numero;
	private int lotacao;
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getLotacao() {
		return lotacao;
	}
	public void setLotacao(int lotacao) {
		this.lotacao = lotacao;
	}
	@Override
	public String toString() {
		return String.valueOf(this.numero);
	}
	
}
