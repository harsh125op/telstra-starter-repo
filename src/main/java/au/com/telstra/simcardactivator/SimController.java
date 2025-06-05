package au.com.telstra.simcardactivator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/sim")
public class SimActivationController {

    private final RestTemplate restTemplate;

    public SimActivationController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/activate")
    public ResponseEntity<String> activateSim(@RequestBody SimActivationRequest request) {
        String actuatorUrl = "http://localhost:8444/actuate";

        // Prepare the payload for the actuator
        ActuatorRequest actuatorRequest = new ActuatorRequest(request.getIccid());

        // Send the request to the actuator
        ResponseEntity<ActuatorResponse> response = restTemplate.postForEntity(actuatorUrl, actuatorRequest, ActuatorResponse.class);

        // Check the response and print the result
        if (response.getBody() != null && response.getBody().isSuccess()) {
            return ResponseEntity.ok("SIM card activated successfully.");
        } else {
            return ResponseEntity.status(500).body("Failed to activate SIM card.");
        }
    }
}
