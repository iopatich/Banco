import java.util.ArrayList;

public class Banco {
    private ArrayList<Sucursal> sucursales = new ArrayList<>();

    public void crearSucursal(String nombre, Admin admin) {
        sucursales.add(new Sucursal(nombre, admin));
    }

    public Sucursal buscarSucursal(String nombre) {
        for (Sucursal sucursal : sucursales) {
            if (sucursal.getNombre().equalsIgnoreCase(nombre)) {
                return sucursal;
            }
        }
        return null;
    }

    public Cliente buscarCliente(int idUsuario) {
        for (Sucursal sucursal : sucursales) {
            for (Cliente cliente : sucursal.getClientes()) {
                if (cliente.getUsuario().getId() == idUsuario) {
                    return cliente;
                }
            }
        }
        return null;
    }

    public void mostrarBalanceCuentas() {
        double total = 0;

        for (Sucursal sucursal : sucursales) {
            System.out.println("Sucursal: " + sucursal.getNombre());

            for (Cliente cliente : sucursal.getClientes()) {
                for (Cuenta cuenta : cliente.getCuentas()) {
                    System.out.println("Cuenta: " + cuenta.getIdCuenta() + "  Saldo: $" + cuenta.getSaldo());
                    total += cuenta.getSaldo();
                }
            }

            System.out.println();
        }

        System.out.println("Total en el banco: $" + total);
    }

    public void mostrarCuentasCliente(int idUsuario) {
        Cliente cliente = buscarCliente(idUsuario);

        if (cliente == null) {
            System.out.println("Cliente no encontrado");
            return;
        }

        System.out.println("Cliente: " + cliente.getUsuario().getNombre());

        for (Cuenta cuenta : cliente.getCuentas()) {
            System.out.println("Cuenta: " + cuenta.getIdCuenta() + " Saldo: $" + cuenta.getSaldo());
        }
    }

    public boolean sinSucursales() {
        return sucursales.isEmpty();
    }

    public ArrayList<Sucursal> getSucursales() {
        return sucursales;
    }

    public Sucursal loginAdmin(int id, String contrasenia) {
        for (Sucursal sucursal : sucursales) {
            Admin admin = sucursal.getAdmin();

            if (admin.getId() == id && admin.getContrasenia().equals(contrasenia)) {
                return sucursal;
            }
        }
        return null;
    }
}