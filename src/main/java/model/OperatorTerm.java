package model;

public class OperatorTerm extends Term {
    private OperatorType operatorType;

    public OperatorTerm(OperatorType operatorType) {
        super(TermType.Operator);
        this.operatorType = operatorType;
    }

    public OperatorType getOperatorType() {
        return operatorType;
    }

    @Override
    public String toString() {
        return operatorType.toString();
    }
}
