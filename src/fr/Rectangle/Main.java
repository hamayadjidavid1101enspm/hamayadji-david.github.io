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
    }
}
