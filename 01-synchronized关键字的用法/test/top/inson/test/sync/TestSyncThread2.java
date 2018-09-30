package top.inson.test.sync;

import top.inson.keyworks.sync.SyncThread;

public class TestSyncThread2 {
	public static void main(String[] args) {
		SyncThread syncThread = new SyncThread();
		SyncThread syncThread2 = new SyncThread();
		Thread thread = new Thread(syncThread,"syncThread");
		Thread thread2 = new Thread(syncThread2,"syncThread2");
		thread.start();
		thread2.start();
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
}
