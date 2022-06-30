package test.singleton;

import java.io.Serializable;

public class SingletonClass extends MyCloneable implements Serializable {

	private static final long serialVersionUID = 1L;

	public static SingletonClass INSTANCE = null;

	private SingletonClass() {

		if (INSTANCE != null) {
			throw new IllegalStateException("Reflection is not allowed");
		}
	}
	//public static synchronized SingletonClass factoryMethod() { Not used for performance issue
	public static SingletonClass factoryMethod() {
		if (INSTANCE == null) {
			if (INSTANCE == null) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				INSTANCE = new SingletonClass();
			}
		}
		return INSTANCE;

	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Cloning of this object is not allowed");
	}

	protected Object readResolve() {
		return INSTANCE;

	}
}
