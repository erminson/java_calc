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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LiteralTerm that = (LiteralTerm) o;

        return value != null ? value.equals(that.value) : that.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
