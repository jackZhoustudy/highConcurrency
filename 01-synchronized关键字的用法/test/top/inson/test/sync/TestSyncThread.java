package top.inson.test.sync;

import top.inson.keyworks.sync.SyncThread;

public class TestSyncThread {
	public static void main(String[] args) {
		SyncThread syncThread = new SyncThread();
		Thread thread1 = new Thread(syncThread, "SyncThread1");
		Thread thread2 = new Thread(syncThread, "SyncThread2");
		thread1.start();
		thread2.start();
		//运行打印的结果如下
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

	}
}
