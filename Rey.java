import java.util.LinkedList;
import java.util.List;

/**
 * Clase Rey que extiende Pieza para implementar una pieza de ajedrez de tipo rey
 * @author
 * @version (Noviembre 2022)
 * @see Pieza
 * @see Posicion
 */
public class Rey extends Pieza{

    /**
     * Constructor parametrizado de un objeto Rey
     * @param inicial Posicion inicial del rey en el tablero
     * @param esBlanca Booleano true para un rey blanco o false para negro
     * @throws NullPointerException En caso de recibir una posicion null
     */
    public Rey(Posicion inicial, boolean esBlanca){
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
        for(int i=1;i >= -1;i-=2){
            int columnaFinal = columnaActual+i;
            int filaFinal = filaActual+i;
            if(96 < columnaFinal && columnaFinal < 105)
                movimientos.add(new Posicion((char) columnaFinal, filaActual));
            if(0 < filaFinal && filaFinal < 9)
                movimientos.add(new Posicion((char) columnaActual, filaFinal));
            if((96 < columnaFinal && columnaFinal < 105) && (0 < filaFinal && filaFinal < 9))
                movimientos.add(new Posicion((char) columnaFinal, filaFinal));
            columnaFinal = columnaActual-i;
            if((96 < columnaFinal && columnaFinal < 105) && (0 < filaFinal && filaFinal < 9))
                movimientos.add(new Posicion((char) columnaFinal, filaFinal));
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
        return "K" + (this.color ? "B" : "N");
    }
}