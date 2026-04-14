import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private int idCuenta;
    private TipoCuenta tipoCuenta;
    private double saldo;
    private ArrayList<Transaccion> historial;

    public Cuenta(int id, TipoCuenta tipo) {
        this.idCuenta = id;
        this.tipoCuenta = tipo;
        this.saldo = 0;
        this.historial = new ArrayList<>();
    }

    public void depositar(double monto) {
        saldo += monto;
        historial.add(new Transaccion("DEPOSITO", monto));
    }

    public void retirar(double monto) {
        saldo -= monto;
        historial.add(new Transaccion("RETIRO", monto));
    }

    public void agregarTransaccion(Transaccion t) {
        historial.add(t);
    }

    public List<Transaccion> getHistorial() {
        return historial;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getIdCuenta() {
        return idCuenta;
    }
}
