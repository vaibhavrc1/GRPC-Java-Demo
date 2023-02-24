package com.companyname;

import java.io.IOException;

import com.companyname.grpc.user.UserService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Started main method");
		
		Server server=ServerBuilder.forPort(9090).addService(new UserService()).build();
		server.start();
		System.out.println("Server started");
		server.awaitTermination();
		System.out.println("Waiting for termination");
	}
}
