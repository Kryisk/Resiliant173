package net.minecraft.Resiliant;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip; 



import org.lwjgl.opengl.Display;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import net.minecraft.Resiliant.Command.Command;
import net.minecraft.Resiliant.Logging.LogArray;
import net.minecraft.Resiliant.Logging.Logger;
import net.minecraft.Resiliant.Module.ModuleManager;

import net.minecraft.client.Minecraft;



public class Resiliant {
	
	 public static  String client_name = "Resilient";
	 public static double client_version = 0.9;
	 public static String command_talk = "[Resiliant] ";
	 public static final Resiliant Resiliant = new Resiliant();
	 
	 public static boolean stop = false;
	 public static Minecraft mc = null;
	 public static ModuleManager modulemanager;
	 
	 public static Command cmd;
	 private static String protectedplayers = "Kryisk Kukumba unassigned_";
	 public static String[] protected_players = protectedplayers.split(" ");
	 
	 public static LogArray log;
	 
	 public static void StartClient() {
		 Display.setTitle(client_name + "(rel-"+ client_version + ")");
		 Command.instantiateCommands();
		 modulemanager = new ModuleManager();
		 log = new LogArray(); 
	
		 
		 System.out.println("# # # # # # # # # # # # # # # # # # #");
		 System.out.println("Starting client " + modulemanager.getModules().size() + " Mods loaded");
		 System.out.println("# # # # # # # # # # # # # # # # # # #");
	 }
	 
	 public static void stopClient() {
		 System.out.println("# # # # # # # # # # # # # # # # # # #");
		 System.out.println("Stoping Client");
		 System.out.println("# # # # # # # # # # # # # # # # # # #");
	 }
	 
	
	public static String getClient_name() {
		return client_name;
	}

	public static void setClient_name(String client_name) {
		Resiliant.client_name = client_name;
	}

	public static double getClient_version() {
		return client_version;
	}

	public static void setClient_version(double client_version) {
		Resiliant.client_version = client_version;
	} 
	  
}
