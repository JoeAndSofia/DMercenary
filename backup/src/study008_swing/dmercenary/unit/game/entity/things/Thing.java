package study008_swing.dmercenary.unit.game.entity.things;

import javax.swing.Icon;

import study008_swing.dmercenary.unit.game.entity.top.GameObject;

public class Thing extends GameObject {
	protected Integer stackAmount = 1;
	protected Integer stackSize = 1;
	
	public Thing(){
		this(null, null);
	}
	
	public Thing(String name, Icon image){
		this.name = name;
		this.image = image;
	}

	public Integer getStackSize() {
		return stackSize;
	}
	
	public void setStackSize(Integer stackSize) {this.stackSize = stackSize;}
	
	public Integer stack(Integer amount){
		if(this.stackSize==1){
			return amount;
		}else{
			int remain = this.stackAmount + amount - this.stackSize;
			if(remain>0){
				this.stackAmount = this.stackSize;
				return remain;
			}else if(remain==0){
				this.stackAmount = this.stackSize;
				return null;
			}else{
				this.stackAmount += amount;
				return null;
			}
		}
	}
	
	public Integer split(Integer amount){
		if(amount<1 || amount>=this.stackAmount || this.stackSize ==1){
			return null;
		}else{
			this.stackAmount -= amount;
			return amount;
		}
	}
}