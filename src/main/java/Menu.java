import java.util.Scanner;

public class Menu {
    private Operaciones operacion = new Operaciones();
    private Banco banco = new Banco();
    private Scanner teclado = new Scanner(System.in);

    public void iniciar() {
        int opcion;
        banco.crearSucursal("Parque patricios");
        banco.crearSucursal("Boedo");
        banco.crearSucursal("Retiro");

        do {
            System.out.println("Menu\nElija que desea hacer");
            System.out.println("Sucursales existentes: Parque patricios - Boedo - Retiro");
            System.out.println("1: Craer cuenta");
            System.out.println("2: Depositar");
            System.out.println("3: Retirar");
            System.out.println("4: Transferir");
            System.out.println("5: Mostrar cuenta");
            System.out.println("6: Ver saldo");
            System.out.println("7: Ver balance de las cuentas");
            System.out.println("8: Borrar usuario");
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
                case 8 -> borrarUsuario();
                case 0 -> System.out.println("Finalizado");
                default -> System.out.println("Opcion invalida");
            }
        } while (opcion != 0);
    }

    private void crearUsuario() {
        teclado.nextLine();
        System.out.print("Nombre de sucursal: ");
        String nombreSucursal = teclado.nextLine();

        Sucursal sucursal = banco.buscarSucursal(nombreSucursal);

        if (sucursal == null) {
            System.out.println("Recuerde ingresar una sucursal.");
        }

        System.out.print("Id: ");
        int idUsuario = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Contrasenia: ");
        String contrasenia = teclado.nextLine();

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

        sucursal.crearUsuario(idUsuario, nombre, contrasenia, direccion, tipoCuenta, edad, correo);
    }

    private void depositar() {
        teclado.nextLine();
        System.out.print("Nombre de sucursal: ");
        String nombreSucursal = teclado.nextLine();

        Sucursal sucursal = banco.buscarSucursal(nombreSucursal);

        if (sucursal == null) {
            System.out.println("No se encontro la sucursal");
            return;
        }

        System.out.print("Id del usuario: ");
        int idUsuario = teclado.nextInt();

        Usuario usuario = sucursal.buscarUsuario(idUsuario);

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
        System.out.print("Nombre de sucursal: ");
        String nombreSucursal = teclado.nextLine();

        Sucursal sucursal = banco.buscarSucursal(nombreSucursal);

        if (sucursal == null) {
            System.out.println("No se encontro la sucursal");
            return;
        }

        System.out.print("Id del usuario: ");
        int idUsuario = teclado.nextInt();

        Usuario usuario = sucursal.buscarUsuario(idUsuario);

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
        System.out.print("Nombre de sucursal: ");
        String nombreSucursal = teclado.nextLine();

        Sucursal sucursal = banco.buscarSucursal(nombreSucursal);

        if (sucursal == null) {
            System.out.println("No se encontro la sucursal");
            return;
        }

        System.out.print("id del usuario origen: ");
        int idOrigen = teclado.nextInt();

        Usuario origen = sucursal.buscarUsuario(idOrigen);

        if (origen == null) {
            System.out.println("Usuario origen no encontrado");
            return;
        }

        System.out.print("id del usuario destino: ");
        int idDestino = teclado.nextInt();

        Usuario destino = sucursal.buscarUsuario(idDestino);

        if (destino == null) {
            System.out.println("Usuario destino no encontrado");
            return;
        }

        System.out.print("Monto a transferir: ");
        double monto = teclado.nextDouble();

        operacion.transferir(origen, destino, monto);
    }

    private void mostrarCuenta() {
        System.out.print("id del usuario: ");
        int idUsuario = teclado.nextInt();

        Usuario usuario = banco.buscarUsuario(idUsuario);

        if (usuario == null) {
            System.out.println("Usuario no encontrado");
            return;
        }

        banco.mostrarCuenta(usuario);
    }

    private void verSaldo() {
        System.out.print("id del usuario: ");
        int idUsuario = teclado.nextInt();

        Usuario usuario = banco.buscarUsuario(idUsuario);

        if (usuario == null) {
            System.out.println("Usuario no encontrado");
            return;
        }

        banco.mostrarSaldo(usuario);
    }

    private void verBalanceBanco() {
        banco.mostrarBalanceCuentas();
    }

    private void borrarUsuario() {
        teclado.nextLine();
        System.out.print("Nombre de sucursal: ");
        String nombreSucursal = teclado.nextLine();

        Sucursal sucursal = banco.buscarSucursal(nombreSucursal);

        if (sucursal == null) {
            System.out.println("No se encontro la sucursal");
            return;
        }

        System.out.print("id del usuario a borrar: ");
        int idUsuario = teclado.nextInt();

        sucursal.borrarUsuario(idUsuario);
    }
}
