package sdj3.assignment3_1;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import sdj3.assignment3_1.protobuf.RequestText;
import sdj3.assignment3_1.protobuf.ResponseText;
import sdj3.assignment3_1.protobuf.RetrieveInfoGrpc;

public class GRPCClient {
    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost",8080).usePlaintext().build();
        RetrieveInfoGrpc.RetrieveInfoBlockingStub blockingStub = RetrieveInfoGrpc.newBlockingStub(managedChannel);

        RequestText requestText = RequestText.newBuilder().setInputText("Get animal ID").build();
        RequestText requestText2 = RequestText.newBuilder().setInputText("Get packages by animal").build();

        ResponseText responseText = blockingStub.retrieveRegNum(requestText);
        System.out.println("Received response >>>> " + responseText.getOutputText());

        ResponseText responseText2 = blockingStub.retrievePackage(requestText2);
        System.out.println("Received response >>>> " + responseText2.getOutputText());




    }
}
