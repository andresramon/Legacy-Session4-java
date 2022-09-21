

public class Tile
{
    public static final char EMPTY_TILE = ' ';
    private Position position;
    private char Symbol;

    public Tile(Position position){
        this.position = position;
        this.Symbol = EMPTY_TILE;
    }

    boolean isInPosition(Position position){
        return this.position.equals(position);
    }

    public boolean isNotEmpty(){
        return Symbol != EMPTY_TILE;
    }

    public void setSymbol(char symbol){
        Symbol = symbol;
    }

    public char getSymbol(){
        return Symbol;
    }

    boolean haveTheSameSymbol(Tile otherTile){
        return Symbol == otherTile.Symbol;
    }
}