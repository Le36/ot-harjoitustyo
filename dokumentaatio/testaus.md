# Testausdokumentti #

Ohjelmaan on tehty automaattiset yksikkö ja integraatiotestit JUnitilla. Ohjelmaa on testattu 
paljon käsin etenkin sen käyttöliittymästä tehtäviä toimintoja.

### Yksikkö- ja integraatiotestaus ###

Ohjelmassa on useita testiluokkia, jotka testaavat emulaattorin kannalta oleellista toimintaa. Tämän lisäksi on yksi 
testiluokka tehty pysyväistallennuksen testausta varten.

### Testikattavuus ###

Testikattavuudessa ei ole huomioitu käyttöliittymän rakentavaa koodia. Testien rivikattavuus on huimat 
96% ja haarautumiskattavuus 92%.

Kaikkea ei ole testattu siis ohjelmastakaan, näihin liittyvät esimerkiksi. käyttöliittymästä käytettävä 
näppäimistö, jonka voisi myös ehkä excludee tästä kattavuusmittauksesta samoin pikseleiden piirtoon 
liittyvät luokat, nämä excludemalla rivi- ja haarautumiskattavuus olisivat 99% luokkaa.

Myös esimerkiksi operaatiokoodi Random() on jätetty testaamatta, koska satunnaisuutta on turha testata 
mielestäni tässä yhteydessä.

![tests](/dokumentaatio/kuvat/testaus.png)

### Järjestelmätestaus ###

Sovellus on asennettu ja toimenpiteet ovat tehty käyttöohjeen mukaisesti. Kaikki testaukset on suoritettu 
sekä Linux- että Windows-käyttöympäristöissä. Käyttöohjeen mukaiset tilanteet toimivat täysin. 

Käyttöohjeesta oli jätetty pois emulaattorin laajennetun tilan käyttö, koska sitä tilaa käyttämällä 
on mahdollista aiheuttaa virheitä pakottamalla opcodeja. Tämä ei kuitenkaan tarkoita sitä, että emulaattorin 
koodissa olisi virhe, vaan ROM:in koodissa, jonka koodaukseen tässä projektissa ei oteta huomiota. Onhan 
virheitä mahdollista saada aikaan Javassa, vaikka Javan koodi olisikin toimivaa, vika voisi olla 
silloin ohjelmoijassa.

### Jääneitä laatuongelmia ###

- Sovellus voisi antaa ilmoituksen keskeytyksestä myös käyttöliittymässä, mutta normaalissa käytössä 
näitä ei pääse syntymään toisaalta.

- Muissa kuin Windows ympäristöissä CSS-tiedostojen määrittelemä Consolas-fontti ei ole saatavilla, jolloin 
järjestelmä käyttää tilalla oletusfonttia. 