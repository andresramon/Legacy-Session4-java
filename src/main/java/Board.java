import java.util.ArrayList;
import java.util.List;

public class Board{

    private static final int FIRST_COLUMN = 0;
    private static final int SECOND_COLUMN = 1;
    private static final int THIRD_COLUMN = 2;
    private static final int NUMBER_OF_COLS = 3;
    private static final int FIRST_ROW = 0;
    private final int NUMBER_OF_ROWS = 3;
    private List<Tile> tiles = new ArrayList<>();

    public Board(){

        for(int row = FIRST_ROW; row < NUMBER_OF_ROWS; row++){
            for(int col = FIRST_COLUMN; col < NUMBER_OF_COLS; col++){
                initialize(row, col);
            }
        }
    }

    private void initialize(int row, int col){
        Tile tile = new Tile(new Position(row, col));
        tiles.add(tile);
    }

    private Tile TileAt(Position position){
        for(Tile tile : tiles){
            if(tile.isInPosition(position)){
                return tile;
            }
        }
        return null;
    }

    public void addSymbolToTile(char symbol, Position position){
        TileAt(position).setSymbol(symbol);
    }

    private boolean rowIsComplete(int row){
        return TileAt(new Position(row, FIRST_COLUMN)).isNotEmpty() && TileAt(new Position(row, SECOND_COLUMN)).isNotEmpty()
                && TileAt(new Position(row, THIRD_COLUMN)).isNotEmpty();
    }

    private boolean fullRowHaveTheSameSymbol(int row){
        return TileAt(new Position(row, FIRST_COLUMN)).haveTheSameSymbol(TileAt(new Position(row, SECOND_COLUMN)))
                && TileAt(new Position(row, THIRD_COLUMN)).haveTheSameSymbol(TileAt(new Position(row, SECOND_COLUMN)));
    }

    private boolean winnerInRow(int row){
        if(rowIsComplete(row)){
            return fullRowHaveTheSameSymbol(row);
        }
        return false;
    }

    public char winner() {
        for (int row = FIRST_ROW; row < NUMBER_OF_ROWS; row++) {
            if (winnerInRow(row)) {
                return TileAt(new Position(row, FIRST_COLUMN)).getSymbol();
            }
        }

        return Tile.EMPTY_TILE;
    }

    boolean tileIsNotEmpty(Position position){
        return TileAt(position).isNotEmpty();
    }
}