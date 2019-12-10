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


## note
- 
