package com.example.browser;

import android.util.EventLog;

public class EventLogTags {
    public static final int BROWSER_BOOKMARK_ADDED = 70103;
    public static final int BROWSER_PAGE_LOADED = 70104;
    public static final int BROWSER_TIMEONPAGE = 70105;

    private EventLogTags() {
    }

    public static void writeBrowserBookmarkAdded(String url, String where) {
        EventLog.writeEvent(70103, new Object[]{url, where});
    }

    public static void writeBrowserPageLoaded(String url, long time) {
        EventLog.writeEvent(70104, new Object[]{url, time});
    }

    public static void writeBrowserTimeonpage(String url, long time) {
        EventLog.writeEvent(70105, new Object[]{url, time});
    }
}