

# linux常用命令

```sh
firewall-cmd --list-ports; 	#查看端口号时候被开放
firewall-cmd --zone=public --add-port=3306/tcp --permanent; #将3306端口号开放
firewall-cmd --reload;		#开放端口号之后要重启防火墙

（注意：若输入命令后报错了，可能是防火墙服务禁止了，关闭了，这时输入以下命名来启动linux防火墙：（当服务被关闭时）启动防火墙服务：systemctl ummask firewalld启动墙：systemctl start firewalld）


```

```sql
--赋予远程连接的用户权限 root是用户,passowd是密码
grant all privileges  on *.* to root@'%' identified by "password"; 
-- 刷新权限
flush privileges;

```

```shell
source /etc/profile  #修改完了profile文件需要刷新一下
```

