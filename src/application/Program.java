package application;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import entities.FluxoFinanceiro;
import entities.Parcelas;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Parcelas parcela = new Parcelas();
		
		FluxoFinanceiro fluxo = new FluxoFinanceiro();
		
		System.out.print("Entre com a quantidade de parcelas: ");		
		int quantidadeParcelas = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Entre com o primeiro valor: ");
		
		double valor = sc.nextDouble();
		
		
		System.out.print("Entre com o valor das parcelas: ");
		double valorParcelas = sc.nextDouble();
		
		System.out.print("Entre a data do contrato: ");	
		LocalDate dataInic = LocalDate.parse(sc.next());
		LocalDate data;
		
		parcela = new Parcelas(valor, dataInic);
		fluxo.addParcela(parcela);		
		
		for (int i=0; i < quantidadeParcelas; i++) {				
			data = dataInic.plusMonths(i+1);
			parcela = new Parcelas(valorParcelas, data);
			fluxo.addParcela(parcela);				
		}

		System.out.printf("Valor XTIR :"+String.format("%.9f", fluxo.calculaXTIR()));
		System.out.println();
		System.out.printf("Valor TIR :"+String.format("%.9f", fluxo.calculaTIR()));
	
		sc.close();
	}
}
