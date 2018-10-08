package top.inson.keyworks.sync;
/**
 * @description 多个线程访问synchronized代码块和非synchronized代码块<br/>
 * @ClassName CounterThread<br/>
 * @author jack<br/>
 * @createTime 2018年10月8日下午4:48:16<br/>
 * @version 1.0.0<br/>
 */
public class CounterThread implements Runnable{
	//synchronized关键字修饰的方法
	public void syncMethod() {
		System.out.println("sync启动了");
		synchronized(this) {
			try {
				for(int i=0;i < 3;i++) {
					System.out.println(Thread.currentThread().getName()+"----i--"+i);
					Thread.sleep(2000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("sync结束了");
	}
	//非synchronized关键字的方法
	public void noMethod() {
		System.out.println("no启动了");
		try {
			for(int i=0;i < 3;i++) {
				System.out.println(Thread.currentThread().getName()+"----i--"+i);
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("no结束了");
	}
	
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		if("sync".equals(threadName)) {
			syncMethod();
		}else if("no".equals(threadName)) {
			noMethod();
		}
	}

}
