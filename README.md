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
## Lisence
```lisence
MIT License

Copyright (c) 2019 Son SeungBeom

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```
