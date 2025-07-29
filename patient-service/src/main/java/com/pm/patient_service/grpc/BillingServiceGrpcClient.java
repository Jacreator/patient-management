package com.pm.patient_service.grpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import billing.BillingServiceGrpc;
import io.grpc.ManagedChannelBuilder;

@Service
public class BillingServiceGrpcClient {
  private final BillingServiceGrpc.BillingServiceBlockingStub billingServiceBlockingStub;
  private static final Logger logger = LoggerFactory.getLogger(BillingServiceGrpcClient.class);

  public BillingServiceGrpcClient(
      @Value("${billing.service.address:localhost}") String billingServiceAddress,
      @Value("${billing.service.port:5003}") int billingServicePort) {
    logger.info("Connecting to Billing Service GRPC at {}:{}", billingServiceAddress, billingServicePort);
    this.billingServiceBlockingStub = BillingServiceGrpc.newBlockingStub(
        ManagedChannelBuilder.forAddress(billingServiceAddress, billingServicePort)
            .usePlaintext()
            .build());
  }

  public billing.CreateBillResponse createBillingAccount(String patientId, String name, String email) {
    billing.CreateBillRequest request = billing.CreateBillRequest.newBuilder()
        .setPatientId(patientId)
        .setName(name)
        .setEmail(email)
        .build();
    logger.info("Creating billing account with request: {}", request);
    billing.CreateBillResponse response = billingServiceBlockingStub.createBillingAccount(request);
    logger.info("Received billing account response: {}", response);
    return response;
  }

  public billing.GetBillResponse getBill(String patientId) {
    billing.GetBillRequest request = billing.GetBillRequest.newBuilder()
        .setPatientId(patientId)
        .build();
    logger.info("Getting bill with request: {}", request);
    billing.GetBillResponse response = billingServiceBlockingStub.getBill(request);
    logger.info("Received bill response: {}", response);
    return response;
  }
}
