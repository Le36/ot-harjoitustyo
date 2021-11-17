# OT-harjoitystyö #

**CHIP-8** *Emulator*

Tällä hetkellä emulaattoriin implementoitu muutamat opcodet, toimii testi rom "IBM" projektin juuressa, jonka funktio on
tulostaa näytölle IBM-logo.

## Komentorivitoiminnot ##

### Sovelluksen käynnistäminen

Sovelluksen voi käynnistää komennolla

```
mvn compile exec:java -Dexec.mainClass=com.chip8.emulator.Main
```

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportin voi luoda komennolla

```
mvn test jacoco:report
```

Kattavuusraporttia voi tarkastella projektin juuresta löytyvästä tiedostosta **target/site/jacoco/index.html** tai
esimerkiksi Chromium-selaimessa komennolla (edellyttää Chromium-selaimen asennuksen)

```
chromium-browser target/site/jacoco/index.html
```

## Dokumentaatio ##

[Vaatimusmäärittely](https://github.com/Le36/ot-harjoitustyo/blob/main/dokumentaatio/vaatimusm%C3%A4%C3%A4rittely.md)

[Työaikakirjanpito](https://github.com/Le36/ot-harjoitustyo/blob/main/dokumentaatio/tuntikirjanpito.md)
