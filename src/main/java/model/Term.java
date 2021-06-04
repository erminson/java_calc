package model;



public abstract class Term {
    private final TermType type;

    public Term(final TermType type) {
        this.type = type;
    }

    public TermType getType() {
        return type;
    }
}
