######################################################################################################
## script que elimina, crea tots els objectes k8s de l'aplicació a partir dels fitxer definits
## en cada projecte
###################################################################################################### 

### set docker env
eval $(minikube docker-env)

### build the repository
#mvn clean  install

### build the docker images on minikube
cd ecommerce-config-service
docker build -t ecommerce-config-service .

cd ecommerce-webapp
docker build -t ecommerce-webapp .
cd ../ecommerce-web-reactive
docker build -t ecommerce-web-reactive .
cd ..


### Config server
kubectl delete -f ecommerce-config-service/ecommerce-config-configmap.yaml
kubectl create -f ecommerce-config-service/ecommerce-config-configmap.yaml



### secret and mongodb
kubectl delete -f travel-agency-service/secret.yaml
kubectl delete -f travel-agency-service/mongo-deployment.yaml

kubectl create -f travel-agency-service/secret.yaml
kubectl create -f travel-agency-service/mongo-deployment.yaml

### travel-agency-service
kubectl delete -f travel-agency-service/travel-agency-deployment.yaml
kubectl create -f travel-agency-service/travel-agency-deployment.yaml


### ecommerce-web-reactive
kubectl delete configmap ecommerce-web-reactive
kubectl delete -f ecommerce-web-reactive/ecommerce-web-reactive-deployment.yaml

kubectl create -f ecommerce-web-reactive/ecommerce-web-reactive-config.yaml
kubectl create -f ecommerce-web-reactive/ecommerce-web-reactive-deployment.yaml

# Check that the pods are running
kubectl get pods