package entities;

public class CalculaPMT {
	
	private double valor;
	private double juros;
	private int    prazo;
	
	
	public CalculaPMT() {
	}
	
	public CalculaPMT(double valor, double juros, int prazo) {
		this.valor = valor;
		this.juros = juros;
		this.prazo = prazo;
	}
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	public double PMT() {
		
		return this.valor * Math.pow((1.0+this.juros/100.0),this.prazo)*(this.juros/100.0)/
				(Math.pow((1.0+this.juros/100.0),this.prazo)-1.0);
		
	}	

	
	
	

}
