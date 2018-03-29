package study_Thread.interact;

import basic.Basic;

public class ThreadInteractionTest extends Basic{
    public static void main(String[] args) {
        
        ThreadSum sum = new ThreadSum();
        // 启动计算线程
        sum.start();
        pl("Compute start");
        // 线程ThreadInteractionTest拥有sum对象上的锁。
        // 线程为了调用wait()或notify()方法，该线程ThreadInteractionTest必须是那个对象锁的拥有者
        synchronized (sum) {
            try {
                System.out.println("Waiting for computing sum");
                sum.wait();
                // 当前线程ThreadInteractionTest等待
//                System.out.println("After wait");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Computed sum is: " + sum.total);
        }
        
    }
}
