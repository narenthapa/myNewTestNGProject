package DemoTest;

import org.testng.annotations.Test;

public class InvocationCountTest {

    @Test(invocationCount = 10) 
    public void addNumbers(){
        int a = 20;
        int b = 40;
        int sum = a+b;
        System.out.println(sum);
    }


}
