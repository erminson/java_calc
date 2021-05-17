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

    public BracketType getBracketType() {
        return bracketType;
    }

    public String toString() {
        return sign;
    }
}