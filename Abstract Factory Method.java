interface Button {
    void paint();
}

interface CheckBox {
    void paint();
}

class WindowsButton implements Button {
    public void paint() {
        System.out.println("Render a button in windows style");
    }
}

class MacButton implements Button {
    public void paint() {
        System.out.println("Render a button in mac style");
    }
}

class WindowsCheckBox implements CheckBox {
    public void paint() {
        System.out.println("Render a CheckBox in windows style");
    }
}

class MacCheckBox implements CheckBox {
    public void paint() {
        System.out.println("Render a CheckBox in mac style");
    }
}

interface GUIFactory {
    Button createButton();
    CheckBox createCheckBox();
}

class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
    
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}

class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }
    
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}

public class Main {
    public static void main(String[] args) {
        
        GUIFactory factory;
        
        String osName = "Mac";
        if(osName.equalsIgnoreCase("windows")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }
        
        Button button = factory.createButton();
        CheckBox checkBox = factory.createCheckBox();
        
        button.paint();
        checkBox.paint();
    }
}
