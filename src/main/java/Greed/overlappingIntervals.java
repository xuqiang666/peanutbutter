package Greed;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:
 * @create: 2020-04-16 15:44
 * 先计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。
 *
 * 在每次选择中，区间的结尾最为重要，选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大。
 *
 * 按区间的结尾进行排序，每次选择结尾最小，并且和前一个区间不重叠的区间。
 **/
public class overlappingIntervals {

    public int OverlappingIntervals(int[][] intervals){
        if(intervals.length == 0) return 0;
        //对数组进行排序，使每次选择从区间结尾值小的开始
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] -  o2[1];
            }
        });
        int n= 1;
        int end = intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            //比较区间起始值避免重叠
            if(intervals[i][0]>=end){
                end = intervals[i][1];
                n++;
            }
        }
        return intervals.length - n;
    }

    @Test
    public void testo8989(){
        int[][] intervals = {{2,3},{4,5},{1,5},{4,6},{5,7}, {7,8},{9,15},{3,10}};
        System.out.println(OverlappingIntervals(intervals));
    }
}
