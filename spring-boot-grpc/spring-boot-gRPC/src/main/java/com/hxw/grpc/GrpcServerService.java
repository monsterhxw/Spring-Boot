package com.hxw.grpc;

import com.hxw.grpclib.protobuf.HelloReply;
import com.hxw.grpclib.protobuf.HelloRequest;
import com.hxw.grpclib.protobuf.SimpleGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;

@GrpcService(SimpleGrpc.class)
public class GrpcServerService extends SimpleGrpc.SimpleImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello-------------->" + request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
