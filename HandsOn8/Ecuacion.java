package examples.handson;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
import java.util.*;

public class Ecuacion extends Agent {

    protected void setup() {
        //OneShotBehaviour
        addBehaviour(new OpenFrame());
    }

    public class OpenFrame extends OneShotBehaviour{
        
        public void action() {
                       
            //Interfaz grafica del InputDialog
            TextFieldEcuacion frame = new TextFieldEcuacion();
            frame.setSize(400,400);
            frame.setLayout(null);
            frame.setVisible(true);
            done();
            takeDown();
            doDelete();
        }
    }   
}