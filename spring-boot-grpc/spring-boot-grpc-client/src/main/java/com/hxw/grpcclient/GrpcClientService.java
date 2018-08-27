package com.hxw.grpcclient;

import com.hxw.grpclib.protobuf.HelloReply;
import com.hxw.grpclib.protobuf.HelloRequest;
import com.hxw.grpclib.protobuf.SimpleGrpc;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {

    @GrpcClient("local-grpc-server")
    private Channel serverChannel;

    public String sendMessage(String name) {
        SimpleGrpc.SimpleBlockingStub stub = SimpleGrpc.newBlockingStub(serverChannel);
        HelloReply response = stub.sayHello(HelloRequest.newBuilder().setName(name).build());
        return response.getMessage();
    }
}
