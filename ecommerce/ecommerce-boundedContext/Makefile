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

#####################################################################################
##  MINIKUBE
#####################################################################################	
delete:
	minikube delete

stop:
	minikube stop
	
	
dashboard:
	minikube dashboard
	
	
list:
	minikube service list	

start: 
	# https://airwavetechio.medium.com/istio-with-minikube-on-windows-pt-1-e33e5f193b2   
	minikube start --memory=4096 --cpus=4 --vm-driver hyperv --hyperv-virtual-switch "minikube" -v 9999 --extra-config=apiserver.service-node-port-range=1-40000
#	minikube start --vm-driver=hyperv -v 9999 --extra-config=apiserver.service-node-port-range=1-40000
#####################################################################################

	

#####################################################################################
##  ISTIO
#####################################################################################	
creaEcommerceIstio:
	kubectl apply -R -f ./istio
#	kubectl apply -f ./istio/ecommerce.yaml

eliminaEcommerceIstio:	
	sh ./istio/cleanup.sh
#####################################################################################	


mount:
	minikube mount ${PWD}/grafana/config:/grafana



#####################################################################################
##  KUBERNETES
#####################################################################################	

ingress:
	kubectl apply -f k8s/ingress


## frontend:
##	kubectl apply -f ecommerce-webapp-angular/kubernetes

	
arrancaEcommerceNetwork:
	kubectl apply -f ./networking/ecommerce-gateway.yaml	
	

watch:
	kubectl get pods -A --watch


## mongo, rabbit, axon,...
creaInfrastructure:
	kubectl apply -R -f ./k8s/infrastructure	


creaVaultConsul:	
	sh ./k8s/infrastructure/vault-consul-kubernetes/create.sh	
	

	

