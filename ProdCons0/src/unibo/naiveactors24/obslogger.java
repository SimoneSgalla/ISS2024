package unibo.naiveactors24;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.msg.ProtocolType;
import unibo.basicomm23.utils.CommUtils;

public class obslogger extends ActorBasic24{
		
	public obslogger(String name, ActorContext24 ctx) throws IOException {
        super(name,ctx);
    }
	
	protected void elabMsg(IApplMessage msg) throws IOException {
        CommUtils.outgreen(name + " | elab " + msg + " in:" + Thread.currentThread().getName());
        if( msg.msgId()=="update" ) {
        	FileWriter fstream = new FileWriter("obslogger.txt",true);
        	BufferedWriter out = new BufferedWriter(fstream);
        	CommUtils.outblue("SCRIVO FILE ");
        	out.write(msg.toString()+"\n");
        	out.close();
        }
	}
}
