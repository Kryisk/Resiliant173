package net.minecraft.Resiliant.Module;

public class Module {
	
	private String name;
	private int bind;
	private int color;
	private Category category;
	private boolean isEnabled;
	
	public Module(String name, int bind, int color, Category category) {
		this.name = name;
		this.bind = bind;
		this.color = color;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public int getBind() {
		return bind;
	}

	public int getColor() {
		return color;
	}

	public Category getCategory() {
		return category;
	}

	public boolean getState() {
		return isEnabled;
	}
	
	public void setState(boolean state) {
		this.onToggle();
		if(state) {
			this.onEnable();
			this.isEnabled = true;
		}else{
			this.onDisable();
			this.isEnabled = false;
		}
	}
	
	public void toggleModule() {
		this.setState(!this.getState());
	}
	
	public void onToggle(){}
	public void onEnable(){}
	public void onDisable(){}
	public void onTick(){}
	public void onRender(){}
	
}
