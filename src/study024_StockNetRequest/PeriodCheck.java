package study024_StockNetRequest;

import java.util.Timer;
import java.util.TimerTask;

public class PeriodCheck {
	
	
	public static void main(String[] args){



	}
	
	public static void checkPeriodically(){
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}, 0, 10);
	}
}
