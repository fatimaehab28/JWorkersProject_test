package com.example.testproject1.workers;


import io.camunda.client.api.worker.JobClient;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.client.annotation.JobWorker;

import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class DiscountWorker {

        @JobWorker(type = "calculate-discount")
        public Map<String, Object> handleDiscount(final JobClient client, final ActivatedJob job) {

            Map<String, Object> variables = job.getVariablesAsMap();

            Number priceNumber = (Number) variables.get("price");

            if (priceNumber == null) {
                throw new RuntimeException("Price variable is missing!");
            }

            double price = priceNumber.doubleValue();
            double discount = price * 0.1;

            System.out.println("Step 1: Calculated discount: " + discount);

            return Map.of("discount", discount);
        }
    }
