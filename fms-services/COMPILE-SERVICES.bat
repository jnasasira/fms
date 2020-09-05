echo "[PROCESS]  Compiling services for fms-system"
E:
cd E:\Pahappa\people-system\fms-services
call mvn eclipse:clean
call mvn eclipse:eclipse
call mvn clean install
call mvn install:install-file -Dfile="E:\Pahappa\people-system\fms-services\target\fms-services.jar" -DgroupId=org.pahappa.systems -DartifactId=fms-services -Dversion=1.0-SNAPSHOT -Dpackaging=jar
echo "[SUCCESSFUL]  Successfully Compiled All services"
PAUSE
