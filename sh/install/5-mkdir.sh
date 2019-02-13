#! /bin/bash

SERVERS="172.16.9.244 172.16.9.245"
PASSWORD=beebeeWIN@2018

for SERVER in $SERVERS
do
    ssh root@$SERVER mkdir /opt/apps
    ssh root@$SERVER mkdir /opt/logs
    ssh root@$SERVER mkdir /opt/sh/install
done
echo "mkdir done"
