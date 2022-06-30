package test.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestClass {

	public static void main(String[] args) throws CloneNotSupportedException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException, IOException, ClassNotFoundException {

		SingletonClass single = SingletonClass.factoryMethod();
		SingletonClass single1 = SingletonClass.factoryMethod();
	
		System.out.println(single.hashCode());
		System.out.println(single1.hashCode());
		
		/*===================Cloning==================================*/
		
		/*SingletonClass single2 = (SingletonClass) single.clone();
		  System.out.println(single2.hashCode());*/

		
		
		/*===================Reflection API==================================*/
		/*SingletonClass refSingle = null;
		Constructor[] constructors = SingletonClass.class.getDeclaredConstructors();
		for(Constructor con : constructors){
			con.setAccessible(true);
			refSingle = (SingletonClass) con.newInstance();
		}
		System.out.println(refSingle.hashCode());*/
		
		/*===================Serialization==================================*/
		
		//Serialization
		
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("abc.txt"));
		out.writeObject(single);
		out.close();
		
		ObjectInput in = new ObjectInputStream(new FileInputStream("abc.txt"));
		SingletonClass single3 = (SingletonClass) in.readObject();
		in.close();
		System.out.println(single3.hashCode());
		
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		MyThread thread = new MyThread();
		
		service.execute(thread);
		service.execute(thread);service.execute(thread);
		service.shutdown();
	}

}
