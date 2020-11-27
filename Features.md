# features
```
本项目使用到的特色

```
## gateway
### 代理
### 负载均衡
### 限流

## eureka

## open-feign

## lombak

## logback

### profiles

## profiles


## mysql
### mariadb 服务
```
yum groupinstall -y mariadb mariadb-server
mysql_secure_installation
show variables like "%character%";
show variables like "%collation%"
设置字符集一般建议是在配置文件中设置，也可以在数据库中设置，在数据库中设置的话当服务重启后就会恢复默认字符集，会出现乱码现象
配置文件一般在/etc/my.cnf
vim /etc/my.cnf
在[mysqld]下添加如下配置
init_connect='SET collation_connection = utf8_unicode_ci'
init_connect='SET NAMES utf8'
character-set-server=utf8
collation-server=utf8_unicode_ci
skip-character-set-client-handshake
在[client]下添加 （有些配置文件没有[client],是因为包含了 “!includedir /etc/my.cnf.d”这句话，说明其他配置在这个目录中）
default-character-set=utf8
然后重启mariadb
```

