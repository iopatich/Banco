public class Banco {
    public void mostrarBalanceCuentas(Usuario cuenta1, Usuario cuenta2, Usuario cuenta3) {
        System.out.println("El balance total de las cuentas en el banco es de $" + (cuenta1.getSaldo() + cuenta2.getSaldo() + cuenta3.getSaldo()));
    }
}
