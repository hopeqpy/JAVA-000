作业一：
GC的总结：

1.UseSerialGC  
启动参数：
-XX:+UseSerialGC  -Xmx512m  -Xms512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps

现象：
发生多次full GC  串行GC期间，会发生STW,用于垃圾回收
1）对 年轻代  使用标记复制算法，老年代使用标记，移动，压缩算法
2）+UserParNewGc 是改进版本的Serial Gc 经常配合CMS使用
3）串行Gc使用单线程进行垃圾回收，cpu利用率高，暂停时间会较长

2.UseParallelGc
启动参数：
-XX:+UseParallelGC -XX:+UseParallelOldGC -XX:ParallelGCThreads=N 指定GC线程数，默认为CPU核心数

现象： 内存较小也会发生Full Gc,停顿时间叫串行Gc更短，利用了多核心计算机的优势
1) 年轻代采用标记，复制算法，老年代使用标记，移动压缩算法
2）并行Gc，可以增加系统的吞吐量，Gc期间 用于出发STW,并进行垃圾回收，每次Gc会重启动Gc线程；

3. CMS

启动参数：-XX:+UseConcMarkSweepGC

特点：
1）年轻代采用并行的标记复制算法，老年代采用并发的标记，移动算法
2）不对老年代进行整理，使用freeList方式来管理空闲内存
3）cms默认的并发线程数是cpu的四分之一，标记清理阶段大部分跟工作线程一起，STW时间较短；

4：G1 Gc

参数：-XX:+UseG1GC -XX:MaxGCPauseMills=50

特点：
g1 垃圾回收器是垃圾优先，让stw的时间变为可控制，堆的划分不再采用分代，而是划分为不同的区域，每一个区域可能是年轻代或者老年代

总结：当应用分配的内存较少时，cms可能会比g1 更高效；当内存增加，g1更适合处理内容较大的