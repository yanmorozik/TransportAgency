package eu.morozik.transportagency.model.enums;


public enum PurposeTransport {
    CARGO,
    PASSENGER,
    MIXED;

    public static PurposeTransport getPurposeTransport(Long i) {
        if (i == 1)
            return CARGO;
        if (i == 2)
            return PASSENGER;
        if (i == 3)
            return MIXED;
        return null;
    }
}
