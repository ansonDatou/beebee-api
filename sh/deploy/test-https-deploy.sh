#! /bin/bash

case $1 in
archives)
scp ../archives/beebee-archives-thrift-consumer.jar test@172.17.2.172:/opt/apps
scp ../archives/beebee-archives-thrift-provider-client.jar test@172.17.2.173:/opt/apps
scp ../archives/beebee-archives-thrift-provider-server.jar test@172.17.2.174:/opt/apps
echo "archives done"
;;

common)
scp ../common/beebee-common-service-thrift-consumer.jar test@172.17.2.172:/opt/apps
scp ../common/beebee-common-service-thrift-provider-client.jar test@172.17.2.173:/opt/apps
scp ../common/beebee-common-service-thrift-provider-server.jar test@172.17.2.174:/opt/apps
echo "common done"
;;

topic)
scp ../topic/beebee-topic-thrift-consumer.jar test@172.17.2.172:/opt/apps
scp ../topic/beebee-topic-thrift-provider-client.jar test@172.17.2.173:/opt/apps
scp ../topic/beebee-topic-thrift-provider-server.jar test@172.17.2.174:/opt/apps
echo "topic done"
;;

user)
scp ../user/beebee-user-thrift-consumer.jar test@172.17.2.172:/opt/apps
scp ../user/beebee-user-thrift-provider-client.jar test@172.17.2.173:/opt/apps
scp ../user/beebee-user-thrift-provider-server.jar test@172.17.2.174:/opt/apps
echo "user done"
;;

third)
scp ../third/beebee-third-service-thrift-consumer.jar test@172.17.2.172:/opt/apps
scp ../third/beebee-third-service-thrift-provider-client.jar test@172.17.2.173:/opt/apps
scp ../third/beebee-third-service-thrift-provider-server.jar test@172.17.2.174:/opt/apps
echo "third done"
;;

eureka)
scp ../eureka/beebee-eureka.jar test@172.17.2.172:/opt/apps
scp ../eureka/beebee-eureka.jar test@172.17.2.173:/opt/apps
scp ../eureka/beebee-eureka.jar test@172.17.2.174:/opt/apps
echo "eureka done"
;;

all)
scp ../archives/beebee-archives-thrift-consumer.jar test@172.17.2.172:/opt/apps
scp ../archives/beebee-archives-thrift-provider-client.jar test@172.17.2.173:/opt/apps
scp ../archives/beebee-archives-thrift-provider-server.jar test@172.17.2.174:/opt/apps
scp ../common/beebee-common-service-thrift-consumer.jar test@172.17.2.172:/opt/apps
scp ../common/beebee-common-service-thrift-provider-client.jar test@172.17.2.173:/opt/apps
scp ../common/beebee-common-service-thrift-provider-server.jar test@172.17.2.174:/opt/apps
scp ../topic/beebee-topic-thrift-consumer.jar test@172.17.2.172:/opt/apps
scp ../topic/beebee-topic-thrift-provider-client.jar test@172.17.2.173:/opt/apps
scp ../topic/beebee-topic-thrift-provider-server.jar test@172.17.2.174:/opt/apps
scp ../user/beebee-user-thrift-consumer.jar test@172.17.2.172:/opt/apps
scp ../user/beebee-user-thrift-provider-client.jar test@172.17.2.173:/opt/apps
scp ../user/beebee-user-thrift-provider-server.jar test@172.17.2.174:/opt/apps
scp ../third/beebee-third-service-thrift-consumer.jar test@172.17.2.172:/opt/apps
scp ../third/beebee-third-service-thrift-provider-client.jar test@172.17.2.173:/opt/apps
scp ../third/beebee-third-service-thrift-provider-server.jar test@172.17.2.174:/opt/apps
scp ../eureka/beebee-eureka.jar test@172.17.2.172:/opt/apps
scp ../eureka/beebee-eureka.jar test@172.17.2.173:/opt/apps
scp ../eureka/beebee-eureka.jar test@172.17.2.174:/opt/apps
echo "all done"

esac
