# CodeView
CodeView extended from ScrollView

[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)
[![](https://jitpack.io/v/asdfghjkkl11/CodeView.svg)](https://jitpack.io/#asdfghjkkl11/CodeView)

## How to import
Add it in your root build.gradle
```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Add the dependency
```gradle
dependencies {
	implementation 'com.github.asdfghjkkl11:CodeView:0.2'
}
```

## Usage
1. add codeview on your activity
```xml
<com.asd.codeview.CodeView
        android:id="@+id/codeview"
        android:fillViewport="true"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_below="@id/title_text"
        android:layout_above="@+id/addFinish">
</com.asd.codeview.CodeView>
```
2. use like edittext using setter, getter
```java
private CodeView codeView=findViewById(R.id.codeview);
codeView.setText(text);
text=codeView.getText();
```
