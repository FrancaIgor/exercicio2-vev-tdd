import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ParticoesEquivalenciaTest {
	@Test
    public void testeValorNegativo() {
        List<Boleto> boletos = new ArrayList<>();
        Fatura fatura = new Fatura(new Date(), -100.0, "Cliente Teste");
        ProcessadorBoletos.processarBoletos(boletos, fatura);
        // Verifique o tratamento de erro, por exemplo, exceção lançada ou mensagem de erro.
    }

    @Test
    public void testeValorZero() {
        List<Boleto> boletos = new ArrayList<>();
        Fatura fatura = new Fatura(new Date(), 0.0, "Cliente Teste");
        ProcessadorBoletos.processarBoletos(boletos, fatura);
        assertTrue(fatura.estaPaga());
    }

    @Test
    public void testeValorPositivoMenor() {
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(new Boleto("001", new Date(), 1000.0));
        Fatura fatura = new Fatura(new Date(), 1500.0, "Cliente Teste");
        ProcessadorBoletos.processarBoletos(boletos, fatura);
        assertFalse(fatura.estaPaga());
    }
}
