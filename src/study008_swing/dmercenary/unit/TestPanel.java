package study008_swing.dmercenary.unit;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.xml.soap.SAAJResult;

import study008_swing.dmercenary.unit.DMercenary.SaveAndLoadSandBox;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

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
	
	private Insets control_inset = new Insets(2,2,2,2);
	
	
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
	
	public JPanel getSandbox() {
		return sandbox;
	}

	public void setSandbox(JPanel sandbox) {
		this.remove(this.sandbox);
		this.sandbox = sandbox;
		this.add(this.sandbox);
	}

	public JPanel getControl() {
		return control;
	}

	public void setControl(JPanel control) {
		this.remove(this.control);
		this.control = control;
		this.add(this.control);
	}

	public JPanel getData_group() {
		return data_group;
	}

	public void setData_group(JPanel data_group) {
		this.remove(this.data_group);
		this.data_group = data_group;
		this.add(this.data_group);
	}

	public JPanel getData_privy() {
		return data_privy;
	}

	public void setData_privy(JPanel data_privy) {
		this.remove(this.data_privy);
		this.data_privy = data_privy;
		this.add(this.data_privy);
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
		private JPanel battlefield = new JPanel(true);
		
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
		
		private void initMain(){
			this.battlefield.setLayout(null);
			this.battlefield.setBounds(LTX+BT,LTY+BT,MAIN_PANEL_WIDTH,MAIN_PANEL_HEIGHT);
			this.battlefield.setBorder(new LineBorder(Color.GRAY, 1));
			this.battlefield.setFocusable(true);
			this.battlefield.addMouseWheelListener(new MouseWheelListener() {
				@Override
				public void mouseWheelMoved(MouseWheelEvent e) {
					if(CANZOOM){
						int a = -(int)e.getPreciseWheelRotation();
						Component[] cArr = ((JPanel)e.getComponent()).getComponents();
						for(Component c: cArr){
							Cube cube = (Cube)c;
							cube.zoom(a);
						}
					}
				}
			});
		}
		
		private void init(){	
			this.setLayout(null);
			this.setBounds(0, 0,MAIN_PANEL_WIDTH+BT*2+LTX*2, MAIN_PANEL_HEIGHT+BT*2+LTY*2);
			this.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY));
			
			initMain();
			this.add(this.battlefield);
		}
	}
	
	class SandBoxJson{
		private int csl;
		private UnitJson[] unit;
		public int getCsl() {
			return csl;
		}
		public void setCsl(int csl) {
			this.csl = csl;
		}
		public UnitJson[] getUnit() {
			return unit;
		}
		public void setUnit(UnitJson[] unit) {
			this.unit = unit;
		}
		public SandBox parseSandBox(){
			SandBox sb = new SandBox();
			for(UnitJson uj : unit){
				switch (uj.type)
				{
					case "cube":{
						sb.battlefield.add(new Cube(uj.x,uj.y,uj.zr,uj.text,uj.iconUrl));
					}
				}
			}
			return sb;
		}
	}
	
	class UnitJson{
		private String type;
		private int x;
		private int y;
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
	
	class Cube extends JButton{
		private int zr;	//zoom_rate
		private int x;
		private int y;
		private String iconUrl;
		public Cube(){
			this(0,0,CSL,null,null);
		}
		
		public Cube(int x, int y, int zr, String name, String iconUrl){
			this.x = x;
			this.y = y;
			this.zr = zr;
			this.iconUrl = iconUrl;
			this.setText(name==null?"":name);
			this.setMargin(new Insets(0,0,0,0));
			this.setFont(new Font("Arial",Font.PLAIN,8));
			this.setBounds(x*zr, y*zr, zr, zr);
			
		}
		
		public void zoom(int a){
			if((zr+a>CSL/2-1)&&(zr+a)<=CSL){
				this.zr+=a;
				this.setBounds(x*zr, y*zr, this.zr, this.zr);
			}
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
			this.next.setMargin(control_inset);
			this.next.setFont(control_font);
			
			this.locate.setBounds(LTX*6+DBW, LTY*4, DBW, DBH);
			this.locate.setText("Locate");
			this.locate.setToolTipText("Locate current unit on the map");
			this.locate.setMargin(control_inset);
			this.locate.setFont(control_font);
			
			JButton jb1 = new JButton();
			jb1.setBounds(LTX*4, LTY*4+DBW/2, DBW, DBH);
			jb1.setText("Test");
			jb1.setMargin(control_inset);
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
				String jsonStr = readSaveFile(name).toString();
				SandBox sandbox = new SandBox();
				Gson gson = new Gson();
				JsonObject jo = null;
				JsonElement je = null;
				
				SandBoxJson sbj = gson.fromJson(jsonStr, SandBoxJson.class);
				return sbj.parseSandBox();
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
		
		private StringBuffer readSaveFile(String fileName) throws IOException{

			InputStream is = new FileInputStream("./save/scene/"+fileName+".json");
			byte[] content = new byte[300];
			int length = 0;
			StringBuffer sb = new StringBuffer();
			while(true){
				length = is.read(content);
				if(length<=0){
					break;
				}
				String line = new String(content).trim();
				String modified = line.replaceAll("\r|\n|\t", "");
				sb.append(modified);
			}
			return sb;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}