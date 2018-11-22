package grpcTests;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class DemoTest {

        private static ManagedChannel channel;
        private static GreeterGrpc.GreeterBlockingStub blockingStub;

    @BeforeClass
    public static void setup() {
        //create channel for the service to client communication
        channel = ManagedChannelBuilder.forAddress("localhost",50051)
                .usePlaintext(true)
                .build();
        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }

        @Test
        public void verifyHelloWorldMethod() {
            System.out.println("Trying to call service ");
            try {
                //Build the payload and call the "sayHello" method and
                  HelloReply reply=   blockingStub.sayHello( HelloRequest.newBuilder().setName("testing").build());
                System.out.println("message from service" + reply.getMessage());


                Assert.assertEquals(reply.getMessage(),"Hello testing");

            } catch (RuntimeException e) {
                System.err.print("Request to grpc server failed " + e);
            }
        }


 @AfterClass
        public static void tearDown() throws InterruptedException {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        }
    }


