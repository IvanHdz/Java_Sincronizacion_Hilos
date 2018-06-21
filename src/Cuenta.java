/**
 *
 * @author Jesus Ivan
 */
public class Cuenta {
    private int saldo = 50;
    
    public int getSaldo(){
        return saldo;
    }
    
    public void retiro (int cantidad){
        saldo+=-cantidad;
    }
}