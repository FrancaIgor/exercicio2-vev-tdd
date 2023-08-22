import java.util.Date;

public class Boleto {
    private String codigo;
    private Date data;
    private double valorPago;

    public Boleto(String codigo, Date data, double valorPago) {
        this.codigo = codigo;
        this.data = data;
        this.valorPago = valorPago;
    }

    public double getValorPago() {
        return valorPago;
    }
}
