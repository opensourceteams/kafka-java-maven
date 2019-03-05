

### 启动Kafka server

```aidl
kafka-server-start.sh config/server.properties
```

### 创建主题

```aidl
kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test

```

### 查看主题
```aidl
kafka-topics.sh --list --zookeeper localhost:2181
```

###  控制台生产消息

```aidl
kafka-console-producer.sh --broker-list localhost:9092 --topic test

```


###  控制台消费消息

```aidl
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning

```

### 查看zk配置
```aidl
查看配置  get  /brokers/ids/0 
```


### java maven 客户端，生产数据，消息数据
- https://github.com/opensourceteams/kafka-java-maven/blob/master/md/producter-consumer-example.md