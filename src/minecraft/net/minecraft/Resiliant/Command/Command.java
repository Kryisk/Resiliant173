package net.minecraft.Resiliant.Command;

import java.util.ArrayList;

import net.minecraft.Resiliant.Command.Commands.cmdTest;
import net.minecraft.client.Minecraft;

public  class Command {

	private String words;
	private String extras;
	private String desc;
	
	private Minecraft mc = null;
	public static String command_prefix = ".";
	
	public static ArrayList<Command> cmdList = new ArrayList<Command>();
	
	public Command(String words, String extras, String desc){
		this.words = words;
		this.extras = extras;
		this.desc = desc;
	}
	
	public static void instantiateCommands(){
		add(new cmdTest());
	}
	private static void add(Command cmd){
		cmdList.add(cmd);
		
	}
	
	public boolean recieveCommand(String cmd) throws Exception {
		return false;
	}  
	
	public String getWords(){
		return words;
	}
	
	public String getExtras(){
		return extras;
	}
	
	public String getDesc(){
		return desc;
	}
	
	protected void setWords(String words){
		this.words = words;
	}
	
	protected void setExtras(String extras){
		this.extras = extras;
	}
	
	public String getFirstWord(){
		String[] wordArray = words.split(" ");
		return wordArray[0];
	}
}
