package study008_swing.dmercenary.unit.game.carrier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.event.MouseInputListener;

import study008_swing.dmercenary.unit.game.entity.things.Thing;
import study008_swing.dmercenary.unit.game.interphase.C;
import study008_swing.dmercenary.unit.game.interphase.SandBox;

public class Square extends UIObject implements ActionListener, MouseInputListener{

	private int zr;	//zoom_rate
	private int mr;	//max_rate
	private int x;
	private int y;
	private int w;
	private int h;
	private String iconUrl;
	private Thing entity;
	public Square(){
		this(0,0,C.SSL,C.SSL,C.SSL,null,null);
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
			this.setIcon(new ImageIcon(this.iconUrl));
		}
		this.setToolTipText(tooltip==null?"":tooltip);
		this.setMargin(C.BEING_SQUARE_INSETS);
//		this.setFont(new Font("Arial",Font.PLAIN,fontsize));
		this.setBorder(null);
//		this.setIcon(arg0); 
		this.setBounds(x*zr, y*zr, w*zr, h*zr);
		this.addActionListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setContentAreaFilled(false);
	}
	
	public void zoom(int a){
		if((zr+a>mr/2-1)&&(zr+a)<=mr){
			this.zr+=a;
			this.setBounds(x*zr, y*zr, w*zr, h*zr);
		}
	}
	
	public int Zr() {return this.zr;}
	public void Zr(int zr) {this.zr = zr;}
	public int Mr() {return this.mr;}
	public void Mr(int mr) {this.mr = mr;}
	public int X() {return this.x;}
	public void X(int x) {this.x = x;}
	public int Y() {return this.y;}
	public void Y(int y) {this.y = y;}
	public int W() {return this.w;}
	public void W(int w) {this.w = w;}
	public int H() {return this.h;}
	public void H(int h) {this.h = h;}
	public String IconUrl() {return this.iconUrl;}
	public void IconUrl(String iconUrl) {this.iconUrl = iconUrl;}	
	public Thing Entity() {return this.entity;}
	public void Entity(Thing entity) {this.entity = entity;}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {
		Square square = (Square)e.getSource();
		SandBox sandbox = (SandBox)square.getParent().getParent();
		
		sandbox.Activated(square);
		
		sandbox.Battlefield().requestFocusInWindow();
		System.out.println(square.getToolTipText());
//		((Square)e.getSource()).getParent().requestFocusInWindow();
	}
	
}
