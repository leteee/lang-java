package com.example.heap;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * 数据流的中位数
 */
public class _295 {

    PriorityQueue<Integer> queMin;
    int left = 0, right = 0;
    PriorityQueue<Integer> queMax;

    public _295() {
        Comparator<Integer> comparator = Comparator.comparingInt(a -> a);
        //大顶堆
        queMin = new PriorityQueue<>(comparator.reversed());
        //小顶堆
        queMax = new PriorityQueue<>(comparator);
    }

    public void addNum(int num) {
        //奇数，中位数在queMin
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            left++;
            if (left > right + 1) {
                queMax.offer(queMin.poll());
                left--;
                right++;
            }
        } else {
            queMax.offer(num);
            right++;
            if (left < right) {
                queMin.offer(queMax.poll());
                right--;
                left++;
            }
        }
    }

    public double findMedian() {
        if (left > right) {
            return queMin.peek();
        }
        return (queMin.peek() + queMax.peek()) / 2.0;
    }
}
