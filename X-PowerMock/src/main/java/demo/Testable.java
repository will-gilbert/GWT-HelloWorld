package demo;

public class Testable {

    // Make these public so we can probe the instance easily
    public int a;
    public int b;
    public int c;

    public void a() {
        a++;
        b(a);
        c(new Integer(a), "Hello");
    }

    // Method parameter added to show how to use in tests
    public void b(int n) {
        b++; 
    }

    // Method parameters added to show how to use in tests
    private void c(Integer n, String string) {
        c++;  
    }

}
