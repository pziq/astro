package io.seq.astro.global.enumerations;

public enum Status {

    Preactive(0),
    Active(1),
    Inactive(2),
    ;

    public final int label;
    Status(int label) {
        this.label = label;
    }
}
