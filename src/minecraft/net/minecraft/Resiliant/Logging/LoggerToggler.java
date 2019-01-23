package net.minecraft.Resiliant.Logging;

import net.minecraft.Resiliant.Resiliant;

public class LoggerToggler extends Logger{

	public LoggerToggler() {
		super(Resiliant.modulemanager.activeModules.size(),"Mods Enabled");
		// TODO Auto-generated constructor stub
	}
	
	public void onGet() {
		System.out.println(Resiliant.modulemanager.getModules().size());
	}

}
