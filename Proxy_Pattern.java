interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;
    
    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }
    
    private void loadFromDisk() {
        System.out.println("Loading image from disk: " + filename);
    }
    
    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;
    
    public ProxyImage(String filename)
    {
        this.filename = filename;
    }
    
    @Override
    public void display() {
        if(realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
    
}

public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("Pic1.jpg");
        Image image2 = new ProxyImage("Pic2.jpg");
        
        System.out.println("Frist time accessing pic1:");
        image1.display();
        System.out.println("\nSecond time accessing pic2:");
        image1.display();
        System.out.println("\nThird time accessing pic3:");
        image2.display();
    }
}



