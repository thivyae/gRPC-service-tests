## GRPC SERVICE TESTS

This repo shows sample of writing tests to verify grpc service from service layer
This repo contains tests to test the "hello world" service which is present in official grpc java repo(https://github.com/grpc/grpc-java/tree/master/examples)

# Start the grpc service
1. Clone the repo(https://github.com/grpc/grpc-java/tree/master/examples)
2. Run ```./build/install/examples/bin/hello-world-server```


# Generate protobuf files for the grpc service:

Place the .proto files of the service in src/test/proto folder.
Run ```./gradlew build``` to generate all code derived from the .proto file.
The generated files are placed under src/generated folder
Whenever there are changes to the proto file, rebuild the project and it should update the classes for you.
    
     
## RUN TESTS
```./gradlew clean test```