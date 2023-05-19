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


Fifth:

Replace Conditional with Polymorphism

در این قسمت نیاز داریم تعدادی کلاس جدید تعریف کنیم تا به جای سوییچ کیس بتوانیم از آن ها استفاده کنیم.

کلاس TypeAddress را مانند زیر تغییر میدهیم :
![image](https://github.com/alikmr1378/softeng7/assets/87147901/b54c3e23-1924-4ef5-961e-39293bdfc74c)



کلاس هایی که ایجاد شده اند:

![image](https://github.com/alikmr1378/softeng7/assets/87147901/907c6b26-984f-4651-9864-52c315244c65)
همینطور برای Indirect و Imidiate.
سپس مشکلاتی که بر اساس این تغییر در کد ها به وجود آمده را اعمال می کنیم تا کد دوباره قابل اجرا شود.
برای مثال: کد قبلی :


        switch (Type) {
            case Direct:
                return getnum() + "";
            case Indirect:
                return "@" + getnum();
            case Imidiate:
                return "#" + getnum();
        }
        return getnum() + "";


بعد از تغییر:

        return Type.toString(num);


در دیگر جاهای کد هم برای مثلا به جای هر کدام از Typeaddress.Direct از new Direct() استفاده میکنیم.


Sixth and Seventh:
Facade

کلاس های MemoryFacade و CodeGeneratorFacade را اضافه میکنیم.

![image](https://github.com/alikmr1378/softeng7/assets/87147901/e8786480-dd75-49c2-be8a-c8eddb59d917)
![image](https://github.com/alikmr1378/softeng7/assets/87147901/ae7fc80b-edb9-4860-ae9f-278825ba1d1f)


questions:

سوال اول

1. کد تمیز :

به مجموعه قوانینی می گویند که باعث می شود کدی که مینویسیم بعدا هم برای خودمان و هم برای دیگران قابل استفاده و اصلاح باشد. در کار تیمی رعایت این قوانین بسیار مهم می شود.

2. بدهی فنی:

برنامه نویس یک کار را به صورت غیر اصولی انجام می دهد تا بتواند زودتر به نتیجه برسد در این حال موظف است بعدا آن کار را به صورت درست انجام دهد.

3. بوی بد:

بوی کد زمانی اتفاق می افتد که برنامه نویس از اصول درست برای برنامه نویسی استفاده نمیکند و باعث ایجاد مشکل در کد می شود.

سوال دوم

1. bloaters

کلاس هایی که با گذشت زمان بسیار طولانی و پیچیده میشوند و تغییر دادن آن ها در طول زمان مدام سخت تر می شود.

2. Object-Orientation Abusers

کاربرد اشتباه از برنامه نویسی آبجکت ارینتد مانند سوییچ کیس ها.

3.  Change Preventers

قسمت هایی که برای تغییر دادن آن ها باید قسمت هایی زیادی را تغییر دهیم و زمان زیادی از ما می گیرد انجام یک تغییر در آن ها.

4. Dispensables

چیزهایی که بودن آن ها به کد کمکی نمیکند و بودنشان فقط باعث شلوغ شدن و طولانی شدن کد می شود.

5. Couplers

این دسته از بو ها درباره وابستگی بیش از حد بین کلاس های متفاوت است.

سوال سوم

1. در دسته Dispensables قرار دارد.

2. قطعات بی فایده را می توان با استفاده از روش Inline برطرف کرد و برای برطرف کردن کلاس هایی با توابع کم می توان از Collapse Hierarchy استفاده کرد.

3. گاهی اوقات هدف از ایجاد این کلاس ها این است که در آینده بتوانیم کدمان را تمیز نگه داریم و در این صورت نیازی نیست که آن را حذف کنیم.

 




