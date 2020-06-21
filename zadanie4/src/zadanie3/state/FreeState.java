package zadanie3.state;

import zadanie3.handler.PackageHandler;

public class FreeState extends HandlingState {

	@Override
	public void next(PackageHandler handler) {
		System.out.println(handler.toString() + " moved status : FREE -> IN PROGRESS");
		handler.setState(new InProgressState());
	}

}
