package Greed;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @description:
 * @create: 2020-04-16 10:12
 **/
public class AssignCookies {

    public int assignCookies(int[] children, int[] cookies){
        Arrays.sort(children);
        Arrays.sort(cookies);
        int i=0,j=0;
        while((i<children.length) && (j<cookies.length)){
            if(children[i]<=cookies[j]) i++;
            j++;
        }
        return i;
    }

    @Test
    public void test03403(){
        int[] children={1,2,2,3,4,5};
        int[] cookies={1,2,3,6,7,2,2,2};
        System.out.println(assignCookies(children,cookies));
    }

}
