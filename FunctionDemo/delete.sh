#!/bin/bash

docker rm -f `docker ps -a -q`

docker rmi `docker images -q`

sudo rm -fR ./target