/*
 * La clase Consumidor define hilos que leen mensajes de un buzón de mensajes
 * y los muestran por pantalla.
 * El buzón y el número de mensajes, los reciben como parámetros del constructor
 * antes de terminar.
 * Entre lectura y lectura, esperan un tiempo aleatorio entre 0.5 y 1 seg.
 */
package ejemplo1;

public class Consumidor extends Thread
{
    private String nombre;
    private Buffer miBuffer;
    

    public Consumidor(String nombre, Buffer miBuzon)
    {
        this.nombre = nombre;
        this.miBuffer=miBuzon;
    }


    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                sleep((int)(200+600*Math.random()));
                System.out.println(nombre + " ha leído " + miBuffer.recibeMensaje() + "; Resultado: " + miBuffer.getResultado());
                
            } catch(InterruptedException e){ }
                
        }
    }
}
