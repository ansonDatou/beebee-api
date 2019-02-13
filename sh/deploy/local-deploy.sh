#! /bin/bash

case $1 in
archives)
scp ../../beebee-archives-thrift-consumer/target/beebee-archives-thrift-consumer.jar root@39.107.86.140:/opt/apps/archives
scp ../../beebee-archives-thrift-provider-client/target/beebee-archives-thrift-provider-client.jar root@39.107.86.140:/opt/apps/archives
scp ../../beebee-archives-thrift-provider-server/target/beebee-archives-thrift-provider-server.jar root@39.107.86.140:/opt/apps/archives
echo "archives done"
;;

common)
scp ../../beebee-common-service-thrift-consumer/target/beebee-common-service-thrift-consumer.jar root@39.107.86.140:/opt/apps/common
scp ../../beebee-common-service-thrift-provider-client/target/beebee-common-service-thrift-provider-client.jar root@39.107.86.140:/opt/apps/common
scp ../../beebee-common-service-thrift-provider-server/target/beebee-common-service-thrift-provider-server.jar root@39.107.86.140:/opt/apps/common
echo "common done"
;;

topic)
scp ../../beebee-topic-thrift-consumer/target/beebee-topic-thrift-consumer.jar root@39.107.86.140:/opt/apps/topic
scp ../../beebee-topic-thrift-provider-client/target/beebee-topic-thrift-provider-client.jar root@39.107.86.140:/opt/apps/topic
scp ../../beebee-topic-thrift-provider-server/target/beebee-topic-thrift-provider-server.jar root@39.107.86.140:/opt/apps/topic
echo "topic done"
;;

user)
scp ../../beebee-user-thrift-consumer/target/beebee-user-thrift-consumer.jar root@39.107.86.140:/opt/apps/user
scp ../../beebee-user-thrift-provider-client/target/beebee-user-thrift-provider-client.jar root@39.107.86.140:/opt/apps/user
scp ../../beebee-user-thrift-provider-server/target/beebee-user-thrift-provider-server.jar root@39.107.86.140:/opt/apps/user
echo "user done"
;;

third)
scp ../../beebee-third-service-thrift-consumer/target/beebee-third-service-thrift-consumer.jar root@39.107.86.140:/opt/apps/third
scp ../../beebee-third-service-thrift-provider-client/target/beebee-third-service-thrift-provider-client.jar root@39.107.86.140:/opt/apps/third
scp ../../beebee-third-service-thrift-provider-server/target/beebee-third-service-thrift-provider-server.jar root@39.107.86.140:/opt/apps/third
echo "third done"
;;

eureka)
scp ../../beebee-eureka/target/beebee-eureka.jar root@39.107.86.140:/opt/apps/eureka
echo "eureka done"
;;

all)
scp ../../beebee-archives-thrift-consumer/target/beebee-archives-thrift-consumer.jar root@39.107.86.140:/opt/apps/archives
scp ../../beebee-archives-thrift-provider-client/target/beebee-archives-thrift-provider-client.jar root@39.107.86.140:/opt/apps/archives
scp ../../beebee-archives-thrift-provider-server/target/beebee-archives-thrift-provider-server.jar root@39.107.86.140:/opt/apps/archives
scp ../../beebee-common-service-thrift-consumer/target/beebee-common-service-thrift-consumer.jar root@39.107.86.140:/opt/apps/common
scp ../../beebee-common-service-thrift-provider-client/target/beebee-common-service-thrift-provider-client.jar root@39.107.86.140:/opt/apps/common
scp ../../beebee-common-service-thrift-provider-server/target/beebee-common-service-thrift-provider-server.jar root@39.107.86.140:/opt/apps/common
scp ../../beebee-topic-thrift-consumer/target/beebee-topic-thrift-consumer.jar root@39.107.86.140:/opt/apps/topic
scp ../../beebee-topic-thrift-provider-client/target/beebee-topic-thrift-provider-client.jar root@39.107.86.140:/opt/apps/topic
scp ../../beebee-topic-thrift-provider-server/target/beebee-topic-thrift-provider-server.jar root@39.107.86.140:/opt/apps/topic
scp ../../beebee-user-thrift-consumer/target/beebee-user-thrift-consumer.jar root@39.107.86.140:/opt/apps/user
scp ../../beebee-user-thrift-provider-client/target/beebee-user-thrift-provider-client.jar root@39.107.86.140:/opt/apps/user
scp ../../beebee-user-thrift-provider-server/target/beebee-user-thrift-provider-server.jar root@39.107.86.140:/opt/apps/user
scp ../../beebee-third-service-thrift-consumer/target/beebee-third-service-thrift-consumer.jar root@39.107.86.140:/opt/apps/third
scp ../../beebee-third-service-thrift-provider-client/target/beebee-third-service-thrift-provider-client.jar root@39.107.86.140:/opt/apps/third
scp ../../beebee-third-service-thrift-provider-server/target/beebee-third-service-thrift-provider-server.jar root@39.107.86.140:/opt/apps/third
scp ../../beebee-eureka/target/beebee-eureka.jar root@39.107.86.140:/opt/apps/eureka
echo "all done"

esac
