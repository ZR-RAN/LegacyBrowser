<h1>Legacy Browser</h1>

Based on the bundled browser of the AOSP until android 6, with changes to avoid package name and provider names conflicts with bundled packages on modern Android.

To build this project, a modified android.jar with hidden apis included is needed.

On some OSs (e.g. the AOSP), the installation fails with the following error:
```
Installation failed due to: 'INSTALL_FAILED_CONFLICTING_PROVIDER: Scanning Failed.: Can't install because provider name browser (in package com.example.browser) is already used by com.android.bookmarkprovider'
```

If so, delete `;browser` from `android:authorities` in the `AndroidManifest.xml`.

```xml
<provider android:name=".provider.BrowserProvider2"
    android:authorities="com.example.browser;browser"
    android:multiprocess="false"
    android:exported="true"
    android:readPermission="com.example.browser.permission.READ_HISTORY_BOOKMARKS"
    android:writePermission="com.example.browser.permission.WRITE_HISTORY_BOOKMARKS">
    <path-permission android:path="/bookmarks/search_suggest_query"
        android:readPermission="android.permission.GLOBAL_SEARCH" />
</provider>
```