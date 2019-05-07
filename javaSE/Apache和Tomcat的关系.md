# Apache和Tomcat的关系



1. Apache是Web服务器，用于加载一些静态的资源，html，js,css等，Tomcat是一个Java服务器，只是一个servlet的容器，是Apache的扩展
2. Apache和Tomcat都可以zuowei做为一个独立的服务器来运行，但是Apache不能解释java程序（jsp,servlet）
3. 两者都是一种容器，只不过发布的东西不同，Apache是html容器，功能像IIS一样；Tomcat是jsp/servlet容器，用于发布jsp及java的，类似的有IBM的webshere、EBA的Weblogic，sun的JRun等等
4. Apache和Tomcat都是独立的，通过一台服务器是可以集成的



> 打个比方：Apache是一辆卡车，上面可以装一些东西如html等。但是不能装水，要装水必须要有容器（桶），Tomcat就是一个桶（装像Java这样的水），而这个桶也可以不放在卡车上

## 总结：

**Apache只支持静态网页，但像asp,php,cgi,jsp等动态网页就需要Tomcat来处理**