package com.rimac.app.util;

public class ComandosScroll {
    private static final String UI_SELECTOR_TEXT_VERTICAL_SCROLL_VIEW_CONTAINS = "new UiScrollable(new UiSelector().scrollable(true).className(\"android.widget.ScrollView\").instance(0)).scrollIntoView(new UiSelector().textContains(\"%s\").instance(0))";
    private static final String UI_SELECTOR_TEXT_HORIZONTAL = "new UiScrollable(new UiSelector().scrollable(true).className(\"androidx.recyclerview.widget.RecyclerView\")).setAsHorizontalList().scrollIntoView(new UiSelector().textContains(\"%s\").instance(0))";
    private static final String UI_SELECTOR_TEXT_VERTICAL_RECYCLER_VIEW = "new UiScrollable(new UiSelector().scrollable(true).className(\"androidx.recyclerview.widget.RecyclerView\").instance(0)).scrollIntoView(new UiSelector().textContains(\"%s\").instance(0))";
    private static final String UI_SELECTOR_TEXT_VERTICAL_SCROLL_VIEW_CONTAINS_EXACT = "new UiScrollable(new UiSelector().scrollable(true).className(\"android.widget.ScrollView\").instance(0)).scrollIntoView(new UiSelector().text(\"%s\").instance(0))";
    private static final String UI_SELECTOR_TEXT_VERTICAL_TEXT_VIEW = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().className(\"android.widget.TextView\").textContains(\"%s\").instance(0))";
    private static final String UI_SELECTOR_YEAR_VERTICAL = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\"android:id/text1\").text(\"%s\").instance(0))";
    private static final String UI_SELECTOR_DAY_VERTICAL = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().className(\"android.view.View\").text(\"%s\").instance(0))";
    private static final String UI_SELECTOR_FECHA_VERTICAL = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().className(\"android.widget.ListView\")..textContains(\"%s\").instance(0))";
    private static final String UI_SELECTOR_PLACE_VERTICAL = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollForward(10).scrollIntoView(new UiSelector().textContains(\"%s\").instance(0))";
    private static final String UI_SELECTOR_TEXT_VERTICAL = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"%s\").textContains(\"%s\").instance(0))";

    private ComandosScroll() {
        throw new IllegalStateException("Error en ComandosScroll");
    }

    public static String uiSelectorTextoHorizontal() {
        return "new UiScrollable(new UiSelector().scrollable(true).className(\"androidx.recyclerview.widget.RecyclerView\")).setAsHorizontalList().scrollIntoView(new UiSelector().textContains(\"%s\").instance(0))";
    }

    public static String uiSelectorTextoVerticalScrollView() {
        return "new UiScrollable(new UiSelector().scrollable(true).className(\"android.widget.ScrollView\").instance(0)).scrollIntoView(new UiSelector().textContains(\"%s\").instance(0))";
    }

    public static String uiSelectorTextoVerticalRecyclerView() {
        return "new UiScrollable(new UiSelector().scrollable(true).className(\"androidx.recyclerview.widget.RecyclerView\").instance(0)).scrollIntoView(new UiSelector().textContains(\"%s\").instance(0))";
    }

    public static String uiSelectorTextoVerticalScrollViewContainsExact() {
        return "new UiScrollable(new UiSelector().scrollable(true).className(\"android.widget.ScrollView\").instance(0)).scrollIntoView(new UiSelector().text(\"%s\").instance(0))";
    }

    public static String uiSelectorTextoVerticalTextView() {
        return "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().className(\"android.widget.TextView\").textContains(\"%s\").instance(0))";
    }

    public static String uiSelectorYearVertical() {
        return "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\"android:id/text1\").text(\"%s\").instance(0))";
    }

    public static String uiSelectorFechaVertical() {
        return "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().className(\"android.widget.ListView\")..textContains(\"%s\").instance(0))";
    }

    public static String uiSelectorPlaceVertical() {
        return "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollForward(10).scrollIntoView(new UiSelector().textContains(\"%s\").instance(0))";
    }

    public static String uiSelectorDayVertical() {
        return "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().className(\"android.view.View\").text(\"%s\").instance(0))";
    }

    public static String getUiSelectorTextoVertical() {
        return "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"%s\").textContains(\"%s\").instance(0))";
    }
}
