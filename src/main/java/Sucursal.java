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

    public void crearUsuario(int idUsuario, String nombre, String contrasenia, String direccion, TipoCuenta tipoCuenta, int edad, String correo) {
        Usuario usuario = new Usuario(idUsuario, nombre, contrasenia, direccion, tipoCuenta, edad, correo);
        usuarios.add(usuario);
        System.out.println("Se  ha creado el usuario " + usuario.getNombre());
    }

    public void borrarUsuario(int idUsuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getIdUsuario() == idUsuario) {
                usuarios.remove(i);
                return;
            }
        }
        System.out.println("Se ha eliminado al usuario " + idUsuario);
    }

    public Usuario buscarUsuario(int idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario() == idUsuario) {
                return usuario;
            }
        }
        return null;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

}
