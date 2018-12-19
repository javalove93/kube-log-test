# kube-log-test

Google Kubernetes Engine + Java Spring + Logging performance test

## Docker build and test

~~~
docker build . -t spring
docker run spring

# Run as daemon
docker run -d --name spring-app -p 8888:8888 spring-app

# Stop the daemon
docker stop spring-app
docker rm spring-app
~~~

## Build with Cloud Build

~~~
$ cat cloudbuild.yaml
$ gcloud builds submit --config cloudbuild.yaml
~~~

## Create Pod/Deployment, Service

~~~
$ kubectl create -f deployment.yaml
$ kubectl create -f service.yaml

$ kubectl get svc --watch
$ curl http://<svc ip>:8888/sample/hello
I'm Alive!
~~~

## Persistent Volume

~~~
$ gcloud compute disks create --size=500GB --zone=us-central1-a my-data-disk
$ kubectl create -f disk.yaml
$ kubectl create -f deployment.yaml
~~~

---
# Logging performance test

## Performance test for file logging adn syslog udp logging
~~~
$ curl http://<svc ip>:8888/sample/file
Elapsed: OOOOO
$ curl http://<svc ip>:8888/syslog/udp
Elapsed: OOOOO
~~~





