package fr.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Dessin {
    private List<Rectangle> formes = new ArrayList<>();
    
    /**
     * Ajoute une forme au dessin (polymorphisme)
     * @param r Rectangle ou SlantedRectangle
     */
    public void ajouter(Rectangle r) {
        if (r != null) {
            formes.add(r);
        }
    }
    
    /**
     * Calcule la surface totale
     * @return somme des surfaces
     */
    public double surfaceTotale() {
        return formes.stream()
                   .mapToDouble(Rectangle::surface)
                   .sum();
    }
    
    /**
     * Vérifie si un point est contenu dans une des formes
     * @param p Point à tester
     * @return vrai si contenu dans au moins une forme
     */
    public boolean contient(Point p) {
        return formes.stream()
                   .anyMatch(forme -> forme.contains(p));
    }
    
    /**
     * Calcule le rectangle englobant (hull)
     * @return Rectangle englobant minimum
     */
    public Rectangle hull() {
        if (formes.isEmpty()) {
            return new Rectangle(0, 0, 0, 0);
        }
        
        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;
        double maxY = Double.MIN_VALUE;
        
        for (Rectangle r : formes) {
            if (r instanceof SlantedRectangle) {
                SlantedRectangle sr = (SlantedRectangle) r;
                // Pour les rectangles inclinés, on prend les 4 coins transformés
                Point[] coins = getCoinsTransformes(sr);
                for (Point coin : coins) {
                    minX = Math.min(minX, coin.getX());
                    minY = Math.min(minY, coin.getY());
                    maxX = Math.max(maxX, coin.getX());
                    maxY = Math.max(maxY, coin.getY());
                }
            } else {
                // Pour les rectangles normaux
                minX = Math.min(minX, r.getX());
                minY = Math.min(minY, r.getY());
                maxX = Math.max(maxX, r.getX() + r.getWidth());
                maxY = Math.max(maxY, r.getY() + r.getHeight());
            }
        }
        
        return new Rectangle(minX, minY, maxX - minX, maxY - minY);
    }
    
    /**
     * Calcule les coins transformés d'un rectangle incliné
     */
    private Point[] getCoinsTransformes(SlantedRectangle sr) {
        double angleRad = Math.toRadians(sr.getAngle());
        double cos = Math.cos(angleRad);
        double sin = Math.sin(angleRad);
        
        double x = sr.getX();
        double y = sr.getY();
        double w = sr.getWidth();
        double h = sr.getHeight();
        
        Point[] coins = new Point[4];
        coins[0] = new Point(x, y); // Coin bas-gauche
        
        // Coin bas-droit
        coins[1] = new Point(
            x + w * cos,
            y + w * sin
        );
        
        // Coin haut-gauche
        coins[2] = new Point(
            x - h * sin,
            y + h * cos
        );
        
        // Coin haut-droit
        coins[3] = new Point(
            x + w * cos - h * sin,
            y + w * sin + h * cos
        );
        
        return coins;
    }
}