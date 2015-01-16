package pl.edu.knbit.domain.enrollment.aggregates;

import pl.edu.knbit.domain.enrollment.valueobjects.EnrollmentConfiguration;
import pl.edu.knbit.domain.enrollment.valueobjects.EnrollmentId;

public class EnrollmentFactory {
    public static Enrollment create(EnrollmentId enrollmentId, String title, String description, EnrollmentConfiguration configuration) {
        return new Enrollment(enrollmentId, title, description, configuration);
    }
}
