package net.minecraft.Resiliant.Logging;

import java.util.ArrayList;

import net.minecraft.Resiliant.Module.Module;

public class Logger {
	
	private int mods_toggled;
	private String mod;
	
	public Logger(int toggled, String module) {
		toggled = this.mods_toggled;
		module = this.mod;
	}
	

	public int getMods_toggled() {
		return mods_toggled;
	}

	public void setMods_toggled(int mods_toggled) {
		this.mods_toggled = mods_toggled;
	}

	public String getMod() {
		return mod;
	}

	public void setMod(String mod) {
		this.mod = mod;
	}
	
	
	
}
