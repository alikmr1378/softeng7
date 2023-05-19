first: loose coupling
![image](https://github.com/alikmr1378/softeng7/assets/87147901/380840c4-2cff-45b9-bf89-cbfbd73c91cb)
![image](https://github.com/alikmr1378/softeng7/assets/87147901/7021dbe9-afc7-4aa3-9281-8a3345902fc0)

second: 
Seperate Query from Modifier

در ابتدا تابع زیر را تغییر میدهیم تا برای انجام هر کار تابع جدا گانه داشته باشیم
تابع اولیه:

    public int getTemp() {
        lastTempIndex += tempSize;
        return lastTempIndex - tempSize;
    }
    
    بعد از تغییر:
    
        public int getLastTempIndex(){
        return lastTempIndex;
    }

    public void updateTemp(){
        lastTempIndex += tempSize;
    }
    
    در فایل کد جنریتور هم به جای خط زیر(هر جا که استفاده شده)با توجه به تابع های تعریف شده در بالا از دستور های جدید استفاده میکنیم.
    حالت اولیه:
    Address temp = new Address(memory.getTemp(), t);
بعد از تغییر:

    Address temp = new Address(memory.getLastTempIndex(), t);
    memory.updateTemp();

Third: 
Self Encapsulated field

برای هر متغیر تابع set و get خود را بذاریم. برای مثلا برای متغیر num در کلاس address این کار را انجام می دهیم:
قبل از تغییر:

public int num;

بعد از تغییر:

    private int num;
    public int getnum(){
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

حالا هر جایی که از متغیر num استفاده کرده ایم را به جای آنکه مستقیم خود آن را صدا بزنیم تابع getnum را صدا میزنیم و هر جایی که میخواستیم آن را مقدار دهی کنیم از setNum استفاده می کنیم.

![image](https://github.com/alikmr1378/softeng7/assets/87147901/88f27eb6-ce13-44ba-965f-bf49b68c5910)
همانطور که در تصویر بالا ملاحظه می شود پس از اعمال تغییرات پارامتر نام فقط در دو تابع getnum و setNum استفاده شده و بقیه جاها از این دو تابع استفاده کردیم.

Fourth:
Remove switch statements

حذف سوییچ کیس استفاده شده در کد:
قبل از تغییر:

        switch (s.type) {
            case Bool:
                t = varType.Bool;
                break;
            case Int:
                t = varType.Int;
                break;
        }
        
        بعد از تغییر:
        
        
        if (s.type.toString() == "Bool"){
            t = varType.Bool;
        }
        else if (s.type.toString() == "int") {
            t = varType.Int;
        }



