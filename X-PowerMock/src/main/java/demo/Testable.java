package demo;

public class Testable {

    // Make these public so we can probe the instance easily
    public int a;
    public int b;
    public int c;

    public void a() {
        a++;
        b();
        c();
    }

    public void b() {
        b++; 
    }

    private void c() {
        c++;  
    }

}
