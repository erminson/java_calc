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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperatorTerm that = (OperatorTerm) o;

        return operatorType == that.operatorType;
    }

    @Override
    public int hashCode() {
        return operatorType != null ? operatorType.hashCode() : 0;
    }

    @Override
    public String toString() {
        return operatorType.toString();
    }
}
