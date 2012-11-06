#!/bin/sh

count=1796019
((step=$count/28+1))
to=0;
echo $to;
if [ $to -gt $count ]; then
		to=$count
fi
echo "$to"