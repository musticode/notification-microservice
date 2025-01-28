echo "runner file"

echo "Running docker compose file.."
docker compose up -d

echo "Starting config-server application"
cd config-server
mvn spring-boot:run

echo "Starting service-discovery application"
cd service-discovery
mvn spring-boot:run

