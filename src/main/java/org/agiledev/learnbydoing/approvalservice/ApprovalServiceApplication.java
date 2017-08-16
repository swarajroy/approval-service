package org.agiledev.learnbydoing.approvalservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableBinding(Source.class)
public class ApprovalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApprovalServiceApplication.class, args);
	}
}

@RestController
class ApprovalController{

	@Autowired
	private final Source source;

	ApprovalController(Source source) {
		this.source = source;
	}

	@GetMapping("/approvals")
	public ResponseEntity<List<String>> approvals(){
		List<String> approvals = Arrays.asList("Swaraj", "Ruchika");
		return ResponseEntity.status(201).body(approvals);
	}

	@PostMapping("/approvalMessage")
	public void triggerApprovalMessage() {
		source.output().send(MessageBuilder.withPayload(new Approval("APPROVED")).build());
	}
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Approval{
	private String approvalStatus;

}