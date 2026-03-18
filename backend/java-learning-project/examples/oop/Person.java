// 基础类示例：Person类
public class Person {
    // 私有字段
    private String name;
    private int age;
    private String email;
    
    // 构造函数
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public Person(String name, int age, String email) {
        this(name, age);  // 调用另一个构造函数
        this.email = email;
    }
    
    // Getter方法
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getEmail() {
        return email;
    }
    
    // Setter方法（带验证）
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }
    
    public void setAge(int age) {
        if (age > 0 && age < 150) {
            this.age = age;
        }
    }
    
    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        }
    }
    
    // 业务方法
    public void introduce() {
        System.out.println("大家好，我是" + name + "，今年" + age + "岁");
        if (email != null) {
            System.out.println("我的邮箱是：" + email);
        }
    }
    
    public boolean isAdult() {
        return age >= 18;
    }
    
    // toString方法（用于打印对象）
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
    
    // equals方法（用于比较对象）
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && 
               name.equals(person.name) && 
               (email != null ? email.equals(person.email) : person.email == null);
    }
    
    // 测试代码
    public static void main(String[] args) {
        // 创建对象
        Person person1 = new Person("张三", 25);
        Person person2 = new Person("李四", 30, "lisi@example.com");
        
        // 调用方法
        person1.introduce();
        person2.introduce();
        
        // 使用setter
        person1.setEmail("zhangsan@example.com");
        System.out.println("张三的邮箱：" + person1.getEmail());
        
        // 判断是否成年
        System.out.println(person1.getName() + (person1.isAdult() ? "是" : "不是") + "成年人");
        
        // 打印对象
        System.out.println(person1);
    }
}
