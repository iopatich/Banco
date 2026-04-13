public class Operaciones {
    public void depositar(Usuario usuario, double monto) {
        usuario.saldo += monto;
        System.out.println("Se han depositado $" + monto + " en su cuenta");
    }

    public void transferir(Usuario usuarioOrigen, Usuario usuarioDestino, double monto) {
        if (usuarioOrigen == usuarioDestino) {
            System.out.println("No es posible transferirse a uno mismo.");
        } else if (monto > usuarioOrigen.saldo) {
            System.out.println("Saldo insuficiente");
        } else {
            usuarioOrigen.saldo -= monto;
            usuarioDestino.saldo += monto;
            System.out.println("La transferencia se ha enviado con exito!");
        }
    }

    public void mostrarSaldo(Usuario usuario) {
        System.out.println("El saldo del usuario " + usuario.nombre + " es: $" + usuario.saldo);
    }
}
