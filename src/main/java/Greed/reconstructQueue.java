package Greed;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description:
 * @create: 2020-04-16 16:12
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 题目描述：一个学生用两个分量 (h, k) 描述，h 表示身高，k 表示排在前面的有 k 个学生的身高比他高或者和他一样高。
 *
 * 为了在每次插入操作时不影响后续的操作，身高较高的学生应该先做插入操作，否则身高较小的学生原先正确插入第 k 个位置可能会变成第 k+1 个位置。
 *
 * 身高降序、k 值升序，然后按排好序的顺序插入队列的第 k 个位置中。
 **/
public class reconstructQueue {

    public int[][] ReconstructQueue(int[][] people){
        if(people == null || people.length == 0 || people[0].length==0) return new int[0][0];
        //先比较身高，降序，在比较k值，升序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });
        int n = people.length;
        //利用list插入数据来改变位置
        List<int[]> tmp = new ArrayList<>();
        for(int i=0;i<n;i++){
            //按k的值在tmp的对应位置插入排序好的people
            tmp.add(people[i][1],new int[]{people[i][0],people[i][1]});
        }
        //再将list中的数据存到二维数组中
        int[][] ret = new int[n][2];
        for(int i=0;i<n;i++){
            ret[i][0] = tmp.get(i)[0];
            ret[i][1] = tmp.get(i)[1];
        }
        return ret;
    }

    public int[][] reconstructQueue2(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }
        return queue.toArray(new int[queue.size()][]);
    }

    @Test
    public void test6768(){
        int[][] people = {{7,0},{7,1},{6,1},{5,0},{5,2},{4,4}};
        int[][] out = ReconstructQueue(people);
        for(int i=0;i<out.length;i++){
            System.out.println(out[i][0]+"  "+out[i][1]);
        }
    }
}
