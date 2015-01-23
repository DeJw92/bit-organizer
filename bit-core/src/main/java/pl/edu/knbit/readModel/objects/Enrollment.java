package pl.edu.knbit.readModel.objects;

import pl.edu.knbit.readModel.core.AbstractReadObject;

/**
 * @author mciolek
 */
public class Enrollment extends AbstractReadObject<String> {
    private final String title;

    public Enrollment(String id, String title) {
        super(id);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
