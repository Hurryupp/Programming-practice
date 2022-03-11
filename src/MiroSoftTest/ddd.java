package MiroSoftTest;

import org.junit.Test;

import java.util.Date;
import java.util.HashMap;

public class ddd {
    @Test
    public void test(){
        //Date data1 = new Date("");
        String s1 = "1:12:30";
        String[] times = s1.split(":");
        int mit = (Integer.valueOf(times[0]) - 1) * 24 + (Integer.valueOf(times[1])) * 60 + (Integer.valueOf(times[2]));
        System.out.println(mit);




    }

}
