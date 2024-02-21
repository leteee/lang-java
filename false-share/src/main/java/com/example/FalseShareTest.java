package com.example;

public class FalseShareTest {
    public static int NUM_THREADS = 4;
    public final static long ITERATIONS = 500L * 1000L * 1000L;
    private final int arrayIndex;
    private static VolatileLong[] longs;
    public static long SUM_TIME = 0l;

    public FalseShareTest(final int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    //    那么该如何做到呢？其实在我们注释的那行代码中就有答案，那就是缓存行填充（Padding） 。现在分析上面的例子，我们知道一条缓存行有 64 字节，而 Java 程序的对象头固定占 8 字节(32位系统)或 12 字节( 64 位系统默认开启压缩, 不开压缩为 16 字节)，所以我们只需要填 6 个无用的长整型补上6*8=48字节，让不同的 VolatileLong 对象处于不同的缓存行，就避免了伪共享( 64 位系统超过缓存行的 64 字节也无所谓，只要保证不同线程不操作同一缓存行就可以)。
    //    首先就是多次强调的，伪共享是很隐蔽的，我们暂时无法从系统层面上通过工具来探测伪共享事件。其次，不同类型的计算机具有不同的微架构（如 32 位系统和 64 位系统的 java 对象所占自己数就不一样），如果设计到跨平台的设计，那就更难以把握了，一个确切的填充方案只适用于一个特定的操作系统。还有，缓存的资源是有限的，如果填充会浪费珍贵的 cache 资源，并不适合大范围应用。最后，目前主流的 Intel 微架构 CPU 的 L1 缓存，已能够达到 80% 以上的命中率。
    public static void main(final String[] args) throws Exception {
        Thread.sleep(10000);
        for (int j = 0; j < 10; j++) {
            System.out.println(j);
            if (args.length == 1) {
                NUM_THREADS = Integer.parseInt(args[0]);
            }
            longs = new VolatileLong[NUM_THREADS];
            for (int i = 0; i < longs.length; i++) {
                longs[i] = new VolatileLong();
            }
            final long start = System.nanoTime();
            runTest();
            final long end = System.nanoTime();
            SUM_TIME += end - start;
        }
        System.out.println("平均耗时：" + SUM_TIME / 10);
    }

    private static void runTest() throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(String.valueOf(new FalseShareTest(i)));
        }
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
    }

    public void run() {
        long i = ITERATIONS + 1;
        while (0 != --i) {
            longs[arrayIndex].value = i;
        }
    }

    public final static class VolatileLong {
        public volatile long value = 0L;
//        public long p1, p2, p3, p4, p5, p6;     //屏蔽此行
    }
}