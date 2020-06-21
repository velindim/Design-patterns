package zadanie3.handler;

import java.util.Observable;

import zadanie3.deliveryPackage.DeliveryPackage;
import zadanie3.deliveryPackage.PackageType;
import zadanie3.state.FreeState;
import zadanie3.state.HandlingState;

public abstract class PackageHandler extends Observable {
	private PackageHandler successor;
	private HandlingState state = new FreeState();

	public PackageHandler() {
	}

	public PackageHandler(PackageHandler successor) {
		this.successor = successor;
	}

	protected abstract boolean canHandlePackage(PackageType packageType);

	public void handle(DeliveryPackage deliveryPackage) {
		if (successor != null) {
			successor.handle(deliveryPackage);
		} else {
			System.out.println(
					"Unable to find the correct handler for this package: " + deliveryPackage.getPackageType());
		}
	}

	public HandlingState getState() {
		return state;
	}

	public void setState(HandlingState state) {
		this.state = state;
		setChanged();
		notifyObservers();
	}

}
