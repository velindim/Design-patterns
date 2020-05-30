package mediator.person;

import mediator.chat.room.ChatRoom;

public class Person {
	private String name;
	private ChatRoom chatRoom;

	public Person(String name, ChatRoom chatRoom) {
		this.name = name;
		this.chatRoom = chatRoom;
	}

	public void say(String message) {
		if (chatRoom == null) {
			return;
		}
		chatRoom.sendMessage(name, message);
	}

	public void leaveChatRoom() {
		chatRoom = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ChatRoom getChatRoom() {
		return chatRoom;
	}

	public void setChatRoom(ChatRoom chatRoom) {
		this.chatRoom = chatRoom;
	}

}
