#!/bin/sh
cd ..
./qhull-2012.1/bin/qhull < ./input/GO1.0.nm -i > ./input/GO1.0.tmp
echo 'Voronoi generated'
sh run.sh utility.newDelaunayParser ./input/GO1.0 ./input/GO1.0.pd.dat
echo 'Data generated'
rm ./input/GO1.0.tmp
echo 'finished!'