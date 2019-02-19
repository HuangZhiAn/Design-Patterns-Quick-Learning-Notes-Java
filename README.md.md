
# Design-Patterns-Quick-Learning-Notes-Java
设计模式快速学习笔记  
之前看《Java设计模式》这本书，写了一些设计模式学习笔记，现在重新排版整理，增加书中的练习题代码，作为设计模式的**快速学习**或**快速复习**资料  
[设计原则学习复习笔记](https://github.com/HuangZhiAn/Design-Patterns-Quick-Learning-Notes-Java/blob/master/Object-Oriented-Design-Principles.md)  
特别感谢书本作者[刘伟](http://blog.csdn.net/lovelion),编辑 [quanke](http://quanke.name)

## 创建型模式
### 简单工厂模式

> 定义一个工厂类，它可以根据参数的不同返回不同类的 实例，被创建的实例通常都具有共同的父类。因为在简单工厂模式中用于创建实例的方法是静态
> (static) 方法，因此简单工厂模式又被称为静态工厂方法 (Static Factory Method) 模式，它属于类创建型模式

为了满足单一职责原则，**将对象的创建和使用分离**，使用工厂类创建对象，可根据传入的参数不同，创建不同的对象。满足依赖倒转原则，客户端并不需要关心具体的实现类
**违反了开闭原则**，增加新的实现类需要修改工厂类中的代码
适用于实现类较少且不怎么会增加的情况 
示例代码 [graph](https://github.com/HuangZhiAn/Design-Pattern-with-Java-Learn/tree/master/src/main/factory/simple/graph)

### 工厂方法模式

> 定义一个用于创建对象的接口，让子类决定将哪一个类实例化。工厂方法模式让一个类的实例化延迟到其子类。工厂方法模式又简称为工厂模式
> (Factory Pattern)，又可称作虚拟构造器模式(Virtual Constructor Pattern)或多态工厂模式
> (Polymorphic Factory Pattern)。工厂方法模式是一种类创建型模式。

工厂方法模式在原来简单工厂模式的基础上，为了**解决增加实现类需要修改工厂类的问题**，将工厂类抽象化，新增实现类时只需新增工厂实现类即可，不需要修改原来的代码，**获得更好的扩展性，满足开闭原则**
每个产品实现类都需要对应的工厂类，这将**增加编码复杂度** 
示例代码 [image/reader](https://github.com/HuangZhiAn/Design-Pattern-with-Java-Learn/tree/master/src/main/factory/image/reader)

### 抽象工厂模式

> 提供一个创建一系列相关或相互依赖对象的接口，而 无须指定它们具体的类。抽象工厂模式又称为Kit模式，它是一种对象创建型模式。

作为工厂方法模式的延伸，抽象工厂模式简化类工厂方法模式的某些情况，即是某几个产品总是同时发生改变，且这几个产品相对固定，即**产品存在产品族划分**时。抽象工厂模式将同一等级的产品放到同一个工厂创建，按不同的产品族划分不同的工厂
抽象工厂**需要固定的产品族**，如果产品族经常发生改变，则会违反开闭原则，不适用于该模式

### 单例模式
单例模式比较简单，学习成本低，使用频率却比较高，是性价比很高的设计模式。

> 单例模式有三个要点：  
> 一是某个类只能有一个实例；  
> 二是它必须自行创建这个实例；  
> 三是它必须自行向整个系统提供这个实例  

单例模式分为饿汉式和懒汉式，饿汉式在类加载时创建实例，可以保证实例唯一，但比较浪费系统资源，因为不管该类有没有使用，启动时都会实例化单例类，因此推荐使用懒汉式
懒汉式在无 synchronized 同步约束的单例模式存在并发情况下创建多个实例的问题
有 synchronized 单例类一般使用**双重检查锁定**保证实例唯一
```java
class LazySingleton {   
    private volatile static LazySingleton instance = null;   

    private LazySingleton() { }   

    public static LazySingleton getInstance() {   
        //第一重判断  
        if (instance == null) {  
            //锁定代码块  
            synchronized (LazySingleton.class) {  
                //第二重判断  
                if (instance == null) {  
                    instance = new LazySingleton(); //创建单例实例  
                }  
            }  
        }  
        return instance;   
    }  
}
```
此外，可以使用静态内部类的 JVM 特性实现无 synchronized 的懒汉式单例类，将实例放在内部类中
```java
//Initialization on Demand Holder  
class Singleton {  
    private Singleton() {}  

    private static class HolderClass {  
        private final static Singleton instance = new Singleton();  
    }  

    public static Singleton getInstance() {  
        return HolderClass.instance;  
    }  

    public static void main(String args[]) {  
        Singleton s1, s2;   
        s1 = Singleton.getInstance();  
        s2 = Singleton.getInstance();  
        System.out.println(s1==s2);  
    }  
}
```
利用 JVM 的特性，在加载 Singleton 单例类时不会马上实例化静态内部类的静态变量，同时在并发调用 getInstance() 方法时，JVM 保证了只实例化一次（如何保证？）
### 原型模式

> 使用原型实例指定创建对象的种类，并且**通过拷贝这些原型创建新的对象**。原型模式是一种对象创建型模式。
> 一般而言，Java语言中的clone()方法满足：
> 
> > (1) 对任何对象x，都有x.clone() != x，即克隆对象与原型对象不是同一个对象；
>> 
> > (2) 对任何对象x，都有x.clone().getClass() == x.getClass()，即克隆对象与原型对象的类型一样；
> > 
> > (3) 如果对象x的equals()方法定义恰当，那么x.clone().equals(x)应该成立。
> 
> 为了获取对象的一份拷贝，我们可以直接利用Object类的clone()方法，具体步骤如下：
> 
> > (1) 在派生类中覆盖基类的clone()方法，并声明为public；
> > 
> > (2) 在派生类的clone()方法中，调用super.clone()；
> > 
> > (3) 派生类需实现Cloneable接口。

原型模式在原型类本身中实现 Cloneable 接口，并重写 clone() 方法，通过 clone() 将本身复制并返回
不存在引用类型的成员变量时，使用 Object 的 clone() 方法即可(浅拷贝)
当原型类中存在引用类型成员变量时，需要实现 Serializable 接口，将本身序列化和反序列化(深拷贝)
### 建造者模式

> 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。建造者模式是一种对象创建型模式。

建造者模式用于创建**复杂对象**，该模式使用频率不高
抽象化建造者类 (Builder)，方便扩展
建造者实现类 (ConcreteBuilder) 负责产品类不同部件的建造实现，不同的建造者建造出不同的产品（废话！）
指挥者负责建造的过程（顺序、是否调用），可以并入建造者类中

<!--stackedit_data:
eyJoaXN0b3J5IjpbMTQ5NjQ3NTQxLC02NzMzMjI1NzBdfQ==
-->