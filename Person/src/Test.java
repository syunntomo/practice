
public class Test {

	public static void main(String[] args) {
		Person saburo = new Person("saburo");
		saburo.age=0;
		System.out.println(saburo.name);
		System.out.println(saburo.age);

		Person nanashi= new Person(25);
		System.out.println(nanashi.name);
		System.out.println(nanashi.age);

		Person hanako=new Person(17,"hanako");
		System.out.println(hanako.name);
		System.out.println(hanako.age);
	}

}
