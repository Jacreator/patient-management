package com.pm.billing_service.grpc;

import net.devh.boot.grpc.server.service.GrpcService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import billing.BillingServiceGrpc.BillingServiceImplBase;
import io.grpc.stub.StreamObserver;

@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {
  private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

  @Override
  public void createBillingAccount(billing.CreateBillRequest request, StreamObserver<billing.CreateBillResponse> responseObserver) {
    log.info("Received request to create billing account: {}", request.toString());

    // Implement your logic to create a billing account here
    billing.CreateBillResponse response = billing.CreateBillResponse.newBuilder()
        .setAccountId("12345")
        .setStatus("ACTIVE")
        .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void getBill(billing.GetBillRequest request, StreamObserver<billing.GetBillResponse> responseObserver) {
    log.info("Received request to get bill: {}", request.toString());

    // Implement your logic to get a bill here
    billing.GetBillResponse response = billing.GetBillResponse.newBuilder()
        .setAccountId("12345")
        .setStatus("PAID")
        .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
