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
 
        // Creación del objeto ACLMessage
            ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM);
 
        //Rellenar los campos necesarios del mensaje
            mensaje.setSender(getAID());
            mensaje.addReceiver(id);
            mensaje.setContent("59");
 
        //Envia el mensaje a los destinatarios
            send(mensaje);
            
            fin = true;
        }
 
        public boolean done()
        {
            return fin;
        }
    }

}
