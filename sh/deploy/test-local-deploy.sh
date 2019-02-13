#! /bin/bash

case $1 in
archives)
scp ../../beebee-archives-thrift-consumer/target/beebee-archives-thrift-consumer.jar test@47.95.241.203:/home/test/apps/archives
scp ../../beebee-archives-thrift-provider-client/target/beebee-archives-thrift-provider-client.jar test@47.95.241.203:/home/test/apps/archives
scp ../../beebee-archives-thrift-provider-server/target/beebee-archives-thrift-provider-server.jar test@47.95.241.203:/home/test/apps/archives
echo "archives done"
;;

common)
scp ../../beebee-common-service-thrift-consumer/target/beebee-common-service-thrift-consumer.jar test@47.95.241.203:/home/test/apps/common
scp ../../beebee-common-service-thrift-provider-client/target/beebee-common-service-thrift-provider-client.jar test@47.95.241.203:/home/test/apps/common
scp ../../beebee-common-service-thrift-provider-server/target/beebee-common-service-thrift-provider-server.jar test@47.95.241.203:/home/test/apps/common
echo "common done"
;;

topic)
scp ../../beebee-topic-thrift-consumer/target/beebee-topic-thrift-consumer.jar test@47.95.241.203:/home/test/apps/topic
scp ../../beebee-topic-thrift-provider-client/target/beebee-topic-thrift-provider-client.jar test@47.95.241.203:/home/test/apps/topic
scp ../../beebee-topic-thrift-provider-server/target/beebee-topic-thrift-provider-server.jar test@47.95.241.203:/home/test/apps/topic
echo "topic done"
;;

user)
scp ../../beebee-user-thrift-consumer/target/beebee-user-thrift-consumer.jar test@47.95.241.203:/home/test/apps/user
scp ../../beebee-user-thrift-provider-client/target/beebee-user-thrift-provider-client.jar test@47.95.241.203:/home/test/apps/user
scp ../../beebee-user-thrift-provider-server/target/beebee-user-thrift-provider-server.jar test@47.95.241.203:/home/test/apps/user
echo "user done"
;;

third)
scp ../../beebee-third-service-thrift-consumer/target/beebee-third-service-thrift-consumer.jar test@47.95.241.203:/home/test/apps/third
scp ../../beebee-third-service-thrift-provider-client/target/beebee-third-service-thrift-provider-client.jar test@47.95.241.203:/home/test/apps/third
scp ../../beebee-third-service-thrift-provider-server/target/beebee-third-service-thrift-provider-server.jar test@47.95.241.203:/home/test/apps/third
echo "third done"
;;

eureka)
scp ../../beebee-eureka/target/beebee-eureka.jar test@47.95.241.203:/home/test/apps/eureka
echo "eureka done"
;;

all)
scp ../../beebee-archives-thrift-consumer/target/beebee-archives-thrift-consumer.jar test@47.95.241.203:/home/test/apps/archives
scp ../../beebee-archives-thrift-provider-client/target/beebee-archives-thrift-provider-client.jar test@47.95.241.203:/home/test/apps/archives
scp ../../beebee-archives-thrift-provider-server/target/beebee-archives-thrift-provider-server.jar test@47.95.241.203:/home/test/apps/archives
scp ../../beebee-common-service-thrift-consumer/target/beebee-common-service-thrift-consumer.jar test@47.95.241.203:/home/test/apps/common
scp ../../beebee-common-service-thrift-provider-client/target/beebee-common-service-thrift-provider-client.jar test@47.95.241.203:/home/test/apps/common
scp ../../beebee-common-service-thrift-provider-server/target/beebee-common-service-thrift-provider-server.jar test@47.95.241.203:/home/test/apps/common
scp ../../beebee-topic-thrift-consumer/target/beebee-topic-thrift-consumer.jar test@47.95.241.203:/home/test/apps/topic
scp ../../beebee-topic-thrift-provider-client/target/beebee-topic-thrift-provider-client.jar test@47.95.241.203:/home/test/apps/topic
scp ../../beebee-topic-thrift-provider-server/target/beebee-topic-thrift-provider-server.jar test@47.95.241.203:/home/test/apps/topic
scp ../../beebee-user-thrift-consumer/target/beebee-user-thrift-consumer.jar test@47.95.241.203:/home/test/apps/user
scp ../../beebee-user-thrift-provider-client/target/beebee-user-thrift-provider-client.jar test@47.95.241.203:/home/test/apps/user
scp ../../beebee-user-thrift-provider-server/target/beebee-user-thrift-provider-server.jar test@47.95.241.203:/home/test/apps/user
scp ../../beebee-third-service-thrift-consumer/target/beebee-third-service-thrift-consumer.jar test@47.95.241.203:/home/test/apps/third
scp ../../beebee-third-service-thrift-provider-client/target/beebee-third-service-thrift-provider-client.jar test@47.95.241.203:/home/test/apps/third
scp ../../beebee-third-service-thrift-provider-server/target/beebee-third-service-thrift-provider-server.jar test@47.95.241.203:/home/test/apps/third
scp ../../beebee-eureka/target/beebee-eureka.jar test@47.95.241.203:/home/test/apps/eureka
echo "all done"

esac
