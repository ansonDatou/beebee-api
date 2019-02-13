#!/bin/bash

tar -zxvf /usr/local/software/jdk-8u151-linux-x64.tar.gz -C /usr/local/
mv /usr/local/jdk1.8.0_151 /usr/local/jdk
cat >> /etc/profile << EOF
export JAVA_HOME=/usr/local/jdk
export PATH=\$PATH:\$JAVA_HOME/bin
EOF