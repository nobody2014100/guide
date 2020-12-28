# docker ready for resources

## mysql
```

docker run -p 8888:3306 --name guide-mysql -e MYSQL_ROOT_PASSWORD=Z..li1zh@u1! -d mysql:5.7

docker run --name guide-mysql -t \
       -e MYSQL_DATABASE="guide" \
       -e MYSQL_USER="guide" \
       -e MYSQL_PASSWORD="Z..li1zh@u1!" \
       -e MYSQL_ROOT_PASSWORD="admin123" \
       -e TZ=Asia/Shanghai \
       -p 8888:3306 \
       -d mysql:5.7 \
         --character-set-server=utf8 \
         --collation-server=utf8_general_ci \
         --sql-mode="NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION"

```

## redis
```

docker run -p 6379:6379 --name redis 
-v /data/redis/redis.conf:/etc/redis/redis.conf  
-v /data/redis/data:/data -d redis redis-server /etc/redis/redis.conf --appendonly yes

```