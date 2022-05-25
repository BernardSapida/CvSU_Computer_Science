package WarBetweenPresident;

import WarBetweenPresident.Objects.Board;
import WarBetweenPresident.Objects.Units;

public class App {
    public static void main(String[] args) throws Exception {
        Board board = new Board();
        board.getBoard();
        board.positionUnits();
    }
}

/*
    a1 b1
    a1 z1
*/