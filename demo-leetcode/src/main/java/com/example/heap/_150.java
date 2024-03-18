package com.example.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class _150 {
    //类似银行家算法
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; ++i) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }

        // 堆资本排序
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        //队列存储到了第几个资本的利润项目
        int cur = 0;
        //新建堆队列
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> (int) i).reversed());
        for (int i = 0; i < k; ++i) {
            while (cur < n && arr[cur][0] <= w) {
                pq.add(arr[cur][1]);
                cur++;
            }

            if (!pq.isEmpty()) {
                w += pq.poll();
            } else {
                break;
            }
        }
        return w;
    }

    public static void main(String[] args) {
        int[] profits = {1, 2, 3};
        int[] capitals = {0, 1, 2};
        _150 solution = new _150();
        int result = solution.findMaximizedCapital(3, 0, profits, capitals);
        System.out.println(result == 6);
    }
}
