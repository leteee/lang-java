package com.example.heap;

public class _215 {

    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = 1; i < k; i++) {
            --heapSize;
            swap(nums, 0, heapSize);
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    // 倒叙遍历堆（层序遍历的倒序），一次对每个非叶子节点执行“从顶至低堆化”
    public void buildMaxHeap(int[] nums, int heapSize) {
        for (int index = heapSize / 2; index >= 0; --index) {
            maxHeapify(nums, index, heapSize);
        }
    }

    //从顶至底堆化
    public void maxHeapify(int[] nums, int index, int heapSize) {
        int left = 2 * index + 1, right = 2 * index + 2, nextIndex = index;
        if (left < heapSize && nums[left] > nums[nextIndex]) {
            nextIndex = left;
        }
        if (right < heapSize && nums[right] > nums[nextIndex]) {
            nextIndex = right;
        }
        if (nextIndex != index) {
            swap(nums, index, nextIndex);
            maxHeapify(nums, nextIndex, heapSize);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public boolean test(int[] nums, int k, int kthLargest) {
        return kthLargest == findKthLargest(nums, k);
    }

    /**
     * 输出通过率
     *
     * @return
     */
    public double test() {
        double count = 2d;
        int valid = 0;
        int[] nums = {3, 2, 1, 5, 6, 4};
        if (test(nums, 2, 5)) {
            valid++;
        }
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        if (test(nums2, 4, 4)) {
            valid++;
        }
        return valid / count;
    }

    public static void main(String[] args) {
        _215 solution = new _215();
        System.out.println(solution.test());
    }
}
