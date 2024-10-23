## Intala El XML

Importa en AndroidManifest
```xml
<intent-filter android:label="IMG">
        <action android:name="android.intent.action.SEND" />
        <category android:name="android.intent.category.DEFAULT" />
        <data android:mimeType="image/*" />
    </intent-filter>
```
