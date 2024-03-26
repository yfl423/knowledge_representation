package src;

import java.io.File;
import java.util.*;

public class Core {
    String path;
    int cnt = 1;
    List<Clause> kb = new ArrayList<>();
    Set<Clause> added = new HashSet<>();

    public Core(String path) {
        this.path = path;
    }

    public void run() {
        constructKB();
        resolution();
    }

    // Read .kb file, parse each line to populate KB, and negate the test clause, make KB prepared for resolution
    private List<Clause> constructKB() {
        File file = new File(path);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] strings = line.split(" ");
                boolean lastOne = !scanner.hasNextLine();
                if (lastOne) {
                    for (String s : strings) {
                        Literal literal = new Literal(s);
                        literal.negate();
                        Clause clause = new Clause();
                        clause.add(literal);
                        if (added.contains(clause)) continue;
                        kb.add(clause);
                        added.add(clause);
                        System.out.println(cnt++ + ". " + clause + " {}");
                    }
                } else {
                    Clause clause = new Clause();
                    for (String s : strings) {
                        Literal literal = new Literal(s);
                        clause.add(literal);
                    }
                    if (added.contains(clause)) continue;
                    kb.add(clause);
                    added.add(clause);
                    System.out.println(cnt++ + ". " + clause + " {}");
                }
            }
        } catch (Exception e) {
            System.err.println("File is failed to parse: " + e.getMessage());
        }
        if (scanner != null) scanner.close();
        return kb;
    }

    // Implement resolution algorithm
    private void resolution() {
        List<Clause> newClauses = new ArrayList<>();
        do {
            kb.addAll(newClauses);
            newClauses.clear();
            for (int i = 1; i < kb.size(); i++) {
                for (int j = 0; j < i; j++) {
                    Clause clause = resolute(kb.get(i), kb.get(j));
                    if (clause == null) continue;
                    if (clause.size() == 0) { // Find empty clause
                        System.out.println(cnt++ + ". Contradiction {" + (i + 1) + ", " + (j + 1) + "}");
                        System.out.println("Valid");
                        return;
                    }
                    if (!added.contains(clause)) {
                        added.add(clause);
                        newClauses.add(clause);
                        System.out.println(cnt++ + ". " + clause + " {" + (i + 1) + ", " + (j + 1) + "}");
                    }
                }
            }

        } while (newClauses.size() > 0);
        System.out.println("Fail");
    }

    private Clause resolute(Clause c1, Clause c2) {
        Clause c = null;
        for (Literal l1 : c1.literals)
            if (c2.literals.contains(l1.negated())) {
                c = new Clause();
                for (Literal l : c1.literals) {
                    if (l.equals(l1)) continue;
                    if (c.contains(l.negated())) return null;
                    c.add(l);
                }
                for (Literal l : c2.literals) {
                    if (l.equals(l1.negated())) continue;
                    if (c.contains(l.negated())) return null;
                    c.add(l);
                }
            }
        return c;
    }
}
