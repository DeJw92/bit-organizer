package pl.edu.knbit.domain.enrollment.valueobjects;

import java.util.UUID;

public class EnrollmentId {
    private final UUID id;

    public EnrollmentId() {
        this.id = UUID.randomUUID();
    }

    public EnrollmentId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnrollmentId enrollmentId = (EnrollmentId) o;

        return id.equals(enrollmentId.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return String.format("EnrollmentId(id=%s)", id);
    }
}
