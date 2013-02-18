#!/bin/sh

> /tmp/qchen/database/$1.dl.dat
for i in 40 42 43 44 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68
do
	cat /tmp/qchen/database/$1.dl.$i.dat >> /tmp/qchen/database/$1.dl.dat
	rm /tmp/qchen/database/$1.dl.$i.dat
	echo "csr$i merged and deleted";
	#ssh csr$[$i + 40] 'if [ ! -d "/tmp/qchen"]; then mkdir "/tmp/qchen" else rm -rf "/tmp/qchen" & mkdir "/tmp/qchen"; fi' &
done