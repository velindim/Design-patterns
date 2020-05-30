package mediator;

import mediator.chat.room.ChatRoom;
import mediator.person.Person;
import mediator.person.PersonFactory;

public class Demo {
	public static void main(String[] args) {
		ChatRoom room = new ChatRoom();

		Person john = PersonFactory.create("Gosho");
		Person jane = PersonFactory.create("Tosho");

		room.join(john);
		room.join(jane);

		john.say("hi room");
		jane.say("oh, hey john");

		Person simon = PersonFactory.create("Simon");
		room.join(simon);
		simon.say("hi everyone!");
		
		jane.say("addBot");
		john.say("addBot");
		simon.say("I have a cat");
		
		jane.say("oh, why he left");
		john.say("it is a forbidden word");		
		simon.say("I should not be able to chat anymore");
		
		room.showChatLog();
	}
}
