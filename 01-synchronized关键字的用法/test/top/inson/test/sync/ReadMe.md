main方法测试线程:
topic-01:
public static void main(String[] args){
	SyncThread syncThread = new SyncThread();
	Thread thread1 = new Thread(syncThread, "SyncThread1");
	Thread thread2 = new Thread(syncThread, "SyncThread2");
	thread1.start();
	thread2.start();
}
//运行打印的结果如下:
/*
	run启动了。。。
	run启动了。。。
	SyncThread1在这里我要干点什么呢？0
	SyncThread1在这里我要干点什么呢？1
	SyncThread1在这里我要干点什么呢？2
	run结束了。。。
	SyncThread2在这里我要干点什么呢？0
	SyncThread2在这里我要干点什么呢？1
	SyncThread2在这里我要干点什么呢？2
	run结束了。。。
*/
从这里我们可以看到:
1.当两个并发线程(thread1和thread2)同时访问同一对象(syncThread)中的synchronized代码块时，在同一时刻只能有一个线程得到执行，
另一个线程受阻塞，必须等待当前线程执行完后才能执行该代码块(后面的需要等前面的执行完了之后，才能执行)
2.thread1和thread2是互斥的，因为在执行synchronized代码块时会锁定当前的对象，只有执行完该代码块之后才能释放该对象锁，
下一线程下能执行并锁定该对象

topic-02:
public static void main(String[] args) {
	SyncThread syncThread = new SyncThread();
	SyncThread syncThread2 = new SyncThread();
	Thread thread = new Thread(syncThread,"syncThread");
	Thread thread2 = new Thread(syncThread2,"syncThread2");
	thread.start();
	thread2.start();
	//程序运行结果是：
	/*run启动了。。。
	run启动了。。。
	syncThread在这里我要干点什么呢？0
	syncThread2在这里我要干点什么呢？0
	syncThread在这里我要干点什么呢？1
	syncThread2在这里我要干点什么呢？1
	syncThread2在这里我要干点什么呢？2
	syncThread在这里我要干点什么呢？2
	run结束了。。。
	run结束了。。。*/
}
不是说一个线程执行synchronized代码块时其它的线程会受到阻塞吗，为什么上面thread1和thread2同时执行，因为synchronized之锁定对象，
每个对象只有一个锁与之关联。














