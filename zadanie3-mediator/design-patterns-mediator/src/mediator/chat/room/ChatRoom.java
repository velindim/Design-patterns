package mediator.chat.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import mediator.bot.ChatBot;
import mediator.bot.ChatBotFactory;
import mediator.person.Person;

public class ChatRoom {

	private static final String ADD_BOT_KEYWORD = "addBot";
	private ChatBot bot;
	private List<Person> participants = new ArrayList<>();
	private List<String> chatLog = new ArrayList<>();

	public void sendMessage(String name, String message) {
		Optional<Person> optional = participants.stream().filter(person -> person.getName().equals(name)).findFirst();

		if (name == null || message == null || optional.isEmpty()) {
			return;
		}

		Person person = optional.get();

		boolean hasActiveBot = bot != null;
		if (ADD_BOT_KEYWORD.equals(message)) {
			if (hasActiveBot) {
				chatLog.add("Bot has already been added");
				return;
			}
			bot = ChatBotFactory.getInstance();
			chatLog.add("Bot has been added");
		} else if (hasActiveBot && bot.matchesForbiddenWord(message)) {
			person.leaveChatRoom();
			chatLog.add(person.getName() + " has been removed for using forbidden word");
		} else {
			chatLog.add(String.format("[%s] says: %s", person.getName(), message));
		}
	}

	public void join(Person person) {
		if (person == null) {
			return;
		}
		String joinMsg = person.getName() + " joins the chat";
		chatLog.add(joinMsg);

		person.setChatRoom(this);
		participants.add(person);
	}

	public void showChatLog() {
		for (String message : chatLog) {
			System.out.println(message);
		}
	}
}
