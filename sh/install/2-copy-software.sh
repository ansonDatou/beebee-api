#! /bin/bash

SERVERS="172.16.9.244 172.16.9.245"
PASSWORD=beebeeWIN@2018

case $1 in
jdk)
for SERVER in $SERVERS
do
    ssh root@$SERVER mkdir /usr/local/software
    scp /usr/local/software/jdk-8u151-linux-x64.tar.gz root@$SERVER:/usr/local/software/
done
echo "copy jdk done"
;;


install)
for SERVER in $SERVERS
do
    ssh root@$SERVER mkdir -p /opt/sh/install
    scp -r /opt/sh/install/ root@$SERVER:/opt/sh/install
    ssh root@$SERVER /opt/sh/install/install-jdk.sh
    ssh root@$SERVER /opt/sh/install/install-supervisor.sh
done
echo "copy install done"
;;

esac