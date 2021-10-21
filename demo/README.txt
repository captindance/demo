After code is unzipped and compiled run "mvn  spring-boot:build-image"
Then run "docker images" to find your image that was created

Once you have found your image name and version run "docker run --rm -p 8080:8080 demo:0.0.1-SNAPSHOT". Replace demo:0.0.1-SNAPSHOT with the name of your image  


Otherwise you can just hit the run button in the compiler and it should just run on port 8080