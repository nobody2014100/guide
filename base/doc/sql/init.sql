## create user
```
create user 'guide'@'%' identified by 'Z..li1zh@u1!';

```
## handle privileges
```
## 授权模板
GRANT privileges ON databasename.tablename TO 'username'@'host'

1. 授权db给guide用户
GRANT ALL ON guide.* TO 'guide'@'%';
GRANT ALL ON learn.* TO 'guide'@'%';
GRANT ALL ON user_center.* TO 'guide'@'%';

```

## 创建db
```
create database guide default character set utf8mb4 collate utf8mb4_unicode_ci;

create database learn default character set utf8mb4 collate utf8mb4_unicode_ci;

create database user_center default character set utf8mb4 collate utf8mb4_unicode_ci;

```