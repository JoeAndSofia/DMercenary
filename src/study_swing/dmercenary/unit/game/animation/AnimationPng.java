package study_swing.dmercenary.unit.game.animation;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class AnimationPng {
	private static final int W = 100;
	private static final int H = 100;
	
	public static void main(String[] args){
		try{
			test01(960, 384, 192, 192, "img/magic/fireball_backup.png");
			
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	public static void test01(int w, int h, int subw, int subh, String path) throws FileNotFoundException, IOException{
		JFrame jf = new JFrame();
		jf.setBounds(200, 200, 420, 200);
		
		JPanel jp1 = new JPanel(true);
		jp1.setBounds(0, 0, 200, 200);
		jp1.setBorder(new BevelBorder(BevelBorder.LOWERED));
		Image[] images = new BufferedImage[10];
		BufferedImage imageAll = ImageIO.read(new File(path));
		int hc = w/subw;
		int vc = h/subh;
		int c = hc*vc;
		for(int i = 0, j = 0, k = 0; i<c; i++){
			BufferedImage bi = imageAll.getSubimage(j*subw, k*subh, subw, subh);
			images[i] = bi;
			if(j == hc - 1){
				j = 0;
				k ++;
			}else{
				j++;
			}
		}
		
		
		JPanel jp2 = new JPanel(true);
		jp2.setBounds(220, 0, 200, 200);
		jp2.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		jf.setLayout(null);
		jf.add(jp1);
		jf.add(jp2);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}
