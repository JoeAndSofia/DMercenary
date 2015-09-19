package study008_swing.dmercenary.unit;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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

@SuppressWarnings("serial")
class DMercenary extends JFrame{
	private static final int LTX = 10;		//LEFT_TOP_X
	private static final int LTY = 10;		//LEFT_TOP_Y
	private static final int BT = 2;		//BORDER_THICKNESS
	private static final int CSL = 16;		//CUBE_SIDE_LENGTH
	private static final int MAIN_PANEL_WIDTH = 720;
	private static final int MAIN_PANEL_HEIGHT = 480;
	private static final int RG = 300;		//RIGHT_GAP
	private static final int BG = 100;		//BOTTOM_GAP
	private static boolean CANZOOM = true;
	static{
		try{
			Properties p = new Properties();
			FileInputStream in = new FileInputStream("config.properties");
			p.load(in);
			in.close();
			
			CANZOOM = Boolean.parseBoolean(p.getProperty("canzoom"));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	private Font control_font = new Font("Arial",Font.BOLD+Font.ITALIC,12);
	private Font sandbox_font = new Font("Arial",Font.PLAIN,8);	
	
	private Insets control_inset = new Insets(2,2,2,2);
	private Insets sandbox_inset = new Insets(0,0,0,0);
	
	
	private JPanel sandbox = new SandBox();
	private JPanel control = new Control(sandbox.getWidth(),0,RG+BT*2,sandbox.getHeight());
	private JPanel data_group = new DataGroup(0,sandbox.getHeight(),sandbox.getWidth(),BG+BT*2);
	private JPanel data_privy = new DataPrivy(sandbox.getWidth(),sandbox.getHeight(),control.getWidth(),data_group.getHeight());
	
	private String name;
	
	public DMercenary(){	
		this("DMercenary");
	}
	
	public DMercenary(String name){
		this.name = name;
		init();
//		System.out.println(this.getWidth()+","+this.getHeight());
//		System.out.println(sandbox.getWidth()+","+sandbox.getHeight());
//		System.out.println(control.getWidth()+","+control.getHeight());
//		System.out.println(data_group.getWidth()+","+data_group.getHeight());
//		System.out.println(data_privy.getWidth()+","+data_privy.getHeight());
		this.setVisible(true);
	}
	
	private void init(){
		this.setLayout(null);
		this.setBounds(20, 20, sandbox.getWidth()+control.getWidth()+6, sandbox.getHeight()+data_group.getHeight()+28);
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
			this.main.setBounds(LTX+BT,LTY+BT,MAIN_PANEL_WIDTH,MAIN_PANEL_HEIGHT);
			this.main.setBorder(new LineBorder(Color.GRAY, 1));
			this.main.setFocusable(true);
			this.main.addMouseWheelListener(new MouseWheelListener() {
				
				@Override
				public void mouseWheelMoved(MouseWheelEvent e) {
					if(CANZOOM){
						int a = -(int)e.getPreciseWheelRotation();
						Component[] carr = ((JPanel)e.getComponent()).getComponents();
						for(Component c: carr){
							Cube cube = (Cube)c;
							cube.zoom(a);
						}
					}
					
				}
			});
			
			this.setLayout(null);
			this.setBounds(0, 0,MAIN_PANEL_WIDTH+BT*2+LTX*2, MAIN_PANEL_HEIGHT+BT*2+LTY*2);
			this.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY));
			for(int i=0;i<(MAIN_PANEL_HEIGHT/CSL);i++){
				Cube c = new Cube(0,i,i+1+"");
				
				this.main.add(c);		
			}
			
			this.add(this.main);
		}
	}
	
	class Cube extends JButton{
		private int zr;	//zoom_rate
		private int x;
		private int y;
		public Cube(){
			this(0,0,null);
		}
		
		public Cube(int x, int y, String name){
			this.x = x;
			this.y = y;
			this.zr = CSL;
			this.setText(name==null?"":name);
			this.setMargin(sandbox_inset);
			this.setFont(sandbox_font);
			this.setBounds(x*zr, y*zr, zr, zr);
			
		}
		public void zoom(int a){
			if((zr+a>CSL/2-1)&&(zr+a)<=CSL){
				this.zr+=a;
				this.setBounds(x*zr, y*zr, this.zr, this.zr);
			}
		}
	}
	
	class Control extends JPanel{
		private static final int DBW = 100;		//DEFAULT_BUTTON_WIDTH
		private static final int DBH = 25;		//DEFAULT_BUTTON_HEIGHT
		
		private JButton next = new JButton();
		private JButton locate = new JButton();
		
		public Control(int x, int y, int width, int height){
			init(x,y,width,height);
		}
		
		private void init(int x, int y, int width, int height){
			
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
			this.setBounds(x,y,width,height);
			this.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY));
			this.add(next);
			this.add(locate);
		}
	}
	
	class DataGroup extends JPanel{
		public DataGroup(int x, int y, int width, int height){
			init(x,y,width,height);
		}
		
		private void init(int x, int y, int width, int height){
			this.setBounds(x,y,width,height);
			this.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY));
		}
	}
	
	class DataPrivy extends JPanel{
		public DataPrivy(int x, int y, int width, int height){
			init(x,y,width,height);
		}
		
		private void init(int x, int y, int width, int height){
			this.setBounds(x,y,width,height);
			this.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY));
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}