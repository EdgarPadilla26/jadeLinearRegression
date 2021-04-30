package examples.handson;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;


public class AgentRegression extends Agent {

    protected void setup() {

        System.out.println("\n This is the Simple Linear Regression Formula\n");
        System.out.println("y = Beta0 + Beta1x \n");
        //OneShotBehaviour
        addBehaviour(new Calcular());
    }

    public class Calcular extends OneShotBehaviour {
        
        public void action() {

            int adv[] = {23,26,30,34,43,48,52,57,58};
            int sales[] = {651,762,856,1063,1190,1298,1421,1440,1518};

            LinearRegression obj = new LinearRegression(adv,sales);
            obj.regression();

            System.out.println("\n This is the Linear Regression Formula with dataSet \n");
            System.out.println("\nSales= " + obj.B0 + " + " + obj.B1 +"Advertising\n");

            System.out.println("\nIf Benneton invests 80ME in advertisings this is the result\n");
            System.out.println("Sales= " +  obj.forecastX(80));//2041.5057
        }  
    }   
}
