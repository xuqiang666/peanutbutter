package Greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:
 * @create: 2020-04-16 10:57
 * 也是计算不重叠的区间个数，不过和 Non-overlapping Intervals 的区别在于，[1, 2] 和 [2, 3] 在本题中算是重叠区间。
 **/
public class findMinArrowShots {

    public int greedFindMinArrowShots(int[][] points) {

        if(points.length == 0) return 0;
        //Arrays.sort(points,(a,b) -> (a[1] - b[1]));
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (a[1] - b[1]);
            }
        });

        int end = points[0][1];
        int n = 1;
        for (int i = 1; i < points.length; i++) {

            if(points[i][0] <= end) {
                continue;
            }
            end = points[i][1];
            n++;
        }
        return n;
    }

}
