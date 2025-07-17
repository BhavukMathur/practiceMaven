package target2024.systemDesign.selfCheckout;

import target2024.systemDesign.selfCheckout.coupon.Coupon;
import target2024.systemDesign.selfCheckout.coupon.CouponType;
import target2024.systemDesign.selfCheckout.product.ShoppingCart;
import target2024.systemDesign.selfCheckout.product.ShoppingCartListItem;
import target2024.systemDesign.selfCheckout.user.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Singleton Design Pattern
public class SelfCheckoutService {
	private static SelfCheckoutService instance;
	private Map<String, User> userById;

	private SelfCheckoutService() {
		userById = new HashMap<>();
	}

	public synchronized static SelfCheckoutService getInstance() {
		if(instance == null) {
			instance = new SelfCheckoutService();
		}
		return instance;
	}

	public User registerUser(String name, String phone, Integer age) {
		User user = new User(name, phone, age);
		userById.put(user.getId(), user);
		return user;
	}

	public ShoppingCart createShoppingCart(User user, List<ShoppingCartListItem> listItems) {
		ShoppingCart shoppingCart = new ShoppingCart(user, listItems);
		shoppingCart.calculateOrdervalue();
		return shoppingCart;
	}

	public void applyCoupon(ShoppingCart shoppingCart) {
		User user = shoppingCart.getUser();
		List<Coupon> coupons = user.getCoupons();

		for (Coupon coupon : coupons) {
			for (ShoppingCartListItem listItem : shoppingCart.getListItems()) {
				Double multiplier = listItem.getQuantity() != null ? listItem.getQuantity() : listItem.getWeight();
				if (listItem.getProduct().getCategory() == coupon.getProductCategory()) {
					Double discount;
					if (coupon.getType() == CouponType.PERCENTAGE_BASED) {
						discount = (listItem.getOrderValue() * coupon.getValue()) / 100;
					} else {
						discount = coupon.getValue() * multiplier;
					}
					listItem.setDiscount(listItem.getDiscount() + discount);
				}
			}
			coupon.setActive(false);
		}

		Double totalDiscount=0.0;
		for (ShoppingCartListItem listItem : shoppingCart.getListItems()) {
			totalDiscount = totalDiscount + listItem.getDiscount();
		}
		shoppingCart.setDiscount(totalDiscount);
	}
}
