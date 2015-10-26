package study008_swing.dmercenary.unit.game.interphase;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import com.google.gson.Gson;

public class TestPanel{
	public static void main(String[] args){
		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			DMercenary dm = new DMercenary();
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
	private static final int SSL = 16;		//SQUARE_SIDE_LENGTH
	private static final int MAIN_PANEL_WIDTH = 720;
	private static final int MAIN_PANEL_HEIGHT = 480;
	private static final int RG = 300;		//RIGHT_GAP
	private static final int BG = 100;		//BOTTOM_GAP
	private static final Insets CONTROL_INSETS = new Insets(2,2,2,2);
	public static final Insets BEING_SQUARE_INSETS = new Insets(0,0,0,0);
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
	

	
	private SandBox sandbox = new SandBox();
	private Control control = new Control(sandbox.getWidth(),0,RG+BT*2,sandbox.getHeight());
	private DataGroup data_group = new DataGroup(0,sandbox.getHeight(),sandbox.getWidth(),BG+BT*2);
	private DataPrivy data_privy = new DataPrivy(sandbox.getWidth(),sandbox.getHeight(),control.getWidth(),data_group.getHeight());
	
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
	
	public JPanel getSandbox() {
		return sandbox;
	}

	public void setSandbox(SandBox sandbox) {
		if(sandbox instanceof SandBox){
			this.remove(this.sandbox);
			this.sandbox = sandbox;
			this.add(this.sandbox);
			this.sandbox.battlefield.requestFocusInWindow();
		}else{
			throw new RuntimeException("sandbox is not an instance of SandBox.");
		}
	}

	public JPanel getControl() {
		return control;
	}

	public void setControl(Control control) {
		if(control instanceof Control){
			this.remove(this.control);
			this.control = control;
			this.add(this.control);
		}else{
			throw new RuntimeException("control is not an instance of Control.");
		}
	}

	public JPanel getData_group() {
		return data_group;
	}

	public void setData_group(DataGroup data_group) {
		if(data_group instanceof DataGroup){
			this.remove(this.data_group);
			this.data_group = data_group;
			this.add(this.data_group);			
		}else{
			throw new RuntimeException("data_group is not an instance of DataGroup.");
		}
	}

	public JPanel getData_privy() {
		return data_privy;
	}

	public void setData_privy(DataPrivy data_privy) {
		if(data_privy instanceof DataPrivy){
			this.remove(this.data_privy);
			this.data_privy = data_privy;
			this.add(this.data_privy);	
		}else{
			throw new RuntimeException("data_privy is not an instance of DataPrivy.");
		}
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
	
	class SandBox extends JPanel implements MouseWheelListener, KeyListener{
		private JPanel battlefield = new JPanel(true);
		private JButton activated = new JButton();
		
		public SandBox(){
			init();
		}
		
		public JPanel getBattleField() {
			return battlefield;
		}
		
		public void setBattleField(JPanel main) {
			this.remove(this.battlefield);
			this.battlefield = main;
			initMain();
			this.add(battlefield);
		}
		
		public JButton getActivated() {
			return activated;
		}
		
		public void setActivated(JButton activated) {
			this.activated = activated;
		}
		
		private void initMain(){
			this.battlefield.setLayout(null);
			this.battlefield.setBounds(LTX+BT,LTY+BT,MAIN_PANEL_WIDTH,MAIN_PANEL_HEIGHT);
			this.battlefield.setBorder(new LineBorder(Color.GRAY, 1));
			this.battlefield.setFocusable(true);
			this.battlefield.addMouseWheelListener(this);
			this.battlefield.addKeyListener(this);
		}
		
		private void init(){	
			this.setLayout(null);
			this.setBounds(0, 0,MAIN_PANEL_WIDTH+BT*2+LTX*2, MAIN_PANEL_HEIGHT+BT*2+LTY*2);
			this.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY));
			
			initMain();
			this.add(this.battlefield);
		}

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			if(CANZOOM){
				int a = -(int)e.getPreciseWheelRotation();
				Component[] cs = ((JPanel)e.getComponent()).getComponents();
				for(Component c: cs){
					if(c instanceof Square){
						Square beingSquare = (Square)c;
						beingSquare.zoom(a*beingSquare.mr/4);	
					}
				}
			}
		}

		@Override
		public void keyPressed(KeyEvent k) {
			System.out.println(k.getExtendedKeyCode());
			System.out.println(k.getKeyCode());
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class SandBoxJson{
		private int csl;
		private BeingSquareJson[] unit;
		public int getCsl() {
			return csl;
		}
		public void setCsl(int csl) {
			this.csl = csl;
		}
		public BeingSquareJson[] getUnit() {
			return unit;
		}
		public void setUnit(BeingSquareJson[] unit) {
			this.unit = unit;
		}
		public SandBox parseSandBox(){
			SandBox sb = new SandBox();
			for(BeingSquareJson bcj : unit){
				switch (bcj.type)
				{
					case "square":{
						sb.battlefield.add(new Square(bcj.x,bcj.y,bcj.w,bcj.h,bcj.zr,bcj.text,bcj.iconUrl));
					}
				}
			}
			return sb;
		}
	}
	
	class Square extends JButton implements ActionListener{
		private int zr;	//zoom_rate
		private int mr;	//max_rate
		private int x;
		private int y;
		private int w;
		private int h;
		private String iconUrl;
		public Square(){
			this(0,0,SSL,SSL,SSL,null,null);
		}
		
		public Square(int x, int y, int w, int h, int zr, String tooltip, String iconUrl){
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.mr = zr;
			this.zr = zr;
			this.iconUrl = iconUrl;
			if(this.iconUrl==null || "".equals(this.iconUrl.trim())){
				this.setText(tooltip==null?"":tooltip);	
			}else{
				this.setIcon(new ImageIcon());
			}
			this.setToolTipText(tooltip==null?"":tooltip);
			this.setMargin(BEING_SQUARE_INSETS);
//			this.setFont(new Font("Arial",Font.PLAIN,fontsize));
			this.setBorder(null);
//			this.setIcon(arg0); 
			this.setBounds(x*zr, y*zr, w*zr, h*zr);
			this.addActionListener(this);
			
		}
		
		public void zoom(int a){
			if((zr+a>mr/2-1)&&(zr+a)<=mr){
				this.zr+=a;
				this.setBounds(x*zr, y*zr, w*zr, h*zr);
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Square square = (Square)e.getSource();
			SandBox sandbox = (SandBox)square.getParent().getParent();
			sandbox.battlefield.requestFocusInWindow();
			sandbox.setActivated(square);
//			((Square)e.getSource()).getParent().requestFocusInWindow();
			
		}
	}
	
	class BeingSquareJson{
		private String type;
		private int x;
		private int y;
		private int w;
		private int h;
		private int zr;
		private String text;
		private String iconUrl;
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getW() {
			return w;
		}
		public int getH() {
			return h;
		}
		public void setW(int w) {
			this.w = w;
		}
		public void setH(int h) {
			this.h = h;
		}
		public int getZr() {
			return zr;
		}
		public void setZr(int zr) {
			this.zr = zr;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public String getIconUrl() {
			return iconUrl;
		}
		public void setIconUrl(String iconUrl) {
			this.iconUrl = iconUrl;
		}		
	}
	
	class Control extends JPanel implements ActionListener{
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
			this.next.setMargin(CONTROL_INSETS);
			this.next.setFont(control_font);
			
			this.locate.setBounds(LTX*6+DBW, LTY*4, DBW, DBH);
			this.locate.setText("Locate");
			this.locate.setToolTipText("Locate current unit on the map");
			this.locate.setMargin(CONTROL_INSETS);
			this.locate.setFont(control_font);
			
			JButton jb1 = new JButton();
			jb1.setBounds(LTX*4, LTY*4+DBW/2, DBW, DBH);
			jb1.setText("Test");
			jb1.setMargin(CONTROL_INSETS);
			jb1.setFont(control_font);
			jb1.addActionListener(this);
			
//			dm.update(dm.getGraphics());
			
			this.setLayout(null);
			this.setBounds(x,y,width,height);
			this.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY));
			this.add(next);
			this.add(locate);
			this.add(jb1);
		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			JButton jb = (JButton)ae.getSource();
			if("test".equalsIgnoreCase(jb.getText())){
				SaveAndLoadSandBox sl = new SaveAndLoadSandBox();
				setSandbox(sl.loadSandBox("joe"));
			}

			
			this.getParent().update(this.getParent().getGraphics());
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
	
	
	class SaveAndLoadSandBox{
		public SandBox loadSandBox(String name){
			try{
				String jsonStr = readSaveFile(name);
				Gson gson = new Gson();
				
				SandBoxJson sbj = gson.fromJson(jsonStr, SandBoxJson.class);
				SandBox sb = sbj.parseSandBox();
				return sb;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
		
		private String readSaveFile(String fileName) throws IOException{
			File scene = new File("."+File.separator+"save"+File.separator+"scene"+File.separator+fileName+".json");
			InputStream is = new FileInputStream(scene);
			byte[] content = new byte[(int)scene.length()];
			is.read(content);
			is.close();
			String line = new String(content).trim();
			String modified = line.replaceAll("\r|\n|\t", "");
			return modified;
		}
	}
}
