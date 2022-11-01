/**
 * Clase ejecutable que pone a prueba objetos de la clase Posicion
 * @author
 * @version (Noviembre 2022)
 * @see Posicion
 */
public class PruebaPosicion {

    /**
     * Método principal donde se instancian los objetos Posicion
     */
    public static void main(String[] args){
        Posicion a = new Posicion('a', 8);
        System.out.println(a);

        Posicion b = new Posicion('f', 4);
        System.out.println(b);

        /*Posicion c = new Posicion('j', 8);
        System.out.println(c);*/

        /*Posicion d = new Posicion('a', 9);
        System.out.println(d);*/
    }
}
