package org.xgl.base1.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program leetcode
 * @description 两数求和 给定一个数组nums和一个整数目标值target,在该数组中找出和为目标值的那两个整数，并返回他们的数组下标
 * @auther Mr.Xiong
 * @create 2021-04-13 08:57:06
 */
public class TwoDigitNum {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{1, 2, 3, 4, 6, 8}, 12);
        int[] result2 = twoSum2(new int[]{1, 2, 3, 4, 6, 8}, 12);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));
    }
}
