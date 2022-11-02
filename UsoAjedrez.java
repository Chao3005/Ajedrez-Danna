public class UsoAjedrez {
    public static void main(String[] args){
        Pieza queen = new Reina(new Posicion('f', 5), true);
        System.out.println("REINA en "+queen.obtenerPosicion()+" :");
        for(Posicion p : queen.posiblesMovimientos()){
            System.out.println(p);
        }
        System.out.println(queen.esValida(new Posicion('b', 1)));

        Pieza rook = new Torre(new Posicion('c', 7), false);
        System.out.println("TORRE en "+rook.obtenerPosicion()+" :");
        for(Posicion p : rook.posiblesMovimientos()){
            System.out.println(p);
        }
        System.out.println(rook.esValida(new Posicion('b', 1)));

        Pieza bishop = new Alfil(new Posicion('d', 5), true);
        System.out.println("ALFIL en "+bishop.obtenerPosicion()+" :");
        for(Posicion p : bishop.posiblesMovimientos()){
            System.out.println(p);
        }
        System.out.println(bishop.esValida(new Posicion('g', 8)));

        Pieza knight = new Caballo(new Posicion('e', 5), true);
        System.out.println("CABALLO en "+knight.obtenerPosicion()+" :");
        for(Posicion p : knight.posiblesMovimientos()){
            System.out.println(p);
        }
        System.out.println(knight.esValida(new Posicion('g', 4)));

        Pieza king = new Rey(new Posicion('a', 5), false);
        System.out.println("REY en "+king.obtenerPosicion()+" :");
        for(Posicion p : king.posiblesMovimientos()){
            System.out.println(p);
        }
        System.out.println(king.esValida(new Posicion('b', 4)));

        Pieza pawn = new Peon(new Posicion('g', 8), true);
        System.out.println("PEON en "+pawn.obtenerPosicion()+" :");
        for(Posicion p : pawn.posiblesMovimientos()){
            System.out.println(p);
        }
        System.out.println(pawn.esValida(new Posicion('g', 1)));
    }
}
