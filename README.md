# **CHIP-8** *Emulator* #

Chip-8 emulaattori, tehty Helsingin Yliopiston kurssin Ohjelmistotekniikka kurssityönä.
Chip-8 mielletään yleisesti "Hello World" -emulaattoriksi, sillä se on hyvin yksinkertainen, 
sisältäen vain 35 erilaista käskyä ja mustavalkoisen näytön resoluutiolla 64x32.

Tähän emulaattoriin on kuitenkin pyritty lisäilemään paljon muitakin ominaisuuksia, kuin pelkästään 
Chip-8:lle tehdyn ROM:in tulkitseminen:

![kohje1.1](/dokumentaatio/kuvat/kohje1.1.png)

# Komentorivitoiminnot #

## Sovelluksen käynnistäminen ##

Sovelluksen voi käynnistää komennolla

```
mvn compile exec:java -Dexec.mainClass=com.chip8.Main
```

tai projektista voi tehdä .jar komennolla:

```
mvn package
```

Myös release 1 voi kokeilla ->
[Release 1](https://github.com/Le36/ot-harjoitustyo/releases/tag/viikko5)

# Testaus #

## Testit suoritetaan komennolla ##

```
mvn test
```

## Testikattavuusraportin voi luoda komennolla ##

```
mvn test jacoco:report
```

Testikattavuusraportin voi löytää polusta ***target/site/jacoco/index.html***

## Checkstyle reportaasin saa seuraavalla komennolla ##

```
mvn jxr:jxr checkstyle:checkstyle
```

Checkstyle löytyy polusta ***target/site/checkstyle.hyml***

## JavaDocin saa komennolla ##

```
mvn javadoc:javadoc
```

# Dokumentaatio #

[Vaatimusmäärittely](https://github.com/Le36/ot-harjoitustyo/blob/main/dokumentaatio/vaatimusm%C3%A4%C3%A4rittely.md)

[Työaikakirjanpito](https://github.com/Le36/ot-harjoitustyo/blob/main/dokumentaatio/tuntikirjanpito.md)

[Arkkitehtuurikuvaus](https://github.com/Le36/ot-harjoitustyo/blob/main/dokumentaatio/arkkitehtuuri.md)

[Käyttöohje](https://github.com/Le36/ot-harjoitustyo/blob/main/dokumentaatio/kayttoohje.md)

[Testausdokumentti](https://github.com/Le36/ot-harjoitustyo/blob/main/dokumentaatio/testaus.md)

[Release 1](https://github.com/Le36/ot-harjoitustyo/releases/tag/viikko5)

