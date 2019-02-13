#! /bin/bash

case $1 in
archives)
ssh root@172.16.9.225 cp -r /opt/apps/archives /tmp
ssh root@172.16.9.244 cp -r /opt/apps/archives /tmp
scp -r ../../apps/archives root@172.16.9.225:/opt/apps
scp -r ../../apps/archives root@172.16.9.244:/opt/apps
echo "archives done"
;;

common)
ssh root@172.16.9.226 cp -r /opt/apps/common /tmp
scp -r ../../apps/common root@172.16.9.226:/opt/apps
echo "common done"
;;

topic)
ssh root@172.16.9.227 cp -r /opt/apps/topic /tmp
ssh root@172.16.9.245 cp -r /opt/apps/topic /tmp
scp -r ../../apps/topic root@172.16.9.227:/opt/apps
scp -r ../../apps/topic root@172.16.9.245:/opt/apps
echo "topic done"
;;

user)
ssh root@172.16.9.228 cp -r /opt/apps/user /tmp
scp -r ../../apps/user root@172.16.9.228:/opt/apps
echo "user done"
;;

eureka)
scp -r ../../apps/eureka/beebee-eureka.jar root@172.16.9.232:/opt/apps/
scp -r ../../apps/eureka/beebee-eureka.jar root@172.16.9.233:/opt/apps/
scp -r ../../apps/eureka/beebee-eureka.jar root@172.16.9.234:/opt/apps/
echo "eureka done"
;;

all)
scp -r ../../apps/archives root@172.16.9.225:/opt/apps
scp -r ../../apps/archives root@172.16.9.244:/opt/apps
scp -r ../../apps/common root@172.16.9.226:/opt/apps
scp -r ../../apps/topic root@172.16.9.227:/opt/apps
scp -r ../../apps/topic root@172.16.9.245:/opt/apps
scp -r ../../apps/user root@172.16.9.228:/opt/apps
scp -r ../../apps/eureka/beebee-eureka.jar root@172.16.9.232:/opt/apps/
scp -r ../../apps/eureka/beebee-eureka.jar root@172.16.9.233:/opt/apps/
scp -r ../../apps/eureka/beebee-eureka.jar root@172.16.9.234:/opt/apps/
;;

esac
