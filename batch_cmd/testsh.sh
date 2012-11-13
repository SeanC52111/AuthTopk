#!/bin/sh

count=433436
((step=$count/28+1))
to=0;
echo $to;
if [ $to -gt $count ]; then
		to=$count
fi
echo "$to"