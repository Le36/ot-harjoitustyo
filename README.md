# OT-harjoitystyö #

##**CHIP-8** *Emulator*

Tällä hetkellä emulaattoriin implementoitu muutamat opcodet, toimii testi rom "IBM" projektin juuressa, jonka funktio on
tulostaa näytölle IBM-logo. Projekti osaa tulostaa IBM-logon nyt JFX näytölle!

## Komentorivitoiminnot ##

### Sovelluksen käynnistäminen

Sovelluksen voi käynnistää komennolla

```
mvn compile exec:java -Dexec.mainClass=com.chip8.Main
```

tai projektista voi tehdä .jar komennolla:

```
mvn package
```

## Testaus

###Testit suoritetaan komennolla

```
mvn test
```

###Testikattavuusraportin voi luoda komennolla

```
mvn test jacoco:report
```

Testikattavuusraportin voi löytää polusta ***target/site/jacoco/index.html***

###Checkstyle reportaasin saa seuraavalla komennolla:

```
mvn jxr:jxr checkstyle:checkstyle
```

Checkstyle löytyy polusta ***target/site/checkstyle.hyml***

## Dokumentaatio ##

[Vaatimusmäärittely](https://github.com/Le36/ot-harjoitustyo/blob/main/dokumentaatio/vaatimusm%C3%A4%C3%A4rittely.md)

[Työaikakirjanpito](https://github.com/Le36/ot-harjoitustyo/blob/main/dokumentaatio/tuntikirjanpito.md)

[Arkkitehtuurikuvaus](https://github.com/Le36/ot-harjoitustyo/blob/main/dokumentaatio/arkkitehtuuri.md)
