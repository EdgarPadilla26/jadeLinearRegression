package examples.messaging.handson6;
 
import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.*;
 
public class EmisorAgent extends Agent {

    protected void setup() {
        addBehaviour(new EmisorComportaminento());
    }

   private class EmisorComportaminento extends SimpleBehaviour {
        boolean fin = false;
      
        public void action() {
            System.out.println(getLocalName() +": Enviando variable al receptor");
            AID id = new AID();
            id.setLocalName("receptor");
 
            ACLMessage variable = new ACLMessage(ACLMessage.INFORM);
            variable.setSender(getAID());
            variable.setContent("59");
 
            send(variable);
            
            fin = true;
        }
 
        public boolean done()
        {
            return fin;
        }
    }

}

