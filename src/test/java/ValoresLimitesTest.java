import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class ValoresLimitesTest {
	@Test
    public void testeValorLimiteZero() {
        List<Boleto> boletos = new ArrayList<>();
        Fatura fatura = new Fatura(new Date(), 0.0, "Cliente Teste");
        ProcessadorBoletos.processarBoletos(boletos, fatura);
        assertTrue(fatura.estaPaga());
    }

    @Test
    public void testeValorLimiteIgual() {
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(new Boleto("001", new Date(), 1500.0));
        Fatura fatura = new Fatura(new Date(), 1500.0, "Cliente Teste");
        ProcessadorBoletos.processarBoletos(boletos, fatura);
        assertTrue(fatura.estaPaga());
    }

    @Test
    public void testeValorLimiteMenor() {
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(new Boleto("001", new Date(), 1499.0));
        Fatura fatura = new Fatura(new Date(), 1500.0, "Cliente Teste");
        ProcessadorBoletos.processarBoletos(boletos, fatura);
        assertFalse(fatura.estaPaga());
    }
}
