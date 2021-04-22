package examples.messaging.handson6;
 
import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
 
public class ReceiverAgent extends Agent {
   
    
    protected void setup() {
        addBehaviour(new ReceptorComportaminento());
    }

    private class ReceptorComportaminento extends SimpleBehaviour {
            private boolean fin = false;
            int b0 = 168;
            int b1 = 23;  
            int Sales = 0;

            public void action() {
                System.out.println(" Please execute DummyAgent on GUI and set content with any value bigger than 23 or Execute EmisorAgent");
 
            //Obtiene el primer mensaje de la cola de mensajes
                ACLMessage mensaje = receive();
 
                if (mensaje!= null) {

                    System.out.println("\nThis is the Linear Regression Formula for Benneton\n\n");
                    System.out.println(" Sales = 168 + 23Advertising\n\n");
                    
                    System.out.println(getLocalName() + ": just received " + mensaje.getContent() + " of Advertising");
                    try {

                        int i = Integer.parseInt(mensaje.getContent());

                        System.out.println("\n Calculating...\n");
                        System.out.println("Advertising | Sales");
                        
                        for(int adv = 23; adv < i+1; adv++){
                            Sales = b0 + (b1*adv);
                            System.out.println("  "+ adv + "           " + Sales);
                        } 

                        System.out.println("End of LinearRegression\n");
                        fin = true; 

                    } catch (Exception e) {
                        System.out.println(getLocalName() + ": Al parecer eso no es un numero, intenta de nuevo");
                    }
                    

                    
                } else{
                    System.out.println("Receptor: Esperando a recibir mensaje...");
                    block();
                }
            }
            public boolean done() {
               return fin;
            }
    }
}







