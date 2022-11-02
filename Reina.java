import java.util.LinkedList;
import java.util.List;

/**
 * Clase Reina que extiende Pieza para implementar una pieza de ajedrez de tipo reina
 * @author
 * @version (Noviembre 2022)
 * @see Pieza
 * @see Posicion
 */
public class Reina extends Pieza{

    public Reina(Posicion inicial, boolean esBlanca){
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
        // Movimiento horizontal
        for(int i = 97;i < 105;i++){
            if(i != columnaActual)
                movimientos.add(new Posicion((char) i, filaActual));
        }
        //Movimiento vertical
        for(int i=1;i < 9;i++){
            if(i != filaActual)
                movimientos.add(new Posicion((char) columnaActual, i));
        }
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
        return "Q" + (this.color ? "B" : "N");
    }
}
