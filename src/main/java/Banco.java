public class Banco {
    public void mostrarBalanceCuentas(Usuario cuenta1, Usuario cuenta2, Usuario cuenta3) {
        System.out.println("El balance de cada cuenta es el siguiente");
        System.out.println(cuenta1.getNombre() + ": " + cuenta1.getSaldo());
        System.out.println(cuenta2.getNombre() + ": " + cuenta2.getSaldo());
        System.out.println(cuenta3.getNombre() + ": " + cuenta3.getSaldo());
        System.out.println("El balance total de las cuentas en el banco es de $" + (cuenta1.getSaldo() + cuenta2.getSaldo() + cuenta3.getSaldo()));
    }
}
