import java.util.Scanner;

public class Menu {
    private Banco banco = new Banco();
    private Scanner teclado = new Scanner(System.in);

    public void iniciar() {
        Admin adminParquePatricios = new Admin(1, "adminParquePatricios", "123");
        Admin adminBoedo = new Admin(2, "adminBoedo", "456");
        Admin adminRetiro = new Admin(3, "adminRetiro", "789");

        banco.crearSucursal("Parque Patricios", adminParquePatricios);
        banco.crearSucursal("Boedo", adminBoedo);
        banco.crearSucursal("Retiro", adminRetiro);

        boolean finalizar = false;
        while (!finalizar) {
            Sucursal sucursalLogueada = login();

            if (sucursalLogueada == null) {
                System.out.println("Login fallido");
                continue;
            }

            Admin admin = sucursalLogueada.getAdmin();

            int opcion;

            do {
                System.out.println("Menu\nSucursal: " + sucursalLogueada.getNombre());
                System.out.println("1: Crear cliente");
                System.out.println("2: Crear cuenta");
                System.out.println("3: Depositar");
                System.out.println("4: Transferir");
                System.out.println("5: Retirar");
                System.out.println("6: Ver balance de las cuentas");
                System.out.println("7: Ver historial de transacciones");
                System.out.println("8: Ver cuentas");
                System.out.println("9: Borrar cuenta");
                System.out.println("0: Cerrar sesión");
                System.out.println("-1: Finalizar");

                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1 -> crearCliente(sucursalLogueada, admin);
                    case 2 -> crearCuenta(sucursalLogueada, admin);
                    case 3 -> depositar(sucursalLogueada, admin);
                    case 4 -> transferir(sucursalLogueada, admin);
                    case 5 -> retirar(sucursalLogueada);
                    case 6 -> banco.mostrarBalanceCuentas();
                    case 7 -> verTransacciones(sucursalLogueada, admin);
                    case 8 -> sucursalLogueada.mostrarCuentas(admin);
                    case 9 -> borrarCuenta(sucursalLogueada, admin);
                    case 0 -> System.out.println("Cerrando sesión");
                    case -1 -> {System.out.println("Finalizando"); finalizar = true;}
                    default -> System.out.println("Opcion invalida");
                }
            } while (opcion != 0 && !finalizar);
            teclado.nextLine();
        }
    }

    private Sucursal login() {
        System.out.println("Ingrese sus datos de admin");
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Contrasenia: ");
        String contrasenia = teclado.nextLine();

        Sucursal sucursal = banco.loginAdmin(nombre, contrasenia);

        if (sucursal != null) {
            System.out.println("Login exitoso en sucursal: " + sucursal.getNombre());
        }
        return sucursal;
    }

    private void crearCliente(Sucursal sucursal, Admin admin) {
        teclado.nextLine();

        System.out.print("id del cliente: ");
        int id = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Nombre del cliente: ");
        String nombre = teclado.nextLine();

        System.out.print("Contrasenia del cliente: ");
        String pass = teclado.nextLine();

        Usuario usuario = new Usuario(id, nombre, pass) {};
        Cliente cliente = new Cliente(usuario);

        sucursal.crearCliente(admin, cliente);
    }

    private void crearCuenta(Sucursal sucursal, Admin admin) {
        System.out.print("id del cliente: ");
        int idCliente = teclado.nextInt();

        Cliente cliente = null;

        for (Cliente clientee : sucursal.getClientes()) {
            if (clientee.getUsuario().getId() == idCliente) {
                cliente = clientee;
                break;
            }
        }

        if (cliente == null) {
            System.out.println("Cliente no encontrado");
            return;
        }

        System.out.print("id de la cuenta: ");
        int idCuenta = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Tipo de cuenta (ahorro o corriente): ");
        TipoCuenta tipo = TipoCuenta.valueOf(teclado.nextLine().toUpperCase());

        sucursal.crearCuenta(admin, cliente, idCuenta, tipo);
    }

    private void depositar(Sucursal sucursal, Admin admin) {
        System.out.print("id cuenta: ");
        int idCuenta = teclado.nextInt();

        System.out.print("Monto: ");
        double monto = teclado.nextDouble();

        sucursal.depositar(admin, idCuenta, monto);
    }

    private void retirar(Sucursal sucursal) {
        System.out.print("id cliente: ");
        int idCliente = teclado.nextInt();
        teclado.nextLine();

        Cliente cliente = null;

        for (Cliente clientee : sucursal.getClientes()) {
            if (clientee.getUsuario().getId() == idCliente) {
                cliente = clientee;
                break;
            }
        }

        if (cliente == null) {
            System.out.println("No se ha encontrado el cliente");
            return;
        }

        System.out.print("id cuenta: ");
        int idCuenta = teclado.nextInt();

        System.out.print("Monto: ");
        double monto = teclado.nextDouble();

        sucursal.retirar(cliente.getUsuario(), idCuenta, monto);
    }

    private void transferir(Sucursal sucursal, Admin admin) {
        System.out.print("id Cuenta origen: ");
        int origen = teclado.nextInt();

        System.out.print("id Cuenta destino: ");
        int destino = teclado.nextInt();

        System.out.print("Monto: ");
        double monto = teclado.nextDouble();

        sucursal.transferir(admin, origen, destino, monto);
    }

    private void verTransacciones(Sucursal sucursal, Admin admin) {
        System.out.print("ID cuenta: ");
        int idCuenta = teclado.nextInt();

        Cuenta cuenta = sucursal.buscarCuenta(idCuenta);

        if (cuenta != null) {
            sucursal.verTransacciones(admin, cuenta);
        }
    }

    private void borrarCuenta(Sucursal sucursal, Admin admin) {
        System.out.print("ID cuenta: ");
        int id = teclado.nextInt();

        sucursal.borrarCuenta(admin, id);
    }
}