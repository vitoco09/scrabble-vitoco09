package cl.uchile.dcc.scrabble.type;

import java.util.Objects;

public class ScrabbleBinary extends AbstractType implements INumber {

    private String value;

    public ScrabbleBinary(String binary) {
        this.value = binary;
    }

    public String getValue() { return value; }

    @Override
    public String toString() {
        return this.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScrabbleFloat.class, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScrabbleBinary) {
            var o = (ScrabbleBinary) obj;
            return this.getValue().equals(o.getValue());
        }
        return false;
    }

    public ScrabbleFloat toScrabbleFloat() {
        long binary = Long.parseLong(this.getValue());
        double ans = Double.longBitsToDouble(binary);
        return new ScrabbleFloat(ans);
    }

    public ScrabbleInt toScrabbleInt() {
        if (bitToInt(this.getValue().charAt(0)) == 0) {
            return new ScrabbleInt(positiveBinaryToInt(this.getValue()));
        } else {
            return new ScrabbleInt(negativeBinaryToInt(this.getValue()));
        }
    }

    private int bitToInt(char charAt) {
        return charAt == '0' ? 0 : 1;
    }

    private int negativeBinaryToInt(String value) {
        value = inverseTwosComponent(value);
        return -positiveBinaryToInt(value);
    }

    private int positiveBinaryToInt(String value) {
        return Integer.parseInt(value, 2);
    }

    private String inverseTwosComponent(String binary) {
        int i = 63;   // 64 bits
        String one = "1";
        while (binary.charAt(i) == '0') { i--; }
        String ans = binary.substring(0, i) + '0';
        ans = ans + one.repeat(63-i);
        ans = ans.replaceAll("0", "x");
        ans = ans.replaceAll("1", "0");
        ans = ans.replaceAll("x", "1");
        return ans;
    }

    public ScrabbleBinary toScrabbleBinary() {
        return new ScrabbleBinary(this.getValue());
    }

}
