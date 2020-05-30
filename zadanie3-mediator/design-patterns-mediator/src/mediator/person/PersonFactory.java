package mediator.person;

public class PersonFactory {

	public static Person create(String name) {
		return new Person(name, null);
	}
}
