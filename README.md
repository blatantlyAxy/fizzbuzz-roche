# fizzbuzz-roche
Production ready fizzbuzz generator with GKE

# build instructions
cd into the root dir and run ./gradlew clean build

# Containerization and deployment
Deploy via DockerHub using any preferred deployment engine, a sample dockerfile and pod configuration file is provided which can be used to deploy to GKE.

# Accessing the demo server
The server is live and available for 30 days on 35.200.24.139:80

Sample request :
http://35.200.24.139:80/api/v1/fizzbuzz?int1=3&int2=5&limit=5&str1=fizz&str2=buzz
an explicit API documentation wasn't done due to time limitations.

# Future scope
Loadbalancer is already available and caching/sharding seemed like an overkill at the moment, but can be added at a later point of time.
Observability is setup via GKE, but additional logging and monitoring can be added.

# Dev contact :
Akshay Rathore <br/>
startswithakshay@gmail.com <br/>
+91-7798060059 <br/>
Linkedin @ https://www.linkedin.com/in/eerav
