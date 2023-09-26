import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class TabelasDeDecisaoTest {
	
	 @Test
	    public void testeValorNegativo() throws ValorNegativoException, ValorInsuficienteException {
	        List<Boleto> boletos = new ArrayList<>();
	        Fatura fatura = new Fatura(new Date(), -100.0, "Cliente Teste");
	        ProcessadorBoletos.processarBoletos(boletos, fatura);
	        // Preciso codar o try catch
	    }

	    @Test
	    public void testeValorZero() throws ValorNegativoException, ValorInsuficienteException {
	        List<Boleto> boletos = new ArrayList<>();
	        Fatura fatura = new Fatura(new Date(), 0.0, "Cliente Teste");
	        ProcessadorBoletos.processarBoletos(boletos, fatura);
	        assertTrue(fatura.estaPaga());
	    }

	    @Test
	    public void testeValorPositivoMenor() throws ValorNegativoException, ValorInsuficienteException {
	        List<Boleto> boletos = new ArrayList<>();
	        boletos.add(new Boleto("001", new Date(), 1000.0));
	        Fatura fatura = new Fatura(new Date(), 1500.0, "Cliente Teste");
	        ProcessadorBoletos.processarBoletos(boletos, fatura);
	        assertFalse(fatura.estaPaga());
	    }
}
