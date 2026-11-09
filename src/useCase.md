
### UC1: Start Tjeneste

- Systemet opretter en streaming tjeneste og beder brugeren om at logge ind, hvis der er gemt en bruger. Hvis der ikke er gemt en bruger beder systemet oprette en ny bruger(se UC2: Opret bruger).


- **Rainy day:** Der findes en gemt bruger, men man ønsker at oprette en ny: Hvis en gemt bruger eksisterer, skal brugeren have mulighed for at fortsætte med log ind (se UC3: Log ind) eller oprette en ny bruger. 


### UC2: Opret bruger

- Programmet er startet og brugeren har valgt "Opret bruger" i startmenuen.
Brugeren opretter en ny konto, så han eller hun, kan logge ind og have egne lister.


- **Rainy day:** Brugernavnet er allerede i brug. Systemet beder brugeren om at taste nyt brugernavn ind.

### UC3: Log ind

- Hvis der findes en gemt bruger, bedes brugeren logge ind.


- **Rainy day:** Brugernavn eller adgangskode er forkert. Opret en ny bruger(se UC2: Opret bruger).



### UC4: Hovedmenu

- Hoved menu viser brugeren valg for følgende:
1. UC5: Søg medie
2. UC6: Søg kategori 
3. UC7: Se sete medier
4. UC8: Se gemte medier

### UC5: Søg medie 


- Hvis brugeren vælger at søge medie kan brugeren direkte søge efter medie på det specifikke medie navn.


- **Rainy day:** Hvis mediet ikke findes, vil systemet udskrive en besked, med at mediet ikke eksisterer.



### UC6: Søg kategori

- Brugeren er logget ind og har valgt "Søg kategori" i hovedmenu (se UC4: Hovedmenu). Brugeren kan nu direkte søge efter en specifik kategori og få vist listen over alle film/serier i kategorien.


- **Rainy day:** Brugeren har indtastet ugyldig kategori. Meddel brugeren om at den indtastede kategori ikke findes og bed brugeren om at indtaste ny kategori:

### UC7: Se sete medier

- Viser brugeren en liste over hvilke medie brugeren allerede har set. 

- Brugeren kan vælge imellem medie i listen hvis brugeren vil se mediet igen kan brugeren vælge dette.


### UC8: Se gemte medier

- Systemet udskriver en liste over gemte medier på brugerens liste. 


- **Rainy day:** Hvis listen er tom, så udskriver systemet at der ikke er nogen gemte medier.

### UC9: Vælg medie

- Brugeren skal tage et valg mellem: UC10: Afspil medie eller UC11: Gem medie.


- **Rainy day:** Hvis mediet allerede er gemt, skal brugeren have muligheden for UC12: Fjern gemt medie.

### UC10: Afspil medie

- Efter brugeren har valgt et medie, bliver mediet afspillet. Derefter kan brugeren vælge at afslutte mediet og derefter bliver ført til hovedMenu(UC14)

### UC11: Gem medie

Brugeren har valgt sin film (se UC9: Vælg medie) og kan nu gemme medie.
`
- **Rainy day:** Er mediet allerede gemt skal brugeren have mulighed for at fjerne det gemte medie (se UC12: Fjern gemt medie).

### UC12: Fjern gemt medie

- Brugeren kan vælge at fjerne sine gemte medier i sin liste over gemte medier (se UC8: Se gemte medier).
   
### UC13: Afslut tjeneste 

- Når brugeren er på hovedmenu(UC4) kan brugeren bestemme afslutte tjeneste hvis brugeren ikke vælge at se videre.

### UC14: Afslut medie

- Hvis bruger har valgt at afslut medie, bliver brugeren ført til hovedmenu(UC4).
