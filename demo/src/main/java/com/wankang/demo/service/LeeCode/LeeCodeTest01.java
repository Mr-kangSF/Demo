package com.wankang.demo.service.LeeCode;

import java.util.HashMap;
import java.util.Map;

/**
 *     给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 *     你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 *     示例:
 *
 *     给定 nums = [2, 7, 11, 15], target = 9
 *
 *     因为 nums[0] + nums[1] = 2 + 7 = 9
 *     所以返回 [0, 1]
 *
 * @author wankang
 * @create 2019-08-27 18:00
 **/
public class LeeCodeTest01 {

    public static void main(String... args){
        int[] nums = new int[]{2, 7, 11, 15};
        int[] ints = twoSum1(nums, 9);
        System.out.println("[" + ints[0] + "," +ints[1] + "]");
    }

    /**
     * 暴力法  时间复杂度 O(n); 空间复杂度 O(1)
     * @param nums
     * @param target
     * @return
     */
    public static  int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }

        return null;
    }

    /**
     * 时间复杂度与空间复杂度均为O（n）,  containsKey()的时间复杂度可看为O(1),详见hashmap原理
     * @param nums
     * @param target
     * @return
     */
    public static  int[] twoSum1(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (map.containsKey(val) && map.get(val) != i) {
                return new int[]{i, map.get(val)};
            }
            map.put(nums[i] ,i);
        }

        return null;
    }

}
