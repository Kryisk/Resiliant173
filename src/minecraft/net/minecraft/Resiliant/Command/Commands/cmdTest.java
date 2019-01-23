package net.minecraft.Resiliant.Command.Commands;

import net.minecraft.Resiliant.Resiliant;
import net.minecraft.Resiliant.Command.Command;

public class cmdTest extends Command{

	public cmdTest() {
		super("Test", "Testing", "test");
		// TODO Auto-generated constructor stub
	}

	
	

	@Override
	public boolean recieveCommand(String cmd) throws Exception {
		Resiliant.mc.thePlayer.addChatMessage("NIGER");
		
		return true;
	}
	
	

}
