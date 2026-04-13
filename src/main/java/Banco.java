import java.util.ArrayList;

public class Banco {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    public void crearUsuario(String nombre, String direccion, TipoCuenta tipoCuenta, int edad, String correo) {
        Usuario usuario = new Usuario(nombre, direccion, tipoCuenta, edad, correo);
        usuarios.add(usuario);
        System.out.println("El usuario ha sido creado con éxito!");
    }

    public Usuario buscarUsuario(String nombre) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                return usuario;
            }
        }
        return null;
    }

    public void mostrarBalanceCuentas() {
        double total = 0;

        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getNombre() + ": $" + usuario.getSaldo());
            total += usuario.getSaldo();
        }

        System.out.println("Total en el banco: $" + total);
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
