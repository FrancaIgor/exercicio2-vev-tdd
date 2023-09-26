import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcessadorBoletosTest {
    
	//Testando a soma dos boletos ultrapassa a fatura
	@Test
    public void testProcessarBoletosFaturaPaga() throws ValorNegativoException, ValorInsuficienteException {
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(new Boleto("001", new Date(), 500.0));
        boletos.add(new Boleto("002", new Date(), 400.0));
        boletos.add(new Boleto("003", new Date(), 600.0));

        Fatura fatura = new Fatura(new Date(), 1500.0, "Cliente Teste");

        ProcessadorBoletos.processarBoletos(boletos, fatura);

        assertTrue(fatura.estaPaga());
    }
	
	//Testando a soma dos boletos nao ultrapassando a fatura
    @Test
    public void testProcessarBoletosFaturaNaoPaga() throws ValorNegativoException, ValorInsuficienteException {
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(new Boleto("001", new Date(), 300.0));
        boletos.add(new Boleto("002", new Date(), 200.0));

        Fatura fatura = new Fatura(new Date(), 600.0, "Cliente Teste");

        ProcessadorBoletos.processarBoletos(boletos, fatura);

        assertFalse(fatura.estaPaga());
    }
}