<div aling="center">
    
    </br><b>Intent-Filter</b> es un sistema de Android para recibir contenido de otras Apps como enlaces o archivos, en este proyecto te muestro a implementarlo y usarlo correctamente.
    </br> </br>
    <img src="./Preview/logo.png" width=150 title="Screen">
</div>


## Vista Previa
<img src="./Preview/preview1.gif" width=300 title="Screen">

## Inicio

Importa el código XML en el AndroidManifest de tú proyecto, en el caso de querer recibir archivos o textos:
```xml
/*Tipos: "image/*" "video/*" "text/plain" "application/pdf"*/
<intent-filter android:label="IMG">
        <action android:name="android.intent.action.SEND" />
        <category android:name="android.intent.category.DEFAULT" />
        <data android:mimeType="image/*" />
    </intent-filter>
```
En el caso de querer abrir enlaces con un Host específico como un navegador ingresa el siguiente código:
```xml
<intent-filter android:autoVerify="true">
<action android:name="android.intent.action.VIEW" />
<action android:name="arash.android11.LAUNCH" />
<category android:name="android.intent.category.DEFAULT" />
<category android:name="android.intent.category.BROWSABLE" />
<data android:scheme="http" />
<data android:scheme="https" />
<data android:host="intentfilter.com" />
</intent-filter>
```

## Recive Los Datos Enviados

Obten los datos de Archivos o Textos:
```java
private String Action ="";
private String Type ="";
private Uri uri;

private Intent in = new Intent();


//En el caso de recibir otro tipo de Archivo cambia "image/*"
   Intent in = getIntent();
        String Action = in.getAction();
            String Type = in.getType();
if (in.ACTION_SEND.equals(Action) && Type != null) {
	if (Type.startsWith("image/*")) {
		    Uri uri = (Uri) in.getParcelableExtra(Intent.EXTRA_STREAM);
	}
	if (Type.startsWith("text/plain")) {
		textview1.setText(in.getStringExtra(Intent.EXTRA_TEXT));
	}
}
try {
		if (!getIntent().getDataString().isEmpty()) {
				textview2.setText(getIntent().getDataString());
		}
} catch ( Exception e){
		      
}
```

Obten los enlaces abiertos:

```java
try {
		if (!getIntent().getDataString().isEmpty()) {
				textview2.setText(getIntent().getDataString());
		}
} catch ( Exception e){
		      
}
```
¡Con esto tú proyecto sera capaz de utilizar estos 2 tipos de Intent-Filter!

## Otras Funciones

Estas son algunas funciones que te serviarn para complementar tú proyecto con Intent-Filter:
```java
//Uri a String
uri.toString()

//Reproducir VideoView desde Uri
videoview1.setVideoURI(Uri.parse(uri.toString()));
```
