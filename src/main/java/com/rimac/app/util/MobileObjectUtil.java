package com.rimac.app.util;

public class MobileObjectUtil {

    private static MobileObjectUtil obj = null;

    private MobileObjectUtil() {
    }


    public static MobileObjectUtil getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new MobileObjectUtil();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

}
