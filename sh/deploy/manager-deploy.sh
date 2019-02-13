#! /bin/bash

case $1 in
archives)
scp -r ../../apps/archives root@172.16.91.252:/opt/apps
echo "archives done"
;;

common)
scp -r ../../apps/common root@172.16.91.252:/opt/apps
echo "common done"
;;

topic)
scp -r ../../apps/topic root@172.16.91.252:/opt/apps
echo "topic done"
;;

user)
scp -r ../../apps/user root@172.16.91.252:/opt/apps
echo "user done"
;;

third)
scp -r ../../apps/third root@172.16.91.252:/opt/apps
echo "third done"
;;

eureka)
scp -r ../../apps/eureka root@172.16.91.252:/opt/apps
echo "eureka done"
;;

all)
scp -r ../../apps/archives ../../apps/common ../../apps/topic ../../apps/user ../../apps/third ../../apps/eureka root@172.16.91.252:/opt/apps
echo "all done"

esac
