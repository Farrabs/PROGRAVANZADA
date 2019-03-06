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
        Buzon buzonX = new Buzon();
        Productor pedro = new Productor("Pedro ",6,buzonX);
        Productor juan = new Productor("Juan ",7,buzonX);
        Productor antonio = new Productor("Antonio ",7,buzonX);
        Productor luis = new Productor("Luis ",7,buzonX);
        Consumidor jose = new Consumidor(27,buzonX);
        pedro.start();
        juan.start();
        antonio.start();
        luis.start();
        jose.start();
    }
}
