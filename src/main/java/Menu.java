import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Operaciones operacion = new Operaciones();
    private Banco banco = new Banco();
    private Scanner teclado = new Scanner(System.in);

    public void iniciar() {
        int opcion;

        do {
            System.out.println("Menu\nElija que desea hacer\nRecuerde Crear una sucursal primero");
            System.out.println("1: Crear sucursal");
            System.out.println("2: Craer cuenta");
            System.out.println("3: Depositar");
            System.out.println("4: Retirar");
            System.out.println("5: Transferir");
            System.out.println("6: Mostrar cuenta");
            System.out.println("7: Ver saldo");
            System.out.println("8: Ver balance de las cuentas");
            System.out.println("0: Finalizar");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1 -> crearSucursal();
                case 2 -> crearUsuario();
                case 3 -> depositar();
                case 4 -> retirar();
                case 5 -> transferir();
                case 6 -> mostrarCuenta();
                case 7 -> verSaldo();
                case 8 -> verBalanceBanco();
                case 0 -> System.out.println("Finalizado");
                default -> System.out.println("Opcion invalida");
            }
        } while (opcion != 0);
    }

    private void crearSucursal() {
        teclado.nextLine();
        System.out.print("Nombre de la sucursal: ");
        String nombre = teclado.nextLine();

        banco.crearSucursal(nombre);
    }

    private void crearUsuario() {
        if (banco.sinSucursales()) {
            System.out.println("Se debe crear una sucursal primero!");
            return;
        }

        teclado.nextLine();
        System.out.print("Nombre de sucursal: ");
        String nombreSucursal = teclado.nextLine();

        Sucursal sucursal = banco.buscarSucursal(nombreSucursal);

        if (sucursal == null) {
            System.out.println("No se encontro la sucursal");
            return;
        }

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
        sucursal.crearUsuario(nombre, direccion, tipoCuenta, edad, correo);
    }

    private void depositar() {
        if (banco.sinSucursales()) {
            System.out.println("Se debe crear una sucursal primero!");
            return;
        }

        teclado.nextLine();
        System.out.print("Nombre de sucursal: ");
        String nombreSucursal = teclado.nextLine();

        Sucursal sucursal = banco.buscarSucursal(nombreSucursal);

        if (sucursal == null) {
            System.out.println("No se encontro la sucursal");
            return;
        }

        teclado.nextLine();

        System.out.print("Nombre del usuario: ");
        String nombre = teclado.nextLine();

        Usuario usuario = sucursal.buscarUsuario(nombre);

        if (usuario == null) {
            System.out.println("Usuario no encontrado");
            return;
        }

        System.out.print("Monto a depositar: ");
        double monto = teclado.nextDouble();

        operacion.depositar(usuario, monto);
    }

    private void retirar() {
        if (banco.sinSucursales()) {
            System.out.println("Se debe crear una sucursal primero!");
            return;
        }

        teclado.nextLine();
        System.out.print("Nombre de sucursal: ");
        String nombreSucursal = teclado.nextLine();

        Sucursal sucursal = banco.buscarSucursal(nombreSucursal);

        if (sucursal == null) {
            System.out.println("No se encontro la sucursal");
            return;
        }

        teclado.nextLine();

        System.out.print("Nombre del usuario: ");
        String nombre = teclado.nextLine();

        Usuario usuario = sucursal.buscarUsuario(nombre);

        if (usuario == null) {
            System.out.println("Usuario no encontrado");
            return;
        }

        System.out.print("Monto a retirar: ");
        double monto = teclado.nextDouble();

        operacion.retirar(usuario, monto);
    }

    private void transferir() {
        if (banco.sinSucursales()) {
            System.out.println("Se debe crear una sucursal primero!");
            return;
        }

        teclado.nextLine();
        System.out.print("Nombre de sucursal: ");
        String nombreSucursal = teclado.nextLine();

        Sucursal sucursal = banco.buscarSucursal(nombreSucursal);

        if (sucursal == null) {
            System.out.println("No se encontro la sucursal");
            return;
        }

        teclado.nextLine();

        System.out.print("Usuario origen: ");
        String nombreOrigen = teclado.nextLine();

        Usuario origen = sucursal.buscarUsuario(nombreOrigen);

        if (origen == null) {
            System.out.println("Usuario origen no encontrado");
            return;
        }

        System.out.print("Usuario destino: ");
        String nombreDestino = teclado.nextLine();

        Usuario destino = sucursal.buscarUsuario(nombreDestino);

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
