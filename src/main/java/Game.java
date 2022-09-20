public class Game {
    private char _lastSymbol = ' ';
    private Board _board = new Board();

    public void Play(char symbol, int x, int y) throws Exception {

        if (isFirstMove()) {
            firstPlayerHaveToBeXSymbol(symbol);
        }

        else if (isRepeatedPlayerTurn(symbol)) {
            throw new Exception("Invalid next player");
        }

        else if (isNotEmptyTile(x, y)) {
            throw new Exception("Invalid position");
        }

        updateGameState(symbol, x, y);
    }

    private boolean isNotEmptyTile(int x, int y){
        return _board.TileAt(x, y).Symbol != ' ';
    }

    private boolean isRepeatedPlayerTurn(char symbol){
        return symbol == _lastSymbol;
    }

    private void firstPlayerHaveToBeXSymbol(char symbol) throws Exception{
        if (isZeroSymbol(symbol)) {
            throw new Exception("Invalid first player");
        }
    }

    private boolean isZeroSymbol(char symbol){
        return symbol == 'O';
    }

    private boolean isFirstMove(){
        return _lastSymbol == ' ';
    }

    private void updateGameState(char symbol, int x, int y){
        _lastSymbol = symbol;
        _board.AddTileAt(symbol, x, y);
    }

    public char Winner() {
        //if the positions in first row are taken
        if (_board.winnerInRow(0))
            return _board.TileAt(0, 0).Symbol;

        //if the positions in first row are taken
        if (_board.winnerInRow(1))
            return _board.TileAt(1, 0).Symbol;

        //if the positions in first row are taken
        if (_board.winnerInRow(2))
            return _board.TileAt(2, 0).Symbol;

        return ' ';
    }

}

