package cl.uchile.dcc.scrabble.type;

import java.util.Objects;

public class ScrabbleInt extends AbstractType implements INumber {

    private int value;

    public ScrabbleInt(int i) {
        this.value = i;
    }

    public int getValue() { return value; }

    @Override
    public String toString() {
        return String.valueOf(this.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScrabbleInt.class, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScrabbleInt) {
            var o = (ScrabbleInt) obj;
            return this.getValue() == o.getValue();
        }
        return false;
    }

    public ScrabbleFloat toScrabbleFloat() {
        return new ScrabbleFloat(Double.parseDouble(this.toString()));
    }

    public ScrabbleInt toScrabbleInt() {
        return new ScrabbleInt(this.getValue());
    }

    public ScrabbleBinary toScrabbleBinary() {
        int num = Math.abs(this.getValue());
        String binary = positiveIntToBinary(num);
        if (this.getValue() < 0) {
            binary = TwosComplement(binary);
        }
        return new ScrabbleBinary(binary);
    }

    private String TwosComplement(String binary) {
        binary = binary.replaceAll("0", "x");
        binary = binary.replaceAll("1", "0");
        binary = binary.replaceAll("x", "1");
        int i = 63;   // 64 bits
        while (binary.charAt(i) == '1') { i--; }
        String ans = binary.substring(0, i) + "1";
        if (i == 63) {
            return ans;
        } else {
            return ans + String.format("%0" + String.valueOf(63 - i) + "d", 0);
        }
    }

    private String positiveIntToBinary(int num) {
        String ans = Integer.toBinaryString(num);
        return String.format("%064d", Integer.parseInt(ans));
    }

}
