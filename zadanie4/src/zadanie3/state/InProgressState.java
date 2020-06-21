package zadanie3.state;

import zadanie3.handler.PackageHandler;

public class InProgressState extends HandlingState {

	@Override
	public void next(PackageHandler handler) {
		System.out.println(handler.toString() + " moved status : IN PROGRESS -> FREE");
		handler.setState(new FreeState());
	}

}
