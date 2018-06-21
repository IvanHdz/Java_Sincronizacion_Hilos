/**
 *
 * @author Jesus Ivan
 */
public class Main {
    public static void main(String [] args){
        Cuenta cuenta = new Cuenta();
        //Los hilos se asocian ala misma cuenta para que las personas retiren
        //de la misma cuenta.
        HiloCuenta r = new HiloCuenta(cuenta);
        Thread uno = new Thread(r);
        Thread dos = new Thread(r);
        uno.setName("Pedro");
        dos.setName("Juan");
        uno.start();
        dos.start();   
    }
}