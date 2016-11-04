package homework;

import org.testng.annotations.Test;

public class StatisticTest {

    @Test (expectedExceptions = Exception.class)
    public void tstNullListParameter() throws Exception {
        Statistic statistic = new Statistic();
        statistic.showStatistic(null);
    }
}