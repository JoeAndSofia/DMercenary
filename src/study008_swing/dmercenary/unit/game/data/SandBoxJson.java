package study008_swing.dmercenary.unit.game.data;

import study008_swing.dmercenary.unit.game.data.SquareJson;
import study008_swing.dmercenary.unit.game.interphase.SandBox;
import study008_swing.dmercenary.unit.game.carrier.Square;

public class SandBoxJson {
	private int csl;
	private SquareJson[] unit;
	public int getCsl() {
		return csl;
	}
	public void setCsl(int csl) {
		this.csl = csl;
	}
	public SquareJson[] getUnit() {
		return unit;
	}
	public void setUnit(SquareJson[] unit) {
		this.unit = unit;
	}
	public SandBox parseSandBox(){
		SandBox sb = new SandBox();
		for(SquareJson cj : unit){
			switch (cj.Type())
			{
				case "square":{
					sb.Battlefield().add(new Square(cj.X(),cj.Y(),cj.W(),cj.H(),cj.Zr(),cj.Text(),cj.IconUrl()));
				}
			}
		}
		return sb;
	}
}
