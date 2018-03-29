package study_Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import basic.Basic;

public class NoDuplicationSixDigit extends Basic{
	
	private List result = new ArrayList<Long>();
	
	public void selectNum(){  
        for(long n = 100000; n <= 999999;n++){   
            if(isSelfRepeat(n))                    //有相同的数字，则跳过
                continue;   
            else if(isPingFangRepeat(n*n,n)){    //该数的平方中是否有与该数相同的数字
                continue;   
            }else{                                //符合条件，则打印
                   result.add(n);
            }   
        } 
     }
    public boolean isSelfRepeat(long n){
        HashMap<Long,String> m=new HashMap<Long,String>();
        //存储的时候判断有无重复值
        while(n!=0){
            if(m.containsKey(n%10)){
                return true;
            }
            else{
                m.put(n%10,"1");
            }
            n=n/10;
        }
        return false;
    }

    public boolean isPingFangRepeat(long pingfang,long n){
        HashMap<Long,String> m=new HashMap<Long,String>();
        while(n!=0){
            m.put(n%10,"1");
            n=n/10;
        }

        while(pingfang!=0){
            if(m.containsKey(pingfang%10)){
                return true;
            }
            pingfang=pingfang/10;
        }
        return false;
    }
	
    public static void main (String args[]){
//    	NoDuplicationSixDigit n = new NoDuplicationSixDigit();
//    	n.selectNum();
//    	pl(n.result.size());
//    	pl(n.result);
    	
    	
    	
//        Integer i1 = 100, i2 = 100, i3 = 150, i4 = 150;
//        int i5 = 100, i6 = 150;
//        
//        pl(i1 == i2);
//        pl(i3 == i4);
//        pl(i1 == i5);
//        pl(i3 == i6);
    	
    	int x = 4;
    	int m = 7;
    	pl((Math.pow(2,m) - 1) * x);
    	pl((2^m-1) * x);
        pl((x << m) -x);
    }
    
}
