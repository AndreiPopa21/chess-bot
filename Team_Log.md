Etapa 1



[Stefan-Andrei Popa] : am implementat reprezentarea interna a tablei si clasele celorlalte piese
					   am utilizat o clasa abstracta comuna Piece ca sa grupez piesele
					   am reprezentat tabla interna sub forma de matrice bidimensionala de obiecte Piece

[Ilie-Cristian Sandu] : am implementat protocolul de comunicatie intre program si XBoard
						am creeat clasa ReceiverXboard care interpreteaza comenzile de la XBoard 
						am incercat diferite implementari in Main ca sa leg tabla interna de logica din XBoard


In stadiul actual, programul reuseste sa mute legal fiecare piesa de pe tabla (inca nu sunt implementate mutarile mai speciale cum ar fi En Passant, Promotion, Sah, etc.).

Programul nu stie sa interpreteze daca primeste un sah si pentru testare e recomandat evitarea unei astfel de mutari. Pentru stadiul actual, ca sa putem sa aratam ceea am implementat, ne-am gandit sa mutam caii atat timp cat ei au mutari valabile si nu sunt capturati. In spate, pe fiecare piesa exista cate o metoda getAllPossibleMoves() care odata apelata, intoarce o lista cu toate mutarile posibile pe care le poate face piesa respectiva. Algoritmul tine cont de reprezentarea interna a tablei si de regulile de mutare pentru acea piesa. Pentru un demo, ne-am gandit sa mutam un cal atata timp cat nu e capturat si metoda getAllPossibleMoves() ii intoarce optiuni. Daca mutarea calului nu mai este posibila, atunci engine-ul da Resign. Pe deasupra, desi am dezactivat comenzile white si black, switch-ul de sides-uri inca este posibil dandu-i engine-ului comanda go. Indiferent de culoare, am ales sa mutam un anumit cal. Ce este de notat este si ca caii mereu aleg o mutare la intamplare din lista lor de optiuni. Aveam posibilitatea si ca in loc de "resign" sa dam draw prin comanda "1/2-1/2 {Draw by repetition}".


Am incercat sa versionam codul in mod constant folosind Git si sa ne creem branch-uri pentru fiecare feature pe care l-am adaugat programului. Am lucrat atat individual, cat si impreuna pe fiecare branch. Odata terminat un feature, realizam merge cu branch-ul principal si ii dadeam push pe remote. 


In general, am incercat sa facem codul clar si sa realizam clase de sine statatoare. Codul consideram ca este lizibil si usor de inteles. Pentru rularea programului, am facut un Makefile care build-uieste clasele Java si face run direct cu comanda de xboard. Comanda de clean sterge fisierele .class. Pentru testare, atasam un folder separat cu fisierele .java si cu Makefile-ul. 

______________________________________________________________________________



Etapa 2

[Ilie-Cristian Sandu] : am implementat metodele din MiniMax de evaluare a configuratiei tablei si de returnare a tuturor mutarior posibile 
                        am implementat clasa ScoreManager care salveaza intr-o tabela de dispersie toate valorile mutarilor fiecarei piese alaturi de o metoda care returneaza valoarea piesei adaugata la valoarea patratelului pe care se afla pentru piesa respectiva 
                        am implementat in GameManager istoricul alaturi de metodele record, searchHistoryFor.
                        am testat functionalitatea pe parcurs

[Stefan-Andrei Popa] : am implementat metodele mini si maxi din MiniMax si le-am conectat cu celelalte metode auxiliare de evaluare si cautare
					   am contribuit la implementarea regulilor si a mutarilor speciale: Rocada, Promotion, En-Passant
					   am contribuit la refactorizarea codului pentru fiecare piesa
					   am implementat functionalitatea de cautare de mutari valide pentru fiecare piesa in parte
					   am implementat clasa Table si toate clasele auxiliare de care are nevoie si am conectat-o cu celelalte componente
					   am ajutat la testare si depanare, precum si la organizarea workflow-ului cu Git



In stadiul actual, programul este capabil sa nu mai dea mutari invalide, implementand in mod corespunzator toate regulile jocului. Mai mult, programul e capabil sa 
efectueze decizii cu ajutorul unui algoritm bazat pe Minimax si sa bata in unele cazuri fairymax (acesta rulat cu adancime 2, in timp ce programul nostru reuseste
sa exploreze configuratii pana la adancime 4). Algoritmul de cautare este optimizat prin Alpha-Beta Pruning. 

Echipa per total si-a imbunatatit workflow-ul pe Git, iar acum, de fiecare data cand este nevoie sa depanam sau sa proiectam un nou feature, ne organizam pe 
branchuri separate si ulterior, facem merge cu branch-ul principal cand avem un produs functional. Acest tip de lucru ne permite sa lucram armonios, in paralel si
faciliteaza comunicarea eficienta intre membrii echipei.

Avem in acest moment multe clase care abstractizeaza toate componentele jocului si care sunt proiectate in asa masura incat sa fie cat mai independente una de 
cealalta. Codul este atat bine organizat, cat si bine documentat, fiind descris in mod clar functia fiecarei clase si a fiecarei metode.