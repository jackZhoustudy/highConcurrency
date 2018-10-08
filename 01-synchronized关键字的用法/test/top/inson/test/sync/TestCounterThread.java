package top.inson.test.sync;

import top.inson.keyworks.sync.CounterThread;

public class TestCounterThread {
	public static void main(String[] args) {
		CounterThread counterThread = new CounterThread();
		Thread sync = new Thread(counterThread,"sync");
		sync.start();
		Thread no = new Thread(counterThread,"no");
		no.start();
		/*运行结果：
		sync启动了
		no启动了
		sync----i--0
		no----i--0
		no----i--1
		sync----i--1
		no----i--2
		sync----i--2
		sync结束了
		no结束了
		上面代码中syncMethod是一个synchronized的，noMethod是非synchronized的。
		从上面的结果中可以看出一个线程访问一个对象的synchronized代码块时，别的线程可以访问该对象的非synchronized代码块而不受阻塞。
		*/
	}
}
