package zadanie3;

import java.util.Observable;
import java.util.Observer;

import zadanie3.handler.PackageHandler;
import zadanie3.state.HandlingState;
import zadanie3.state.InProgressState;

public class DeliveryBoy implements Observer {
	private String name;

	public DeliveryBoy(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof PackageHandler) {
			PackageHandler handler = ((PackageHandler) o);
			HandlingState state = handler.getState();
			if (state != null && state instanceof InProgressState) {
				System.out.println(name + " got the package and moved it to stock");
				state.next(handler);
			}
		}

	}

}
