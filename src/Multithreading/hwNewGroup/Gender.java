package Multithreading.hwNewGroup;

public enum Gender {
    MALE("male"),
    FEMALE("female");

    private final String description;

    Gender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
