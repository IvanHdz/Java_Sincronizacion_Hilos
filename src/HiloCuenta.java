/**
 *
 * @author Jesus Ivan
 */
public class HiloCuenta implements Runnable {
    private final Cuenta cuenta;
    
    public HiloCuenta(Cuenta cuenta){
        this.cuenta = cuenta;
    }

    public void run(){
        //for que v a pasar 5 recorridos cada uno de $10
        for(int i=0;i<5;i++){
            //Se hace un retiro de $10
            hacerRetiro(10);
            if(cuenta.getSaldo()<0){
                System.out.println("Cuenta sobregirada");
            }
        }   
    }
    //Se sincroniza para que cuando retire uno se actualize y no agarren el
    //objeto.
    private synchronized void hacerRetiro(int cantidad){
        String hilo = Thread.currentThread().getName();
        //Pregunta si el saldo es mayor que Cantidad
        if(cuenta.getSaldo() >= cantidad){
            System.out.println(hilo +" Procede a realizar un Retiro " +   
                    cuenta.getSaldo());
            //Excepcion try,catch se pone por el sleep.
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            System.out.println("Error de thread");
        }
            cuenta.retiro(cantidad);
            System.out.println(hilo + " Termino de realizar un retiro " + 
                     cuenta.getSaldo());
        }
        else{
            System.out.println(" No hay suficiente saldo para que "+ hilo + 
                    " realice un retiro ("  + cuenta.getSaldo()+ ")");
        } 
    }
}