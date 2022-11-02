import java.util.LinkedList;
import java.util.List;

/**
 * Clase Alfil que extiende Pieza para implementar una pieza de ajedrez de tipo alfil
 * @author
 * @version (Noviembre 2022)
 * @see Pieza
 * @see Posicion
 */
public class Alfil extends Pieza{

    /**
     * Constructor parametrizado de un objeto Alfil
     * @param inicial Posicion inicial del alfil en el tablero
     * @param esBlanca Booleano true para un alfil blanco o false para negro
     * @throws NullPointerException En caso de recibir una posicion null
     */
    public Alfil(Posicion inicial, boolean esBlanca){
        this.asignarPosicion(inicial);
        this.asignarColor(esBlanca);
    }

    /**
     * Método que calcula los posibles movimientos de esta pieza desde su posición actual
     * @return Devuelve una lista con las posibles posiciones a las que se puede mover esta pieza
     */
    @Override
    public List<Posicion> posiblesMovimientos(){
        LinkedList<Posicion> movimientos = new LinkedList<Posicion>();
        int columnaActual = (int) this.posicionActual.obtenerColumna();
        int filaActual = this.posicionActual.obtenerFila();
        //Diagonal /
        int menor = (columnaActual-96 < filaActual) ? columnaActual-97 : filaActual-1;
        for(int i = columnaActual-menor, j=filaActual-menor; (i < 105) && (j < 9);i++,j++){
            if(i == columnaActual)
                continue;
            movimientos.add(new Posicion((char) i, j));
        }
        //Diagonal \
        menor = (columnaActual-97 < 8-filaActual) ? columnaActual-97 : 8-filaActual;
        for(int i=columnaActual-menor, j=filaActual+menor;(i < 105) && (j > 0);i++,j--){
            if(i == columnaActual)
                continue;
            movimientos.add(new Posicion((char) i, j));
        } 
        return movimientos;
    }

    /**
     * Método que determina si es válido mover esta pieza desde su posición actual a la posición p
     * @param p Posición a la que se pretende mover la pieza
     * @return Devuelve un booleano true de ser válido o false de lo contrario
     * @throws NullPointerException En caso de recibir un parámetro null
     */
    @Override
    public boolean esValida(Posicion p){
        if(p == null)
            throw new NullPointerException();
        for(Posicion posible : this.posiblesMovimientos()){
            if((p.obtenerColumna() == posible.obtenerColumna()) && (p.obtenerFila() == posible.obtenerFila()))
                return true;
        }
        return false;
    }

    /**
     * Método que genera una cadena representativa de la pieza
     */
    @Override
    public String toString(){
        return "A" + (this.color ? "B" : "N");
    }
}