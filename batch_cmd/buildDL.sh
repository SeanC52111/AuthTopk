#!/bin/sh

 #count=1336581
 #count=118804
 count=433436
((step=$count/27+1))

j=0
for i in 40 42 43 44 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68
do
	((from=$j*$step))
	((to=$from+$step))
	if [ $to -gt $count ]; then
		to=$count
	fi
	((j++))
	cmd="cd ~/workspace/auth_of_knn; sh run.sh utility.geo.buildIndexDL ./input/$1 /tmp/qchen/database/$2.dl.$i $from $to 16"
	echo $cmd
	ssh csr$i $cmd &
done