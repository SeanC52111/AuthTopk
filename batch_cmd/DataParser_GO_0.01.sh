#!/bin/sh
cd ..
./qhull-2012.1/bin/qhull < ./input/GO0.01.nm -i > ./input/GO0.01.tmp
echo 'Voronoi generated'
sh run.sh utility.newDelaunayParser ./input/GO0.01 ./input/GO0.01.pd.dat
echo 'Data generated'
rm ./input/GO0.01.tmp
echo 'finished!'