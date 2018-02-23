package study_swing.dmercenary.unit.game.test;

import study_swing.dmercenary.unit.game.entity.things.Thing;

public class Stack extends Thing{
	
	protected Class stackType = null;
	protected Integer amount = 0;
	protected Integer size = 0;
	
	public Stack(Class stackType, Integer amount, Integer size){
		this.stackType = stackType;
		this.amount = amount;
		this.size = size;
	}
	
	public Integer stack(Thing thingToStack){
		if(thingToStack!=null && thingToStack instanceof Stack){
			Stack stack = (Stack)thingToStack;
			if(stack.getStackType().equals(this.stackType)){
				int remain = this.amount+stack.getAmount()-this.size;
				if(remain>0){
					this.amount = this.size;
					return remain;	//something more than size remains.
				}else{
					this.amount += stack.getAmount();
					return 0;	//all merged
				}
			}else{
				return -1;	//change position
			}			
		}else if(thingToStack!=null){
			if(thingToStack.getClass().equals(this.stackType)){
				if(this.amount<this.size){
					this.amount++;
					return 0;	//all merged
				}else{
					return -1;	//change position
				}
			}else{
				return -1;
			}
		}
		return 0;
	}
	
	public Integer split(Integer splitAmount){
		if(splitAmount>=this.amount){
			return null;
		}else{
			return null;
		}
	}

	public Class getStackType() {
		return stackType;
	}
	public void setStackType(Class stackType) {
		this.stackType = stackType;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}	
}
