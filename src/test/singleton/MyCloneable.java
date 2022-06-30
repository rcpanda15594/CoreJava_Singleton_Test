package test.singleton;

public class MyCloneable implements Cloneable {

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
