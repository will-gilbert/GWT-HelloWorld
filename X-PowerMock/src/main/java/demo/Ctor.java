package demo;

public class Ctor {

    // Make these public so we can probe the instance easily to verify the testing logic
    public int a;
    public int b;
    public int c;

    public Ctor() {
        a();
    }

    public void a() {
        a++;
        b(a);
        c(new Integer(a), "Hello");
    }

    // Method parameter added to show how to specify in tests to choose the intended method
    public void b(int n) {
        b++; 
    }

    public void b() {
        b++; 
    }

    // Method parameters added to show how to specify in to choose the intended method
    private void c(Integer n, String string) {
        c++;  
    }

    private void c() {
        c++;  
    }

}
