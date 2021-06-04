package model;

import java.util.Comparator;

public enum OperatorType implements Comparator<OperatorType> {
    Addition(1),
    Subtraction(1),
    Multiplication(2),
    Division(2);

    OperatorType(int priority) {
        this.priority = priority;
    }

    private final int priority;

    public int getPriority() {
        return priority;
    }

    @Override
    public int compare(OperatorType o1, OperatorType o2) {
        return o1.priority - o2.priority;
    }

    @Override
    public String toString() {
        String sign = "";
        switch (this) {
            case Addition:
                sign = "+";
                break;
            case Subtraction:
                sign = "-";
                break;
            case Multiplication:
                sign = "*";
                break;
            case Division:
                sign = "/";
                break;
        }

        return sign;
    }
}
