#!/bin/sh
cd ..
#sh run.sh utility.FormatData2Norm ./input/$1 ./input/$1.nm 
#echo 'Format to norm'
./qhull-2012.1/bin/qhull < ./input/$1.nm -i > ./input/$1.tmp
echo 'Voronoi generated'
sh run.sh utility.newDelaunayParser ./input/$1 ./input/$1.pd
echo 'Data generated'
rm ./input/$1.tmp
echo 'finished!'