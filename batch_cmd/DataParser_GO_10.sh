#!/bin/sh
cd ..
./qhull-2012.1/bin/qhull < ./input/GO10.0.nm -i > ./input/GO10.0.tmp
echo 'Voronoi generated'
sh run.sh utility.newDelaunayParser ./input/GO10.0 ./input/GO10.0.pd.dat
echo 'Data generated'
rm ./input/GO10.0.tmp
echo 'finished!'