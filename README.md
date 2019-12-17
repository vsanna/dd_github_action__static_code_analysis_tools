## initial setup
```bash
# 1. create database & tables. see init.sql and sample/src/main/resources/db/migration
# 2. no more action is requierd
```

## how to start

```bash
$ redis-server --port 16379
$ mysql.server start
$ cd sample
$ ./gradlew bootRun
```

## test usecase

```bash
curl -X POST localhost:8100/v1/sample/messages/ \
    -d '{"senderId": 1, "receiverId": 2, "body": "hogehoge"}' -H 'Content-Type: application/json'
    
curl -X GET localhost:8100/v1/sample/users/2/messages/ | jq
```
 
 
## todo
- [ ] dockerize


## static code analysis tools
- PMD
- spotbugs
- CheckStyle
- google errorprone
- CodeGuru
- owasp dependency check
