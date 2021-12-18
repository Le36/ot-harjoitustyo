
# Käyttöohje #

Aloitetaan sovelluksen käyttö lataamalla viimeisin release

Tämä tiedosto voidaan suorittaa komennolla, eli näin emulaattori käynnistetään

```java -jar ladattuRelease.jar```

## Sovellus käynnistetty ##

Kun sovellus on käynnistetty, pitäisi näkymän olla seuraava

![kohje1](/dokumentaatio/kuvat/kohje1.png)

Tässä kohtaa ohjelma kysyy missä tilassa emulaattori halutaan käynnistää
erilaisia tiloja on 2 kappaletta. Normaali ja laajennettu tila. Tämä ohje ei tule ottamaan
kantaa laajennettuun tilaan, sillä se on suunnattu käyttäjille, jotka ymmärtävät jo valmiiksi
emulaattoriin ja Chip-8:iin liittyviä käsitteitä valmiiksi.

### Extended mode ###

Laajennettu näkymä kuitenkin olisi seuraavanlainen, jos oletamme ladammeemme emulaattoriin
Space Invaders -pelin ROM:in.

![kohje1.1](/dokumentaatio/kuvat/kohje1.1.png)

Laajennettu tila voikin näyttää hieman sekavalta, jonka vuoksi keskitytään ohjeessa normaaliin tilaan:

### Normal mode ###

Oletetaan että painaisimme valinnassa nyt laajennetun tilan sijasta normaalia tilaa. Seuraavaksi
meiltä kysyttäisiin resoluutiolla, jolla tahdomme ajaa emulaattoria.

![kohje2](/dokumentaatio/kuvat/kohje2.png)

Emulaattorissa resoluutio on mahdollista saada aina 64x32 tarkkuudesta 4K tarkkuuteen 3840x1920. 
Oletetaan että olemme valinneet resoluutioksi 960x480 ja painetaan seuraavaksi käynnistä painiketta.

![kohje3](/dokumentaatio/kuvat/kohje3.png)

Emulaattoriin aukeaa nyt yksinkertainen näkymä, jossa ylhäällä on työkalupalkki yksinkertaisille toiminnoille. 
Jotta emulaattoriin saadaan näkymään ROM, meillä täytyy olla se ladattuna käyttämäämme järjestelmään. 
ROM:in pystyy valitsemaan painamalla painiketta "Select ROM", jonka jälkeen käyttäjälle avautuu ikkuna, 
jossa voimme valita tiedostomme. Chip-8:lle tehtyjä ROM:eja voi etsiä esim. googlettamalla "Chip8 roms". Muutama 
erilainen ROM on myös mukana projektin juuressa kansiossa /roms. Kun olemme valinneet tiedoston, aukeaa 
suoritettava ROM suoraan emulaattorin näytölle.

![kohje4](/dokumentaatio/kuvat/kohje4.png)

Tässä olemme esimerkiksi avanneet tiedoston Space Invaders.ch8, joka on videopeli. Emulaattorissa 
näppäimistönä toimivat seuraavat napit:


| 1 | 2 | 3 | 4 |

| Q | W | E | R |

| A | S | D | F |

| Z | X | C | V |

Näppäimet tulevat siitä, kun Chip-8 käyttää 4x4 keypadia.
Laajennetussa tilassa on myös näppäimistö, jota voi käyttää hiirellä klikkaillen.
Näppäimiä voi myös rebindailla options valikosta.

Näillä ohjeilla ROM pitäisi nyt olla käynnissä emulaattorissa ja sitä voi käyttää näppäimistöllä.

### Toolbar ###

Tutustutaan seuraavaksi vielä toolbarissa oleviin toiminnallisuuksiin, jotka esiintyvät niin laajennetussa kuin 
normaalissakin tilassa.

![kohje5](/dokumentaatio/kuvat/kohje5.png)

### Select ROM ###

Ensimmäisenä meillä on "Select ROM" -painike, jota jo aiemmin ohjeessa käytettiin. Sillä voidaan valita 
ROM, joka on emulaattorilla käynnissä, sitä voi käyttää myös vaikka olisimme aiemmin valinneet täysin erilaisen 
ROM:in. 

### Reset ROM ###

Seuraavaksi painike "Reset ROM" yksinkertaisesti resetoi nykyisen ROM:in, joka on valittu aiemmin. Se 
nollaa kaiken muisteista ROM:in tilaan, toiminta pohjautuu siihen, että se lataa ROM:in uudelleen.

### Pause ROM ###

Tämä painike yksinkertaisesti keskeyttää valitun ROM:in suorituksen. Painike toimii Toggle painikkeena, eli se 
jää painettaessa pohjaan.

### Next Instruction ###

Tämä painike suorittaa emulaattorissa seuraavan käskyn. Käytännössä siis teemme yhden fetch-decode-execute -syklin. 
Tällä painikkeella voikin tavallaan "kelata" ROM:ia hitaasti eteen kun se on pausetettu.

### Fade On ###

Tällä painikkeella voidaan valita onko käytössä pikseleiden haihdutus. Tämän toiminnan tarkoituksena on 
poistaa Chip-8:lle tyypillistä välkkymistä. Painike on toggle, joten se jää pohjaan.

### Fade Speed ###

Tällä liukurilla voidaan valita haihdunnan nopeus, jokaisella ROM:illa tätä kannattaa kokeilla ja säätää, jotta 
saadaan parhain mahdollinen lopputulos.

### ROM Speed ###

Tällä liukurilla voimme vaikuttaa ROM:in suorituksen nopeuteen, eli sillä voidaan nopeuttaa tai hidastaa 
suoritettavaa ROM:ia. 

### Options ###

Avaa uuden ikkunan jossa on lisää erilaisia konfiguroitavia asioita.

![kohje6](/dokumentaatio/kuvat/kohje6.png)

Ensimmäinen ominaisuus on näppäimien rebindaus. Klikkaa painiketta jonka haluat rebindata, jonka 
jälkeen paina näppäimistöllä painiketta johon haluat asettaa sen.

On myös mahdollista vaihtaa emulaattorin spriten ja taustan värejä. Lisäksi on mahdollista 
tulostaa ROM suoraan consoleen vapaasti valittavalla symbolilla. Samoin mahdollisuus 
pysäyttää käyttöliittymän päivitykset.

Set default painike asettaa kaiken oletusarvoihin. Save changes tallentaa arvot tiedostoon.
Lopulta apply changes ottaa muutokset käyttöön, tallentamatta niitä tiedostoon.