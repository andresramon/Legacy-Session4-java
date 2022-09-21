public class Game{

    private EnumSymbol _lastSymbol = EnumSymbol.EMPTY;
    private Board _board = new Board();

    public void Play(char symbol, int row, int col) throws Exception{

        Position position = new Position(row, col);

        EnumSymbol enumSymbol = EnumSymbol.getEnumSymbol(symbol);

        if(isFirstMove()){
            firstPlayerHaveToBeXSymbol(enumSymbol);
        }

        if(isRepeatedPlayerTurn(enumSymbol)){
            throw new Exception("Invalid next player");
        }

        if(_board.tileIsNotEmpty(position)){
            throw new Exception("Invalid position");
        }

        updateGameState(enumSymbol, position);
    }

    private boolean isRepeatedPlayerTurn(EnumSymbol symbol){
        return symbol == _lastSymbol;
    }

    private void firstPlayerHaveToBeXSymbol(EnumSymbol symbol) throws Exception{
        if(isZeroSymbol(symbol)){
            throw new Exception("Invalid first player");
        }
    }

    private boolean isZeroSymbol(EnumSymbol symbol){
        return symbol == EnumSymbol.ZERO;
    }

    private boolean isFirstMove(){
        return _lastSymbol == EnumSymbol.EMPTY;
    }

    private void updateGameState(EnumSymbol symbol, Position position){
        _lastSymbol = symbol;
        _board.addSymbolToTile(symbol.getCode(), position);
    }

    public char Winner(){
        return _board.winner();
    }

}

