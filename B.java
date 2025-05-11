package fr.Rectangle;

public class B extends A {
    @Override
    public void f(A o) {
        System.out.println("void f(A o) dans B");
    }
    
    // Ajout pour l'exercice 9
    public void f(B o) {
        System.out.println("void f(B o) dans B");
    }
    
}