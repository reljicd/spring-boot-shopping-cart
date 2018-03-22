#!/usr/bin/env bash

CONTAINER_NAME=spring-boot-shopping-cart
echo -e "\nSet docker container name as ${CONTAINER_NAME}\n"
IMAGE_NAME=${CONTAINER_NAME}:dev
echo -e "\nSet docker image name as ${IMAGE_NAME}\n"
PORT=8070
echo -e "Set docker image PORT to ${PORT}\n"

echo -e "Create uber jar...\n"
mvn clean package

echo -e "\nStop running Docker containers with image tag ${CONTAINER_NAME}, and remove them...n"
docker stop $(docker ps -a | grep ${CONTAINER_NAME} | awk '{print $1}')
docker rm $(docker ps -a | grep ${CONTAINER_NAME} | awk '{print $1}')

echo -e "\nDocker build image with name ${IMAGE_NAME}...\n"
docker build -t ${IMAGE_NAME} -f docker/Dockerfile .

echo -e "\nStart Docker container of the image ${IMAGE_NAME} with name ${CONTAINER_NAME}...\n"
docker run --rm -i -p ${PORT}:${PORT} \
    --name ${CONTAINER_NAME} \
    ${IMAGE_NAME}