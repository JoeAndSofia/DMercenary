package study008_swing.dmercenary.game.basic;

import java.awt.GraphicsEnvironment;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;

public class Area extends JButton {
//	Rectangle2D.Float r = new Rectangle2D.Float();
//	Point2D p = new Point2D.Float();
	
	public static void main(String[] args){
//		test01();
		test02();
	}
	
	
	public static void test01(){
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		for(String font : fonts){
			System.out.println(font);
		}
	}
	
	public static void test02(){
		System.out.println('\u2297');
	}
}
