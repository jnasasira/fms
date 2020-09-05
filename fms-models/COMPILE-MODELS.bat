echo "[PROCESS]  Compiling Models for People system"
E:
cd E:\Pahappa\people-system\fms-models
call mvn eclipse:clean
call mvn eclipse:eclipse
call mvn clean install
call mvn install:install-file -Dfile="E:\Pahappa\people-system\fms-models\target\fms-models.jar" -DgroupId=org.pahappa.systems -DartifactId=fms-models -Dversion=1.0-SNAPSHOT -Dpackaging=jar
echo "[SUCCESSFUL]  Successfully Compiled All Models"
PAUSE
