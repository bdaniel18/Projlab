# Szoftver projekt laboratórium 2019 - Game of Threads
Pandapláza

Állatkertből kiszöktek a pandák, és a szomszédos bevásárolóközpont egyik emeletén ütöttek tanyát, ahol véletlenszerűen kószálnak. A feladat a pandákat összeszedő orángutánok irányítása és ezáltal minél több panda összegyűjtése. 
Az emelet padlóját különböző, sokszög alakú csempék alkotják (ezek oldalszáma igen változatos), de egy csempén csak egy állat állhat. A csempék között vannak gyengébbek, amelyekre, ha több, mint húszszor lépnek, eltörnek. Ha egy állat egy eltört csempére lép, lezuhan és meghal. 
Az emeleten különféle tárgyak vannak elhelyezve. Van szekrény, fotel, játékgép, csokiautomata. A tárgyakat nem lehet a helyükről elmozdítani. A játékgép néha csilingel, a csokiautomata néha sípol. Ezek a hangok azonban csak a szomszéd csempéken állókig hallatszanak el. A szekrény speciális: ebbe bele lehet lépni. Aki belép, az az emelet egy másik részén álló szekrényből fog kilépni. 
Az orángutánok egy módon tudnak pandát fogni: egy pandának nekimenve megragadják a panda mancsát. Az a panda, akinek megfogják a mancsát, mindenhova követi azt, aki a mancsát fogja. Az orángután, ha már fogja egy panda mancsát, úgy fogja meg a következő pandát, hogy nekimegy, majd a régebbi panda mancsát az újéba adja, és ő az új pandát vezeti tovább. Így a pandákat sorba lehet fűzni. 
A pandáknak különféle tulajdonságaik vannak, de mindegyiknek csak egy. Van, amelyik a játékgép csilingelésétől megijed, és elengedi a mögötte álló panda mancsát (ilyenkor az elengedés végigfut a soron, és így a sor hátralevő része felbomlik). Van, amelyik a csokiautomata sípolásától ugrik egyet, amitől a törékeny csempe élettartama csökken. Van, amelyik a fotel mellett elmenve elfárad, és beül a fotelbe. 
Az emeletnek két speciális pontja van: a bejárat és a kijárat. Ha egy orángután egy csoport pandát a kijáraton kivezet, a pandák darabszáma után pontot kap. A kivezetés után az orángután a bejáraton jön vissza.

Változás (2019.03.26.)
- az orángutánok el tudják engedni a pandákat. Ilyenkor az érintett sor felbomlik.
- az orángutánok elrabolhatják egymás pandáit. Ennek menete, hogy ha egy orángután (o1), akinek nincs pandája, nekimegy egy másik orángutánnak (o2), akkor helyet cserélnek, és o1 megszerzi o2 panda-sorát. Ekkor o2-nek 3 lépést kell tennie, mielőtt újra pandát foghat vagy másik orángutántól rabolhat.
