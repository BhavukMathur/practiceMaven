package target2024.systemDesign.selfCheckout;

import target2024.systemDesign.selfCheckout.coupon.Coupon;
import target2024.systemDesign.selfCheckout.coupon.CouponType;
import target2024.systemDesign.selfCheckout.product.Product;
import target2024.systemDesign.selfCheckout.product.ProductCategory;
import target2024.systemDesign.selfCheckout.product.ShoppingCart;
import target2024.systemDesign.selfCheckout.product.ShoppingCartListItem;
import target2024.systemDesign.selfCheckout.user.User;

import java.util.List;

public class SelfCheckoutDemo {
	public static void main(String[] args) {
		SelfCheckoutService service = SelfCheckoutService.getInstance();

		User user1 = service.registerUser("User1", "100000", 33);
		User user2 = service.registerUser("User2", "200000", 31);

		Coupon coupon1 = new Coupon(CouponType.PERCENTAGE_BASED, 10.0, ProductCategory.ELECTRONICS);
		Coupon coupon2 = new Coupon(CouponType.AMOUNT_BASED, 200.0, ProductCategory.ELECTRONICS);

		user1.attachCoupon(coupon1);
		user1.attachCoupon(coupon2);

		Product apple = new Product("apple", 100.0, ProductCategory.FOOD);
		Product laptop = new Product("laptop", 10000.0, ProductCategory.ELECTRONICS);
		Product mobile = new Product("mobile", 1000.0, ProductCategory.ELECTRONICS);
		Product racquet = new Product("racquet", 200.0, ProductCategory.SPORTS);

		ShoppingCartListItem lineItem1 = new ShoppingCartListItem(apple, 2.0, null);
		ShoppingCartListItem lineItem2 = new ShoppingCartListItem(laptop, null, 1.0);
		ShoppingCartListItem lineItem3 = new ShoppingCartListItem(mobile, null, 3.0);

		ShoppingCart shoppingCart = service.createShoppingCart(user1, List.of(lineItem1, lineItem2, lineItem3));

		System.out.println("Before discount");
		for(ShoppingCartListItem listItem: shoppingCart.getListItems()) {
			System.out.println(listItem.getProduct().getName() + " : " + listItem.getOrderValue());
		}

		System.out.println("Applying coupons");
		service.applyCoupon(shoppingCart);

		System.out.println("After discount");
		for(ShoppingCartListItem listItem: shoppingCart.getListItems()) {
			System.out.println(listItem.getProduct().getName()
					+ " : " + listItem.getOrderValue()
					+ " : " + listItem.getDiscount());
		}

	}
}
