

public class Tile
{
    public static final char EMPTY_TILE = ' ';
    private Position position;
    private EnumSymbol Symbol;

    public Tile(Position position){
        this.position = position;
        this.Symbol = EnumSymbol.EMPTY;
    }

    boolean isInPosition(Position position){
        return this.position.equals(position);
    }

    public boolean isNotEmpty(){
        return Symbol !=  EnumSymbol.EMPTY;
    }

    public void setSymbol(EnumSymbol symbol){
        Symbol = symbol;
    }

    public EnumSymbol getSymbol(){
        return Symbol;
    }

    boolean haveTheSameSymbol(Tile otherTile){
        return Symbol == otherTile.Symbol;
    }
}