package mediator.bot;

public class ChatBotFactory {
	private static ChatBot INSTANCE = null;

	private ChatBotFactory() {

	}

	public static ChatBot getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ChatBot();
		}

		return INSTANCE;
	}
}
