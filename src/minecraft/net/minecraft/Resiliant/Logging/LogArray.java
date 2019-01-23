package net.minecraft.Resiliant.Logging;

import java.util.ArrayList;


public class LogArray {
	
	public static ArrayList<Logger> activelogs = new ArrayList<Logger>();
	
	public LogArray() {
		
		LogArray.activelogs.add(new LoggerToggler());
		
	}

}
