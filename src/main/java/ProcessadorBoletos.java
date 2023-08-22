import java.util.List;	

public class ProcessadorBoletos {
    public static void processarBoletos(List<Boleto> boletos, Fatura fatura) {
        double totalPago = 0.0;

        for (Boleto boleto : boletos) {
            totalPago += boleto.getValorPago();
            if (totalPago >= fatura.getValorTotal()) {
                fatura.marcarComoPaga();
            }
            fatura.estaPaga();
        }

        
    }
}