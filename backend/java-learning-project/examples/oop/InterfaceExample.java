// 接口示例：支付系统

// 支付接口
interface Payment {
    boolean processPayment(double amount);
    String getPaymentMethod();
    boolean refund(double amount);
}

// 信用卡支付
class CreditCardPayment implements Payment {
    private String cardNumber;
    private String holderName;
    private double balance;
    
    public CreditCardPayment(String cardNumber, String holderName, double balance) {
        this.cardNumber = maskCardNumber(cardNumber);
        this.holderName = holderName;
        this.balance = balance;
    }
    
    private String maskCardNumber(String cardNumber) {
        // 只显示最后4位
        int length = cardNumber.length();
        return "**** **** **** " + cardNumber.substring(length - 4);
    }
    
    @Override
    public boolean processPayment(double amount) {
        if (amount <= 0) {
            System.out.println("无效金额");
            return false;
        }
        
        if (balance >= amount) {
            balance -= amount;
            System.out.println("信用卡支付成功：$" + amount);
            System.out.println("剩余额度：$" + balance);
            return true;
        } else {
            System.out.println("信用卡余额不足");
            return false;
        }
    }
    
    @Override
    public String getPaymentMethod() {
        return "信用卡 " + cardNumber;
    }
    
    @Override
    public boolean refund(double amount) {
        balance += amount;
        System.out.println("退款成功：$" + amount);
        return true;
    }
}

// 支付宝支付
class AlipayPayment implements Payment {
    private String account;
    private double balance;
    
    public AlipayPayment(String account, double balance) {
        this.account = account;
        this.balance = balance;
    }
    
    @Override
    public boolean processPayment(double amount) {
        if (amount <= 0) {
            System.out.println("无效金额");
            return false;
        }
        
        if (balance >= amount) {
            balance -= amount;
            System.out.println("支付宝支付成功：¥" + amount);
            System.out.println("剩余余额：¥" + balance);
            return true;
        } else {
            System.out.println("支付宝余额不足");
            return false;
        }
    }
    
    @Override
    public String getPaymentMethod() {
        return "支付宝 " + account;
    }
    
    @Override
    public boolean refund(double amount) {
        balance += amount;
        System.out.println("退款到支付宝成功：¥" + amount);
        return true;
    }
}

// 微信支付
class WeChatPayment implements Payment {
    private String wechatId;
    private double balance;
    
    public WeChatPayment(String wechatId, double balance) {
        this.wechatId = wechatId;
        this.balance = balance;
    }
    
    @Override
    public boolean processPayment(double amount) {
        if (amount <= 0) {
            System.out.println("无效金额");
            return false;
        }
        
        if (balance >= amount) {
            balance -= amount;
            System.out.println("微信支付成功：¥" + amount);
            System.out.println("剩余余额：¥" + balance);
            return true;
        } else {
            System.out.println("微信余额不足");
            return false;
        }
    }
    
    @Override
    public String getPaymentMethod() {
        return "微信支付 " + wechatId;
    }
    
    @Override
    public boolean refund(double amount) {
        balance += amount;
        System.out.println("退款到微信成功：¥" + amount);
        return true;
    }
}

// 订单类
class Order {
    private String orderId;
    private double totalAmount;
    private Payment payment;
    private boolean isPaid;
    
    public Order(String orderId, double totalAmount) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.isPaid = false;
    }
    
    public void setPaymentMethod(Payment payment) {
        this.payment = payment;
        System.out.println("订单 " + orderId + " 选择支付方式：" + payment.getPaymentMethod());
    }
    
    public boolean checkout() {
        if (payment == null) {
            System.out.println("请选择支付方式");
            return false;
        }
        
        if (isPaid) {
            System.out.println("订单已支付");
            return false;
        }
        
        System.out.println("\n处理订单 " + orderId + "，总金额：$" + totalAmount);
        isPaid = payment.processPayment(totalAmount);
        
        if (isPaid) {
            System.out.println("订单支付完成！\n");
        }
        
        return isPaid;
    }
    
    public boolean refundOrder() {
        if (!isPaid) {
            System.out.println("订单未支付，无需退款");
            return false;
        }
        
        System.out.println("\n处理订单 " + orderId + " 退款");
        boolean refunded = payment.refund(totalAmount);
        
        if (refunded) {
            isPaid = false;
            System.out.println("订单退款完成！\n");
        }
        
        return refunded;
    }
}

// 测试类
public class InterfaceExample {
    public static void main(String[] args) {
        System.out.println("=== 电商支付系统演示 ===\n");
        
        // 创建不同的支付方式
        Payment creditCard = new CreditCardPayment("1234567890123456", "张三", 5000);
        Payment alipay = new AlipayPayment("zhangsan@example.com", 3000);
        Payment wechat = new WeChatPayment("zhangsan-wx", 2000);
        
        // 创建订单
        Order order1 = new Order("ORD001", 1500);
        Order order2 = new Order("ORD002", 500);
        Order order3 = new Order("ORD003", 2500);
        
        // 场景1：使用信用卡支付
        System.out.println("=== 场景1：信用卡支付 ===");
        order1.setPaymentMethod(creditCard);
        order1.checkout();
        
        // 场景2：使用支付宝支付
        System.out.println("=== 场景2：支付宝支付 ===");
        order2.setPaymentMethod(alipay);
        order2.checkout();
        
        // 场景3：微信余额不足
        System.out.println("=== 场景3：微信支付（余额不足）===");
        order3.setPaymentMethod(wechat);
        order3.checkout();
        
        // 场景4：订单退款
        System.out.println("=== 场景4：订单退款 ===");
        order1.refundOrder();
        
        // 场景5：使用数组统一处理不同支付方式
        System.out.println("=== 场景5：批量处理支付 ===");
        Payment[] payments = {creditCard, alipay, wechat};
        double[] amounts = {100, 200, 150};
        
        for (int i = 0; i < payments.length; i++) {
            System.out.println("\n使用 " + payments[i].getPaymentMethod() + " 支付 $" + amounts[i]);
            payments[i].processPayment(amounts[i]);
        }
    }
}
