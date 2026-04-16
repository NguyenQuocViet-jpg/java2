package entity;

import lombok.Getter;

@Getter
public enum CopyStatus {
    GOOD("Còn tốt"),
    DAMAGED("Hư hỏng"),
    LOST("Mất");

    private final String description;

    CopyStatus(String description) {
        this.description = description;
    }

    public static CopyStatus fromString(String text) {
        if (text == null) return GOOD;
        for (CopyStatus status : CopyStatus.values()) {
            if (status.name().equalsIgnoreCase(text) || status.description.equalsIgnoreCase(text)) {
                return status;
            }
        }
        return GOOD;
    }
}