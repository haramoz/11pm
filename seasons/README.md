Dockerfile

#Create docker image
docker build -t sample:react-app .

#Running docker image
docker run -p 3000:3000 #imageId
If you do not do port forwarding then in local it would never work

#Useful docker commands
docker images
docker ps
docker stop #containerId
docker rm #containerId
docker image rm #imageId
docker system prune

