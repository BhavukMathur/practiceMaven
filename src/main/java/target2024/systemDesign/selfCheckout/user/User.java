package target2024.systemDesign.selfCheckout.user;

import lombok.Getter;
import target2024.systemDesign.selfCheckout.coupon.Coupon;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Getter
public class User {
	String id;
	String name;
	String phone;
	Integer age;
	List<Coupon> coupons;

	public User(String name, String phone, Integer age) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.phone = phone;
		this.age = age;
		coupons = new LinkedList<>();
	}

	public void attachCoupon(Coupon coupon) {
		this.coupons.add(coupon);
	}
}
