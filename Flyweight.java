import java.util.HashMap;
import java.util.Map;

interface ICharacter {
    void display(int row, int column);
}

class ConcreteCharacter implements ICharacter {
    private char symbol;
    
    public ConcreteCharacter(char symbol) {
        this.symbol = symbol;
    }
    
    @Override
    public void display(int row, int col) {
        System.out.println("Character: " + symbol + " at ( " + row + " , " + col + " ) ");
    }
}

class CharacterFactory {
    private Map<Character, ConcreteCharacter> pool = new HashMap<>();
    
    public ICharacter getCharacter(char symbol) {
        pool.putIfAbsent(symbol, new ConcreteCharacter(symbol));
        return pool.get(symbol);
    }
}

public class Main {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();
        String text = "aabba";
        int row = 1;
        
        for(int i=0; i<text.length(); i++) {
            char ch = text.charAt(i);
            ICharacter character = factory.getCharacter(ch);
            character.display(row, i);
        }
    }
}
