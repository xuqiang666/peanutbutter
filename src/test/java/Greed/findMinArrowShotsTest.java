package Greed;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class findMinArrowShotsTest {

    @Test
    void countsDisjointBalloonsWhenEndpointsUseIntegerExtremes() {
        int[][] points = {
                {Integer.MIN_VALUE, Integer.MIN_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE}
        };

        assertEquals(2, new findMinArrowShots().greedFindMinArrowShots(points));
    }
}
