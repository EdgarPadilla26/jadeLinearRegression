
package examples.behaviours;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;


public class HandsOn5 extends Agent {

  protected void setup() {

    System.out.println("Agent "+getLocalName()+" started.");
    
    int b0 = 168;
    int b1 = 23;  
    int Sales = 0;
    System.out.println("\n\nThis is the Linear Regression Formula for Benneton\n\n");
    System.out.println("\n\n Sales = 168 + 23Advertising\n\n");

    System.out.println("Advertising | Sales");
    for(int adv = 23; adv<59; adv++){
      Sales = b0 + (b1*adv);
      System.out.println("  "+ adv + "           " + Sales);
    }

    System.out.println("\n\nEnd of LinearRegression\n\n");
  }  
  
}
