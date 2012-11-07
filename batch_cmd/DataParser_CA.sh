#!/bin/sh
cd ..
sh run.sh utility.FormatData2Norm ./source/CA.dat ./source/CA.dat.nm 
echo 'Format to norm'
./qhull-2012.1/bin/qhull < ./source/CA.dat.nm -i > ./source/CA.dat.tmp
echo 'Voronoi generated'
sh run.sh utility.newDelaunayParser ./source/CA.dat ./source/CA.dat.pd
echo 'Data generated'
rm ./source/CA.dat.tmp
echo 'finished!'