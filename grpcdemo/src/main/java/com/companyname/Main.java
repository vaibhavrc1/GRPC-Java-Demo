package com.companyname;

import java.io.IOException;

import com.companyname.grpc.user.UserService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class Main {
	public static void main(String[] args) {
		System.out.println("Started main method");
		
		Server server=ServerBuilder.forPort(9090).addService(new UserService()).build();
		try {
			server.start();
		} catch (IOException e) {
			System.out.println("Error from server");
			e.printStackTrace();
		}
		System.out.println("Server started");
		try {
			server.awaitTermination();
		} catch (InterruptedException e) {
			System.out.println("Error from server");
			e.printStackTrace();
		}
		System.out.println("Waiting for termination");
	}
}
