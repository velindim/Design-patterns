import java.util.ArrayList;
import java.util.List;

import zadanie3.DeliveryBoy;
import zadanie3.deliveryPackage.DeliveryPackage;
import zadanie3.deliveryPackage.PackageType;
import zadanie3.handler.InternationalPackageHandler;
import zadanie3.handler.NationalPackageHandler;
import zadanie3.handler.PackageHandler;
import zadanie3.handler.PlovdivPackageHandler;

public class Main {

	public static void main(String[] args) {

		DeliveryBoy deliveryBoy = new DeliveryBoy("Toshko");

		PackageHandler handlerChain = buildChain(deliveryBoy);

		for (DeliveryPackage deliveryPackage : getPackages()) {
			System.out.println("Started handling package of type: " + deliveryPackage.getPackageType());
			handlerChain.handle(deliveryPackage);
			System.out.println();
		}
	}

	private static PackageHandler buildChain(DeliveryBoy deliveryBoy) {
		InternationalPackageHandler internationalPackageHandler = new InternationalPackageHandler();
		internationalPackageHandler.addObserver(deliveryBoy);
		NationalPackageHandler nationalPackageHandler = new NationalPackageHandler(internationalPackageHandler);
		nationalPackageHandler.addObserver(deliveryBoy);
		PlovdivPackageHandler plovdivPackageHandler = new PlovdivPackageHandler(nationalPackageHandler);
		plovdivPackageHandler.addObserver(deliveryBoy);

		return plovdivPackageHandler;
	}

	private static List<DeliveryPackage> getPackages() {
		List<DeliveryPackage> packages = new ArrayList<>();
		packages.add(new DeliveryPackage(PackageType.NATIONAL));
		packages.add(new DeliveryPackage(PackageType.INTERNATIONAL));
		packages.add(new DeliveryPackage(PackageType.INTERNATIONAL));
		packages.add(new DeliveryPackage(null));
		packages.add(new DeliveryPackage(PackageType.INSIDE_PLOVDIV));
		return packages;
	}

}
