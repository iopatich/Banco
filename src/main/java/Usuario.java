public class Usuario {
    private String nombre;
    private String direccion;
    private TipoCuenta tipoCuenta;
    private int edad;
    private String correo;
    private double saldo;

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public int getEdad() {
        return edad;
    }

    public String getCorreo() {
        return correo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public Usuario(String nombre, String direccion, TipoCuenta tipoCuenta, int edad, String correo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipoCuenta = tipoCuenta;
        this.edad = edad;
        this.correo = correo;
        this.saldo = 0;
    }
}
