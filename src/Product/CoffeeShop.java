package Product;

public class CoffeeShop {  
    private RewardSystem rewardSystem;  
      
    public CoffeeShop() {  
        rewardSystem = new RewardSystem();  
    }  
      
    public void makePurchase(Customer customer, double purchaseAmount) {  
        // 计算购买应获得的积分  
        int pointsForPurchase = rewardSystem.getPointsForPurchase(purchaseAmount);  
          
        // 给顾客添加积分  
        customer.addPoints(pointsForPurchase);  
          
        System.out.println("Purchase made for " + purchaseAmount + ". Customer " + customer.getName() + " earned " + pointsForPurchase + " points.");  
          
        // 检查是否有足够的积分换取折扣  
        if (rewardSystem.hasEnoughPointsForDiscount(customer)) {  
            // 应用折扣  
            double discountedAmount = rewardSystem.applyDiscount(purchaseAmount);  
              
            // 从顾客积分中扣除换取折扣所需的积分  
            customer.deductPoints(RewardSystem.POINTS_FOR_DISCOUNT);  
              
            System.out.println("Discount applied! Customer paid " + discountedAmount + " after discount.");  
        } else {  
            System.out.println("Customer did not have enough points for a discount.");  
        }  
    }  
      
    public static void main(String[] args) {  
        CoffeeShop coffeeShop = new CoffeeShop();  
        Customer customer = new Customer("John Doe");  
          
        // 模拟顾客购买咖啡  
        coffeeShop.makePurchase(customer, 20.0); // 假设顾客购买了价值20元的咖啡  
          
        // 打印顾客当前的积分情况  
        System.out.println("Current points for customer " + customer.getName() + ": " + customer.getPoints());  
    }  
}