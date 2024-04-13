package practicaVCI;

public class Token {
    private String lexema; 
    private String token; 
    private String posicionEnTabla;
    private String linea; 

    public Token(String lexema, String token, String posicionEnTabla, String linea) {
        this.lexema = lexema;
        this.token = token;
        this.posicionEnTabla = posicionEnTabla;
        this.linea = linea;
    }

    public String getLexema() {
        return lexema;
    }

    public String getToken() {
        return token;
    }

    public String getPosicionEnTabla() {
        return posicionEnTabla;
    }

    public String getLinea() {
        return linea;
    }
    
    @Override
    public String toString() {
        return lexema + ", " + token + ", " + posicionEnTabla + ", " + linea; 
    }
}
