package sdj3.assignment3_1.service;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import sdj3.assignment3_1.protobuf.RequestText;
import sdj3.assignment3_1.protobuf.ResponseText;
import sdj3.assignment3_1.protobuf.RetrieveInfoGrpc;

import java.util.ArrayList;

import static sdj3.assignment3_1.database.Retrieve.getPackages;
import static sdj3.assignment3_1.database.Retrieve.getRegNum;

@GRpcService
public class RetrieveInfoImpl extends RetrieveInfoGrpc.RetrieveInfoImplBase {
    @Override
    public void retrieveRegNum(RequestText request, StreamObserver<ResponseText> responseObserver){
        System.out.println("Received Request ===> " + request.toString());
        int temp=getRegNum("21");
        ResponseText responseText = ResponseText.newBuilder().setOutputText(String.valueOf(temp)).build();
        responseObserver.onNext(responseText);
        responseObserver.onCompleted();
    }



    public void retrievePackage(RequestText request, StreamObserver<ResponseText> responseObserver){
        System.out.println("Received Request ===> " + request.toString());
        ArrayList<Integer> list = getPackages(1);
        String output = "";
        for(int i = 0; i < list.size()-1;i++){
            output += list.get(i) + ", ";
        }
        output+= list.get(list.size()-1);
        ResponseText responseText = ResponseText.newBuilder().setOutputText(output).build();
        responseObserver.onNext(responseText);
        responseObserver.onCompleted();
    }




}
