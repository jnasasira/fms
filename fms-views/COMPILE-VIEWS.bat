echo "[PROCESS]  Compiling Views for fms-system"
E:
cd E:\Pahappa\people-system\fms-views
call mvn eclipse:clean
call mvn eclipse:eclipse
call mvn clean install
call mvn install:install-file -Dfile="E:\Pahappa\people-system\fms-views\target\fms-views.jar" -DgroupId=org.pahappa.systems -DartifactId=fms-views -Dversion=1.0-SNAPSHOT -Dpackaging=jar
echo "[SUCCESSFUL]  Successfully Compiled All Views"
PAUSE
