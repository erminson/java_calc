package model;

import exception.TermInitializeCalculatorException;

public class BracketTerm extends Term {
    private BracketType bracketType;
    private String sign;

    public BracketTerm(final String sign) throws TermInitializeCalculatorException {
        super(TermType.Bracket);
        switch (sign) {
            case "(":
                this.bracketType = BracketType.Opening;
                break;
            case ")":
                this.bracketType = BracketType.Closing;
                break;
            default:
                throw new TermInitializeCalculatorException("BracketTerm. Invalid character: " + sign);
        }

        this.sign = sign;
    }

    public BracketTerm(BracketType bracketType) {
        super(TermType.Bracket);

        this.bracketType = bracketType;
        switch (bracketType) {
            case Opening:
                this.sign = "(";
                break;
            case Closing:
                this.sign = ")";
                break;
        }
    }

    public BracketType getBracketType() {
        return bracketType;
    }

    public String toString() {
        return sign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BracketTerm that = (BracketTerm) o;

        if (bracketType != that.bracketType) return false;
        return sign != null ? sign.equals(that.sign) : that.sign == null;
    }

    @Override
    public int hashCode() {
        int result = bracketType != null ? bracketType.hashCode() : 0;
        result = 31 * result + (sign != null ? sign.hashCode() : 0);
        return result;
    }
}