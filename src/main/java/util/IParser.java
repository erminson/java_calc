package util;

import exception.ParseCalculatorException;
import exception.TermInitializeCalculatorException;
import model.Term;

import java.util.List;

public interface IParser {
    public List<Term> parse(final String expr) throws ParseCalculatorException, TermInitializeCalculatorException;
}
