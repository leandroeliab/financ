package entities;

import java.time.LocalDate;

public class Parcelas {

	private double valor;
	private LocalDate data; 
	private long qtdDias;
	
	public Parcelas() {
	}

	public Parcelas(double valor, LocalDate data, long qtdDias) {
		this.valor = valor;
		this.data = data;
		this.qtdDias = qtdDias;
	}
	
	public Parcelas(double valor, LocalDate data) {
		this.valor = valor;
		this.data = data;
	}
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public long getQtdDias() {
		return qtdDias;
	}

	public void setQtdDias(long qtdDias) {
		this.qtdDias = qtdDias;
	}
	
	public String toString() {
		return "Parcelas [valor=" + valor + ", data=" + data + ", qtdDias=" + qtdDias + "]";
	}
	
	
}
