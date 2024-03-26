import src.Core;

public class Main {
    public static void main(String[] args) {
        if (args == null || args.length != 1) throw new RuntimeException("Args format: <path_to_kb_file>..");
        Core core = new Core(args[0]);
        core.run();
    }
}


