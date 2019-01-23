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
//		if(this.category == Category.PLAYER){
//			this.color = 0xffFFC312;
//		}
//		if(this.category == Category.COMBAT){
//			this.color = 0xffff0000;
//		}
//		if(this.category == Category.RENDER){
//			this.color = 0xff00aa00;
//		}
//		if(this.category == Category.WORLD){
//			this.color = 0xffff0000;
//		}
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
