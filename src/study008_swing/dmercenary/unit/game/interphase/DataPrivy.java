package study008_swing.dmercenary.unit.game.interphase;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class DataPrivy extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8388248679292397032L;

	public DataPrivy(int x, int y, int width, int height){
		init(x,y,width,height);
	}
	
	private void init(int x, int y, int width, int height){
		this.setBounds(x,y,width,height);
		this.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY));
	}

}
