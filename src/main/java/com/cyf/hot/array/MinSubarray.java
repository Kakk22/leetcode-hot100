package com.cyf.hot.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈一锋
 * @date 2023/3/10 9:45 下午
 */
public class MinSubarray {

    public static void main(String[] args) {
//        System.out.println(new MinSubarray().minSubarray(new int[]{1000000000, 1000000000, 1000000000}, 3) == 0);
        System.out.println(new MinSubarray().minSubarray(new int[]{3,1,4,2}, 6) == 1);
    }

    public int minSubarray(int[] nums, int p) {
        // 前缀和+hash，同余定理
        long sum = 0;
        int n = nums.length;
        //前缀和数组
        long[]pre = new long[n+1];
        for(int i = 0;i<n;i++){
            sum += nums[i];
            pre[i+1] = nums[i] + pre[i];
        }
        if(sum < p){
            return -1;
        }
        if(sum % p == 0){
            return 0;
        }

        sum %= p;
        //结束时 min > n 则不存在满足的子串
        int min = n + 1;
        Map<Long,Integer> map = new HashMap<>();
        for(int i = 0;i<=n;i++){
            //更新最新出现的pre[i] % p 的下标
            map.put(pre[i] % p,i);
            long prePoint = (pre[i] - sum + p) % p;
            if(map.containsKey(prePoint)){
                min = Math.min(min,i - map.get(prePoint));
            }
        }
        return min >= n ? -1 : min;
    }
}
