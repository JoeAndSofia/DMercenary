package study_swing.dmercenary.unit.game.entity.things;

import java.util.HashMap;
import java.util.Map;

public class Pack extends Thing{
	
	private Integer size = null;
	private Integer amount = null;
	private boolean extra = false;
	private boolean inPack = false;
	private Map<String, Thing> things = new HashMap<String, Thing>();
	
	public Pack(){
		this(8,false);
	}
	
	public Pack(Integer size, boolean extra){
		this.amount = 0;
		this.size = size;
		this.extra = extra;
	}
	
	public boolean put(Thing thing){
		if(this.amount==this.size){
			return false;
		}
		if(thing instanceof Pack){
			Pack pack = (Pack)thing;
			if(pack.isExtra()){
				this.amount++;
			}else{
				if(this.amount + pack.getAmount() > this.size){
					return false;
				}
				this.amount+=pack.getAmount();
			}
			return true;
		}else{
			this.amount++;
			return true;	
		}
	}

	public Integer getAmount() {
		return amount;
	}
	public Integer getSize() {
		return size;
	}
	public boolean isExtra() {
		return extra;
	}
	public Map<String, Thing> getThings() {
		return things;
	}
	
	
	
	
	


	public void setSize(Integer size) {this.size = size;}
	public void setExtra(boolean extra) {this.extra = extra;}
	public void setAmount(Integer amount) {this.amount = amount;}
	public void setThings(Map<String, Thing> things) {this.things = things;}
}
