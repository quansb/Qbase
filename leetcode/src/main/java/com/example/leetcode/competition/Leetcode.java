package com.example.leetcode.competition;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author quanshibao
 * @description
 * @date 2021/6/25
 */
public class Leetcode {

    /**
     * 1711. 大餐计数
     * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
     * 你可以搭配 任意 两道餐品做一顿大餐。
     * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​道餐品的美味程度，
     * 返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
     * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
     * 示例 1：
     * 输入：deliciousness = [1,3,5,7,9]
     * 输出：4
     * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
     * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
     * 示例 2：
     * 输入：deliciousness = [1,1,1,3,3,3,7]
     * 输出：15
     * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
     * 提示：
     * 1 <= deliciousness.length <= 105
     * 0 <= deliciousness[i] <= 220
     */
    public int countPairs(int[] deliciousness) {
        int res = 0;
        int mod = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deliciousness.length; i++) {
            map.put(deliciousness[i], i);
        }
        for (int i = 0; i < deliciousness.length; i++) {
            for (int j = 1; j < 22; j++) {
                int target = (int) Math.pow(2, j);
                int value = target - deliciousness[i];
                if (value < deliciousness[i]) continue;
                if (map.containsKey(value)) {
                    Integer index = map.get(value);
                    if (index != null && index != i) {
                        res += 1;
                    }
                }
            }
        }
        return res % mod;
    }


    /**
     * 1710. 卡车上的最大单元数
     * 请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
     * numberOfBoxesi 是类型 i 的箱子的数量。
     * numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
     * 整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
     * 返回卡车可以装载 单元 的 最大 总数。
     * 示例 1：
     * 输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
     * 输出：8
     * 解释：箱子的情况如下：
     * - 1 个第一类的箱子，里面含 3 个单元。
     * - 2 个第二类的箱子，每个里面含 2 个单元。
     * - 3 个第三类的箱子，每个里面含 1 个单元。
     * 可以选择第一类和第二类的所有箱子，以及第三类的一个箱子。
     * 单元总数 = (1 * 3) + (2 * 2) + (1 * 1) = 8
     * 示例 2：
     * 输入：boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
     * 输出：91
     * 提示：
     * 1 <= boxTypes.length <= 1000
     * 1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
     * 1 <= truckSize <= 106
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int cur = truckSize;
        int sum = 0;
        for (int[] boxType : boxTypes) {
            if (boxType[0] > cur) {
                sum += cur * boxType[1];
                break;
            } else {
                sum += boxType[0] * boxType[1];
                cur -= boxType[0];
            }
        }
        return sum;
    }
}
