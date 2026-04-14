import java.time.LocalDateTime;

public class Transaccion {
    private String tipo; // DEPOSITO, RETIRO, TRANSFERENCIA
    private double monto;
    private LocalDateTime fecha;

    public Transaccion(String tipo, double monto) {
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return tipo + " - $" + monto + " - " + fecha;
    }
}
