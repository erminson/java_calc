package view;

import java.math.BigDecimal;

public interface IView {
    String readExpression();
    void printResult(BigDecimal result);
}
