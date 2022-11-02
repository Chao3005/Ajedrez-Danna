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
        this.asignarColor(esBlanca);
        this.asignarPosicion(inicial);
    }

    /**
     * Método modificador de la posición de una peon
     * @param nueva Nueva posición por asignar
     * @throws NullPointerException En caso de recibir un parámetro null
     * @throws IllegalArgumentException En caso de que la nueva posición tenga una fila invalida para el peón segun su color
     */
    @Override
    public void asignarPosicion(Posicion nueva){
        if(nueva == null)
            throw new NullPointerException();
        int filaNoValida = this.color ? 1 : 8;
        if(nueva.obtenerFila() == filaNoValida)
            throw new IllegalArgumentException();
        this.posicionActual=nueva;
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
            if(this.color && filaActual+i < 9)
                movimientos.add(new Posicion((char) columnaActual, filaActual+i));
            else if(!this.color && filaActual-i > 0)
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