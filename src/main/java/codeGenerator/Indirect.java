package codeGenerator;

public class Indirect extends TypeAddress{
    @Override
    public String toString(int num) {
        return "@" + num;
    }
}
