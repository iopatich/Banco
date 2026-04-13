public class Main {
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Ignacio", "Calle 1234", "Corriente", 22, "iopatich@gmail.com");
        Usuario user2 = new Usuario("Jorge", "Avenida 200", "Ahorro", 30, "jorge@gmail.com");
        Usuario user3 = new Usuario("Delfina", "Calle 303", "Corriente", 22, "delfina@gmail.com");

        Operaciones operacion = new Operaciones();
        Banco banco = new Banco();

        operacion.depositar(user1, 10000);
        operacion.depositar(user2, 5000);
        operacion.depositar(user3, 20000);
        System.out.println();

        banco.mostrarSaldo(user1);
        banco.mostrarSaldo(user2);
        banco.mostrarSaldo(user3);
        System.out.println();

        operacion.transferir(user1, user2, 5000);
        banco.mostrarSaldo(user1);
        banco.mostrarSaldo(user2);
        System.out.println();

        operacion.transferir(user1, user1, 2500);
        System.out.println();

        banco.mostrarCuenta(user1);
        System.out.println();

        banco.mostrarBalanceCuentas(user1, user2, user3);
    }
}
