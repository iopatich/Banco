import java.util.ArrayList;

public class Banco {
    private ArrayList<Sucursal> sucursales = new ArrayList<>();

    public void crearSucursal(String nombre) {
        sucursales.add(new Sucursal(nombre));
    }

    public Sucursal buscarSucursal(String nombre) {
        for (Sucursal sucursal : sucursales) {
            if (sucursal.getNombre().equalsIgnoreCase(nombre)) {
                return sucursal;
            }
        }
        return null;
    }

    public Usuario buscarUsuario(int idUsuario) {
        for (Sucursal sucursal : sucursales) {
            Usuario usuario = sucursal.buscarUsuario(idUsuario);
            if (usuario != null) return usuario;
        }
        return null;
    }

    public void mostrarBalanceCuentas() {
        double total = 0;

        for (Sucursal sucursal : sucursales) {
            System.out.print("Ingrese la sucursal que quiera mirar: " + sucursal.getNombre());

            for (Usuario usuario : sucursal.getUsuarios()) {
                System.out.println("  " + usuario.getNombre() + ": $" + usuario.getSaldo());
                total += usuario.getSaldo();
            }

            System.out.println();
        }

        System.out.println("Total en el banco: $" + total);
    }

    public void mostrarCuenta(Usuario usuario) {
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Direccion: " + usuario.getDireccion());
        System.out.println("Tipo de cuenta: " + usuario.getTipoCuenta());
        System.out.println("Edad: " + usuario.getEdad());
        System.out.println("Correo: " + usuario.getCorreo());
        System.out.println("Saldo: " + usuario.getSaldo());
    }

    public void mostrarSaldo(Usuario usuario) {
        System.out.println("El saldo del usuario " + usuario.getNombre() + " es: $" + usuario.getSaldo());
    }

    public boolean sinSucursales() {
        return sucursales.isEmpty();
    }
}
