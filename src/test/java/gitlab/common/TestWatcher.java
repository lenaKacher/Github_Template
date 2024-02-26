package gitlab.common;

import gitlab.tests.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;


public class TestWatcher extends BaseTest implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result){
        try {
            takeScreenshot(result.getName());
        } catch (IOException e) {
            e.getMessage();
        }
    }
    
}

