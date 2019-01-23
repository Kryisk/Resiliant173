package net.minecraft.Resiliant.Module;


import java.util.ArrayList;

import net.minecraft.Resiliant.Module.Modules.Combat.KillAura;
import net.minecraft.Resiliant.Module.Modules.World.Actualysppeedd;
import net.minecraft.Resiliant.Module.Modules.Player.AntiVelocity;
import net.minecraft.Resiliant.Module.Modules.World.Flight;
import net.minecraft.Resiliant.Module.Modules.World.Jesus;
import net.minecraft.Resiliant.Module.Modules.World.Nuker;
import net.minecraft.Resiliant.Module.Modules.World.Run;
import net.minecraft.Resiliant.Module.Modules.World.Speedmine;
import net.minecraft.Resiliant.Module.Modules.Player.Sprint;
import net.minecraft.Resiliant.Module.Modules.Player.fastwalk;
import net.minecraft.Resiliant.Module.Modules.Player.nameprotect;
import net.minecraft.Resiliant.Module.Modules.Player.reversenuke;
import net.minecraft.Resiliant.Module.Modules.Player.signedit;
import net.minecraft.Resiliant.Module.Modules.Player.waterplace;
import net.minecraft.Resiliant.Module.Modules.Render.Fullbright;
import net.minecraft.Resiliant.Module.Modules.Render.jvision;
import net.minecraft.Resiliant.Module.Modules.World.fastplace;
import net.minecraft.Resiliant.Module.Modules.World.Rise;

public class ModuleManager {
	
	public static ArrayList<Module> activeModules = new ArrayList<Module>();
	
	public ModuleManager() {
		
		
		ModuleManager.activeModules.add(new Speedmine());
		ModuleManager.activeModules.add(new fastwalk());
		ModuleManager.activeModules.add(new AntiVelocity());
		ModuleManager.activeModules.add(new nameprotect());
		ModuleManager.activeModules.add(new reversenuke());
		ModuleManager.activeModules.add(new Run());
		ModuleManager.activeModules.add(new Fullbright());
		ModuleManager.activeModules.add(new waterplace());
		ModuleManager.activeModules.add(new Rise());
		ModuleManager.activeModules.add(new fastplace());
		ModuleManager.activeModules.add(new KillAura());
		ModuleManager.activeModules.add(new signedit());
		ModuleManager.activeModules.add(new jvision());		
		ModuleManager.activeModules.add(new Actualysppeedd());
		ModuleManager.activeModules.add(new Jesus());
		ModuleManager.activeModules.add(new Nuker());
		ModuleManager.activeModules.add(new Flight());
		ModuleManager.activeModules.add(new Sprint());
		


		
		
	}
	
	public static ArrayList<Module> getModules() {
		return activeModules;
	}

	public Module getModule(Class<? extends Module> clazz) {
		for (Module mod : getModules()) {
			if (mod.getClass() == clazz) {
				return mod;
			}
		}
		return null;
	}

}
