
#Mybatis源码学习笔记

## Mybatis执行过程

![img.png](./img/img.png)

## Executor

### SimpleExecutor
>无论SQL是否一样，每次都会进行预编译操作

![img_1.png](./img/img_1.png)

### RecuseExecutor
>当SQL语句一样的时候，只会执行一次预编译处理
> 
![img_2.png](./img/img_2.png)

### BatchExecutor   ·   ·
>当增删改的时候用该执行器，当sql一样时，只会执行一次预编译处理
> 
![img_3.png](./img/img_3.png)

### BaseExecutor
>一级缓存缓存实现的地方，范围是当前线程

![img_5.png](./img/img_5.png)


### CacheExecutor
>二级缓存实现的地方，范围是可以跨线程的，所以要先提交，其他的线程才能使用到二级缓存
> 
>查询的时候先走二级缓存，再走一级缓存的。如果二级缓存有数据，就不走一级缓存了
> 


## 一级缓存
>一级缓存默认是打开的
> 

### 命中场景条件
![img4.png](./img/img_4.png)

### 一级缓存执行流程
![img_7.png](./img/img_7.png)

### 面试可能遇到的问题
- spring 继承mybatis 一级缓存失效
> spring中的myabtis每次执行的时候，都会创建一个新的会话。
> 
> 如何处理：方到同一个事物里
### 使用场景

## 二级缓存

### 缓存结构
![img_8.png](./img/img_8.png)


### 缓存命中条件
![img_9.png](./img/img_9.png)


### 二级缓存执行流程
![img_11.png](./img/img_11.png)


