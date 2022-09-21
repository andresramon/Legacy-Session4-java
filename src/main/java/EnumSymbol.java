public enum EnumSymbol{

    ZERO('O'),X('X'),EMPTY(' ');

    private char code;

    EnumSymbol(char s){
        code = s;
    }

    public char getCode(){
        return code;
    }

    public static EnumSymbol getEnumSymbol(final char code)    {
        for (EnumSymbol type : EnumSymbol.values())
            if (type.code == code)
                return type;

        return null;
    }

}
