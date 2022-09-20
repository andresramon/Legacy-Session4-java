import java.util.ArrayList;
import java.util.List;

public class Board{
    private List<Tile> _plays = new ArrayList<>();

    public Board(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                Tile tile = new Tile();
                tile.position = new Position(i, j);
                tile.Symbol = ' ';
                _plays.add(tile);
            }
        }
    }

    public Tile TileAt(Position position){
        for(Tile t : _plays){
            if(t.position.X == position.X && t.position.Y == position.Y){
                return t;
            }
        }
        return null;
    }

    public void AddTileAt(char symbol, Position position){
        Tile newTile = new Tile();
        newTile.position = position;
        newTile.Symbol = symbol;

        TileAt(position).Symbol = symbol;
    }

    private boolean rowIsComplete(int rowNumber){
        return TileAt(new Position(rowNumber, 0)).Symbol != ' ' && TileAt(new Position(rowNumber, 1)).Symbol != ' '
                && TileAt(new Position(rowNumber, 2)).Symbol != ' ';
    }

    private boolean tilesHasTheSameSymbol(int rowNumber){
        return TileAt(new Position(rowNumber, 0)).Symbol == TileAt(new Position(rowNumber, 1)).Symbol
                && TileAt(new Position(rowNumber, 2)).Symbol == TileAt(new Position(rowNumber, 1)).Symbol;
    }

    public boolean winnerInRow(int rowNumber){
        if(rowIsComplete(rowNumber)){
            return tilesHasTheSameSymbol(rowNumber);
        }
        return false;
    }
}