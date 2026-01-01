# Base image with Java 17 & Maven
FROM maven:3.9.6-eclipse-temurin-17

# Install required packages
RUN apt-get update && apt-get install -y \
    wget \
    curl \
    unzip \
    gnupg

# Install Google Chrome
RUN curl -fsSL https://dl.google.com/linux/linux_signing_key.pub | gpg --dearmor -o /usr/share/keyrings/google-linux-keyring.gpg

RUN echo "deb [signed-by=/usr/share/keyrings/google-linux-keyring.gpg] http://dl.google.com/linux/chrome/deb/ stable main" \
    > /etc/apt/sources.list.d/google-chrome.list

RUN apt-get update && apt-get install -y google-chrome-stable

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Download dependencies and compile
RUN mvn clean compile

# Execute TestNG tests
CMD ["mvn", "test"]
