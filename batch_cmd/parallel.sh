!/bin/sh

for i in 40 42 43 44 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69
do
   ssh csr$i  ~/AuthSky/constructS4Tree $[$1+500*$i] $[$2+500*$i]  >>  ~/AuthSky/output/from_$[$1+500*$i]_to_$[$2+500*$i].txt &
done