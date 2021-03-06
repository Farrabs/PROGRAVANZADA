/*
 * La clase Productor define hilos que envían mensajes a un buzón de mensajes.
 * Los mensajes constan de un prefijo String y un sufijo que es un entero del 1 al 5
 * El prefijo, el número de mensajes a escribir y el buzón donde hacerlo,
 *  se reciben como parámetros en el constructor.
 * Entre mensaje y mensaje, esperan un tiempo aleatorio entre 0.5 y 1 seg.
 */

package ejemplo1;

public class Productor extends Thread
{
    private String prefijo;
    private int numMensajes;
    private Buffer miBufer;

    public Productor(String prefijo, int n, Buffer buf)
    {
        this.prefijo=prefijo;
        numMensajes=n;
        miBufer=buf;
    }

    public void run()
    {
        int aleatorio;
        for(int i=1; i<=numMensajes; i++)
        {
            aleatorio = (int)(Math.random()*20);
            try
            {
                miBufer.enviaMensaje(aleatorio);
                System.out.println(prefijo + " genera " + aleatorio);
                sleep((int)(300+400*Math.random()));
            } catch(InterruptedException e){  }
        }
    }
}
