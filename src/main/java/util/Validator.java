package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator implements IValidator {
    @Override
    public boolean isValid(final String expr) {
        final String exprWithoutBraces = expr.replaceAll("(\\(|\\))", "");
        final String exprWithoutWhiteSpaces = exprWithoutBraces.replaceAll(" ", "").trim();
        Pattern pattern = Pattern.compile("([-+]?[0-9]*\\.?[0-9]+[\\/\\+\\-\\*])+([-+]?[0-9]*\\.?[0-9]+)");
        Matcher matcher = pattern.matcher(exprWithoutWhiteSpaces);

        return matcher.matches();
    }
}
