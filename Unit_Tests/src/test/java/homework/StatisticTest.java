package homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class StatisticTest {

    @Test
    public void tstPositiveStatisticCreation() {
        Statistic statistic = new Statistic();
        assertNotNull(statistic);
    }
}