package study019_EasingFunction.EasingDemo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class EasingFunction extends JFrame{
	private static final Insets BUTTON_INSETS= new Insets(0,0,0,0);
	private static final int X_INTERVAL = 25;	
	
	private static long LINEAR_TIME_INTERVAL = 0;
	private static long QUADRATIC_TIME_INTERVAL = 0;
	private static long CUBIC_TIME_INTERVAL = 0;
	private static long QUARTIC_TIME_INTERVAL = 0;
	private static long QUINTIC_TIME_INTERVAL = 0;
	private static long SINUSOIDAL_TIME_INTERVAL = 0;
	private static long EXPONENTIAL_TIME_INTERVAL = 0;
	private static long CIRCULAR_TIME_INTERVAL = 0;
	private static long ELASTIC_TIME_INTERVAL = 0;
	private static long BACK_TIME_INTERVAL = 0;
	private static long BOUNCE_TIME_INTERVAL = 0;
	
	private JPanel animationBoard = new JPanel(true);
	private JPanel controlBoard = new JPanel();
	
	private ButtonGroup typeBg = new ButtonGroup();
	private ButtonGroup wayBg = new ButtonGroup();
	private JRadioButton[] easeTypeRadioButtonArr = new JRadioButton[11];
	private JRadioButton[] easeWayRadioButtonArr = new JRadioButton[3];
	private int type = 0;
	private int way = 0;
	private Thread t = null;
	private ThreadDraw td = new ThreadDraw();
	
	private JRadioButton linear = new JRadioButton();
	private JRadioButton quadratic = new JRadioButton();
	private JRadioButton cubic = new JRadioButton();
	private JRadioButton quartic = new JRadioButton();
	private JRadioButton quintic = new JRadioButton();
	private JRadioButton sinusoidal = new JRadioButton();
	private JRadioButton exponential = new JRadioButton();
	private JRadioButton circular = new JRadioButton();
	private JRadioButton elastic = new JRadioButton();
	private JRadioButton back = new JRadioButton();
	private JRadioButton bounce = new JRadioButton();

	
	private JRadioButton easeIn = new JRadioButton();
	private JRadioButton easeOut = new JRadioButton();
	private JRadioButton easeInOut = new JRadioButton();
	
	private JButton show = new JButton();
	private JButton reload = new JButton();
	
	public EasingFunction(){
		init();
	}
	
	private void initAnimationBoard(){
		this.animationBoard.setBounds(0, 0, 600, 600);
	}
	
	private void initControlBoard(){
		this.controlBoard.setBounds(600,0,280,600);
		this.controlBoard.setLayout(null);
		
		ShowButtonActionListener sal = new ShowButtonActionListener();
		
		show.setBounds(10, 450, 100, 25);
		show.setText("Show");
		show.setMargin(BUTTON_INSETS);
		show.addActionListener(sal);
		reload.setBounds(130, 450, 100, 25);
		reload.setText("Reload");
		reload.setMargin(BUTTON_INSETS);
		reload.addActionListener(sal);
		
		this.controlBoard.add(show);
		this.controlBoard.add(reload);
		
		WayRadioButtonActionListener wal = new WayRadioButtonActionListener();
		
		easeWayRadioButtonArr[0]=easeIn;
		easeWayRadioButtonArr[1]=easeOut;
		easeWayRadioButtonArr[2]=easeInOut;
		
		this.easeIn.setBounds(10,400,80,25);
		this.easeIn.setText("EaseIn");
		this.easeIn.addItemListener(wal);
		wayBg.add(easeIn);
		this.easeOut.setBounds(100,400,80,25);
		this.easeOut.setText("EaseOut");
		this.easeOut.addItemListener(wal);
		wayBg.add(easeOut);
		this.easeInOut.setBounds(190,400,80,25);
		this.easeInOut.setText("EaseInOut");
		this.easeInOut.addItemListener(wal);
		wayBg.add(easeInOut);
		this.easeIn.setSelected(true);
		
		this.controlBoard.add(this.easeIn);
		this.controlBoard.add(this.easeOut);
		this.controlBoard.add(this.easeInOut);
		
		TypeRadioButtonActionListener tal = new TypeRadioButtonActionListener();
		
		easeTypeRadioButtonArr[0]=linear;
		easeTypeRadioButtonArr[1]=quadratic;
		easeTypeRadioButtonArr[2]=cubic;
		easeTypeRadioButtonArr[3]=quartic;
		easeTypeRadioButtonArr[4]=quintic;
		easeTypeRadioButtonArr[5]=sinusoidal;
		easeTypeRadioButtonArr[6]=exponential;
		easeTypeRadioButtonArr[7]=circular;
		easeTypeRadioButtonArr[8]=elastic;
		easeTypeRadioButtonArr[9]=back;
		easeTypeRadioButtonArr[10]=bounce;
		
		linear.setBounds(10, 10, 200, 25);
		linear.setText("无缓动效果");
		linear.addItemListener(tal);
		typeBg.add(linear);
		quadratic.setBounds(10, 45, 200, 25);
		quadratic.setText("二次方缓动");
		quadratic.addItemListener(tal);
		typeBg.add(quadratic);
		cubic.setBounds(10, 80, 200, 25);
		cubic.setText("三次方缓动");
		cubic.addItemListener(tal);
		typeBg.add(cubic);
		quartic.setBounds(10, 115, 200, 25);
		quartic.setText("四次方缓动");
		quartic.addItemListener(tal);
		typeBg.add(quartic);
		quintic.setBounds(10, 150, 200, 25);
		quintic.setText("五次方缓动");
		quintic.addItemListener(tal);
		typeBg.add(quintic);
		sinusoidal.setBounds(10, 185, 200, 25);
		sinusoidal.setText("正弦曲线缓动");
		sinusoidal.addItemListener(tal);
		typeBg.add(sinusoidal);
		exponential.setBounds(10, 220, 200, 25);
		exponential.setText("指数曲线缓动");
		exponential.addItemListener(tal);
		typeBg.add(exponential);
		circular.setBounds(10, 255, 200, 25);
		circular.setText("圆形曲线缓动");
		circular.addItemListener(tal);
		typeBg.add(circular);
		elastic.setBounds(10, 290, 200, 25);
		elastic.setText("指数衰减的正弦曲线缓动");
		elastic.addItemListener(tal);
		typeBg.add(elastic);
		back.setBounds(10, 325, 200, 25);
		back.setText("超过范围的三次方缓动");
		back.addItemListener(tal);
		typeBg.add(back);
		bounce.setBounds(10, 360, 200, 25);
		bounce.setText("指数衰减的反弹缓动");
		bounce.addItemListener(tal);
		typeBg.add(bounce);
		linear.setSelected(true);
		
		this.controlBoard.add(linear);
		this.controlBoard.add(quadratic);
		this.controlBoard.add(cubic);
		this.controlBoard.add(quartic);
		this.controlBoard.add(quintic);
		this.controlBoard.add(sinusoidal);
		this.controlBoard.add(exponential);
		this.controlBoard.add(circular);
		this.controlBoard.add(elastic);
		this.controlBoard.add(back);
		this.controlBoard.add(bounce);
		
	}
	
	class ShowButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			String which = btn.getText();
			switch (which){
				case "Show":{
					btn.setText("Pause");
					if(t!=null){
//						t.();
					}			
					t = new Thread(td);
					t.start();
					break;
				}
				case "Reload":{
					loadProperties();
					break;
				}
				case "Pause":{
					btn.setText("Go on");
					if(t!=null){
						t.suspend();
					}
					break;
				}
				case "Go on":{
					btn.setText("Pause");
					if(t!=null){
						t.resume();
					}
					break;
				}
			}
		}
	}
	
	class WayRadioButtonActionListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			for(int j=0;j<easeWayRadioButtonArr.length;j++){
				if(easeWayRadioButtonArr[j].isSelected()){
					way=j;
					break;
				}
			}
		}
	}
	
	class TypeRadioButtonActionListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			for(int i=0;i<easeTypeRadioButtonArr.length;i++){
				if(easeTypeRadioButtonArr[i].isSelected()){
					type=i;
					break;
				}
			}
		}
	}
	
	class ThreadDraw implements Runnable{
		@Override
		public void run() {
			 caseDraw(type,way);
		}
	}
	
	public void init(){
		this.setBounds(20, 20, 880, 600);
		this.setLayout(null);
		this.setResizable(false);
		initAnimationBoard();
		initControlBoard();
		this.add(animationBoard);
		this.add(controlBoard);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		loadProperties();
	}
	
	private void loadProperties(){
		try{
			Properties p = new Properties();
			
			String path = this.getClass().getClassLoader().getResource("study019_EasingFunction/EasingDemo/config.properties").getPath();
			InputStream is = new FileInputStream(path);
			p.load(is);
			is.close();
			
			
//			URL url =this.getClass().getResource("config.properties");
//			FileInputStream in = new FileInputStream(url.getFile());
//			p.load(in);
//			in.close();

			
			LINEAR_TIME_INTERVAL = Long.parseLong(p.getProperty("LINEAR_TIME_INTERVAL"));
			QUADRATIC_TIME_INTERVAL = Long.parseLong(p.getProperty("QUADRATIC_TIME_INTERVAL"));
			CUBIC_TIME_INTERVAL = Long.parseLong(p.getProperty("CUBIC_TIME_INTERVAL"));
			QUARTIC_TIME_INTERVAL = Long.parseLong(p.getProperty("QUARTIC_TIME_INTERVAL"));
			QUINTIC_TIME_INTERVAL = Long.parseLong(p.getProperty("QUINTIC_TIME_INTERVAL"));
			SINUSOIDAL_TIME_INTERVAL = Long.parseLong(p.getProperty("SINUSOIDAL_TIME_INTERVAL"));
			EXPONENTIAL_TIME_INTERVAL = Long.parseLong(p.getProperty("EXPONENTIAL_TIME_INTERVAL"));
			CIRCULAR_TIME_INTERVAL = Long.parseLong(p.getProperty("CIRCULAR_TIME_INTERVAL"));
			ELASTIC_TIME_INTERVAL = Long.parseLong(p.getProperty("ELASTIC_TIME_INTERVAL"));
			BACK_TIME_INTERVAL = Long.parseLong(p.getProperty("BACK_TIME_INTERVAL"));
			BOUNCE_TIME_INTERVAL = Long.parseLong(p.getProperty("BOUNCE_TIME_INTERVAL"));
			
			System.out.println(LINEAR_TIME_INTERVAL);
			System.out.println(QUADRATIC_TIME_INTERVAL);
			System.out.println(CUBIC_TIME_INTERVAL);
			System.out.println(QUARTIC_TIME_INTERVAL);
			System.out.println(QUINTIC_TIME_INTERVAL);
			System.out.println(SINUSOIDAL_TIME_INTERVAL);
			System.out.println(EXPONENTIAL_TIME_INTERVAL);
			System.out.println(CIRCULAR_TIME_INTERVAL);
			System.out.println(ELASTIC_TIME_INTERVAL);
			System.out.println(BACK_TIME_INTERVAL);
			System.out.println(BOUNCE_TIME_INTERVAL);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void caseDraw(int type, int way){
		System.out.println(type+","+way);
		Graphics g = animationBoard.getGraphics();
		if(g!=null){
			g.clearRect(0, 0, 600, 600);
			int x = 0;
			int y = 600;
			g.setColor(Color.red);
			switch (type){
			case 0:{
				try{
					while( x<600&&y>0){
						g.drawLine(x++, y--, x, y);
						Thread.sleep(LINEAR_TIME_INTERVAL);
					}	
				}catch(Exception e){
					System.out.println("case-0");
					e.printStackTrace();
				}
				show.setText("Show");
				break;
			}
			case 1:{
				try{
					while(x<600 && y>0){
						int dy = 600-(int)Math.pow((x+X_INTERVAL)/X_INTERVAL,2);
						g.drawLine(x,y,x+=X_INTERVAL,dy);
						y = dy;
						Thread.sleep(QUADRATIC_TIME_INTERVAL);
					}
				}catch(Exception e){
					System.out.println("case-1");
					e.printStackTrace();
				}
				show.setText("Show");
				break;
			}
			case 2:{

				break;
			}
			case 3:{

				break;
			}
			case 4:{

				break;
			}
			case 5:{

				break;
			}
			case 6:{

				break;
			}
			case 7:{

				break;
			}
			case 8:{

				break;
			}
			case 9:{

				break;
			}
			case 10:{
				x = 0;
				y = 0;
				int ex = 600;
				int ey = 600;
				int dx = ex - x;
				int dy = ey - y;
				double dis = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
				break;
			}
			default:break;
			}
		}
	}
	
	
	
	public static void main(String[] args){
		EasingFunction ef = new EasingFunction();
		ef.setVisible(true);
	}
	
}


