## create user
```
create user 'guide'@'%' identified by 'Z..li1zh@u1!';

```
## handle privileges
```

GRANT privileges ON databasename.tablename TO 'username'@'host'

GRANT ALL ON guide.* TO 'guide'@'%';
GRANT ALL ON learn.* TO 'guide'@'%';
GRANT ALL ON user_center.* TO 'guide'@'%';

```

create database guide default character set utf8mb4 collate utf8mb4_unicode_ci;

create database learn default character set utf8mb4 collate utf8mb4_unicode_ci;

create database user_center default character set utf8mb4 collate utf8mb4_unicode_ci;