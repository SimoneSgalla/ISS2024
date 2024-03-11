package unibo.naiveactors24.example;
import java.io.IOException;
import java.io.PrintWriter;

import unibo.basicomm23.msg.ProtocolType;
import unibo.basicomm23.utils.CommUtils;
import unibo.naiveactors24.ActorContext24;
import unibo.naiveactors24.obslogger;
 

public class MainExampleNaiveActors24 {

	
	protected void alienCaller() {
		AlienJava caller = new AlienJava("javacaller", ProtocolType.tcp, "localhost", "8123");
		caller.activate();
	}
    public void configureTheSystem() throws IOException{
         
        int port1 = 8123;
        CommUtils.outblue("MainExampleTowardsActors24 CREA I CONTESTI ");
        ActorContext24 ctx1 = new ActorContext24("ctx1", "localhost", port1);
        CommUtils.outblue("MainExampleTowardsActors24 CREA GLI ATTORI ");

        Actor24Sender a1   = new Actor24Sender("produttore",ctx1);
        Actor24Receiver a2 = new Actor24Receiver("consumatore",ctx1);
        obslogger o = new obslogger("obslogger", ctx1);

        ctx1.showActorNames();
        
        o.activateAndStart();
        a1.activateAndStart();
        a2.activateAndStart();
        
        alienCaller();
        
        CommUtils.outblue("PROVO UPDATE ");
        a1.addObserver(o.getName());
        a2.addObserver(o.getName());
        a1.updateResources("prova");
        a2.updateResources("prova1");
        
    }
    public static void main(String[] args ) throws IOException{
        new MainExampleNaiveActors24().configureTheSystem();
    }
}
