.PHONY: build release

build: build-nginx build-spring-boot
release: release-nginx release-spring-boot

LOGGING_TEST_DRIVER_NGINX_VERSION="1"

build-nginx:
	docker build --tag observabilitystack/logging-test-driver-nginx:$(LOGGING_TEST_DRIVER_NGINX_VERSION) logging-test-driver-nginx/

build-spring-boot:
	$(MAKE) -C logging-test-driver-spring-boot/ build

release-nginx: build-nginx
	docker push observabilitystack/logging-test-driver-nginx:$(LOGGING_TEST_DRIVER_NGINX_VERSION)

release-spring-boot:
	$(MAKE) -C logging-test-driver-spring-boot/ release

