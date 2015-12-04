package study008_swing.dmercenary.unit.game.carrier;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.event.MouseInputListener;

import study008_swing.dmercenary.unit.game.entity.character.Character;
import study008_swing.dmercenary.unit.game.entity.things.Thing;
import study008_swing.dmercenary.unit.game.entity.top.GameObject;
import study008_swing.dmercenary.unit.game.interphase.IC;
import study008_swing.dmercenary.unit.game.interphase.SandBox;

public class Square extends UIObject implements ActionListener, MouseInputListener{

	private int zr;	//zoom_rate
	private int mr;	//max_rate
	private int x;
	private int y;
	private int w;
	private int h;
//	private JProgressBar hp;
//	private JProgressBar mp;
	
	private GameObject thing;
	public Square(){
		this(0,0,IC.SSL,IC.SSL,IC.SSL,null,null);
	}
	
	public Square(int x, int y, int w, int h, int zr, String tooltip, String iconUrl){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.mr = zr;
		this.zr = zr;
		this.setToolTipText(tooltip==null?"":tooltip);
		this.setBorder(null);
		this.setBounds(x*zr, y*zr, w*zr, h*zr);
		this.addActionListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
//		this.setBorderPainted(false);
//		this.setContentAreaFilled(false);
//		this.add(hp);
//		this.add(mp);
	}
	
	private void init(){
		if(this.thing!=null){
			try{
				((Character)this.thing).getAbility().get("ABILITY_HPT");
			}catch(Exception e){
				
			}
		}		
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
	public GameObject Thing() {return this.thing;}
	public void Thing(Thing thing) {this.thing = thing;}

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
