# Docker的常用命令

## 常用命令

```sh

#显示docker 版本信息
docker info

#帮助命令
docker --help

#启动docker
systemctl start docker

#重启docker
systemctl restart docker

#查看docker的状态
systemctl status docker

#查看docker的版本
docker -version

#搜索镜像
docker search image

#查看docker所有的镜像
docker image ls

#获取一个镜像
docker pull (image)

#运行一个镜像
docker run (image)

#运行并进入一个镜像 
docker run (--name=别名) -i -t (image) /bin/bash
ctrl + p + q 		#退出交互式命令，进入后台运行
docker attach (image) #再次进入正在运行的容器

#查询运行的镜像
docker ps [-a] [-l]

#查询容器的详细信息（json格式）
docker inspect (imageName/Id)

#重新启动已经停止的容器
docker start [-i] (image)

#删除停止的容器
docker rm （image)

#删除全部容器
docker rmi -f $(docker images -aq)

```

## 守护式容器

- 能够长期运行
- 没有交互式会话
- 适合运行应用程序和服务

```shell
#运行守护容器
docker run -d (image) 

#查看容器日志
docker logs [-f][-t][-tail] (image)
-f --follows=true|false 默认false
-t --timestamps=true|false 默认false
--tail= "all"

#在运行的容器内启动新的进程
docker exec [-d][-i][-t] (image)
docker exec web(容器名称) nginx(容器内容的应用)

#停止守护式容器
docker stop (image)
docker kill (image) #快速结束

#设置容器的端口映射
docker run -p 本机端口号:容器的端口号 -i -t ubuntu /bin/bash

#查看容器端口的映射情况
 ps -ef
 docker port (imgae)
 
 #查看容器中进行使用的情况
 docker top (image)
 

```

