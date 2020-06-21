package zadanie3.handler;

import zadanie3.deliveryPackage.DeliveryPackage;
import zadanie3.deliveryPackage.PackageType;

public class PlovdivPackageHandler extends PackageHandler {

	public PlovdivPackageHandler(PackageHandler successor) {
		super(successor);
	}

	@Override
	public void handle(DeliveryPackage deliveryPackage) {
		if (canHandlePackage(deliveryPackage.getPackageType())) {
			System.out.println("PlovdivPackageHandler handles package: " + deliveryPackage);
			getState().next(this);
			return;
		} else {
			super.handle(deliveryPackage);
		}

	}

	@Override
	protected boolean canHandlePackage(PackageType packageType) {
		return packageType != null && packageType == PackageType.INSIDE_PLOVDIV;
	}

	@Override
	public String toString() {
		return "PlovdivPackageHandler";
	}
}
