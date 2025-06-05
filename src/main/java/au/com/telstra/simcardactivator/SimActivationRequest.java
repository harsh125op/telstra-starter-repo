package au.com.telstra.simcardactivator;

public class SimActivationRequest {
    private String iccid;
    private String customerEmail;

    // Getters and Setters
    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}

public class ActuatorRequest {
    private String iccid;

    public ActuatorRequest(String iccid) {
        this.iccid = iccid;
    }

    // Getter
    public String getIccid() {
        return iccid;
    }
}

public class ActuatorResponse {
    private boolean success;

    // Getter
    public boolean isSuccess() {
        return success;
    }

    // Setter
    public void setSuccess(boolean success) {
        this.success = success;
    }
}
