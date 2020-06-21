package zadanie3.handler;

import zadanie3.deliveryPackage.DeliveryPackage;
import zadanie3.deliveryPackage.PackageType;

public class InternationalPackageHandler extends PackageHandler {

	@Override
	public void handle(DeliveryPackage deliveryPackage) {
		if (canHandlePackage(deliveryPackage.getPackageType())) {
			System.out.println("InternationalPackageHandler handles package: " + deliveryPackage);
			getState().next(this);
			return;
		} else {
			super.handle(deliveryPackage);
		}

	}

	@Override
	protected boolean canHandlePackage(PackageType packageType) {
		return packageType != null && packageType == PackageType.INTERNATIONAL;
	}

	@Override
	public String toString() {
		return "InternationalPackageHandler";
	}

}
