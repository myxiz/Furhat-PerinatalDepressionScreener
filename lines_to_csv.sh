#!/bin/sh

FILE=$1
cat $FILE | sed -e :a -e '$!N;s/" *+ *\n *"//;ta' -e 'P;D' | sed '/^val /!d' | sed -e 's/^val//' | sed -e 's/ = /,/g' | sed -e 's/ *# */,/g' 

