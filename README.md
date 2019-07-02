ecoop-commons: 基础包

ecoop-config: 暂时没有用

ecoop-eureka: 注册中心

ecoop-query-service: 查询服务

ecoop-zuul: 网关，负载均衡&路由




启动之前修改下：
127.0.0.1 e1
127.0.0.1 e2
127.0.0.1 e3

修改数据链接


先启动eureka


全部启动完成之后：

http://127.0.0.1:8001/query-service/query  不能访问
http://127.0.0.1:8001/query-service/query?token=1  带token可以访问

http://127.0.0.1:8001/query-service/auth?token=1  //带token， 但无接口权限

websocket 做了zuul的穿透
websocket.html是websocket的测试页面
http://127.0.0.1:8001/query-service/msg?token=1 //通过该连接，可给前端发送消息

在service中有单个接口的权限控制
