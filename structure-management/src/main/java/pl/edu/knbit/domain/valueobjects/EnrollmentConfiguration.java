package pl.edu.knbit.domain.valueobjects;

public class EnrollmentConfiguration {

    private final Integer requestsLimit;

    public EnrollmentConfiguration(Integer requestsLimit) {
        this.requestsLimit = requestsLimit;
    }

    public Integer getRequestsLimit() {
        return requestsLimit;
    }
}
