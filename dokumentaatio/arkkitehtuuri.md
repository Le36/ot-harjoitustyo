# Arkkitehtuurikuvaus #

### Rakenne ###

Koodin pakkausrakenne on seuraava:

![luokkakaavio](/dokumentaatio/kuvat/classDiagram.png)

Emulaattorin toteuttavat luokat ovat omassa pakkauksessa, kun taas ui:n toteuttavat ovat omassaan.

Tarkastellaan seuraavaksi sovellusta hieman laajemmasta näkökulmasta, sillä pakkausrakenne ei yksin 
riitä kuvaamaan sovelluksen rakennetta:

![luokkakaavio](/dokumentaatio/kuvat/luokkakaavio.png)

Nyt kun ohjelman rakenne on jo paljon paremmin selvillä, voimme alkaa tutustumaan hieman yksittäisiin luokkiin 
ja niiden välisiin yhteyksiin.

### Emulaattori ###

Executer toimii emulaattorin main luokkana. Se pystyy pyörittämään emulaattoria ja emulaattorin 
logiikka onkin eriytetty käyttöliittymästä siihen malliin, että käyttöliittymän tarvii koskea emulaattoriin 
käytännössä vain Executer -luokan kautta.

![sekvenssidiagrami](/dokumentaatio/kuvat/sequenceExecuter.png)

Kun Executer luodaan, se luo meille emulaattoriin muistin jota käyttää. Muisti on Memory -luokka. Memory on 
kuitenkin tavallaan vain tyhmää muistia, se ei osaa tehdä mitään, se on käytännössä emulaattorin käyttämä tietorakenne 
jossa on kaikki sille tarpeellinen samassa luokassa. Memory alustetaan Loader -luokan avulla. Loader lataa Memoryyn 
esimerkiksi käyttäjän valitseman ROM:in tiedostosta ja samalla Chip-8:lle pakolliset kovakoodatut fontti datat.

Kun tämä on tehty, tekee Executer meille Fetcherin, jonka funktio on noutaa seuraava käsky program counterin osoittamasta 
paikasta keskusmuistista, joka sijaitsee Memory -luokassa. Fetcherin jälkeen luomme Executer -luokas luokan Decoder, jonka 
tehtävä on purkaa Fetcherin noutama käsky ja tehdä sen mukaiset toimenpiteet. Decoder -luokka on yhteydessä 
käyttöliittymään siinä mielessä, että se piirtää sinne kuvaa ConsoleDisplay -luokassa ja myöhemmin vielä tekee 
emulaattorin laajennettuun tilaan Extended DecodeDetails -luokan, joka kuvailee jokaista käskyä yksityiskohtaisesti 
käyttöliittymässä.

Hyvin yksinkertainen sovelluslogiikka siis käytössä, jonka vuoksi toimintaa ei ole hajautettu useampaan luokkaan. 
Näin pienessä projektissa asiat on pitää kivana, kun pakkauksia ei ole yli kymmentä ja class counttikin pysyy mukavasti alle 
sadassa.

### Käyttöliittymä ###

Tutustutaan seuraavaksi käyttöliittymään ja kuinka se on yhteydessä emulaattoriin:

![sekvenssidiagrami2](/dokumentaatio/kuvat/sequenceLauncher.png)

Ohjelma siis ensin luo Launcher -luokan jossa tehdään käyttöliittymän rakentava toiminta JFX avulla. Tämän 
jälkeen odotetaan käyttäjän reagointia, eli valitaanko mikä tila emulaattoriin (laajennettu vai normaali) ja 
sitten mennään EmulatorUi -luokkaan, jossa on aiempien valintojen mukainen käyttäliittymän rakentaminen JFX avulla.

Miten tämä sitten liittyy emulaattoriin? Luomme täällä Executer -luokkaa varten PixelManager -luokan, joka huolehtii 
pikseleistä ja niiden haihdutuksesta. Seuraavaksi Keys -luokka, joka huolehtii näppäimistön toiminnallisuudesta ja sen 
siirtämisestä Executer -luokan kautta syvemmälle emulaattoriin.