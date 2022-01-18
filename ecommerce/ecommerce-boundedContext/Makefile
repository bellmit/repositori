# ----------------------------------------------------------
# Setup
# ----------------------------------------------------------
DOCKER_COMPOSE_FILE="./docker/docker-compose.yml"
DOCKER_COMPOSE=docker-compose -f $(DOCKER_COMPOSE_FILE)

# ----------------------------------------------------------
# Main Commands
# ----------------------------------------------------------
all: docker-build-all rebuild-mongo docker-up-all

docker-build-all:
	pushd docker &&\
	docker-compose build &&\
	popd

docker-up-all:
	pushd docker &&\
	docker-compose up -d &&\
	popd
	
up-db-local:	rebuild-mongo
	$(DOCKER_COMPOSE) up -d mongo

rebuild-mongo:
	$(DOCKER_COMPOSE) build mongo-seed &&\
	$(DOCKER_COMPOSE) up mongo-seed

# Alternate main commands if you have pushd/popd available, for reference
all-alt:	up-db-local-alt

up-db-local-alt:	rebuild-mongo-alt
	pushd docker &&\
	docker-compose up -d mongo &&\
	popd

rebuild-mongo-alt:
	pushd docker &&\
	docker-compose build mongo-seed &&\
	docker-compose up mongo-seed &&\
	popd

# ----------------------------------------------------------
# Cleanup Helper Commands
# ----------------------------------------------------------
clean:
	$(DOCKER_COMPOSE) down
	docker volume rm docker_mongodata

# ----------------------------------------------------------
# Container Helper Commands
# ----------------------------------------------------------

# exec into mongo container
mongo-terminal:
	docker exec -it docker_mongo_1 mongo
	
# tail the logs for the mongo instance
mongo-logs:
	docker logs -f docker_mongo_1

# ----------------------------------------------------------
# Angular Commands
# ----------------------------------------------------------

#ng-serve:
#	pushd src/main/ng/fxui &&\
#	ng serve &&\
#	popd


# -----------------------------------------------------------
# Makefile Minikube 
# Obtingut de : https://octoperf.com/blog/2019/09/05/kraken-kubernetes-ingress-nginx-frontend/#tl-dr
# -----------------------------------------------------------

delete:
	minikube delete

stop:
	minikube stop

start:    
	minikube start --vm-driver=hyperv -v 9999 --extra-config=apiserver.service-node-port-range=1-40000
	
mount:
	minikube mount ${PWD}/grafana/config:/grafana

ingress:
	kubectl apply -f k8s/ingress

# frontend:
#	kubectl apply -f ecommerce-webapp-angular/kubernetes

# mongo, rabbit, axon,...
arrancaInfrastructure:
	kubectl apply -R -f ./k8s/infrastructure

	
arrancaEcommerceIstio:
	kubectl apply -f ./istio/ecommerce.yaml
	
arrancaEcommerceNetwork:
	kubectl apply -f ./networking/ecommerce-gateway.yaml	
	
	
dashboard:
	minikube dashboard
	
	
list:
	minikube service list

watch:
	kubectl get pods -A --watch
	
	
# Prometheus, Grafana, and Jaeger.	
addons:	
	kubectl apply -f k8s/addons
