/*
 * Programa que lanza cuatro lectores y un escritor.
 * que se comunican a través de un buzón de mensajes.
 * Debe comprobarse que no se pierden los mensajes ni se leen dos veces
 */
package ejemplo1;

public class PruebaBuzon1
{
    public static void main(String[] s)
    { 
        Buffer buffer = new Buffer(20);
        Productor A = new Productor("A",70,buffer);
        Productor B = new Productor("B",70,buffer);
        Productor C = new Productor("C",70,buffer);
        Consumidor Jose = new Consumidor("Jose", buffer);
        Consumidor Ana = new Consumidor("Ana",buffer);
        Consumidor Maria = new Consumidor("Maria",buffer);
        //PRODUCTORES
        A.start();
        B.start();
        C.start();
        
        //CONSUMIDORES
        Jose.start();
        Ana.start();
        Maria.start();
    }
}
