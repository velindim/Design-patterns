package mediator.bot;

public class ChatBot {
	private static final String FORBIDDEN_WORD = "cat";

	public boolean matchesForbiddenWord(String message) {
		return message.contains(FORBIDDEN_WORD);
	}
}
