# OT-harjoitystyö #

**CHIP-8** *Emulator*

Chip8 emulaattori. Aja emulaattori ja valitse emulaattorin ui:ssa haluamasi rom tiedosto, joita on 
muutama mukana projektin juuressa kansiossa /roms
tai voit myös etsiä netistä minkä tahansa chip8 käskykannalle tehdyn romin ja se toimii tällä
emulaattorilla!

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

Myös release 2 voi kokeilla ->
[Release 2](https://github.com/Le36/ot-harjoitustyo/releases/tag/viikko6)

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

[Release 1](https://github.com/Le36/ot-harjoitustyo/releases/tag/viikko5)

[Release 2](https://github.com/Le36/ot-harjoitustyo/releases/tag/viikko6)