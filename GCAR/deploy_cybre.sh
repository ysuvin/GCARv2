#!/bin/bash
set -x
rm -rf /usr/local/Cellar/tomcat/9.0.37/libexec/webapps/GCAR* &&
ant -f build.xml clean &&
ant -f build.xml &&
ssh ifp@cybre.dev "rm -rf /var/lib/tomcat9/webapps/GCAR*" &&
scp dist/GCAR.war ifp@cybre.dev:/var/lib/tomcat9/webapps
