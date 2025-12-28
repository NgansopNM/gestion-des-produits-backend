# Dockerfile pour Spring Boot
FROM eclipse-temurin:17-jdk-jammy

# Répertoire de travail
WORKDIR /app

# Copier les fichiers Maven pour préparer le build
COPY pom.xml mvnw ./
COPY .mvn .mvn

# Télécharger les dépendances offline
RUN ./mvnw dependency:go-offline

# Copier le code source
COPY src src

# Build de l'application
RUN ./mvnw clean package -DskipTests

# Exposer le port
EXPOSE 8080

# Commande pour lancer l'application avec le nom exact de ton jar
CMD ["java", "-Dserver.port=${PORT}", "-jar", "target/API-produit-0.0.1-SNAPSHOT.jar"]
