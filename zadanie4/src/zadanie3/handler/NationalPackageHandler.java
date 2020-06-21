package zadanie3.handler;

import zadanie3.deliveryPackage.DeliveryPackage;
import zadanie3.deliveryPackage.PackageType;

public class NationalPackageHandler extends PackageHandler {

	public NationalPackageHandler(PackageHandler successor) {
		super(successor);
	}

	@Override
	public void handle(DeliveryPackage deliveryPackage) {
		if (canHandlePackage(deliveryPackage.getPackageType())) {
			System.out.println("NationalPackageHandler handles package: " + deliveryPackage);
			getState().next(this);
			return;
		} else {
			super.handle(deliveryPackage);
		}

	}

	@Override
	protected boolean canHandlePackage(PackageType packageType) {
		return packageType != null && packageType == PackageType.NATIONAL;
	}

	@Override
	public String toString() {
		return "NationalPackageHandler";
	}

}
