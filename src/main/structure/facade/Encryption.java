package structure.facade;

public class Encryption {

    public String encrypt(String data){
        char[] chars = data.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char c:chars) {
            Integer t = c+1;
            builder.append((char) t.intValue());
        }
        return builder.toString();
    }

    public String decrypt(String data){
        char[] chars = data.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char c:chars) {
            Integer t = c-1;
            builder.append((char) t.intValue());
        }
        return builder.toString();
    }

}
