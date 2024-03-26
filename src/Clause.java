package src;

import java.util.HashSet;
import java.util.Set;

/**
 * A CNF from clause composites a series of literals
 **/
public class Clause {
    Set<Literal> literals = new HashSet<>();

    void add(Literal literal) {
        literals.add(literal);
    }

    void remove(Literal literal) {
        literals.remove(literal);
    }

    boolean contains(Literal literal) {
        return literals.contains(literal);
    }

    int size() {
        return literals.size();
    }

    Clause copy() {
        Clause clause = new Clause();
        for (Literal l : literals) clause.add(l);
        return clause;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Literal literal : literals) {
            sb.append(literal.toString());
            sb.append(" ");
        }
        if (sb.length() >= 1 && sb.charAt(sb.length() - 1) == ' ') sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return -1;
    }

    @Override
    public boolean equals(Object obj) {
        Clause c = (Clause) obj;
        if (this.size() != c.size()) return false;
        for (Literal l : this.literals) if (!c.contains(l)) return false;
        return true;
    }
}
