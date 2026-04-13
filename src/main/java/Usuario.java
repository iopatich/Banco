public class Usuario {
    public String nombre;
    public String direccion;
    public String tipoCuenta;
    public int edad;
    public String correo;
    public double saldo;

    public  Usuario(String nombre, String direccion, String tipoCuenta, int edad, String correo, double saldo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipoCuenta = tipoCuenta;
        this.edad = edad;
        this.correo = correo;
        this.saldo = 0;
    }
}
