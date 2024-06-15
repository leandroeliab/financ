package entities;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FluxoFinanceiro {

	private List<Parcelas> fluxo = new ArrayList<>();

	public FluxoFinanceiro() {
	}

	public List<Parcelas> getFluxo() {
		return fluxo;
	}
	
	public double calculaXTIR() {
		
		double soma = 0;

		int i = 0;
		LocalDate dataInicial = LocalDate.parse("1900-01-01");
				
		for (Parcelas p : fluxo) {
	
			if (i == 0) {
				dataInicial = p.getData();
			}
					
			soma += p.getValor();
			
			Duration t1 = Duration.between( dataInicial.atStartOfDay(), p.getData().atStartOfDay());
		    i++;
		    p.setQtdDias(t1.toDays());
		    	    		    
		}
		
	 	double tirAtual = 0.0;
		double tirAnterior = 2.0;
		int modificador = (soma > 0.0) ? 1 : -1;
		
		i = 1;
				
		do {
			
			soma = 0;

			for (Parcelas p : fluxo) {	
								
				soma += (p.getValor()*modificador) / ( Math.pow(1.0+tirAtual, p.getQtdDias() / 365.0 ) );		
				
   		    }
         	
			double tirAjuste = Math.abs((tirAnterior-tirAtual)/2);
			tirAnterior = tirAtual;	
			tirAtual = (soma < 0.0) ? tirAtual - tirAjuste : tirAtual + tirAjuste;
		
		} while (++i <= 100 && Math.abs(soma) > 0.00001);
		
		return ( i>=100 ) ? 0.0 : tirAtual;	
	}

	public double calculaTIR() {
		
		double soma = 0;
				
		for (Parcelas p : fluxo) {
					
			soma += p.getValor();
					    	    		    
		}
		
	 	double tirAtual = 0.0;
		double tirAnterior = 2.0;
		int modificador = (soma > 0.0) ? 1 : -1;
		
		int i = 0;
		int j = 0;		
		do {
			
			soma = 0;
			j = 0;

			for (Parcelas p : fluxo) {	
								
				soma += (p.getValor()*modificador) / ( Math.pow(1.0+tirAtual,j ) );		
				j++;
   		    }
         	
			double tirAjuste = Math.abs((tirAnterior-tirAtual)/2);
			tirAnterior = tirAtual;	
			tirAtual = (soma < 0.0) ? tirAtual - tirAjuste : tirAtual + tirAjuste;
		
		} while (++i <= 100 && Math.abs(soma) > 0.00001);
		
		return ( i>=100 ) ? 0.0 : tirAtual;	
	}

	public void addParcela(Parcelas parcela) {
		fluxo.add(parcela);
	}
	
	public void removeParcela(Parcelas parcela) {
		fluxo.remove(parcela);
	}
}
