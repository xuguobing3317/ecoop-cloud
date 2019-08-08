ecoop-commons: 基础包

ecoop-config: 暂时没有用

ecoop-eureka: 注册中心

ecoop-query-service: 查询服务

ecoop-gateway: 网关，负载均衡&路由




启动之前修改本地host下：
127.0.0.1 e1
127.0.0.1 e2
127.0.0.1 e3

修改数据链接


先启动eureka


全部启动完成之后：

http://127.0.0.1:8888/queryApi/query  不能访问
http://127.0.0.1:8888/queryApi/query?token=1  带token可以访问

http://127.0.0.1:8888/queryApi/auth?token=1  //带token， 但无接口权限

websocket 做了zuul的穿透
websocket.html是websocket的测试页面
http://127.0.0.1:8888/queryApi/msg?token=1 //通过该连接，可给前端发送消息

在service中有单个接口的权限控制

nexus的私服
settings.xml 是maven的配置文件
私服地址为：http://114.216.202.69:8081


https://worktable.coop-e.com/eureka  是我们这边测试环境注册中心 用户名/密码：ecoop/ecoop
https://worktable.coop-e.com/queryApi nginx反向代理到相关服务， 此处是queryApi


