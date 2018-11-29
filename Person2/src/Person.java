
public class Person {
	public String name;
	public int age;
	
	public Person(){}
	
	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	
	public void talk(){
		System.out.println(this.name+"が話す");
	}
	public void walk(){
		System.out.println(this.name+"が歩く");
	}
	public void run(){
		System.out.println(this.name+"が走る");
	}
}
