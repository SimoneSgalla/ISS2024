package unibo.naiveactors24;

import java.io.File;
import java.io.FileWriter;

import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.msg.ProtocolType;
import unibo.basicomm23.utils.CommUtils;

public class obslogger extends ActorBasic24{
		
	public obslogger(String name, ActorContext24 ctx) {
        super(name,ctx);
        new File("obsloggerLog.txt");
    }
	
	protected void elabMsg(IApplMessage msg) throws Exception {
        CommUtils.outgreen(name + " | elab " + msg + " in:" + Thread.currentThread().getName());
        if( msg.isDispatch() ) {
        	FileWriter myWriter = new FileWriter("filename.txt");
        	myWriter.write("msg");
        	myWriter.close();
        }
	}

}
