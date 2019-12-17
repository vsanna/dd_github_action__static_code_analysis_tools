## start up
- redis-server --port 16379
- mysql.server start

## test usecase

```bash
curl -X POST localhost:8100/v1/sample/messages/ \
    -d '{"senderId": 1, "receiverId": 2, "body": "hogehoge"}' -H 'Content-Type: application/json'
    
curl -X GET localhost:8100/v1/sample/users/2/messages/ | jq
```
 
 
## todo
- [ ] dockerize


## static code analysis
- PMD
    - pmd -d sample/src -R sample/rulesets/basic.xml -f text
    -
- spotbugs
    - 本当にエラーが出そうなものが大正
- CheckStyle
    - integrate with Gradle
    - checkstyle.xml
    - gradleのtaskとしてgenerate report
    - [ ] how to integrate with github action(or other CI)
- CodeGru
- google errorprone
