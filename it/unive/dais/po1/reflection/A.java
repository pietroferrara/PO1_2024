package it.unive.dais.po1.reflection;

public class A  extends B {

    public final int i = 10;

    public void publicfoo() {
        System.out.println("invoked public!");
    }

    @Override
    public void foo() {

    }

    protected void protectedfoo() {
        System.out.println("invoked protected!");}

    private void privatefoo() {
        System.out.println("invoked private!");}
}
