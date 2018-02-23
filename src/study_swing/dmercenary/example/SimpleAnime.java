package study_swing.dmercenary.example;
//package study008_swing.dmercenary.example;
//
//import java.awt.Canvas;
//import java.awt.Color;
//import java.awt.Frame;
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.Toolkit;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.net.URL;
//
///**
// * <p>
// * Title: ʷ���Javaͼ�λ��ƣ�J2SE���̳�֮һ,ͼ��任��
// * </p>
// * <p>
// * Description:ͼ��任
// * </p>
// * <p>
// * Copyright: Copyright (c) 2007
// * </p>
// * 
// * @author chenpeng
// * @email��ceponline@yahoo.com.cn
// * @version 0.1
// */
//public class SimpleAnime extends Frame {
//
//    /**
//     * �����������AWT�����⣬ʵ���ϣ����Ƕ�֪��ʹ��Swingʱ����ͼ ��������кܶ���Ż���������AWT�У���Щ����Ҫ�����ֶ������ã�
//     * ���������һ�����AWT��ʼ������ʵ��Ҷ�֪���������Ӹ�J�ͱ� Swing�ˡ����������øı�ġ���
//     */
//
//    private static final long serialVersionUID = 1L;
//
//    // ���ڴ洢ͼƬ
//    Image act;
//
//    // �׳Ƶķ����������ֻ��Ļ��ܳ���
//    Canvas canvas = new Canvas() {
//
//        private static final long serialVersionUID = 1L;
//
//        /**
//         * ����ͼ��ֱ�ӵ���update������˳��˵һ�£�����paint����update,
//         * ����update����paint������ֺܺ�����¡�^^��
//         */
//        public void paint(Graphics g) {
//            update(g);
//        }
//
//        /**
//         * �˷��������ڷ�����ʱ����ͼ��
//         */
//        public void update(Graphics g) {
//            // ����ֱ�Ϊ����ͼ������Graphics�ϵ�left,����top,ͼ��width,ͼ��height,Ŀ�����
//            g.drawImage(act, getWidth() / 2 - act.getWidth(null) / 2,
//                    getHeight() / 2 - act.getHeight(null) / 2, act
//                            .getWidth(null), act.getHeight(null), this);
//        }
//    };
//
//    /**
//     * �򵥶����Ĺ���
//     * 
//     */
//    public SimpleAnime() throws Exception{
//        this.setTitle("ͼ��任");
//        this.setSize(400, 400);
//        // �趨����Ϊ��ɫ
//        setBackground(Color.BLACK);
//        // ֱ����class·����ȡͼƬ��Դ
////        String url = 
//        URL imageUrl = getClass().getResource("/image/1.png");
//        // ��ȡimageͼ��ʵ��
//        act = Toolkit.getDefaultToolkit().createImage(imageUrl);
//        // ���ط�����Ϊ����
//        add(canvas);
//        class AnimeMouseListener extends MouseAdapter {
//            // ��������
//            public void mouseEntered(MouseEvent e) {
//                // ˳��˵һ�£�ˮƽ��תͼ��Ч���ǿ����ô��������ģ����潲�⡣
//                URL imageUrl = getClass().getResource("/image/1.png");
//                act = Toolkit.getDefaultToolkit().createImage(imageUrl);
//                canvas.repaint();
//            }
//
//            // ����뿪���
//            public void mouseExited(MouseEvent e){
//                URL imageUrl = getClass().getResource("/image/2.png");
//                act = Toolkit.getDefaultToolkit().createImage(imageUrl);
//                canvas.repaint();
//            }
//        }
//        //�ڷ��������������
//        canvas.addMouseListener(new AnimeMouseListener());
//    }
//
//    /**
//     * ������
//     * 
//     * @param args
//     */
//    public static void main(String[] args) {
//    	try{
//            // ʵ����
//            SimpleAnime sa = new SimpleAnime();
//            // ��ʾ����
//            sa.setVisible(true);
//    	}catch(Exception e){
//    		e.printStackTrace();
//    		
//    	}
//
//    }
//}