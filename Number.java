public enum Number { C(100),XC(90),L(50),XL(40),X(10),IX(9),VIII(8),VII(7),VI(6),V(5),IV(4),III(3),II(2),I(1);
    static String itogRome="";
    private final int translations;
    Number(int translations) {
        this.translations=translations;
    }

    public static boolean isRome(String strArray) {
        for (Number x: values()){
            if (x.name().equals(strArray)){
                return true;
            }
        }
        return false;
    }



    public int getTranslations() {
        return translations;
    }
    public static String toRome(int itog) {
        if (itog> 0) {
            for (Number x : values()) {
                while (x.translations <= itog) {
                    itogRome = itogRome + x;
                    itog = itog - x.translations;
                }
            }
        } else {itogRome = itogRome + "O";}
        return itogRome;
    }
}
