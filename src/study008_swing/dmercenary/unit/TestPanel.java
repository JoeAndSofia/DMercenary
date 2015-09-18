package study008_swing.dmercenary.unit;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class TestPanel{
	public static void main(String[] args){
		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			DMercenary dm = new DMercenary();
//			Farmer f = new Farmer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class DMercenary extends JFrame{
	private static final int LTX = 10;		//LEFT_TOP_X
	private static final int LTY = 10;		//LEFT_TOP_Y
	private static final int BT = 2;		//BORDER_THICKNESS
	private static final int CSL = 25;		//CUBE_SIDE_LENGTH
	private static final int CAPV = 20;		//CUBE_AMOUNT_PER_VERTICLE
	private static final int CAPH = 30;		//CUBE_AMOUNT_PER_HORIZONTAL
	private static final int RG = 300;		//RIGHT_GAP
	private static final int BG = 100;		//BOTTOM_GAP

	private Font control_font = new Font("Arial",Font.BOLD+Font.ITALIC,12);
	private Font sandbox_font = new Font("Arial",Font.PLAIN,8);	
	
	private Insets control_inset = new Insets(2,2,2,2);
	private Insets sandbox_inset = new Insets(0,0,0,0);
	
	
	private JPanel sandbox = new SandBox();
	private JPanel control = new Control();
	private JPanel data_group = new DataGroup();
	private JPanel data_privy = new DataPrivy();
	
	private String name;
	
	public DMercenary(){	
		this("DMercenary");
	}
	
	public DMercenary(String name){
		this.name = name;
		init();
		this.setVisible(true);
	}
	
	private void init(){
		this.setLayout(null);
		this.setBounds(50, 50, CAPH*CSL+BT*12+RG+1, CAPV*CSL+BT*12+BG+1);
		this.setResizable(false);
		this.add(this.sandbox);
		this.add(this.control);
		this.add(this.data_group);
		this.add(this.data_privy);
		this.setTitle(this.name);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	class SandBox extends JPanel{
		private JPanel main = new JPanel(true);
		
		public SandBox(){
			init();
		}
		
		private void init(){
			this.main.setLayout(null);
			this.main.setBounds(LTX+BT,LTY+BT,CAPH*CSL,CAPV*CSL);
			this.main.setBorder(new LineBorder(Color.GRAY, 1));
			this.main.setFocusable(true);
			
			this.setLayout(null);
			this.setBounds(0, 0, CAPH*CSL+BT*2+LTX*2, CAPV*CSL+BT*2+LTY*2);
			this.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY));
			for(int i=0;i<CAPV;i++){
				this.main.add(new Cube(2,i*CSL+2,i+1+""));				
			}
			
			this.add(this.main);
		}
	}
	
	class Cube extends JButton{
		public Cube(){
			this(0,0,null);
		}
		
		public Cube(int x, int y, String name){
			this.setText(name==null?"":name);
			this.setMargin(sandbox_inset);
			this.setFont(sandbox_font);
			this.setBounds(x, y, CSL-4, CSL-4);
			
		}
	}
	
	class Control extends JPanel{
		private static final int DBW = 100;		//DEFAULT_BUTTON_WIDTH
		private static final int DBH = 25;		//DEFAULT_BUTTON_HEIGHT
		
		private JButton next = new JButton();
		private JButton locate = new JButton();
		
		public Control(){
			init();
		}
		
		private void init(){
			
			this.next.setBounds(LTX*4, LTY*4, DBW, DBH);
			this.next.setText("Next Round");
			this.next.setToolTipText("Give up the rest moves and enter into next Round");
			this.next.setMargin(control_inset);
			this.next.setFont(control_font);
			
			this.locate.setBounds(LTX*6+DBW, LTY*4, DBW, DBH);
			this.locate.setText("Locate");
			this.locate.setToolTipText("Locate current unit on the map");
			this.locate.setMargin(control_inset);
			this.locate.setFont(control_font);
			
			this.setLayout(null);
			this.setBounds(CAPH*CSL+BT*2+LTX*2, 0, 300, CAPV*CSL+BT*2+LTY*2);
			this.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY));
			this.add(next);
			this.add(locate);
		}
	}
	
	class DataGroup extends JPanel{
		public DataGroup(){
			init();
		}
		
		private void init(){
			this.setBounds(0,CAPV*CSL+BT*2+LTY*2,CAPH*CSL+BT*2+LTX*2,100);
			this.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY));
		}
	}
	
	class DataPrivy extends JPanel{
		public DataPrivy(){
			init();
		}
		
		private void init(){
			this.setBounds(CAPH*CSL+BT*2+LTX*2,CAPV*CSL+BT*2+LTY*2,300,100);
			this.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY));
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}