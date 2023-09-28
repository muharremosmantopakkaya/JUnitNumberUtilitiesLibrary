# JUnitNumberUtilitiesLibrary

Bu kütüphane, çeşitli sayısal işlemleri kolaylaştırmak için bir dizi yardımcı fonksiyon içermektedir. 
Bu işlevler, asal sayıların tespiti, faktöriyel hesaplama, rakam toplamları ve daha pek çok sayısal işlemi içerir.

## Özellikler

- Asal sayıların tespiti (`isPrime`).
- n'inci asal sayıyı bulma (`getPrime`).
- Bir sayının faktöriyelini hesaplama (`factorial`).
- Bir sayının rakamlarının toplamını bulma (`digitsSum`).
- Bir sayının rakamlarını bir dizi olarak alma (`getDigits`).
- Sayının tersini alma (`reversed`).
- Asal çarpanları yazdırma (`printPrimeFactors`).


## Testler

Projede bir dizi JUnit testi bulunmaktadır. Bu testler, kütüphanenin doğru bir şekilde çalıştığını doğrulamak için tasarlanmıştır.

- `Test_digitsSum`
- `Test_factorial`
- `Test_getDigits`
- `Test_getPrime`
- `Test_getPrime_exception`
- `Test_isPrime`
- `Test_isPrime_false`
- `Test_isPrime_true`

## Kurulum ve Kullanım

Projeyi yerel makinenize klonlayarak başlayabilirsiniz:
Maven veya Gradle gibi bağımlılık yöneticileri ile projenin bağımlılıklarını yükleyebilirsiniz.
