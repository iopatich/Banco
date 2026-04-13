public class Operaciones {
    public void depositar(Usuario usuario, double monto) {
        usuario.saldo += monto;
        System.out.println("Se han depositado $" + monto + " en la cuenta de " + usuario.nombre);
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

    public void mostrarCuenta(Usuario usuario) {
        System.out.println("Nombre: " + usuario.nombre);
        System.out.println("Direccion: " + usuario.direccion);
        System.out.println("Tipo de cuenta: " + usuario.tipoCuenta);
        System.out.println("Edad: " + usuario.edad);
        System.out.println("Correo: " + usuario.correo);
        System.out.println("Saldo: " + usuario.saldo);
    }
}
