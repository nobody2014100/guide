# issue record


## jooq 生存的sql带双引号
```
    @PostConstruct
    private void init() {
        //		去掉sql中的单引号
        dsl.settings().withRenderNameStyle(RenderNameStyle.AS_IS);
    }
```


## OperationImplicitParameterReader : Unable to interpret the implicit parameter configuration with data
```



```

## springboot+jpa+mysql 生成的时间与实际时间不一致，相差14小时
```
在数据库连接url后添加参数 &serverTimezone=Asia/Shanghai 即可

```
## you have not installed the Java Cryptography Extension (JCE)
```hql
https://blog.csdn.net/andyguan01_2/article/details/88343641

1、打开以下网址，下载JCE压缩包：
http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html
2、将压缩包解压，local_policy.jar和US_export_policy.jar这两个jar包放到$JAVA_HOME/jre/lib/security目录。因为目录下已有这两个文件，可以先备份，再覆盖。

mv $JAVA_HOME/jre/lib/security/local_policy.jar $JAVA_HOME/jre/lib/security/local_policy.jar.bak
mv $JAVA_HOME/jre/lib/security/US_export_policy.jar $JAVA_HOME/jre/lib/security/US_export_policy.jar.bak
cp local_policy.jar US_export_policy.jar $JAVA_HOME/jre/lib/security
```

## Data source rejected establishment of connection,  message from server: "Too many connections"
```
show variables like "max_connections"; 
 set GLOBAL max_connections=10000;
 
 在/etc/my.conf 添加如下内容
 [mysqld]
 max_connections=10000
 max_user_connections=5000
 wait_timeout=200

```
## 
```
CREATE USER 'guide'@'%' IDENTIFIED BY 'Z..li1zh@u1!!';

GRANT ALL PRIVILEGES ON *.* TO 'guide'@'%' IDENTIFIED BY 'Z..li1zh@u1!!' WITH GRANT OPTION;
FLUSH   PRIVILEGES;


```





## Access to DialectResolutionInfo cannot be null when 'hibernate.dialect' not set
```


```



## 默认返回xml数据
```
    @GetMapping(value = "/{id}", produces = { "application/json;charset=UTF-8" })
    public ResponseEntity<Map> get(@PathVariable(name = "id") Integer id) {
        Map<String, UserVo> map = new HashMap();
        map.put("data", generateUser(id) );
        return ResponseEntity.ok(map);
    }
    
    在没有设置produces时，返回数据为xml， 即response Content-Type: application/xhtml+xml


```

##  版本依赖问题
```
spring cloud 版本会反过来限制springboot的版本， 容易引发依赖问题， 股一定要根据官方的推荐悬着版本
```




