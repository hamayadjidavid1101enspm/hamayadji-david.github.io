package fr.Rectangle;

//SlantedRectangle.java
public class SlantedRectangle extends Rectangle {
 private double angle; // angle en degrés

 public SlantedRectangle(double x, double y, double width, double height, double angle) {
     super(x, y, width, height);
     this.angle = normalizeAngle(angle);
 }

 public SlantedRectangle(Point p, double width, double height) {
     this(p.getX(), p.getY(), width, height, 0);
 }

 public SlantedRectangle(Point p, double width, double height, double angle) {
     this(p.getX(), p.getY(), width, height, angle);
 }

 public void rotate(double deltaAngle) {
     this.angle = normalizeAngle(this.angle + deltaAngle);
 }

 private double normalizeAngle(double angle) {
     angle = angle % 360;
     return angle < 0 ? angle + 360 : angle;
 }

 @Override
 public boolean contains(Point p) {
     // Version simplifiée (ne tient pas compte de la rotation)
     // Pour une vraie implémentation, il faudrait transformer les coordonnées
     return super.contains(p);
 }

 @Override
 public String toString() {
     return String.format("SlantedRectangle[x=%.2f, y=%.2f, width=%.2f, height=%.2f, angle=%.2f°]", 
                        x, y, width, height, angle);
 }

 public double getAngle() {
     return angle;
 }
}
