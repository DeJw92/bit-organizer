package pl.edu.knbit.domain.enrollment.valueobjects;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum EnrollmentStatus {
    CREATED,
    STARTED,
    CANCELED,
    ENDED;

    private Set<EnrollmentStatus> possibleNextStates;

    static {
        CREATED.possibleNextStates = new HashSet<>(Arrays.asList(STARTED));
        STARTED.possibleNextStates = new HashSet<>(Arrays.asList(CANCELED, ENDED));
        CANCELED.possibleNextStates = new HashSet<>(Arrays.asList(STARTED));
        ENDED.possibleNextStates = new HashSet<>(Arrays.asList(STARTED));
    }

    public boolean canChangeStateTo(EnrollmentStatus status) {
        return possibleNextStates.contains(status);
    }
}
