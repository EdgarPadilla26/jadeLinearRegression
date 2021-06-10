package examples.handson;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

import java.util.*;

public class LinearProfeAgent extends Agent {

	protected void setup() {
		
		DFAgentDescription dfd = new DFAgentDescription();
		dfd.setName(getAID());
		ServiceDescription sd = new ServiceDescription();
		sd.setType("profe");
		sd.setName("Proyect1");
		dfd.addServices(sd);
		try {
			DFService.register(this, dfd);
		}
		catch (FIPAException fe) {
			fe.printStackTrace();
		}

		addBehaviour(new ResolverEcuacion());
		addBehaviour(new Resumen());
	}

	
	protected void takeDown() {
		try {
			DFService.deregister(this);
		}
		catch (FIPAException fe) {
			fe.printStackTrace();
		}

		System.out.println("Profesor "+getAID().getName()+" finalizado.");
	}

	private class ResolverEcuacion extends CyclicBehaviour {
		public void action() {
            
			MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.CFP);
			ACLMessage msg = myAgent.receive(mt);
			
			if (msg != null) {
                Token ecuacion = new Token();
			    ecuacion.resolver(msg.getContent());
                ACLMessage reply = msg.createReply();

                if(!ecuacion.square) {
                    DataSetLinear data = new DataSetLinear();
                    LinearRegression solve = new LinearRegression(data.getAdv(), data.getYear());
                    solve.regression();
                    
					reply.setPerformative(ACLMessage.PROPOSE);
					reply.setContent("y = " + solve.B0 + "B0 + " + solve.B1 + "B1");
				}
				else {
					reply.setPerformative(ACLMessage.REFUSE);
					reply.setContent("No resuelvo esas ecuaciones");
				}
				myAgent.send(reply);
			}
			else {
				block();
			}
		}
	}  

    private class Resumen extends CyclicBehaviour {
		public void action() {

			MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.ACCEPT_PROPOSAL);
			ACLMessage msg = myAgent.receive(mt);

			if(msg != null){
				
				String Ecuacion = msg.getContent();
				ACLMessage reply = msg.createReply();
 
				if (Ecuacion != null) {
					reply.setPerformative(ACLMessage.INFORM);
					System.out.println(Ecuacion + " fue resuelta para " + msg.getSender().getName());
				}
				else {
					reply.setPerformative(ACLMessage.FAILURE);
					reply.setContent("Sabra dios quien te ayude");
				}
				myAgent.send(reply);
			}
			else {
				block();
			}
		}
	}
}
