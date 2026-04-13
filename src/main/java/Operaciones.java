public class Operaciones {
    public void depositar(Usuario usuario, double monto) {
        usuario.saldo += monto;
        System.out.println("Se han depositado $" + monto + " en su cuenta");
    }

    public void transferir(Usuario usuarioSalida, Usuario usuarioEntrada, double monto) {
        if (monto > usuarioSalida.saldo) {
            System.out.println("Saldo insuficiente");
        } else {
            usuarioSalida.saldo -= monto;
            usuarioEntrada.saldo += monto;
            System.out.println("La transferencia se ha enviado con exito!");
        }
    }

    public void mostrarSaldo(Usuario usuario) {
        System.out.println("El saldo del usuario " + usuario.nombre + " es: $" + usuario.saldo);
    }
}
