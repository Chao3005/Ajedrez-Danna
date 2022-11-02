import java.util.LinkedList;
import java.util.List;

/**
 * Clase Peon que extiende Pieza para implementar una pieza de ajedrez de tipo peon
 * @author
 * @version (Noviembre 2022)
 * @see Pieza
 * @see Posicion
 */
public class Peon extends Pieza{

    /**
     * Constructor parametrizado de un objeto Peon
     * @param inicial Posicion inicial del peon en el tablero
     * @param esBlanca Booleano true para un peon blanco o false para negro
     * @throws NullPointerException En caso de recibir una posicion null
     */
    public Peon(Posicion inicial, boolean esBlanca){
        if(inicial == null)
            throw new NullPointerException();
        int filaNoValida = esBlanca ? 1 : 8;
        if(inicial.obtenerFila() == filaNoValida)
            throw new IllegalArgumentException();
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
        int filaDeAvance = this.color ? 2 : 7;
        int tope = (filaActual == filaDeAvance) ? 2 : 1;
        for(int i=1;i <= tope;i++){
            if(this.color)
                movimientos.add(new Posicion((char) columnaActual, filaActual+i));
            else
                movimientos.add(new Posicion((char) columnaActual, filaActual-i));
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
        return "P" + (this.color ? "B" : "N");
    }
}