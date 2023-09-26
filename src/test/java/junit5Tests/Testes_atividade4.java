package junit5Tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class Testes_atividade4 {
	@Nested
    @DisplayName("Testes de Valores Limite")
    class TesteValoresLimite {
        @Test
        public void testeValorLimiteZero() throws ValorNegativoException, ValorInsuficienteException {
            List<Boleto> boletos = new ArrayList<>();
            Fatura fatura = new Fatura(new Date(), 0.0, "Cliente Teste");
            assertThrows(FaturaZeradaException.class, () -> {
                ProcessadorBoletos.processarBoletos(boletos, fatura);
            });
        }

        @Test
        public void testeValorLimiteIgual() throws ValorNegativoException, ValorInsuficienteException, FaturaZeradaException {
            List<Boleto> boletos = new ArrayList<>();
            boletos.add(new Boleto("001", new Date(), 1500.0));
            Fatura fatura = new Fatura(new Date(), 1500.0, "Cliente Teste");
            ProcessadorBoletos.processarBoletos(boletos, fatura);
            assertTrue(fatura.estaPaga());
        }

        @Test
        public void testeValorLimiteMenor() throws ValorNegativoException, ValorInsuficienteException {
            List<Boleto> boletos = new ArrayList<>();
            boletos.add(new Boleto("001", new Date(), 1499.0));
            Fatura fatura = new Fatura(new Date(), 1500.0, "Cliente Teste");
            
            assertThrows(ValorInsuficienteException.class, () -> {
                ProcessadorBoletos.processarBoletos(boletos, fatura);
            });
        }
    }

    @Nested
    @DisplayName("Testes de Partições de Equivalência")
    class TesteParticoesEquivalencia {
        @Test
        public void testeValorNegativo() {
            List<Boleto> boletos = new ArrayList<>();
            Fatura fatura = new Fatura(new Date(), -100.0, "Cliente Teste");
            
            assertThrows(ValorNegativoException.class, () -> {
                ProcessadorBoletos.processarBoletos(boletos, fatura);
            });
        }

        @Test
        public void testeValorZero() throws ValorNegativoException, ValorInsuficienteException {
            List<Boleto> boletos = new ArrayList<>();
            Fatura fatura = new Fatura(new Date(), 0.0, "Cliente Teste");
            
            assertThrows(FaturaZeradaException.class, () -> {
                ProcessadorBoletos.processarBoletos(boletos, fatura);
            });
        }

        @Test
        public void testeValorPositivoMenor() {
            List<Boleto> boletos = new ArrayList<>();
            boletos.add(new Boleto("001", new Date(), 1000.0));
            Fatura fatura = new Fatura(new Date(), 1500.0, "Cliente Teste");
            
            assertThrows(ValorInsuficienteException.class, () -> {
                ProcessadorBoletos.processarBoletos(boletos, fatura);
            });
        }
    }

    @Nested
    @DisplayName("Testes de Tabelas de Decisão")
    class TesteTabelasDecisao {
        @Test
        public void testeValorNegativo() {
            List<Boleto> boletos = new ArrayList<>();
            Fatura fatura = new Fatura(new Date(), -100.0, "Cliente Teste");
            
            assertThrows(ValorNegativoException.class, () -> {
                ProcessadorBoletos.processarBoletos(boletos, fatura);
            });
        }

        @Test
        public void testeValorZero() throws ValorNegativoException, ValorInsuficienteException {
            List<Boleto> boletos = new ArrayList<>();
            Fatura fatura = new Fatura(new Date(), 0.0, "Cliente Teste");
            assertThrows(FaturaZeradaException.class, () -> {
                ProcessadorBoletos.processarBoletos(boletos, fatura);
            });
        }

        @Test
        public void testeValorPositivoMenor() {
            List<Boleto> boletos = new ArrayList<>();
            boletos.add(new Boleto("001", new Date(), 1000.0));
            Fatura fatura = new Fatura(new Date(), 1500.0, "Cliente Teste");
            
            assertThrows(ValorInsuficienteException.class, () -> {
                ProcessadorBoletos.processarBoletos(boletos, fatura);
            });
        }
        
        @Nested
        class TesteParticoesEquivalencia {
            @Test
            public void testeValorNegativo() {
                List<Boleto> boletos = new ArrayList<>();
                Fatura fatura = new Fatura(new Date(), -100.0, "Cliente Teste");

                assertThrows(ValorNegativoException.class, () -> {
                    ProcessadorBoletos.processarBoletos(boletos, fatura);
                });
            }

            @Test
            public void testeValorIgualZero() {
                List<Boleto> boletos = new ArrayList<>();
                Fatura fatura = new Fatura(new Date(), 0.0, "Cliente Teste");

                assertThrows(FaturaZeradaException.class, () -> {
                    ProcessadorBoletos.processarBoletos(boletos, fatura);
                });
            }

            @Test
            public void testeValorInsuficiente() {
                List<Boleto> boletos = new ArrayList<>();
                boletos.add(new Boleto("1", new Date(), 200.0)); // Valor total dos boletos é menor que o da fatura
                Fatura fatura = new Fatura(new Date(), 1000.0, "Cliente Teste");

                assertThrows(ValorInsuficienteException.class, () -> {
                    ProcessadorBoletos.processarBoletos(boletos, fatura);
                });
            }
        }

        @Nested
        class TestePagamentoComSucesso {
            @Test
            public void testePagamentoSucesso() {
                List<Boleto> boletos = new ArrayList<>();
                boletos.add(new Boleto("1", new Date(), 500.0));
                boletos.add(new Boleto("2", new Date(), 400.0));
                boletos.add(new Boleto("3", new Date(), 600.0));
                Fatura fatura = new Fatura(new Date(), 1500.0, "Cliente Teste");

                assertDoesNotThrow(() -> {
                    ProcessadorBoletos.processarBoletos(boletos, fatura);
                });

                assertTrue(fatura.estaPaga());
            }
        }
    }
}
