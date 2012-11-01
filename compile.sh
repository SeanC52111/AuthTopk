#!bin/sh
javac -O -sourcepath src -classpath lib/SrtreeCommon.jar:lib/rtree_original.jar:lib/core.jar:lib/jdbm-2.4.jar $1 -d bin
