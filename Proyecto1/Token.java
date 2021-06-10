package examples.handson;

import java.util.regex.*;
import java.util.*;
import jade.core.Agent;

public class Token{

    public Token(){}

    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    private Tipos tipo;
    private String valor;
    public boolean square;

    enum Tipos {
        NUMERO ("[0-9]+"),
        VARIABLE("[\\p{Alpha}]"),
        OPERADOR_BINARIO("[*|/|+|-|=]");
        

        public final String patron;
        Tipos(String s) {
            this.patron = s;
        }
    }

    public void resolver(String input){
        int x = 0,y = 0;
        boolean sqrt = false;
        String var[] = new String[5];
        String num[] = new String[5];

        ArrayList<Token> tokens = this.lex(input);
        for (Token token : tokens) {
            
            if(token.getTipo().toString()=="VARIABLE"){
                var[x] = token.getValor();
                x++;
            }else if(token.getTipo().toString()=="NUMERO"){
                num[y] = token.getValor().toString();
                y++;
            }
        }
        for(int i=0;i < var.length;i++){
            if(var[i]!=null&&var[i].contains("^")){ 
                sqrt = true;
                this.square = true;
            }
            for(int n=0;n<y;n++){
                if(var[i]==num[n]) num[n]=null;
            }
        }

        for(int i=0;i < var.length;i++){    
            try {
                Separador obj = new Separador(var[i]);
                System.out.println(Arrays.asList(obj.separa()[0]));
            } catch (Exception e) {}
        }
       
    }

    public ArrayList<Token> lex(String input) {
        final ArrayList<Token> tokens = new ArrayList<Token>();
        final StringTokenizer st = new StringTokenizer(input);

        while(st.hasMoreTokens()) {
            String palabra = st.nextToken();

            for (Tipos tokenTipo : Tipos.values()) {
                Pattern patron = Pattern.compile(tokenTipo.patron);
                Matcher matcher = patron.matcher(palabra);
                if(matcher.find()) {
                    Token tk = new Token();
                    tk.setTipo(tokenTipo);
                    tk.setValor(palabra);
                    tokens.add(tk);
                }
            }
        }

        return tokens;
    }
    
}