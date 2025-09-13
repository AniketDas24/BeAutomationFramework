package utils;

import lombok.extern.slf4j.Slf4j;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
@Slf4j
public class RetryAnalyser implements IRetryAnalyzer {
    private int retryCount = 0;
    private final int MAX_RETRY_COUNT = 2;
    @Override
    public boolean retry(ITestResult result) {
        if(retryCount<MAX_RETRY_COUNT){
            log.warn("Retrying test '{}' for the {} time...",
                    result.getName(), retryCount + 1);
            retryCount++;
            return true;
        }
        return false;
    }
}
