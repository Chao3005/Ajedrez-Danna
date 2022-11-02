public class UsoAjedrez {
    public static void main(String[] args){
        Reina queen = new Reina(new Posicion('f', 5), true);
        for(Posicion p : queen.posiblesMovimientos()){
            System.out.println(p);
        }
        System.out.println(queen.esValida(new Posicion('b', 1)));
    }
}
