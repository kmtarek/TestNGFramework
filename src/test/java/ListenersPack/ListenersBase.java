package ListenersPack;


import org.testng.ITestListener;
import org.testng.ITestContext ;
import org.testng.ITestResult ;

import java.io.IOException;


public class ListenersBase extends BaseClassScreenSHOTS  implements ITestListener {



    public void onFinish(ITestContext context) {
        System.out.println("This is END of test :" + context.getPassedTests());
        System.out.println("This is END of test :" + context.getFailedTests());
        System.out.println("This is END of test :" + context.getSkippedTests());

    }


    public void onStart(ITestContext arg0) {

        System.out.println("This start of test ");


    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {


    }

    @Override
    public void onTestFailure(ITestResult Result) {

        System.out.println("The name of the testcase failed is :"+Result.getName());



    }

    @Override
    public void onTestSkipped(ITestResult arg0) {


    }

    @Override
    public void onTestStart(ITestResult arg0) {




    }

    @Override
    public void onTestSuccess(ITestResult Result) {

        System.out.println("The name of the testcase passed is :"+Result.getName());


    }


}
