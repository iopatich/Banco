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

    public void mostrarSaldo(Usuario usuario) {
        System.out.println("El saldo del usuario " + usuario.getNombre() + " es: $" + usuario.getSaldo());
    }

    public void mostrarCuenta(Usuario usuario) {
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Direccion: " + usuario.getDireccion());
        System.out.println("Tipo de cuenta: " + usuario.getTipoCuenta());
        System.out.println("Edad: " + usuario.getEdad());
        System.out.println("Correo: " + usuario.getCorreo());
        System.out.println("Saldo: " + usuario.getSaldo());
    }
}
