package org.kodluyoruz.group1.library.model.enums;

public enum StatusEnum {

    ACTIVE(1, "Aktif"),
    PASSIVE(2, "Pasif"),
    DELETED(3, "Silinmiş");

    private final Integer id;
    private final String value;

    StatusEnum(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
