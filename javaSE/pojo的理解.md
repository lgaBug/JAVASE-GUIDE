# PO、BO、VO、DTO、POJO、DAO概念的理解	

------

参考：

[PO BO VO DTO POJO DAO概念及其作用（附转换图）](http://www.blogjava.net/vip01/archive/2007/01/08/92430.html)

<https://www.zhihu.com/question/39651928>



## PO

> persistant object 持久化对象
>
> 最形象的 理解就是一个PO就是一个数据库中的一条记录。
>
> 好处是可以数据库的一条记录当做一个对象来处理，可以方便的转为其他对象。

## BO

> business object业务对象
>
> 可以把业务逻辑需要的属性封装成一个对象，一个bo可以包含多个po。
>
> 这样处理业务逻辑时，我们就可以针对bo去处理。

## VO

> value object值对象
>
> viewObject表现层对象
>
> 对于一个web界面，用一个vo去对应整个界面的值。

## DTO

> data transfer object数据传输对象
>
> 主要用于远程调用等需要大量传输对象的地方。
>
> 比如我们有一张表有100个字段，那么对应的PO就有100个属性。
>
> 但是我们界面是只需要10个字段。
>
> 客户端使用WEB service来获取数据，没有必要把整个PO对象传递到客户端，
>
> 这是我们就可以用只有这10个属性的DTO来把结果传递到客户端，这样也不会暴露服务端表的结果，达到客户端以后，如果用这个对象来对应界面显示，那么它的身份就转为VO。



## POJO

> plain ordinary java object简单java对象
>
> 个人感觉POJO是最常见多变的对象，是一个中间对象，也是我们最常打交道的对象。
>
> 一个POJO持久化后就是PO
>
> 直接用它传递、传递过程中就是DTO
>
> 直接用来对应表示层的就是VO

## DAO

> data access object数据访问对象
>
> 主要用来封装对数据库的访问。通过它可以把POJO持久化成PO，用PO组装出来VO、DTO。



## **应用**

不同类型的对象在架构设计中用于不同的用途，如下的分层架构表示了各个 POJO 的用途。为什么要在分层架构中，定义这些 POJO 对象呢？主要是为了确保各个分层能够很好地封装自己的服务，有效地控制信息的传播。

![img](https://pic2.zhimg.com/50/v2-bbac0456af84c9feb17b03cdd9501222_hd.jpg)![img](https://pic4.zhimg.com/80/v2-5f90150d5e99a7dd5ef58e75ef9c9334_hd.jpg)

试想一下，如果没有 VO 和 PO 的区别，那么数据库表结构的所有字段就一览无余地展示到了前端，给后台安全带来很大的隐患，并且无法在网络传输中剥离冗余信息提高了用户的带宽成本。



## **实例**

以一个实例来探讨下 POJO 的使用。假设我们有一个面试系统，数据库中存储了很多面试题，通过 web 和 API 提供服务。可能会做如下的设计：

数据表：表中的面试题包括编号、题目、选项、答案、创建时间、修改时间；

PO：包括题目、选项、答案、创建时间、修改时间；

VO：题目、选项、答案、上一题URL、 下一题URL；

DTO：编号、题目、选项、答案、上一题编号、下一题编号；

DAO：数据库增删改查方法；

BO：业务基本操作。















