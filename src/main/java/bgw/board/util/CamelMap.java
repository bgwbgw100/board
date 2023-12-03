package bgw.board.util;

import java.util.HashMap;

public class CamelMap<K extends String,V> extends HashMap<K,V>{
    @Override
    public V put(K key, V value) {
        StringBuilder sb = new StringBuilder();
        boolean convertFlag =false;
        for (char ch: key.toCharArray() ) {
            if(ch == '_'){
                convertFlag = true;
                continue;
            }
            if(convertFlag){
                sb.append(Character.toUpperCase(ch));
                convertFlag = false;
            }else {
                sb.append(Character.toLowerCase(ch));
            }

        }
        K result = (K)sb.toString();

        return super.put(result, value);
    }
}
