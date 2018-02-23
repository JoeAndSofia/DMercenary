//: interfaces/music4/Music4.java
// Abstract classes and methods.
/* 抽象类的功能
 * 使类的抽象性明确起来
 *
 */
// 以下是 抽象类 的示例
package study_Example.interfaces.music4;
import study_Example.pets.Pet;
import study_Example.polymorphism.music.Note;
import static study_Example.net.mindview.util.Print.*;
/* 1. 抽象方法 abstract void f(); 抽象方法不能包含有任何方法的BODY 。
 * 2. 如果一个类包含1个或者多个抽象方法， 则该类必须限定为抽象的。
 * 需要在前面指定 abstract 关键字。
 * （1）抽象类不能被实例化
 * （2）包含抽象方法的类，必须标识 abstract
 * 3. 如果从一个抽象类继承， 必须对所有抽象方法进行覆盖 , 否则导出类也是抽象的
 * 4. 也可以考虑创建没有任何抽象方法的抽象类 。
 *
 */
abstract class Instrument {
	// 抽象类中可以有非抽象方法。
	private int i; // Storage allocated for each
	public abstract void play(Note n);
	public String what() { return "Instrument"; }
	public abstract void adjust();
}
/*
（2）包含抽象方法的类，必须标识 abstract， 否则编译器会报错
class abc
{
public abstract void Demo();
}*/
class Wind extends Instrument {
	public void play(Note n) {
		print("Wind.play() " + n);
	}
	public String what() { return "Wind"; }
	public void adjust() {}
}

class Percussion extends Instrument {
	public void play(Note n) {
		print("Percussion.play() " + n);
	}
	public String what() { return "Percussion"; }
	public void adjust() {}
}

class Stringed extends Instrument {
	public void play(Note n) {
		print("Stringed.play() " + n);
	}
	public String what() { return "Stringed"; }
	public void adjust() {}
}

class Brass extends Wind {
	public void play(Note n) {
		print("Brass.play() " + n);
	}
	public void adjust() { print("Brass.adjust()"); }
}

class Woodwind extends Wind {
	public void play(Note n) {
		print("Woodwind.play() " + n);
	}
	public String what() { return "Woodwind"; }
}

class TestAbsExt extends Instrument
{
	public void play( Note n ) {
		print ("TestAbsExt.play()" + n);
	}
	public String what()
	{
		return "TestAbsExt";
	}
	public void adjust()
	{
	}
}

// 不含任何抽象方法的抽象类
abstract class AbsClass
{
	public void f1() {
		print("f1()");
	}
	public void f2() {
		print("f2()");
	}
}

public class Music4 {
	// Doesn't care about type, so new types
	// added to the system still work right:
	static void tune(Instrument i) {
		// ...
		i.play(Note.MIDDLE_C);
	}
	static void tuneAll(Instrument[] e) {
		for(Instrument i : e)
			tune(i);
	}
	public static void main(String[] args) {
		// !抽象类不能被实例化
		// 若使用以下语句 ， 将会收到报错。
		/* Exception in thread "main" java.lang.Error: Unresolved compilation problem:
Instructment cannot be resolved to a type
		 */
		// ! new Instructment();
		// Upcasting during addition to the array:
		Instrument[] orchestra = {
				new Wind(),
				new Percussion(),
				new Stringed(),
				new Brass(),
				new Woodwind()
		};
		tuneAll(orchestra);
	}
} 
/* Output:
Wind.play() MIDDLE_C
Percussion.play() MIDDLE_C
Stringed.play() MIDDLE_C
Brass.play() MIDDLE_C
Woodwind.play() MIDDLE_C
 *///:~

/*
 * 抽象方法不能包含有任何方法的BODY 。
 */
/*
abstract class RodentAbs extends Pet {
abstract public Rodent(String name) { super(name); }
abstract public Rodent() { super(); }
} ///:~
 */