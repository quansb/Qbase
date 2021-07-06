package com.example.leetcode.data;

import com.example.leetcode.base.DataFactory;
import com.example.leetcode.base.TreeDataFactory;

/**
 * @author quanshibao
 * @description
 * @date 2021/3/8
 */
public class Sort {


    public static void main(String[] args) {
        Sort sort = new Sort();
        //    System.out.println(test.partition2(TreeDataFactory.arr1, TreeDataFactory.arr1.length, 0, TreeDataFactory.arr1.length - 1));
        System.out.println(sort.partition(TreeDataFactory.arr1,
                TreeDataFactory.arr1.length,
                0,
                TreeDataFactory.arr1.length - 1));
    }


    public int partition(int[] arr, int length, int start, int end) {
        if (arr == null || length <= 0 || start < 0 || end >= length) {
            return -1;
        }
        DataFactory.printArr(arr);
        int index = DataFactory.randomInRange2(start, end);
        swap(arr, index, end);
        DataFactory.printArr(arr);
        int small = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[end]) {
                small++;
                if (small != i) {
                    swap(arr, small, i);
                }
            }
        }
        small += 1;
        swap(arr, small, end);
        DataFactory.printArr(arr);
        return small;
    }

    public void swap(int[] arr, int a, int b) {
        if (a == b) {
            return;
        }
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    public int partition2(int[] arr, int length, int start, int end) {
        if (arr == null || length <= 0 || start < 0 || end >= length) {
            return -1;
        }
        int index = DataFactory.randomInRange2(start, end);
        int target = arr[index];
        swap(arr, start, index);
        while (start != end) {
            while (start < end && arr[end] >= target) {
                end--;
            }
            arr[start] = arr[end];
            while (start < end && arr[start] <= target) {
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = target;
        DataFactory.printArr(arr);
        return start;
    }

    /**
     * 快速排序
     */
    private static int[] fastSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left != right) {
            while (arr[left] < 0 && left < right) {
                left++;
            }
            while (arr[right] > 0 && left < right) {
                right--;
            }
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        return arr;
    }


}
