package model;

import java.math.BigDecimal;

public class LiteralTerm extends Term {
    private final BigDecimal value;

    public LiteralTerm(BigDecimal value) {
        super(TermType.Literal);
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
