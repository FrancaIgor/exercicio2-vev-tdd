import java.util.List;	

public class ProcessadorBoletos {
	public static void processarBoletos(List<Boleto> boletos, Fatura fatura) throws ValorNegativoException, ValorInsuficienteException {
        double totalPago = 0.0;
        
        // Verificando o total dos boletos
        for (Boleto boleto : boletos) {
            double valorPago = boleto.getValorPago();
            
            if (valorPago < 0) {
                throw new ValorNegativoException("Valor pago negativo encontrado: " + valorPago);
            }
            
            totalPago += valorPago;
        }
        
        // Se o total pago for maior ou igual ao valor da fatura, marca como paga
        if (totalPago >= fatura.getValorTotal()) {
            fatura.marcarComoPaga();
        } else {
            throw new ValorInsuficienteException("Valor total dos boletos é menor que o valor da fatura");
        }
    }
}