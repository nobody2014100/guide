# docker ready for resources

## mysql
```

docker run -p 8888:3306 --name guide-mysql -e MYSQL_ROOT_PASSWORD=Z..li1zh@u1! -d mysql:5.7

```

## redis
```

docker run -p 6379:6379 --name redis 
-v /data/redis/redis.conf:/etc/redis/redis.conf  
-v /data/redis/data:/data -d redis redis-server /etc/redis/redis.conf --appendonly yes

```