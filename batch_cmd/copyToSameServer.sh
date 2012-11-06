#!/bin/sh
# list {40 41 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69,}
for i in 40 42 43 44 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68
do
	scp qchen@csr$i.comp.hkbu.edu.hk:/tmp/qchen/database/NE.dat qchen@csr69.comp.hkbu.edu.hk:/tmp/qchen/database/NE$i.dat &
	scp qchen@csr$i.comp.hkbu.edu.hk:/tmp/qchen/database/NE.idx qchen@csr69.comp.hkbu.edu.hk:/tmp/qchen/database/NE$i.idx &
	echo "csr$i copy finish";
	#ssh csr$[$i + 40] 'if [ ! -d "/tmp/qchen"]; then mkdir "/tmp/qchen" else rm -rf "/tmp/qchen" & mkdir "/tmp/qchen"; fi' &
done
