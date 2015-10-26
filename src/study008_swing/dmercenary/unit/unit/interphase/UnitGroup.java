package study008_swing.dmercenary.unit.unit.interphase;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class UnitGroup extends JFrame{
	
	private static final int DETAIL_W = 400;
	private static final int DETAIL_H = 110;
	private static final int MAIN_W = 2*DETAIL_W;
	private static final int INFO_H = 490;
	
	private static final Dimension DETAIL_DIMENSION = new Dimension(DETAIL_W,DETAIL_H);
	private static final Dimension INFO_DIMENSION = new Dimension(MAIN_W,INFO_H);
//	private static final int a = 0;
//	private static final int a = 0;
//	private static final int a = 0;
//	private static final int a = 0;
//	private static final int a = 0;
//	private static final int a = 0;
	
	public JPanel leftDetail;
	public JPanel rightDetail;
	
	public JPanel info;
	
	public UnitGroup(){
		init();
	}
	
	public void init(){
		leftDetail = new Detail();
		rightDetail = new Detail(DETAIL_W, 0);
		info = new Info();
	}
	
	class Detail extends JPanel{
		
		public Detail(){
			init(0,0);
		}
		
		public Detail(int x, int y){
			init(x,y);
		}
		
		public void init(int x, int y){
			this.setLocation(new Point(x,y));
			this.setSize(DETAIL_DIMENSION);
		}
	}

	class Info extends JPanel{
		
		public Info(){
			
		}
		
		public void init(int x, int y){
			this.setLocation(new Point(x, y));
			this.setSize(INFO_DIMENSION);
		}
	}
	
}
