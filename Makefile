.PHONY: build release

build: build-nginx 
release: release-nginx 

LOGGING_TEST_DRIVER_NGINX_VERSION="1"

build-nginx:
	docker build --tag observabilitystack/logging-test-driver-nginx:$(LOGGING_TEST_DRIVER_NGINX_VERSION) logging-test-driver-nginx/

release-nginx: build-nginx
	docker push observabilitystack/logging-test-driver-nginx:$(LOGGING_TEST_DRIVER_NGINX_VERSION)

