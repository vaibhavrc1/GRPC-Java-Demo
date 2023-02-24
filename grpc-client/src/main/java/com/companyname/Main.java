package com.companyname;

import java.util.concurrent.TimeUnit;

import com.companyname.grpc.LoginRequest;
import com.companyname.grpc.LoginResponse;
import com.companyname.grpc.UserGrpc;
import com.companyname.grpc.UserGrpc.UserBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Main {

	public static void main(String[] args) {
		ManagedChannel channel=ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
		
		UserBlockingStub userStub=UserGrpc.newBlockingStub(channel);
		LoginRequest request=LoginRequest.newBuilder().setUsername("hello").setPassword("hello").build();
		
		LoginResponse response=userStub.login(request);
		
		System.out.println("client login response finished");
		channel.shutdownNow();
		
	}

}
