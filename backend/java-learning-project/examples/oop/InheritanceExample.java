// 继承示例：动物类层次结构

// 基类：Animal
abstract class Animal {
    protected String name;
    protected int age;
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // 抽象方法 - 子类必须实现
    public abstract void makeSound();
    
    // 具体方法 - 子类可以直接使用
    public void eat() {
        System.out.println(name + "正在吃东西");
    }
    
    public void sleep() {
        System.out.println(name + "正在睡觉");
    }
    
    public void displayInfo() {
        System.out.println("名字：" + name + ", 年龄：" + age);
    }
}

// 子类：Dog
class Dog extends Animal {
    private String breed;  // 品种
    
    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + "：汪汪汪！");
    }
    
    // 子类特有的方法
    public void fetch() {
        System.out.println(name + "正在捡球");
    }
    
    public void wagTail() {
        System.out.println(name + "摇尾巴表示开心");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("品种：" + breed);
    }
}

// 子类：Cat
class Cat extends Animal {
    private boolean isIndoor;
    
    public Cat(String name, int age, boolean isIndoor) {
        super(name, age);
        this.isIndoor = isIndoor;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + "：喵喵喵~");
    }
    
    // 子类特有的方法
    public void scratch() {
        System.out.println(name + "正在磨爪子");
    }
    
    public void purr() {
        System.out.println(name + "发出呼噜声");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("是否室内猫：" + (isIndoor ? "是" : "否"));
    }
}

// 子类：Bird
class Bird extends Animal {
    private double wingspan;  // 翼展（米）
    
    public Bird(String name, int age, double wingspan) {
        super(name, age);
        this.wingspan = wingspan;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + "：叽叽喳喳！");
    }
    
    public void fly() {
        System.out.println(name + "正在飞翔，翼展" + wingspan + "米");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("翼展：" + wingspan + "米");
    }
}

// 测试类
public class InheritanceExample {
    public static void main(String[] args) {
        System.out.println("=== 创建动物 ===");
        Dog dog = new Dog("旺财", 3, "金毛");
        Cat cat = new Cat("咪咪", 2, true);
        Bird bird = new Bird("小黄", 1, 0.3);
        
        System.out.println("\n=== 显示信息 ===");
        dog.displayInfo();
        cat.displayInfo();
        bird.displayInfo();
        
        System.out.println("\n=== 动物叫声 ===");
        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
        
        System.out.println("\n=== 通用行为 ===");
        dog.eat();
        cat.sleep();
        
        System.out.println("\n=== 特有行为 ===");
        dog.fetch();
        dog.wagTail();
        cat.scratch();
        cat.purr();
        bird.fly();
        
        System.out.println("\n=== 多态演示 ===");
        // 父类引用指向子类对象
        Animal[] animals = {dog, cat, bird};
        
        System.out.println("所有动物都来叫一声：");
        for (Animal animal : animals) {
            animal.makeSound();  // 运行时多态
        }
        
        System.out.println("\n所有动物都来吃东西：");
        for (Animal animal : animals) {
            animal.eat();
        }
        
        System.out.println("\n=== 类型检查和转换 ===");
        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                Dog d = (Dog) animal;
                d.fetch();
            } else if (animal instanceof Cat) {
                Cat c = (Cat) animal;
                c.purr();
            } else if (animal instanceof Bird) {
                Bird b = (Bird) animal;
                b.fly();
            }
        }
    }
}
