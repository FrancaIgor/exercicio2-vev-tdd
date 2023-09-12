import java.util.List;	

public class ProcessadorBoletos {
	public static void processarBoletos(List<Boleto> boletos, Fatura fatura) {
        double totalPago = 0.0;
        
        // Verificando o total dos boletos
        for (Boleto boleto : boletos) {
            totalPago += boleto.getValorPago();
        }
        
        // Se o total pago for maior ou igual ao valor da fatura, marca como paga
        if (totalPago >= fatura.getValorTotal()) {
            fatura.marcarComoPaga();
        }
    }
}