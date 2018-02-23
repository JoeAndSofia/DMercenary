package study_swing.dmercenary.unit.game.test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.ButtonUI;

public class OvalButtonUI extends ButtonUI {
	
	private JComponent c = null;
	
	public void paint(Graphics g, JComponent c){
		this.c = c;
		paintBackground(g);
	}
	
	protected void paintBackground(Graphics g){
		if(c!=null){
			int w = c.getWidth();
			int h = c.getHeight();
			Graphics2D g2d = (Graphics2D)g;
			Color color = c.getBackground();
			g2d.setColor(Color.RED);
			g2d.fillOval(0, 0, w, h);
		}
	}
	
	public boolean contains(JComponent c, int x, int y){
		float a = ((float)c.getWidth())/2;
		float b = ((float)c.getHeight())/2;
		float ox = ((float)c.getX());
		float oy = ((float)c.getY());
		float sftx = x*1.0f-ox;
		float sfty = y*1.0f-oy;
		return (sftx*sftx)/(a*a)+(sfty*sfty)/(b*b) <=1;
	}
	
	public boolean contains(JComponent c, float x, float y){
		float a = ((float)c.getWidth())/2;
		float b = ((float)c.getHeight())/2;
		float ox = ((float)c.getX());
		float oy = ((float)c.getY());
		float sftx = x*1.0f-ox;
		float sfty = y*1.0f-oy;
		return (sftx*sftx)/(a*a)+(sfty*sfty)/(b*b) <=1;
	}
	
	
	
	public static void main(String[] args){
		OvalButtonUI o = new OvalButtonUI();
		o.c = new JButton();
		o.c.setBounds(10, 8, 6, 4);
		System.out.println(o.c.getWidth());
		System.out.println(o.c.getHeight());
		System.out.println(o.contains(o.c, 12.9f, 8.500f));
	}
}
