package study_swing.dmercenary.unit.game.interphase;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class DataGroup extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8388248679292397032L;

	static{
		
	}
	
	private JLabel levelName = new JLabel();
	private JLabel race = new JLabel();
	private JLabel rank = new JLabel();
//	private JLabel name = new JLabel();
//	private JLabel name = new JLabel();
//	private JLabel name = new JLabel();
//	private JLabel name = new JLabel();
//	private JLabel name = new JLabel();
	
	public DataGroup(int x, int y, int width, int height){
		init(x,y,width,height);
	}
	
	private void init(int x, int y, int width, int height){
		this.setBounds(x,y,width,height);
		this.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY));
	}

}
