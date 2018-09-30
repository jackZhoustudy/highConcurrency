package top.inson.keyworks.sync;

public class SyncThread implements Runnable {
	
	@Override
	public void run() {
		System.out.println("run启动了。。。");
		synchronized(this) {
			try {
				for (int i = 0; i < 3; i++) {
					System.out.println(Thread.currentThread().getName() + "在这里我要干点什么呢？" + i);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("run结束了。。。");
	}

}
