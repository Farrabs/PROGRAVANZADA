/*
 * La clase Buffer tiene que estar protegida con un cerrojo
 * El método enviaMensaje debe esperar si el buzón está lleno
 * El método recibeMensaje debe esperar si el buzón está vacío.
 * Cuando un hilo completa su operación, desbloquea a los que estén esperando
 * para que puedan continuar intentando su acción.
 */
package ejemplo1;
 
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer
{
    public int[] buf;
    private int in = 0, out = 0, numElem = 0, maximo = 0, resultado =0;
    
    private Lock cerrojo = new ReentrantLock();
    private Condition buzonLleno = cerrojo.newCondition();
    private Condition buzonVacio = cerrojo.newCondition();
 
    public Buffer(int max) 
    {
        this.maximo = max;
        buf = new int [max];
    }
    
    public void enviaMensaje(int obj) throws InterruptedException {
        cerrojo.lock();
        while (numElem==maximo) //Buffer lleno
        { 
            buzonLleno.await();
        }
        try 
        { 
            buf[in] = obj;
            numElem++;
            in = (in + 1) % maximo;
            buzonVacio.signal(); //Buffer ya no está vacío
        } 
        finally
        { 
            cerrojo.unlock(); 
        }
}

 
    public int recibeMensaje() throws InterruptedException {
        cerrojo.lock();
        while (numElem==0) { //Buffer vacío
            buzonVacio.await();
         }
        int obj;
        try 
        {
            obj = buf[out];
            buf[out] = -1;
            numElem = numElem - 1;
            out = (out + 1) % maximo;
            buzonLleno.signal(); //Buffer ya no está lleno
            resultado +=obj;
            return (obj);
        } 
        finally
        {
            cerrojo.unlock(); 
        }
    }
    
    public int getResultado(){
        return resultado;
    }
}
