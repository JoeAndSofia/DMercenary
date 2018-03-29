package study_Thread.interact;

/**
 * Different applying about thread.
 * @author imaginato
 *
 */
public class ThreadSum extends Thread {
    int total = 0;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
            	System.out.println(i);
                total += i;
            }
            //(完成计算了)唤醒在此对象监视器上等待的单个线程，在本例中线程ThreadInteractionTest被唤醒
//            notify();
            System.out.println("Compute complete");
        }
    }
}