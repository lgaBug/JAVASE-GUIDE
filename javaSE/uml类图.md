# UML类图详解

虚线箭头指向依赖；

实线箭头指向关联；

虚线三角指向接口；

实线三角指向父类；

空心菱形能分离而独立存在，是聚合；

实心菱形精密关联不可分，是组合；

 ![img](https://upload-images.jianshu.io/upload_images/2799767-3f16972d7b062110.png?imageMogr2/auto-orient/strip) 

![img](https://images2015.cnblogs.com/blog/1010726/201706/1010726-20170621004756882-1379253225.gif)

上述类图中，实线边框的是实现类，比如ArrayList，LinkedList，HashMap等，折线边框的是抽象类，比如AbstractCollection，AbstractList，AbstractMap等，而点线边框的是接口，比如Collection，Iterator，List等。