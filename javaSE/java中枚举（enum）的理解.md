# java中枚举（enum）的理解



参考：

<https://blog.csdn.net/qq_27093465/article/details/52180865>



> JDK1.5引入了新的类型——枚举 , 在 Java 中它虽然算个“小”功能，却给我的开发带来了“大”方便。
>
> 在JDK1.5 之前，我们定义常量都是： public static final.... 。
>
> 但是有了枚举之后，可以把相关的常量放到一个枚举里，而且枚举提供了比常量更多的方法。



## 用法一：常量

```java
/**
*枚举类型颜色
*/
enum Color {
        /**
         * 红色
         */
        RED,

        /**
         * 绿色
         */
        GREEN,

        /**
         * 黑色
         */
        BLACK,

        /**
         * 黄色
         */
        YELLOW,
    }


public static void main(String[] args){

        Color color = Color.BLACK;
        if (color == Color.BLACK) {//true
            System.out.println("color = " + color); //color = BLACK
        }
}


```

## 用法二：switch

> JDK1.6之前的switch语句只支持int,char,enum类型，使用枚举，能让我们的代码可读性更强。 

```java
  
 public static void main(String[] args){

        Color color = Color.BLACK;

        switch (color) {
            case BLACK:
                System.out.println("back...");
                break;
            case RED:
                System.out.println("red...");
                break;
            case YELLOW:
                System.out.println("yellow...");
                break;
             default:
                 System.out.println("No color...");
        }
    }
```


## 用法三：向枚举中添加新的方法

```java
 public static void main(String[] args){

        
        System.out.println(Color.getNameByIndex(1)); //返回：红色
        System.out.println(Arrays.toString(Color.values())); // 返回：[RED, GREEN, BLACK, YELLOW]

    }

    enum Color {
        /**
         * 红色
         */
        RED("红色",1),

        /**
         * 绿色
         */
        GREEN("绿色",2),

        /**
         * 黑色
         */
        BLACK("黑色",3),

        /**
         * 黄色
         */
        YELLOW("黄色",4);

        private String name;
        private Integer index;

        /**
         * 枚举类型Color的构造方法 默认私有的
         * @param name 颜色名称
         * @param index 位置
         */
        Color(String name, Integer index) {
            this.name = name;
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        /**
         * 通过小标位置获取name
         * @param index
         * @return
         */
        public static String getNameByIndex(int index) {
            //Color.values()获取枚举里面所有的类对象，返回的是一个集合
            for (Color color : Color.values()) {
                if (color.getIndex() == index) {
                    return color.getName();
                }
            }
            return null;
        }
    }

```



## 用法四：重写枚举的方法

```java
enum Color {
        /**
         * 红色
         */
        RED("红色",1),

        /**
         * 绿色
         */
        GREEN("绿色",2),

        /**
         * 黑色
         */
        BLACK("黑色",3),

        /**
         * 黄色
         */
        YELLOW("黄色",4);

        private String name;
        private Integer index;

        /**
         * 枚举类型Color的构造方法 默认私有的
         * @param name 颜色名称
         * @param index 位置
         */
        Color(String name, Integer index) {
            this.name = name;
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        /**
         * 通过小标位置获取name
         * @param index
         * @return
         */
        public static String getNameByIndex(int index) {
            //Color.values()获取枚举里面所有的类对象，返回的是一个集合
            for (Color color : Color.values()) {
                if (color.getIndex() == index) {
                    return color.getName();
                }
            }
            return null;
        }

        /**
        *重写默认的方法 ， 默认的是打印name,即enum中的对象名称
        */
        @Override
        public String toString() {
            return "Color{" +
                    "name='" + name + '\'' +
                    ", index=" + index +
                    '}';
        }
    }
```

## 用法五：实现接口

> 所有的枚举都继承自java.lang.Enum类。由于Java 不支持多继承，所以枚举对象不能再继承其他类。 

```java

public interface Behaviour {  
    void print();  
    String getInfo();  
}  
public enum Color implements Behaviour{  
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);  
    // 成员变量  
    private String name;  
    private int index;  
    // 构造方法  
    private Color(String name, int index) {  
        this.name = name;  
        this.index = index;  
    }  
//接口方法  
    @Override  
    public String getInfo() {  
        return this.name;  
    }  
    //接口方法  
    @Override  
    public void print() {  
        System.out.println(this.index+":"+this.name);  
    }  
} 

```



用法六：使用接口组织枚举

```java
public interface Food {  
    enum Coffee implements Food{  
        BLACK_COFFEE,DECAF_COFFEE,LATTE,CAPPUCCINO  
    }  
    enum Dessert implements Food{  
        FRUIT, CAKE, GELATO  
    }  
}
```



## 用法七：关于枚举集合的使用

> java.util.EnumSet和java.util.EnumMap是两个枚举集合。EnumSet保证集合中的元素不重复；EnumMap中的 key是enum类型，而value则可以是任意类型。关于这个两个集合的使用就不在这里赘述，可以参考JDK文档。



![1557049310220](E:\jianshu\javaSE\assets\1557049310220.png)





















