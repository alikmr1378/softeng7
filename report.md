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
