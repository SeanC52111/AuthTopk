#!/bin/sh
cd ..
./qhull-2012.1/bin/qhull < ./input/GO$1.nm -i > ./input/GO$1.tmp
echo 'Voronoi generated'
sh run.sh utility.newDelaunayParser ./input/GO$1 ./input/GO$1.pd.dat
echo 'Data generated'
rm ./input/GO$1.tmp
echo 'finished!'