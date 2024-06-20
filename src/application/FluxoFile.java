package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import entities.FluxoFinanceiro;
import entities.Parcelas;

public class FluxoFile {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		FluxoFinanceiro fluxo = new FluxoFinanceiro();

		String path = "C:\\temp\\fluxo.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			while (line != null) {
				
				String[] parte = line.split(";");
				
				fluxo.addParcela(new Parcelas(Double.parseDouble(parte[1]), LocalDate.parse(parte[2], sdf)));
							
				line = br.readLine();
			}
			System.out.printf("Valor XTIR :"+String.format("%.9f", fluxo.calculaXTIR()));
			System.out.println();
			System.out.printf("Valor TIR :"+String.format("%.9f", fluxo.calculaTIR()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String pathOut = "C:\\temp\\TIR.csv";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathOut))) {
			
			bw.write("Valor XTIR; Valor TIR");
			bw.newLine();
			bw.write(String.format("%.9f", fluxo.calculaXTIR())+";"+String.format("%.9f", fluxo.calculaTIR()));
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
