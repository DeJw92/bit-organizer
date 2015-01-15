package pl.edu.knbit.domain.aggregates.enrollment;

import pl.edu.knbit.domain.valueobjects.enrollment.EnrollmentConfiguration;
import pl.edu.knbit.domain.valueobjects.enrollment.EnrollmentId;

public class EnrollmentFactory {
    public static Enrollment create(EnrollmentId enrollmentId, String title, String description, EnrollmentConfiguration configuration) {
        return new Enrollment(enrollmentId, title, description, configuration);
    }
}
