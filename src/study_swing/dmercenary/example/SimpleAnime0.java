package study_swing.dmercenary.example;
//package study008_swing.dmercenary.example;
//
//import java.awt.Canvas;
//import java.awt.Color;
//import java.awt.Frame;
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.Toolkit;
//import java.net.URL;
///**
// * @author chenpeng
// * @email��ceponline@yahoo.com.cn
// * @version 0.1
// */
//public class SimpleAnime0 extends Frame {
//
//    private static final long serialVersionUID = 1L;
//
//    Image act1;
//
//    Image act2;
//
//    // �Ƿ���ͼ���ƶ�
//
//    boolean actMoving = false;
//
//    // ��ʼͼ����
//
//    int actPhase = 1;
//
//    Canvas c = new Canvas() {
//
//        private static final long serialVersionUID = 1L;
//
//        /**
//         * ����ͼ��ֱ�ӵ���update������˳��˵һ�£�����paint����update, ����update����paint������ֺܺ�����¡�^^��
//         */
//        public void paint(Graphics g) {
//            update(g);
//        }
//
//        /**
//         * �˷��������ڷ�����ʱ����ͼ��
//         */
//        public void update(Graphics g) {
//            if (actMoving) {
//                if (actPhase == 1) {
//                    g
//                            .drawImage(act1, getWidth() / 2
//                                    - act1.getWidth(null) / 2, getHeight() / 2
//                                    - act1.getHeight(null) / 2, act1
//                                    .getWidth(null), act1.getHeight(null), this);
//                } else {
//                    g
//                            .drawImage(act2, getWidth() / 2
//                                    - act2.getWidth(null) / 2, getHeight() / 2
//                                    - act2.getHeight(null) / 2, act2
//                                    .getWidth(null), act2.getHeight(null), this);
//                }
//            }
//        }
//    };
//
//    /**
//     * �򵥶����Ĺ���
//     * 
//     */
//    public SimpleAnime0(boolean isRun) {
//        actMoving = isRun;
//        setTitle("ͼ��任");
//        setSize(400, 400);
//        // �趨����Ϊ��ɫ
//        setBackground(Color.BLACK);
//        //��ֻ��һ��ͼ����ص���ʾ��������ȫ���Զ���һ��Image���飬Ȼ��̬����
//        //���ɶ������š�
//        URL imageUrl = getClass().getResource("/image/act.jpg");
//        act1 = Toolkit.getDefaultToolkit().createImage(imageUrl);
//        imageUrl = getClass().getResource("/image/act0.jpg");
//        act2 = Toolkit.getDefaultToolkit().createImage(imageUrl);
//        add(c);
//
//        /**
//         * ˳�����һ�£���Swing����Timer�࣬�����趨��������ѭ�������¼��� ����д�����£�����ܶ��˻���Ը�����̡߳���
//         * 
//         * class TimerListener implements ActionListener{ public void
//         * actionPerformed(ActionEvent e){ if(!actMoving) return; actPhase =
//         * (actPhase == 1) ? 2 : 1; canvas.repaint(); } } javax.swing.Timer t =
//         * new javax.swing.Timer(200,new TimerListener()); t.start();
//         */
//
//        Thread t = new Thread(new Timer());
//        t.start();
//    }
//
//    /**
//     * �¼�ѭ�������߳�
//     * 
//     * @author chenpeng
//     */
//    class Timer implements Runnable {
//        public void run() {
//            while (true) {
//                if (!actMoving)
//                    return;
//                actPhase = (actPhase == 1) ? 2 : 1;
//                c.repaint();
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    /**
//     * ������
//     * 
//     * @param args
//     */
//    public static void main(String[] args) {
//        // ʵ����,������ѭ���¼�
//        SimpleAnime0 sa = new SimpleAnime0(true);
//        // ��ʾ����
//        sa.setVisible(true);
//    }
//}
