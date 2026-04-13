public class Operaciones {
    public void depositar(Usuario usuario, double monto) {
        usuario.setSaldo(usuario.getSaldo() + monto);
        System.out.println("Se han depositado $" + monto + " en la cuenta de " + usuario.getNombre());
    }

    public void transferir(Usuario usuarioOrigen, Usuario usuarioDestino, double monto) {
        if (usuarioOrigen == usuarioDestino) {
            System.out.println("No es posible transferirse a uno mismo.");
        } else if (monto > usuarioOrigen.getSaldo()) {
            System.out.println("Saldo insuficiente");
        } else {
            usuarioOrigen.setSaldo(usuarioOrigen.getSaldo() - monto);
            usuarioDestino.setSaldo(usuarioDestino.getSaldo() + monto);
            System.out.println("La transferencia se ha enviado con exito!");
        }
    }
}
