mvn clean install package -Dmaven.test.skip=true
rm -rf /Users/chenjie/servers/Tomcat7/webapps/*
cp target/saas.war  /Users/chenjie/servers/Tomcat7/webapps/saas.war