import java.util.List;
import java.util.LinkedList;

/**
 * Clase Caballo que extiende Pieza para implementar una pieza de ajedrez de tipo caballo
 * @author
 * @version (Noviembre 2022)
 * @see Pieza
 * @see Posicion
 */
public class Caballo extends Pieza{

    /**
     * Constructor parametrizado de un objeto Caballo
     * @param inicial Posicion inicial del caballo en el tablero
     * @param esBlanca Booleano true para un caballo blanco o false para negro
     * @throws NullPointerException En caso de recibir una posicion null
     */
    public Caballo(Posicion inicial, boolean esBlanca){
        this.asignarPosicion(inicial);
        this.asignarColor(esBlanca);
    }

    /**
     * Método que calcula los posibles movimientos de esta pieza desde su posición actual
     * @return Devuelve una lista con las posibles posiciones a las que se puede mover esta pieza
     */
    public List<Posicion> posiblesMovimientos(){
        LinkedList<Posicion> movimientos = new LinkedList<>();
        int columnaActual = (int) this.posicionActual.obtenerColumna();
        int filaActual = this.posicionActual.obtenerFila();
        for(int i=2;i >= -2;i-=4){
            for(int j=1;j >=-1;j-=2){
                int columnaFinal = columnaActual+i;
                int filaFinal = filaActual+j;
                if(96 < columnaFinal && columnaFinal < 105){
                    if(0 < filaFinal && filaFinal < 9)
                        movimientos.add(new Posicion((char) columnaFinal, filaFinal));
                }
                columnaFinal = columnaActual+j;
                filaFinal = filaActual+i;
                if(96 < columnaFinal && columnaFinal < 105){
                    if(0 < filaFinal && filaFinal < 9)
                        movimientos.add(new Posicion((char) columnaFinal, filaFinal));
                }
            }
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
        return "C" + (this.color ? "B" : "N");
    }
}
