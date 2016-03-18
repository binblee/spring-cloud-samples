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
Bar service, code in [bar service](services/bar). Fake REST API for it:

```
curl http://<host>:<port>/message
```

It has below features:

- discovery client enabled, register itself to discovery-server automatically.

### Foobar Service

Foobar service will get results from foo and bar, generate result by turn two
messages to one. It uses loadBalancerClient to do client side load balancing.

```
curl http://<host>:<port>/message
```

### Foobar-ribbon Service

Similar to foobar service, this is a service that consume other services.
It uses @RibbonClient annoation and configuration class to do Ribbon client
side load balance.

```
curl http://<host>:<port>/message
```
