#! /bin/bash

case $1 in
archives)
ssh root@172.16.9.225 scp /etc/supervisor/*.conf root@172.16.9.244:/etc/supervisor/
echo "archives conf done"
;;

topic)
ssh root@172.16.9.227 scp /etc/supervisor/*.conf root@172.16.9.245:/etc/supervisor/
echo "topic conf done"
;;

esac