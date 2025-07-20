Functional Requirements:
	- Multiple products
	- Products can have attributes - price, description
	- Product quantities
	- Products can be bought / sold --> quantities to be affected
	- Search product
	- Transaction log for a given product
	
Non-Functional Requirements:
	- OOS
	

Core Entities:
	- Product
	- InventoryItem (productId, quantity)
	- Inventory
	- Service class - Singleton pattern
	- Demo class - main
	- Inventory - Observer pattern