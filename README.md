
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
示例代码 [abstractt/game](https://github.com/HuangZhiAn/Design-Patterns-Quick-Learning-Notes-Java/tree/master/src/main/factory/abstractt/game)

### 单例模式
单例模式比较简单，学习成本低，使用频率却比较高，是性价比很高的设计模式。

> 单例模式有三个要点：  
> 一是某个类只能有一个实例；  
> 二是它必须自行创建这个实例；  
> 三是它必须自行向整个系统提供这个实例  

单例模式分为饿汉式和懒汉式，饿汉式在类加载时创建实例，可以保证实例唯一，但比较浪费系统资源，因为不管该类有没有使用，启动时都会实例化单例类，因此推荐使用懒汉式
懒汉式在无 synchronized 同步约束的单例模式存在并发情况下创建多个实例的问题
有 synchronized 单例类一般使用**双重检查锁定**保证实例唯一，需要在静态成员变量 instance 之前增加修饰符 volatile ( Why? )
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
示例代码 [prototype](https://github.com/HuangZhiAn/Design-Patterns-Quick-Learning-Notes-Java/tree/master/src/main/prototype)
### 建造者模式

> 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。建造者模式是一种对象创建型模式。

建造者模式用于创建**复杂对象**，该模式使用频率不高
抽象化建造者类 (Builder)，方便扩展
建造者实现类 (ConcreteBuilder) 负责产品类不同部件的建造实现，不同的建造者建造出不同的产品（废话！）
指挥者负责建造的过程（顺序、是否调用），可以并入建造者类中  
示例代码 [builder](https://github.com/HuangZhiAn/Design-Patterns-Quick-Learning-Notes-Java/tree/master/src/main/builder)

## 结构型模式
### 适配器模式

> 将一个接口转换成客户希望的另一个接口，使接口不兼容的那些类可以一起工作，其别名为包装器(Wrapper)。适配器模式既可以作为类结构型模式，也可以作为对象结构型模式

适配器模式可以用来**适配两种能达到相同效果的接口**，将其中一个接口的使用方式改成另一种接口，使系统中的接口统一，可用来适配第三方库  
适配器模式可以用对象关联的方式实现，也可以使用继承的方式实现。继承的实现方式较多的局限（哪些局限？如，目标接口不能是类，适配者类不能被 final 修饰，有多个适配者时需要多重继承等），推荐用对象关联的方式。**双向适配器**使得两种接口方式都可以相互使用，需要适配器类实现两种接口，同时将两种接口作为适配者

### 桥接模式

> 将抽象部分与它的实现部分分离，使它们都可以独立地变化。它是一种对象结构型模式，又称为柄体(Handle and Body)模式或接口(Interface)模式。

桥接模式利用依赖倒转的抽象化手段，**将两个不同维度在抽象层中关联**，使其不受实现类的约束，可以随意扩展。桥接模式使用对象的关联关系，代替继承，可以在客户端中灵活配置  
两个以上维度如何桥接？

### 组合模式

> 组合多个对象形成树形结构以表示具有“整体—部分”关系的层次结构。组合模式对单个对象（即叶子对象）和组合对象（即容器对象）的使用具有一致性，组合模式又可以称为“整体—部分”(Part-Whole)模式，它是一种对象结构型模式

组合模式用于处理树形结构，对容器节点和叶子节点进行抽象，在容器节点处理方法中做递归操作，叶子节点则不递归。组合模式分为透明组合模式和安全组合模式，区别在于是否在抽象类中声明或实现成员管理方法，透明组合模式对于客户端更加透明一致，安全组合模式叶子节点没有多余的成员管理方法，更加安全

### 装饰模式

> 动态地给一个对象增加一些额外的职责，就增加对象功能来说，装饰模式比生成子类实现更为灵活。装饰模式是一种对象结构型模式

装饰模式使用对象间的关联关系代替继承关系，更加灵活透明的扩展原有的功能（和桥接模式的区别？抽象装饰类是否有必要？）  
透明装饰模式和半透明装饰模式，半透明装饰模式在客户端中使用具体的装饰类，因此，不能多次装饰，但可以单独的调用新增的方法

### 外观模式

> 为子系统中的一组接口提供一个统一的入口。外观模式定义了一个高层接口，这个接口使得这一子系统更加容易使用

外观模式位于客户端和子系统之间，用于解耦客户端和子系统（微服务和API网管？）。
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTM3NTE3OTQwMywtMTY5MTUzMDUsLTEzNT
k2NDU1MiwyMDcyNTUwMzUyLDE0OTY0NzU0MV19
-->