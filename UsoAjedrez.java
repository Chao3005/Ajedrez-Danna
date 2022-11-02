public class UsoAjedrez {
    public static void main(String[] args){
        Reina queen = new Reina(new Posicion('f', 5), true);
        for(Posicion p : queen.posiblesMovimientos()){
            System.out.println(p);
        }
        System.out.println(queen.esValida(new Posicion('b', 1)));

        Torre rook = new Torre(new Posicion('c', 7), false);
        for(Posicion p : rook.posiblesMovimientos()){
            System.out.println(p);
        }
        System.out.println(rook.esValida(new Posicion('b', 1)));

        Alfil bishop = new Alfil(new Posicion('d', 5), true);
        for(Posicion p : bishop.posiblesMovimientos()){
            System.out.println(p);
        }
        System.out.println(bishop.esValida(new Posicion('g', 8)));

        Caballo knight = new Caballo(new Posicion('e', 5), true);
        for(Posicion p : knight.posiblesMovimientos()){
            System.out.println(p);
        }
        System.out.println(knight.esValida(new Posicion('g', 4)));

        Rey king = new Rey(new Posicion('a', 8), false);
        for(Posicion p : king.posiblesMovimientos()){
            System.out.println(p);
        }
        System.out.println(king.esValida(new Posicion('b', 4)));
    }
}
