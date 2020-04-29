package priv.TzGin.liskovsubstitution.v1;

public class Test {

    public static void resize(Rectangle rectangle){
        while (rectangle.getWidth() >= rectangle.getHeight()){
            rectangle.setHeight(rectangle.getHeight() + 1);
            System.out.println("Height: " + rectangle.getHeight() + ",Width: " + rectangle.getWidth());
        }
        System.out.println("Resize End, Height: " + rectangle.getHeight() + ",Width: " + rectangle.getWidth());
    }

//    public static void main(String[] args) {
//        Rectangle rectangle = new Rectangle();
//        rectangle.setHeight(10);
//        rectangle.setWidth(20);
//        resize(rectangle);
//    }

    public static void main(String[] args) {
        Square square = new Square();
        square.setLength(15);
        resize(square);
    }
}
