# issue record













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




