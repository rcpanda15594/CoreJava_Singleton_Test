package test.singleton;

public class MyThread implements Runnable {

	@Override
	public void run() {

		SingletonClass single = SingletonClass.factoryMethod();
		System.out.println(Thread.currentThread().getName()+ "-----"+single.hashCode());
	}

}
