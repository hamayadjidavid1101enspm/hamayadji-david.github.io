package fr.Rectangle;

public class Main {
    public static void main(String[] args) {
        // Test Exercice 1
        SlantedRectangle rect1 = new SlantedRectangle(10, 10, 30, 20, 45);
        System.out.println(rect1); // Utilise toString() redéfini
        
        // Test Exercice 2
        rect1.rotate(30);
        System.out.println("Après rotation de 30°: " + rect1);
        
        rect1.rotate(-90);
        System.out.println("Après rotation de -90°: " + rect1);
        
        // Test Exercice 3
        System.out.println("\nMéthodes héritées:");
        System.out.println("Aire: " + rect1.area()); // Hérité de Rectangle
        System.out.println("Périmètre: " + rect1.perimeter()); // Hérité de Rectangle
        
        rect1.translate(5, -3); // Méthode translate() redéfinie mais comportement identique
        System.out.println("Après translation: " + rect1);
        
        // Test constructeur par défaut (angle=0)
        SlantedRectangle rect2 = new SlantedRectangle(0, 0, 10, 5,5);
        System.out.println("\nRectangle sans inclinaison: " + rect2);
        
        Point p = new Point(1, 2);
        Rectangle r = new Rectangle(p, 2, 3);
        Rectangle t = new SlantedRectangle(p, 2, 3);
        SlantedRectangle s = new SlantedRectangle(p, 2, 3);
        
        /*
        System.out.println(r.surface()); 
        r.rotate(2); 
        System.out.println(r.contains(p));
        	//Ne complile pas car rotate() n'est pas definie dans Rectangle
        */ 
        /*
        System.out.println(t.surface()); 
        t.rotate(2); 
        System.out.println(t.contains(p)); 
        //Ne compile pas car t est de type Rectangle a la compilation
         */
        
        System.out.println(s.surface()); 
        s.rotate(2); 
        System.out.println(s.contains(p));
        
    
    System.out.println("=== Exercice 8 - Analyse d'appels ===");
    

    // Analyse des appels
    System.out.println("\n1. Appels sur Rectangle r:");
    System.out.println("r.surface(): " + r.surface()); // Rectangle.surface()
    // r.rotate(2); // Ne compile pas (commenté pour l'exemple)
    System.out.println("r.contains(p): " + r.contains(p)); // Rectangle.contains()

    System.out.println("\n2. Appels sur Rectangle t (réellement SlantedRectangle):");
    System.out.println("t.surface(): " + t.surface()); // Rectangle.surface() (héritée)
    // t.rotate(2); // Ne compile pas (commenté pour l'exemple)
    System.out.println("t.contains(p): " + t.contains(p)); // Appelle Rectangle.contains() 
    System.out.println("\n3. Appels sur SlantedRectangle s:");
    System.out.println("s.surface(): " + s.surface()); // Rectangle.surface() (héritée)
    s.rotate(2); // SlantedRectangle.rotate()
    System.out.println("s.contains(p): " + s.contains(p)); // SlantedRectangle.contains()
    
    System.out.println("\n=== Explications ===");
    System.out.println("1. r.rotate(2) ne compile pas car rotate() n'existe pas dans Rectangle");
    System.out.println("2. t.rotate(2) ne compile pas car le type à la compilation est Rectangle");
    System.out.println("3. t.contains(p) appelle Rectangle.contains() car le type à la compilation est Rectangle");

   
        System.out.println("\n=== Exercice 9 - Surcharge dans B ===");
        
        A a = new A();
        A ab = new B();
        B b = new B();
        
        System.out.println("\n1. Appels sur A a:");
        a.f(a);  // void f(A o) dans A
        a.f(ab); // void f(A o) dans A
        a.f(b);  // void f(A o) dans A

        System.out.println("\n2. Appels sur A ab (réellement B):");
        ab.f(a);  // void f(A o) dans B
        ab.f(ab); // void f(A o) dans B
        ab.f(b);  // void f(A o) dans B
        
        System.out.println("\n3. Appels sur B b:");
        b.f(a);  // void f(A o) dans B
        b.f(ab); // void f(A o) dans B
        b.f(b);  // void f(B o) dans B (nouvelle méthode)
        
        System.out.println("\n=== Explications ===");
        System.out.println("La méthode f(B o) dans B est une surcharge (overload)");
        System.out.println("Elle ne remplace pas f(A o) mais coexiste avec elle");
        System.out.println("Le choix de la méthode se fait à la compilation en fonction du type déclaré");
        
        C c = new C();// Exercice 13
        C cd = new D();
        D d = new D();
        
        System.out.println(c.ch);         // Affiche 'C' (attribut de C)
        System.out.println(c.getCh());    // Affiche 'C' (méthode de C)
        System.out.println(cd.ch);        // Affiche 'C' (attribut de C - masqué)
        System.out.println(cd.getCh());   // Affiche 'D' (méthode redéfinie dans D)
        System.out.println(d.ch);         // Affiche 'D' (attribut de D)
        System.out.println(d.getCh());    // Affiche 'D' (méthode de D)
    }
}
