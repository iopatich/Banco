import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Operaciones operacion = new Operaciones();
    private Banco banco = new Banco();
    private Scanner teclado = new Scanner(System.in);

    public void iniciar() {
        int opcion;

        do {
            System.out.println("Menu\nElija que desea hacer");
            System.out.println("1: Craer cuenta");
            System.out.println("2: Depositar");
            System.out.println("3: Retirar");
            System.out.println("4: Transferir");
            System.out.println("5: Mostrar cuenta");
            System.out.println("6: Ver saldo");
            System.out.println("7: Ver balance de las cuentas");
            System.out.println("0: Finalizar");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1 -> crearUsuario();
                case 2 -> depositar();
                case 3 -> retirar();
                case 4 -> transferir();
                case 5 -> mostrarCuenta();
                case 6 -> verSaldo();
                case 7 -> verBalanceBanco();
                case 0 -> System.out.println("Finalizado");
                default -> System.out.println("Opcion invalida");
            }
        } while (opcion != 0);
    }

    private void crearUsuario() {
        teclado.nextLine();
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();
        System.out.print("Direccion: ");
        String direccion = teclado.nextLine();
        System.out.print("Edad: ");
        int edad = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Correo: ");
        String correo = teclado.nextLine();
        System.out.println("Tipo de cuenta (AHORRO, CORRIENTE): ");
        String tipo = teclado.nextLine().toUpperCase();
        TipoCuenta tipoCuenta = TipoCuenta.valueOf(tipo);
        banco.crearUsuario(nombre, direccion, tipoCuenta, edad, correo);
    }

    private void depositar() {
        teclado.nextLine();

        System.out.print("Nombre del usuario: ");
        String nombre = teclado.nextLine();

        Usuario usuario = banco.buscarUsuario(nombre);

        if (usuario == null) {
            System.out.println("Usuario no encontrado");
            return;
        }

        System.out.print("Monto a depositar: ");
        double monto = teclado.nextDouble();

        operacion.depositar(usuario, monto);
    }

    private void retirar() {
        teclado.nextLine();

        System.out.print("Nombre del usuario: ");
        String nombre = teclado.nextLine();

        Usuario usuario = banco.buscarUsuario(nombre);

        if (usuario == null) {
            System.out.println("Usuario no encontrado");
            return;
        }

        System.out.print("Monto a retirar: ");
        double monto = teclado.nextDouble();

        operacion.retirar(usuario, monto);
    }

    private void transferir() {
        teclado.nextLine();

        System.out.print("Usuario origen: ");
        String nombreOrigen = teclado.nextLine();

        Usuario origen = banco.buscarUsuario(nombreOrigen);

        if (origen == null) {
            System.out.println("Usuario origen no encontrado");
            return;
        }

        System.out.print("Usuario destino: ");
        String nombreDestino = teclado.nextLine();

        Usuario destino = banco.buscarUsuario(nombreDestino);

        if (destino == null) {
            System.out.println("Usuario destino no encontrado");
            return;
        }

        System.out.print("Monto a transferir: ");
        double monto = teclado.nextDouble();

        operacion.transferir(origen, destino, monto);
    }

    private void mostrarCuenta() {
        teclado.nextLine();

        System.out.print("Nombre del usuario: ");
        String nombre = teclado.nextLine();

        Usuario usuario = banco.buscarUsuario(nombre);

        if (usuario == null) {
            System.out.println("Usuario no encontrado");
            return;
        }

        banco.mostrarCuenta(usuario);
    }

    private void verSaldo() {
        teclado.nextLine();

        System.out.print("Nombre del usuario: ");
        String nombre = teclado.nextLine();

        Usuario usuario = banco.buscarUsuario(nombre);

        if (usuario == null) {
            System.out.println("Usuario no encontrado");
            return;
        }

        banco.mostrarSaldo(usuario);
    }

    private void verBalanceBanco() {
        banco.mostrarBalanceCuentas();
    }
}
