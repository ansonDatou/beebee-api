#!/bin/bash

yum -y install supervisor
echo_supervisord_conf > /etc/supervisord.conf
mkdir /etc/supervisor
mkdir -p /opt/logs/supervisor
sed -i 's/file=\/tmp\/supervisor.sock/file=\/etc\/supervisor\/supervisor.sock/g' /etc/supervisord.conf
sed -i 's/port=127.0.0.1:9001/port=0.0.0.0:9001/g' /etc/supervisord.conf
sed -i 's/logfile=\/tmp\/supervisord.log/logfile=\/opt\/logs\/supervisor\/supervisord.log/g' /etc/supervisord.conf
sed -i 's/pidfile=\/tmp\/supervisord.pid/pidfile=\/etc\/supervisor\/supervisord.pid/g' /etc/supervisord.conf
sed -i 's/serverurl=unix:\/\/\/tmp\/supervisor.sock/serverurl=unix:\/\/\/etc\/supervisor\/supervisor.sock/g' /etc/supervisord.conf
cat >> /etc/supervisord.conf << EOF
[include]
files = /etc/supervisor/*.conf
EOF

supervisord -c /etc/supervisord.conf