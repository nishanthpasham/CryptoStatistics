package stats;

import java.util.Arrays;

public class StatisticsService {

	/*
	 * Given a double data set, it computes the mean, median and mode. 
	 * Mode is the most repeated element in the data set. Since this data set is of double values, we
	 * first sort the array and then find the most contiguous set of values within a specified modeThreshold.
	 * Note in the case there is multiple contiguous sets which are within the modeThreshold, 
	 * this method only returns the first such contiguous set's average. Do you want to store mode double[]? Re-think later.
	 */
	public static Stats computeStats(double[] data, double modeThreshold) {
		Stats stats = new Stats();
		int length = data.length;
		double[] sortedData = new double[length];
		System.arraycopy(data, 0, sortedData, 0, length);
		Arrays.sort(sortedData);
		int continuousCount = 0, maxCount = 0;
		double runningAverage = 0.0, maxRunningAverage = 0.0, sum = 0.0;
		for (int i = 0; i < length; i++) {
			if (Math.abs(runningAverage - sortedData[i]) <= modeThreshold) {
				runningAverage = (runningAverage * continuousCount + sortedData[i]) / (++continuousCount);
				if (maxCount < continuousCount) {
					maxCount = continuousCount;
					maxRunningAverage = runningAverage;
				}
			} else {
				runningAverage = sortedData[i];
				continuousCount = 1;
			}
			sum += sortedData[i];
		}
		
		stats.mode = maxRunningAverage;
		stats.median = sortedData[length/2];
		stats.mean = sum/length;
		
		System.out.println("maxCount= " + maxCount);
		return stats;
	}
	

}
