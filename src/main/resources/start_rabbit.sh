#!/usr/bin/env bash

docker run --rm -d --name rabbit-docker -p 5671:5671 -p 5672:5672 -p 15672:15672 rabbitmq:3.8.9-management