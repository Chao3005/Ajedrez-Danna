import java.util.List;

/**
 * Clase abstracta Pieza que generaliza las demás piezas de ajedrez
 * @author
 * @version (Noviembre 2022)
 * @see Posicion
 */
public abstract class Pieza {
    private Posicion posicionActual;
    private boolean color;

    /**
     * Método consultor de la posición de una pieza
     * @return Devuelve la posición actual de la pieza en el tablero
     */
    public Posicion obtenerPosicion(){
        return this.posicionActual;
    }

    /**
     * Método consultor del color de una pieza
     * @return Devuelve un booleano true de ser blanca o false de ser negra
     */
    public boolean esBlanca(){
        return this.color;
    }

    /**
     * Método modificador de la posición de una pieza
     * @param nueva Nueva posición por asignar
     * @throws NullPointerException En caso de recibir un parámetro null
     */
    public void asignarPosicion(Posicion nueva){
        if(nueva == null)
            throw new NullPointerException();
        this.posicionActual=nueva;
    }

    /**
     * Método modificador del color de una pieza
     * @param esBlanca Booleano true si se pretende asignar un color blanco o false para negro
     */
    public void asignarColor(boolean esBlanca){
        this.color=esBlanca;
    }

    /**
     * Método que calcula los posibles movimientos de esta pieza desde su posición actual
     * @return Devuelve una lista con las posibles posiciones a las que se puede mover esta pieza
     */
    public abstract List<Posicion> posiblesMovimientos();

    /**
     * Método que determina si es válido mover esta pieza desde su posición actual a la posición p
     * @param p Posición a la que se pretende mover la pieza
     * @return Devuelve un booleano true de ser válido o false de lo contrario
     */
    public abstract boolean esValida(Posicion p);

    /**
     * Método que genera una cadena representativa de la pieza
     */
    @Override
    public abstract String toString();
}
