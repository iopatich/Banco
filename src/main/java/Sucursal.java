import java.util.ArrayList;

public class Sucursal {
    private String nombre;
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public Sucursal(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void crearUsuario(String nombre, String direccion, TipoCuenta tipoCuenta, int edad, String correo) {
        Usuario usuario = new Usuario(nombre, direccion, tipoCuenta, edad, correo);
        usuarios.add(usuario);
        System.out.println("Se  ha creado el usuario " + this.nombre);
    }

    public Usuario buscarUsuario(String nombre) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                return usuario;
            }
        }
        return null;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

}
