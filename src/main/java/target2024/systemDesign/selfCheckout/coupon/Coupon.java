package target2024.systemDesign.selfCheckout.coupon;

import lombok.Getter;
import target2024.systemDesign.selfCheckout.product.ProductCategory;

@Getter
public class Coupon {
	String id;
	CouponType type;
	Double value;
	ProductCategory productCategory;

	public void setActive(Boolean active) {
		isActive = active;
	}

	Boolean isActive;


	public Coupon(CouponType type, Double value, ProductCategory productCategory) {
		this.type = type;
		this.value = value;
		this.productCategory = productCategory;
		this.isActive = true;
	}
}
