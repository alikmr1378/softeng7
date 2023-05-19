package codeGenerator;

/**
 * Created by mohammad hosein on 6/28/2015.
 */

public class Address {
    private int num;
    public TypeAddress Type;
    public varType varType;

    public int getnum(){
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    public Address(int num, varType varType, TypeAddress Type) {
        this.setNum(num);
        this.Type = Type;
        this.varType = varType;
    }

    public Address(int num, varType varType) {
        this.setNum(num);
        this.Type = TypeAddress.Direct;
        this.varType = varType;
    }

    public String toString() {
        switch (Type) {
            case Direct:
                return getnum() + "";
            case Indirect:
                return "@" + getnum();
            case Imidiate:
                return "#" + getnum();
        }
        return getnum() + "";
    }
}
