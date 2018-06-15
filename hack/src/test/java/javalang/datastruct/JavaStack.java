package javalang.datastruct;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JavaStack {

    private final Map<Character, Character> characterMap = new HashMap<Character, Character>(){{
        put(']','[');
        put('}','{');
        put(')','(');
    }};

    private final Set<Character> allowableClosingCharacters = characterMap.keySet();
    private final Set<Character> allowableOpeningCharacters = characterMap.values().stream().distinct().map(Character::new).collect(Collectors.toSet());

    @Test
    public final void test() {
        assertTrue(isBalanced("(){}()"));
        assertFalse(isBalanced(")){}()"));
        assertTrue(isBalanced("({()})"));
        assertFalse(isBalanced("{}("));
        assertTrue(isBalanced("[]"));
        assertTrue(true);
    }

    private boolean isBalanced(final String s) {
        final Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); ++i) {
            final Character character = s.charAt(i);

            if (isOpeningCharacter(character)) {
                stack.push(character);
            } else if (isClosingCharacter(character)) {
                final Character expectedTopOfStack = getMatchingOpeningCharacter(character);

                if (stack.isEmpty() || (stack.peek() != null && !stack.peek().equals(expectedTopOfStack))) {
                    return false;
                }
                stack.pop();

            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isOpeningCharacter(final Character character) {
        return allowableOpeningCharacters.contains(character);
    }

    private boolean isClosingCharacter(final Character character) {
        return allowableClosingCharacters.contains(character);
    }

    private Character getMatchingOpeningCharacter(final Character closingCharacter) {
       return characterMap.get(closingCharacter);
    }
}
