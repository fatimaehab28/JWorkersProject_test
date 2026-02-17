package com.example.testproject1.workers;

import io.camunda.client.annotation.JobWorker;
import io.camunda.client.api.response.ActivatedJob;
import org.springframework.stereotype.Component;

@Component
public class ShippingWorker {

    @JobWorker(type = "ship-order")
    public void handleShipping(final ActivatedJob job) {
        // Just logic to "ship", no return variables needed here
        System.out.println("Step 2: Shipping the order now...");
    }
}