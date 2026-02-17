package com.example.testproject1;

import io.camunda.client.CamundaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class Testproject1Application implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(Testproject1Application.class);

	// Process instance creation
	private static final String PROCESS_ID = "order-process";
	private static final int NUM_INSTANCES = 1; // Set the total number of new process instances

	@Autowired
	private CamundaClient camundaClient;

	public static void main(String[] args) {
		SpringApplication.run(Testproject1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		startProcessInstances(camundaClient, NUM_INSTANCES);
	}

	public void startProcessInstances(CamundaClient camundaClient, int numInstances) {

		logger.info("Starting: " + numInstances + " process instances for process: " + PROCESS_ID);

		for (int i = 0; i < numInstances; i++) {

			Map<String, Object> variables = Map.of(
					"orderId", "ORD-" + System.currentTimeMillis(),
					"price", 200
			);

			logger.info("Generating Order({})", variables.get("orderId"));

//			var event = camundaClient.newCreateInstanceCommand()
//					.bpmnProcessId(PROCESS_ID)
//					.latestVersion()
//					.variables(variables)
//					.send()
//					.join();
//
//			logger.info("Process instance: {} started", event.getProcessInstanceKey());

			logger.info("Publishing message for Order({})", variables.get("orderId"));

//			camundaClient.newPublishMessageCommand()
//					.messageName("ordermsg")
//					.correlationKey("ORD-" + System.currentTimeMillis())
//					.variables(variables)
//					.send()
//					.join();

			camundaClient.newPublishMessageCommand()
					.messageName("Message_2c9etcg")
					.correlationKey("") // Set this to an empty string for Start Events
					.variables(variables)
					.send()
					.join();
			logger.info("Message published successfully");
		}

		logger.info("Ending: " + numInstances + " instances created for process: " + PROCESS_ID);
	}


}
