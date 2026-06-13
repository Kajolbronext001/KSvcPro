# This is a configuration file for ProGuard.
# http://proguard.sourceforge.net/index.html#manual/usage.html

-dontusemixedcaseclassnames
-verbose

-keepattributes *Annotation*
-keep public class com.google.android.material.** { *; }
-keep public class androidx.** { *; }
-keep interface androidx.** { *; }

-dontwarn android.**
-dontwarn androidx.**
-dontwarn com.google.android.material.**

-keep class com.ksvcpro.appcloner.** { *; }
