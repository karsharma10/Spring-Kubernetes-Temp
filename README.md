# Spring-Kubernetes-Temp
A Template For Developing and Deploying Spring Boot microservices on Kubernetes with MongoDB service.

## Dependencies:
- [MongoDB](https://www.mongodb.com/docs/manual/administration/install-community/)
- [Docker](https://docs.docker.com/get-docker/)
- [Minikube](https://minikube.sigs.k8s.io/docs/start/)
- [Kubernetes CLI](https://kubernetes.io/docs/tasks/tools/)

## Commands to Run:
Once all the dependencies are downloaded:
```
minikube start
```
This will verify that the cluster is created:
```
kubectl cluster-info
```
Go into the app directory:
```
cd app/
```
And push the kube folder with all the kubernetes yaml files into your local kubernetes server. This project has already built the necessary docker images to DockerHub: 
```
kubectl apply -f kube
```
Watch the pods go live:
```
kubectl get pods --watch
```
Get the URL of the knote service which is the only pod that can be accessible from outside the kubernetes service, and type that into the URL of your browser:
```
minikube service knote --url
```
---
> [!WARNING]
> Environmental variables left in source code but should be removed for actual deployment.

