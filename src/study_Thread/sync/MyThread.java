package study_Thread.sync;

import basic.Basic;

public class MyThread extends Basic implements Runnable{
	public static void main(String args[]){
		MyThread mt=new MyThread();
		Thread t1=new Thread(mt,"t1");
		Thread t2=new Thread(mt,"t2");
		Thread t3=new Thread(mt,"t3");
		Thread t4=new Thread(mt,"t4");
		Thread t5=new Thread(mt,"t5");
		Thread t6=new Thread(mt,"t6");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
	public void run(){
		for(int i=0;i<100;i++){
			pl(Thread.currentThread().getName() + " : " + i);
		}
//		synchronized(this){
//			for(int i=0;i<100;i++){
//				pl(Thread.currentThread().getName() + " : " + i);
//			} 
//		}
	}
}