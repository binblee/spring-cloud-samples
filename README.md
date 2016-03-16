# Microservices samples using Spring Cloud


### Configuration Server

Centralized Configuraion Server. Code in [config-server](config-server). Using
git repository for configuration in github repo [https://github.com/binblee/spring-cloud-samples-config](https://github.com/binblee/spring-cloud-samples-config)

You can update content in foo.properties, commit it. Run curl to see the message configured for foo service.

```
curl http://localhost:8888/foo/message
```

### Eureka Discovery Server

Spring Eureka server. Code in [discovery-server](discovery-server). Visit
[localhost:8761](http://localhost:8761/) to see which services are registered
in.

### Foo Service
Foo service, code in [foo service](services/foo). It has below features:

Run this command to get result.

```
curl http://<host>:<port>/message
```
It has below features:

- config client enabled, get config from config-server.
- discovery client enabled, register itself to discovery-server automatically.
- actuator enabled, post to /refresh endpoint will refresh config data, get
valued from config server.

### Bar Service
Bar service, code in [bar service](services/bar). No REST API implemented yet.

It has below features:

- discovery client enabled, register itself to discovery-server automatically.
