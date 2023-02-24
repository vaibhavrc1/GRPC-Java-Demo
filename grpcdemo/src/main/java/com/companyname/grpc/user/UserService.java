package com.companyname.grpc.user;

import com.companyname.grpc.User.Empty;
import com.companyname.grpc.User.LoginRequest;
import com.companyname.grpc.User.LoginResponse;
import com.companyname.grpc.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase {

	@Override
	public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
		// TODO Auto-generated method stub
		System.out.println("Login is called in gRPC server");
		String username=request.getUsername();
		String password=request.getPassword();
		
		LoginResponse.Builder responseBuilder=LoginResponse.newBuilder();
		if(username.equals(password)) {
			System.out.println("matching username and password");
			responseBuilder.setResponseCode(0);
			responseBuilder.setResponseMessage("SUCCESS");
		}
		else {
			System.out.println("non matching username and password");
			responseBuilder.setResponseCode(400);
			responseBuilder.setResponseMessage("FAILURE");
		}
		
		responseObserver.onNext(responseBuilder.build());
		responseObserver.onCompleted();
		System.out.println("Login response complete");
		
	}

	@Override
	public void logout(Empty request, StreamObserver<LoginResponse> responseObserver) {
		// TODO Auto-generated method stub
		System.out.println("Logout is called in gRPC server");
		super.logout(request, responseObserver);
	}

}
