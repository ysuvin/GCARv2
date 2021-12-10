#!/bin/bash
set -x
rm -rf /usr/local/Cellar/tomcat/9.0.37/libexec/webapps/GCAR* &&
ant -f build.xml clean &&
ant -f build.xml &&
cp dist/GCAR.war /usr/local/Cellar/tomcat/9.0.37/libexec/webapps
