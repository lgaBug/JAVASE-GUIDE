# Spring面试题

## 1.谈谈IOC的理解，原理和实现

控制反转：理论思想，原来的对象创建是由使用者来控制的，有了spring之后，可以把整个对象的创建交给spring容器来管理，

​	DI：依赖注入，对应的属性的值注入到具体的对象中，@Autowired,populateBean完成属性值的注入

容器:存储对象，使用的Map数据结构，在spring中一般存在三级缓存，singletonObject存放完整的bean对象，

​	整个bean的生命周期，从创建到使用到销毁的全过程都是由容器来管理（bean的生命周期）



1、一般聊ioc容器的时候要涉及到容器的创建过程（BeanFactory,DefaultListableBeanFacotry),向bean工厂中设置一些参数（BeanPostProcessor,Aware接口的子类等等）属性。

2、加载解析bean对象，准备要创建的bean对象的定义为beanDefinition。

3、BeanFactoryPostProcessor的处理，此处是扩展点。PlaceHolderConfigurSupport,ConfigurationClassPostProcessor

4、BeanPostProcessor的注册功能，方便后续对bean对象完成具体的扩展功能

5、通过反射的方式将BeanDefinition对象实例化成具体的bean对象

6、bean对象的初始化过程（填充属性，调用aware子类的方法，调用BeanPostProcessor前置处理方法，调用init-method方法，调用BeanPostProcessor的后置处理方法）

7、生成完整的bean对象，通过getBean方法可以直接获取

8、销毁过程

面试官，这是我对ioc的整体理解，包含了一些详细的处理过程，您看一下有什么问题，可以指点我一下。



## 2.谈一下Spring Ioc的底层原理

![image-20210823211523889](D:\workspace\springDemo\image-20210823211523889.png)

## 3.描述一下bean的声明周期

![image-20210823211906239](D:\workspace\springDemo\image-20210823211906239.png)

## 4.Spring的循环依赖是如何解决的

## 5.BeanFactory 与FactoryBean有什么区别

## 6.Spring中用到的设计模式

## 7.Spring的AOP底层实现原理

## 8.Spring的事物是如何回滚的

## 9.谈一下Spring事物传播特性