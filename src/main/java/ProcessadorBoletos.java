import java.util.List;	

public class ProcessadorBoletos {
    public static void processarBoletos(List<Boleto> boletos, Fatura fatura) {
        double totalPago = 0.0;
        
        //Verificando se a fatura pode ser paga
        for (Boleto boleto : boletos) {
            totalPago += boleto.getValorPago();
            if (totalPago >= fatura.getValorTotal()) {
                fatura.marcarComoPaga();
            }
            //Retorna o estado atual da fatura
            fatura.estaPaga();
        }

        
    }
}