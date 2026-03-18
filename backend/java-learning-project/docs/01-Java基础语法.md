# Java语法基础

## 前言：给前端开发者的Java入门

作为一名有经验的前端开发者，你已经掌握了JavaScript/TypeScript。Java和JavaScript虽然名字相似，但是完全不同的语言。让我们通过对比来快速学习Java。

## 关键差异速览

| 特性 | JavaScript | Java |
|------|-----------|------|
| 类型系统 | 动态类型 | 静态强类型 |
| 运行环境 | 浏览器/Node.js | JVM (Java虚拟机) |
| 编译 | 解释执行 | 先编译成字节码 |
| 类 | ES6+支持类 | 一切皆对象，必须用类 |
| 包管理 | npm/yarn | Maven/Gradle |
| 文件组织 | 自由 | 一个文件一个公共类 |

## 1. Hello World

### JavaScript
```javascript
console.log("Hello, World!");
```

### Java
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

**Java特点**:
- 必须定义类 (`public class HelloWorld`)
- 文件名必须与类名一致 (`HelloWorld.java`)
- 必须有`main`方法作为程序入口
- `public static void main(String[] args)` 是固定写法

## 2. 变量声明

### JavaScript
```javascript
// 动态类型
let name = "张三";
let age = 25;
const PI = 3.14;

// TypeScript
let name: string = "张三";
let age: number = 25;
```

### Java
```java
// 静态类型，必须声明类型
String name = "张三";
int age = 25;
final double PI = 3.14;  // final类似const
```

## 3. 数据类型

### 基本类型 (Primitive Types)

Java有8种基本类型，JavaScript只有7种原始类型。

```java
// 整数类型
byte b = 127;           // 8位，-128 到 127
short s = 32767;        // 16位
int i = 2147483647;     // 32位，最常用
long l = 9223372036854775807L;  // 64位，后缀L

// 浮点类型
float f = 3.14f;        // 32位，后缀f
double d = 3.14159;     // 64位，默认

// 字符和布尔
char c = 'A';           // 单引号，16位Unicode
boolean flag = true;    // true或false
```

**对比JavaScript**:
```javascript
// JavaScript只有number和bigint
let num = 42;           // number（64位浮点）
let big = 42n;          // bigint
let char = 'A';         // string，没有单字符类型
let flag = true;        // boolean
```

### 引用类型 (Reference Types)

```java
// 字符串（Java中String是类，不是基本类型）
String text = "Hello";
String multi = "多行" + "\n"
    + "字符串" + "\n"
    + "拼接";  // Java 8使用+拼接多行字符串

// 数组
int[] numbers = {1, 2, 3, 4, 5};
String[] names = new String[3];  // 固定长度

// 对象
Object obj = new Object();
```

## 4. 运算符

大部分运算符与JavaScript相同：

```java
// 算术运算符
int a = 10 + 5;   // 15
int b = 10 - 5;   // 5
int c = 10 * 5;   // 50
int d = 10 / 5;   // 2
int e = 10 % 3;   // 1 (取模)

// 比较运算符
boolean eq = (5 == 5);   // true
boolean ne = (5 != 3);   // true
boolean gt = (5 > 3);    // true

// 逻辑运算符
boolean and = true && false;  // false
boolean or = true || false;   // true
boolean not = !true;          // false

// 三元运算符
int max = (a > b) ? a : b;

// 字符串拼接
String full = "Hello" + " " + "World";
```

**注意**: Java中`==`比较的是引用地址，比较字符串内容要用`.equals()`：
```java
String s1 = new String("hello");
String s2 = new String("hello");
System.out.println(s1 == s2);        // false（不同对象）
System.out.println(s1.equals(s2));   // true（内容相同）
```

## 5. 控制流

### if-else

```java
int score = 85;

if (score >= 90) {
    System.out.println("优秀");
} else if (score >= 60) {
    System.out.println("及格");
} else {
    System.out.println("不及格");
}
```

### switch 语句

```java
// 传统switch
int day = 3;
switch (day) {
    case 1:
        System.out.println("星期一");
        break;
    case 2:
        System.out.println("星期二");
        break;
    default:
        System.out.println("其他");
}
```

### 循环

```java
// for循环
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}

// 增强for循环 (for-each)
int[] numbers = {1, 2, 3, 4, 5};
for (int num : numbers) {
    System.out.println(num);
}

// while循环
int i = 0;
while (i < 5) {
    System.out.println(i);
    i++;
}

// do-while循环
int j = 0;
do {
    System.out.println(j);
    j++;
} while (j < 5);
```

## 6. 方法 (函数)

### JavaScript
```javascript
function add(a, b) {
    return a + b;
}

// 箭头函数
const multiply = (a, b) => a * b;
```

### Java
```java
// 必须指定返回类型
public static int add(int a, int b) {
    return a + b;
}

// void表示无返回值
public static void printMessage(String msg) {
    System.out.println(msg);
}

// 方法重载 (Overloading)
public static int add(int a, int b) {
    return a + b;
}

public static double add(double a, double b) {
    return a + b;
}

public static int add(int a, int b, int c) {
    return a + b + c;
}
```

## 7. 数组

```java
// 声明和初始化
int[] numbers = {1, 2, 3, 4, 5};
String[] names = new String[3];  // [null, null, null]

// 访问元素
int first = numbers[0];  // 1

// 数组长度
int length = numbers.length;  // 注意：没有括号

// 遍历
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}

// for-each
for (int num : numbers) {
    System.out.println(num);
}

// 多维数组
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```

## 8. 字符串操作

```java
String str = "Hello, World!";

// 常用方法
int len = str.length();                    // 13
char ch = str.charAt(0);                   // 'H'
String sub = str.substring(0, 5);          // "Hello"
String upper = str.toUpperCase();          // "HELLO, WORLD!"
String lower = str.toLowerCase();          // "hello, world!"
boolean contains = str.contains("World");  // true
String replaced = str.replace("World", "Java");  // "Hello, Java!"
String[] parts = str.split(", ");          // ["Hello", "World!"]
String trimmed = "  hello  ".trim();       // "hello"

// 字符串比较
str.equals("Hello, World!");     // true
str.equalsIgnoreCase("hello");   // true
str.startsWith("Hello");         // true
str.endsWith("!");               // true

// 字符串拼接
String name = "张三";
int age = 25;

// 方式1: + 运算符
String msg1 = "我是" + name + "，今年" + age + "岁";

// 方式2: String.format
String msg2 = String.format("我是%s，今年%d岁", name, age);
```

## 9. 输入输出

```java
import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        // 输出
        System.out.println("Hello");     // 带换行
        System.out.print("No newline");  // 不换行
        System.out.printf("格式化: %d %s\n", 42, "text");
        
        // 输入
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入姓名: ");
        String name = scanner.nextLine();
        
        System.out.print("请输入年龄: ");
        int age = scanner.nextInt();
        
        System.out.println("你好，" + name + "，你" + age + "岁");
        
        scanner.close();
    }
}
```

## 10. 注释

```java
// 单行注释

/*
 * 多行注释
 * 可以写多行
 */

/**
 * JavaDoc注释（用于生成文档）
 * @param name 参数说明
 * @return 返回值说明
 * @author 作者
 */
public String greet(String name) {
    return "Hello, " + name;
}
```

## 练习题

### 练习1: 变量和运算符
```java
public class Exercise1 {
    public static void main(String[] args) {
        // TODO: 声明两个整数变量a和b，计算它们的和、差、积、商
        
        // TODO: 声明一个字符串变量name，输出"Hello, {name}!"
        
        // TODO: 使用三元运算符判断一个数是奇数还是偶数
    }
}
```

### 练习2: 控制流
```java
public class Exercise2 {
    public static void main(String[] args) {
        // TODO: 使用for循环打印1-100之间的所有偶数
        
        // TODO: 使用while循环计算1+2+3+...+100的和
        
        // TODO: 使用switch判断今天是星期几（1-7）
    }
}
```

### 练习3: 数组
```java
public class Exercise3 {
    public static void main(String[] args) {
        int[] numbers = {3, 7, 2, 9, 1, 5, 8};
        
        // TODO: 计算数组的平均值
        
        // TODO: 找出数组中的最大值和最小值
        
        // TODO: 反转数组
    }
}
```

### 练习4: 方法
```java
public class Exercise4 {
    // TODO: 编写一个方法，判断一个数是否为质数
    public static boolean isPrime(int n) {
        // 你的代码
    }
    
    // TODO: 编写一个方法，计算阶乘 (n!)
    public static long factorial(int n) {
        // 你的代码
    }
    
    // TODO: 编写一个方法，反转字符串
    public static String reverse(String str) {
        // 你的代码
    }
    
    public static void main(String[] args) {
        // 测试你的方法
    }
}
```

## 参考答案

<details>
<summary>点击查看练习1答案</summary>

```java
public class Exercise1 {
    public static void main(String[] args) {
        // 练习1.1
        int a = 10, b = 3;
        System.out.println("和: " + (a + b));
        System.out.println("差: " + (a - b));
        System.out.println("积: " + (a * b));
        System.out.println("商: " + (a / b));
        
        // 练习1.2
        String name = "张三";
        System.out.println("Hello, " + name + "!");
        
        // 练习1.3
        int num = 17;
        String result = (num % 2 == 0) ? "偶数" : "奇数";
        System.out.println(num + "是" + result);
    }
}
```
</details>

<details>
<summary>点击查看练习2答案</summary>

```java
public class Exercise2 {
    public static void main(String[] args) {
        // 练习2.1
        for (int i = 2; i <= 100; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // 练习2.2
        int sum = 0;
        int i = 1;
        while (i <= 100) {
            sum += i;
            i++;
        }
        System.out.println("和: " + sum);
        
        // 练习2.3
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 7:
                System.out.println("星期日");
                break;
            default:
                System.out.println("无效");
        }
    }
}
```
</details>

## 下一步

恭喜！你已经掌握了Java基础语法。接下来学习：

1. 📦 面向对象编程 (`02-面向对象编程.md`)
2. 🔢 集合框架 (`03-集合框架.md`)
3. 🌊 Stream API和Lambda表达式 (`04-Stream和Lambda.md`)

## 小贴士

- **多写代码**: 每个概念都要亲自敲一遍代码
- **对比学习**: 把Java代码和JavaScript对比着看
- **使用IDE**: IntelliJ IDEA的代码补全和错误提示非常有帮助
- **查文档**: 习惯查阅Java官方API文档
- **不要怕错误**: 编译错误是你的朋友，它们会告诉你哪里错了

记住：Java虽然看起来啰嗦，但它的类型安全和工具链支持会让大型项目更容易维护！
