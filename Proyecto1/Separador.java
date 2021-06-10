package examples.handson;

import java.util.*;

public class Separador{

    String ecuacion;
    public Separador(String ecuacion){
        this.ecuacion = ecuacion;
    }

    public String[] separa(){
        String[] split = ecuacion.split("[\\p{Alpha}]");
        return split;
    }
}