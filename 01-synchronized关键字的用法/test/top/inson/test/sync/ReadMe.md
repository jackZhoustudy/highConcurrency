main方法测试线程:  <br/>
topic-01:  <br/>
public static void main(String[] args){  <br/>
	SyncThread syncThread = new SyncThread();  <br/>
	Thread thread1 = new Thread(syncThread, "SyncThread1");  <br/>
	Thread thread2 = new Thread(syncThread, "SyncThread2");  <br/>
	thread1.start();  <br/>
	thread2.start();  <br/>
}  <br/>
//运行打印的结果如下:  <br/>
/*  <br/>
	run启动了。。。  <br/>
	run启动了。。。  <br/>
	SyncThread1在这里我要干点什么呢？0  <br/>
	SyncThread1在这里我要干点什么呢？1  <br/>
	SyncThread1在这里我要干点什么呢？2  <br/>
	run结束了。。。  <br/>
	SyncThread2在这里我要干点什么呢？0  <br/>
	SyncThread2在这里我要干点什么呢？1  <br/>
	SyncThread2在这里我要干点什么呢？2  <br/>
	run结束了。。。  <br/>
*/  <br/>
从这里我们可以看到:  <br/>
1.当两个并发线程(thread1和thread2)同时访问同一对象(syncThread)中的synchronized代码块时，在同一时刻只能有一个线程得到执行，  <br/>
另一个线程受阻塞，必须等待当前线程执行完后才能执行该代码块(后面的需要等前面的执行完了之后，才能执行)  <br/>
2.thread1和thread2是互斥的，因为在执行synchronized代码块时会锁定当前的对象，只有执行完该代码块之后才能释放该对象锁，  <br/>
下一线程下能执行并锁定该对象  <br/>

topic-02:  <br/>
public static void main(String[] args) {  <br/>
	SyncThread syncThread = new SyncThread();  <br/>
	SyncThread syncThread2 = new SyncThread();  <br/>
	Thread thread = new Thread(syncThread,"syncThread");  <br/>
	Thread thread2 = new Thread(syncThread2,"syncThread2");  <br/>
	thread.start();  <br/>
	thread2.start();  <br/>
	//程序运行结果是：  <br/>
	/*run启动了。。。  <br/>
	run启动了。。。  <br/>
	syncThread在这里我要干点什么呢？0  <br/>
	syncThread2在这里我要干点什么呢？0  <br/>
	syncThread在这里我要干点什么呢？1  <br/>
	syncThread2在这里我要干点什么呢？1  <br/>
	syncThread2在这里我要干点什么呢？2  <br/>
	syncThread在这里我要干点什么呢？2  <br/>
	run结束了。。。  <br/>
	run结束了。。。*/  <br/>
}  <br/>
不是说一个线程执行synchronized代码块时其它的线程会受到阻塞吗，为什么上面thread1和thread2同时执行，因为synchronized之锁定对象，  <br/>
每个对象只有一个锁与之关联。  <br/>

