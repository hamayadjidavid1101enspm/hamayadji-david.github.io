package fr.Rectangle;

//Rectangle.java
public class Rectangle {
 protected double x;
 protected double y;
 protected double width;
 protected double height;

 public Rectangle(double x, double y, double width, double height) {
     if (width <= 0 || height <= 0) {
         throw new IllegalArgumentException("Dimensions must be positive");
     }
     this.x = x;
     this.y = y;
     this.width = width;
     this.height = height;
 }

 public Rectangle(Point p, double width, double height) {
     this(p.getX(), p.getY(), width, height);
 }

 public double area() {
     return width * height;
 }

 public double surface() {
     return area(); // alias pour surface()
 }

 public double perimeter() {
     return 2 * (width + height);
 }

 public void translate(double dx, double dy) {
     this.x += dx;
     this.y += dy;
 }

 public boolean contains(Point p) {
     return p.getX() >= this.x && p.getX() <= this.x + width &&
            p.getY() >= this.y && p.getY() <= this.y + height;
 }
 

 @Override
 public String toString() {
     return String.format("Rectangle[x=%.2f, y=%.2f, width=%.2f, height=%.2f]", 
                       x, y, width, height);
 }

 // Getters
 public double getX() { return x; }
 public double getY() { return y; }
 public double getWidth() { return width; }
 public double getHeight() { return height; }
}