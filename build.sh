#!/bin/bash
#create source jar
jar cvf bozho-src.jar com
#copy to global bin
cp bozho-src.jar ~/bin/
#build the source files
ant
cd bin
#create a jar
jar cvf bozho.jar com
#copy to global bin
cp bozho.jar ~/bin/
