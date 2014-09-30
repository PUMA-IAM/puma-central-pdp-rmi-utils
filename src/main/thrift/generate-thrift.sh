#!/bin/bash

thrift -v --gen java pdp.thrift
rm ../java/puma/thrift/pdp/gen-java -rf
cp gen-java/puma/ ../java/ -r
rm gen-java -rf
