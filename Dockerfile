FROM centos:latest
MAINTAINER your_name "javalove93@gmail.com"
RUN yum install -y java-1.8.0-openjdk-devel
COPY build/libs/kube-log-test-0.0.1-SNAPSHOT-boot.jar /home
WORKDIR /home
ENTRYPOINT ["java", "-jar", "kube-log-test-0.0.1-SNAPSHOT-boot.jar"]
