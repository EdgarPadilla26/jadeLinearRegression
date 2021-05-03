package examples.handson;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;


public class AgentRegressionDialog extends Agent {

    protected void setup() {
        System.out.println("\n This is the Simple Linear Regression Formula\n");
        System.out.println("y = Beta0 + Beta1x \n");
        //OneShotBehaviour
        addBehaviour(new Calcular());
    }

    public class Calcular extends OneShotBehaviour {

        public void action() {
            //Interfaz grafica del InputDialog
            InputDialog frame = new InputDialog();
            frame.setSize(200,200);
            frame.setLayout(null);
            frame.setVisible(true);
        }  
    }   
}