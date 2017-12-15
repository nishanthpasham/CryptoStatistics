package stats;

import org.junit.Before;
import org.junit.Test;

public class StatisticsServiceTest {
	
	double[] data;

	@Before
	public void setUp() throws Exception {
		data = new double[] {20.1, 30.1, 35.5, 36.4, 40.3, 50.5, 55.3, 54.3, 40.5, 100.4};
	}

	@Test
	public void testMode() {
		double threshold = 5.0;
		System.out.println(StatisticsService.computeStats(data, threshold));
	}

}
