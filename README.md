# Logging Test Drivers
A bunch of Docker images to use as test drivers for a logging stack

## Docker Hub

If you just want to use these images to fire logging on a logging stack, don't bother with building it yourself as the images are published on **DockerHub**:

* [Logging Driver Nginx][docker-hub-test-driver-nginx]
* [Logging Driver SpringBoot][docker-hub-test-driver-spring-boot]

You can pull them via

```
$ docker pull observabilitystack/logging-test-driver-nginx
$ docker pull observabilitystack/logging-test-driver-spring-boot
```

## Usage

There are some `docker-compose` files that illustrate the usage of the containers. See the comments in the compose-files for further details:

* [usage/log-to-stdout/docker-compose.yml](usage/log-to-stdout/docker-compose.yml) shows how you can start the containers and let them log to `stdout` which is the default way. 

* [usage/log-to-file/docker-compose.yml](usage/log-to-file/docker-compose.yml) shows how you can start the containers and let them log to `stdout` **and** to a file which is located in a mapped volume. 

## Build and release

To build and tag the Docker images locally, just call 

```
make build

# or just
make
```

Releasing to **DockerHub** is reserved to the maintainers of **observabilitystack.org**

```
make release
```


[docker-hub-test-driver-nginx]: https://hub.docker.com/r/observabilitystack/logging-test-driver-nginx 
[docker-hub-test-driver-spring-boot]: https://hub.docker.com/r/observabilitystack/logging-test-driver-spring-boot 
