package src;

public class Literal {
    String value;
    Boolean negated;

    public Literal(String str) {
        this.negated = str.startsWith("~");
        this.value = str.startsWith("~") ? str.substring(1) : str;
    }

    private Literal(String value, boolean negated) {
        this.value = value;
        this.negated = negated;
    }

    public void negate() {
        this.negated = !this.negated;
    }

    public Literal negated() {
        return new Literal(this.value, !this.negated);
    }

    @Override
    public int hashCode() {
        return -1;
    }

    @Override
    public boolean equals(Object obj) {
        Literal l = (Literal) obj;
        return this.value.equals(l.value) && this.negated == l.negated;
    }

    @Override
    public String toString() {
        return (negated ? "~" : "") + value;
    }
}
