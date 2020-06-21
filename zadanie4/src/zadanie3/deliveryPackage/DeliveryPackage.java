package zadanie3.deliveryPackage;

public class DeliveryPackage {
	private PackageType packageType;

	public DeliveryPackage(PackageType packageType) {
		this.packageType = packageType;
	}

	public PackageType getPackageType() {
		return packageType;
	}

	public void setPackageType(PackageType packageType) {
		this.packageType = packageType;
	}

	@Override
	public String toString() {
		return "DeliveryPackage of type : " + packageType;
	}

}
