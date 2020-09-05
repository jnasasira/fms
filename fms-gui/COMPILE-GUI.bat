echo "[PROCESS]  Compiling gui for people-system"
E:
cd E:\Pahappa\people-system\fms-gui
call mvn eclipse:clean
call mvn eclipse:eclipse -Dwtpversion=2.0
call mvn package
echo "[SUCCESSFUL]  Successfully Compiled All Guis
PAUSE