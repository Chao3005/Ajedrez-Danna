
/**
 * Clase que implementa una posicion bajo un contexto de tablero de ajedrez
 * @author
 * @version (Nomviembre 2022)
 */
public class Posicion {
    private char columna;
    private int fila;

    /**
     * Constructor parametrizado de una posición de ajedrez
     * @param columna Caracter que simboliza la columna del tablero (a-h)
     * @param fila Número entero que simboliza la fila del tablero (1-8)
     * @throws IllegalArgumentException En caso de recibir parámetros invalidos para fila o columna de una posición
     */
    public Posicion(char columna, int fila){
        this.asignarColumna(columna);
        this.asignarFila(fila);
    }

    /**
     * Método consultor de la columna de la posición
     * @return Devuelve el caracter de la columna de la posición
     */
    public char obtenerColumna(){
        return this.columna;
    }

    /**
     * Método consultor de la fila de la posición
     * @return Devuelve el entero de la fila de la posición
     */
    public int obtenerFila(){
        return this.fila;
    }

    /**
     * Método modificador de la columna de la posición
     * @param columna Nuevo caracter por asignar como columna (a-h)
     * @throws IllegalArgumentEsxception En caso de recibir un parametro distinto a una letra (a-h)
     */
    public void asignarColumna(char columna){
        int ascii = (int) columna;
        if(ascii < 97 || 104 < ascii)
            throw new IllegalArgumentException();
        this.columna = columna;
    }

    /**
     * Método modificador de la fila de una posición
     * @param fila Nuevo entero por asignar como fila (1-8)
     * @throws IllegalArgumentException En caso de recibir un parametro fuera del rango [1,8]
     */
    public void asignarFila(int fila){
        if(fila < 1 || fila > 8)
            throw new IllegalArgumentException();
        this.fila = fila;
    }

    /**
     * Método que devuelve una cadena representativa de la posición
     * @return Devuelve una cadena que indica fila y columna de la posición
     */
    @Override
    public String toString(){
        return this.columna+""+this.fila;
    }
}