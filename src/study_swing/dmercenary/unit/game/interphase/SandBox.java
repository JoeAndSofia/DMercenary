package study_swing.dmercenary.unit.game.interphase;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputListener;

import study_swing.dmercenary.unit.game.carrier.Square;
import study_swing.dmercenary.unit.game.test.JOvalButton;


public class SandBox extends JPanel implements 
	MouseWheelListener,
	KeyListener,
	MouseInputListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7205947267038923265L;
	private JPanel battlefield = new JPanel(true);
	private JButton activated = null;
	
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
		this.battlefield.setBounds(IC.LTX+IC.BT,IC.LTY+IC.BT,IC.MAIN_PANEL_WIDTH,IC.MAIN_PANEL_HEIGHT);
		this.battlefield.setBorder(new LineBorder(Color.GRAY, 1));
		this.battlefield.setFocusable(true);
		this.battlefield.addMouseWheelListener(this);
		this.battlefield.addKeyListener(this);
		this.battlefield.addMouseMotionListener(this);
		this.battlefield.addMouseListener(this);
	}
	
	private void init(){	
		this.setLayout(null);
		this.setBounds(0, 0,IC.MAIN_PANEL_WIDTH+IC.BT*2+IC.LTX*2, IC.MAIN_PANEL_HEIGHT+IC.BT*2+IC.LTY*2);
		this.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY));
		
		initMain();
		this.add(this.battlefield);
	}
	
	
	public JButton Activated() {return this.activated;}
	public void Activated(JButton activated) {
		if(this.activated!=null && this.activated != activated && activated instanceof Square){
			this.activated.setBorder(null);
		}
		this.activated = activated;
		this.activated.setBorder(BorderFactory.createLineBorder(Color.ORANGE,1));
		DMercenary dm = (DMercenary)this.getParent().getParent().getParent().getParent();
		switch (((Square)this.activated).Thing().getType()){
		case 1:
			break;
		}
		DataPrivy dp = (DataPrivy)dm.getDataPrivy();
		
		
		boolean a = true;
	}
	public JPanel Battlefield() {return this.battlefield;}
	public void Battlefield(JPanel battlefield) {this.battlefield = battlefield;}

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
	public void mouseMoved(MouseEvent e) {

		if(this.activated!=null){
			Point p = e.getPoint();
			Rectangle r = this.activated.getBounds();
			int ltX = p.x-r.width/2;
			int ltY = p.y-r.height/2;
			int rbX = p.x+r.width/2;
			int rbY = p.y+r.height/2;
			
			int bW = this.battlefield.getWidth();
			int bH = this.battlefield.getHeight();
			Graphics g = this.battlefield.getGraphics();
			g.setColor(Color.BLUE);
			if(ltX>0 && rbX<bW && ltY>0 && rbY<bH){
				this.paintImmediately(this.battlefield.getBounds());
				g.drawRect(4*(ltX/4), 4*(ltY/4), r.width, r.height);
			}else{
				if(ltX < 0){
					ltX = 0;
				}
				if(rbX > bW){
					ltX = bW - r.width;
				}
				if(ltY < 0){
					ltY = 0;
				}
				if(rbY > bH){
					ltY = bH - r.height;
				}
				this.paintImmediately(this.battlefield.getBounds());
				g.drawRect(4*(ltX/4), 4*(ltY/4), r.width, r.height);
			}
			if(ltX == 0 && ltY == 0){
				
			}else if(ltX == 0 && ltY == bH - r.height){
				
			}else if(ltX == bW - r.width && ltY == 0){
				
			}else if(ltX == bW - r.width && ltY == bH - r.height){
				
			}else if(ltX%4==0 || ltY%4==0){
							
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(IC.CANZOOM){
			int a = -(int)e.getPreciseWheelRotation();
			Component[] cs = ((JPanel)e.getComponent()).getComponents();
			for(Component c: cs){
				if(c instanceof Square){
					Square beingSquare = (Square)c;
					beingSquare.zoom(a*beingSquare.Mr()/4);	
				}
			}
		}
	}

}
