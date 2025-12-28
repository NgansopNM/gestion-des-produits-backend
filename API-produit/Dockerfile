# Utiliser une image JDK 17 officielle
FROM eclipse-temurin:17-jdk-alpine

# Créer un répertoire pour l'application
WORKDIR /app

# Copier les fichiers Maven nécessaires pour le build
COPY pom.xml mvnw ./
COPY .mvn .mvn

# Copier le reste du code
COPY src src

# Installer Maven et builder l'application
RUN ./mvnw clean install -DskipTests

# Exposer le port sur lequel Spring Boot tourne
EXPOSE 8080

# Lancer l'application
CMD ["java", "-Dserver.port=$PORT", "-jar", "target/API-produit-0.0.1-SNAPSHOT.jar"]
