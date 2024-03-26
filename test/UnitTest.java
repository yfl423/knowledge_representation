package test;

import org.testng.annotations.Test;
import src.Core;

@Test
public class UnitTest {
    @Test
    public void TestDEMO() {
        Core core = new Core("test/demo.in");
        core.run();
    }

    @Test
    public void TestTask1() {
        Core core = new Core("test/task1.in");
        core.run();
    }

    @Test
    public void TestTask3() {
        Core core = new Core("test/task3.in");
        core.run();;
    }

    @Test
    public void TestTask6() {
        Core core = new Core("test/task6.in");
        core.run();
    }

    @Test
    public void TestTask7() {
        Core core = new Core("test/task7.in");
        core.run();
    }
}
