import java.util.Date;

public class Fatura {
    private Date data;
    private double valorTotal;
    private String nomeCliente;
    private boolean estaPaga;

    public Fatura(Date data, double valorTotal, String nomeCliente) {
        this.data = data;
        this.valorTotal = valorTotal;
        this.nomeCliente = nomeCliente;
        this.estaPaga = false;
    }

    public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	//Flag para a troca do booleano
	public void marcarComoPaga() {
        estaPaga = true;
    }
	
	//Retornando o estado atual da Fatura
    public boolean estaPaga() {
        return estaPaga;
    }
}
