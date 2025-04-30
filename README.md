# Apple MDM Server

This is a Spring Boot application implementing Apple's Mobile Device Management (MDM) protocol for managing iOS and macOS devices.

## CI/CD Pipeline

This project uses GitHub Actions for continuous integration and deployment. The pipeline includes:

1. **Build and Test**: Compiles the Java code and runs all tests
2. **Security Scan**: Scans dependencies for vulnerabilities
3. **Docker Build**: Builds and pushes a Docker image to GitHub Container Registry
4. **Development Deployment**: Deploys to development environment
5. **Production Deployment**: Deploys to production environment after manual approval

## Development Setup

### Prerequisites

- Java 21
- Maven
- Docker (optional)

### Running Locally

```bash
# Build the application
mvn clean package

# Run the application
java -jar target/apple-mdm-0.0.1-SNAPSHOT.jar
```

### Using Docker

```bash
# Build Docker image
docker build -t apple-mdm .

# Run container
docker run -p 8080:8080 apple-mdm
```

### Using Docker Compose

```bash
# Start all services
docker-compose up -d
```

## Kubernetes Deployment

The application can be deployed to Kubernetes using the provided manifests:

```bash
# Apply the manifests
kubectl apply -f kubernetes/deployment.yml

# Get the service URL
kubectl get ingress apple-mdm-ingress
```

## Endpoints

- `/MDMServiceConfig` - Returns the MDM service configuration
- `/checkin` - Handles device check-in requests
- `/dep/anchor-certs` - Returns anchor certificates
- `/dep/enroll` - Handles DEP enrollment
- `/dep/profile` - Provides trust profiles

## Environment Variables

- `SPRING_PROFILES_ACTIVE` - Spring profiles to activate (default, dev, prod)

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.
