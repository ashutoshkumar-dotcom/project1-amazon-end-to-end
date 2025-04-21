package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer{

	int initialcount=0;
	int retrycounttimes=2;

	@Override
	public boolean retry(ITestResult result) {
		if(initialcount<retrycounttimes) {
			
			initialcount++;
			return true;
		}
		return false;
	}
	
}
